-- 2
-- issue: department name and number of courses were in the wrong order for hackerrank
select d.name as Department_Name, count(c.deptid) as Number_of_Courses
from course c, department d
where d.id = c.deptid
group by c.deptid, d.name
order by Number_of_Courses asc, Department_Name asc;

select * from department;
select * from course;

-- 3
select c.name as Course_Name, count(sc.courseid) as Number_of_Students
from course c, studentCourse sc
where sc.courseid = c.id
group by sc.courseid, c.name
order by Number_of_Students desc, Course_Name asc;

select * from studentCourse;
select * from course;

-- 4
-- issue: i forgot 'not in' + subquery
select c.name as Course_Name
from course c
where c.id not in (select courseid from facultyCourse)
order by Course_Name asc;

select * from course;
select * from faculty;
select * from facultyCourse;

-- 5
select c.name as Course_Name, count(sc.courseid) as Number_of_Students
from course c, studentCourse sc
where c.id not in (select courseid from facultyCourse)
and sc.courseid = c.id
group by sc.courseid
order by Number_of_Students desc, Course_Name asc;

-- 6
-- issue: unable to properly group by since i was using both studentID & year
-- only group by year
select count(distinct sc.studentId) as Students, extract(year from sc.startDate) as Year
from studentcourse sc, student s
where sc.studentId = s.id
group by extract(year from sc.startDate)
order by Year asc, Students desc;

-- 7
-- issue: not making a condition to where the month in startdate = 8
-- it wasn't a issue but it was my challenge
select sc.startDate as Start_Date, count(distinct sc.studentId) as Total_Number_of_Students
from studentcourse sc, student s
where sc.studentId = s.id and extract(month from sc.startDate) = 8
group by extract(year from sc.startDate), extract(month from sc.startDate), sc.startDate
order by Start_Date asc, Total_Number_of_Students asc;

-- 8
-- issue: getting the condition to count based on the majorid and departmentid correctly
-- lacking inner joins
-- inner joins in the from section connects the tables to properly fill the conditions of comparing the ids correctly for the count
select s.firstname as First_Name, s.lastname as Last_Name, count(distinct sc.courseId) as Number_of_Courses
from student s inner join studentcourse sc on (s.id = sc.studentid) inner join course c on (sc.courseid = c.id)
where s.majorId = c.deptId
group by s.firstname, s.lastname
order by Number_of_Courses desc, First_Name asc, Last_Name asc;

select *
from student s, studentcourse sc, department d;

-- 9
-- issue: getting the < 50 condition to properly apply without getting error 1111 invalid use of group function
-- used having to fix the issue
select s.firstname as First_Name, s.lastname as Last_Name, cast(avg(sc.progress) as decimal(10,1)) as Average_Progress
from student s, studentCourse sc
where s.id = sc.studentid
group by s.firstname, s.lastname
having Average_Progress < 50
order by Average_Progress desc, First_Name asc, Last_Name asc;

-- 10
-- issue: no issue.
select c.name as Course_Name, cast(avg(sc.progress) as decimal(10,1)) as Average_Progress
from course c, studentCourse sc
where c.id = sc.courseid
group by c.name
order by Average_Progress desc, Course_Name asc;

-- 11
-- issue: getting only one value to properly appear and making max work properly to do so
-- i think it's due to a misplacement of ()
-- this is the correct take
select name as Course_Name, max(Average_Progress) as Average_Student_Progress
from (select c.name, cast(avg(sc.progress) as decimal(10,1)) as Average_Progress from studentCourse sc inner join course c on (c.id = sc.courseid) group by c.name ) as Average_Student_Progress, studentCourse sc
group by name
order by Average_Student_Progress desc
limit 1;

-- this only returned the correct amount
SELECT MAX(Average_Progress) AS Average_Student_Progress
    FROM (SELECT c.name AS Course_Name, ROUND(AVG(sc.progress),1) AS Average_Progress
            FROM studentCourse sc INNER JOIN course c ON (sc.courseId = c.id)
            GROUP BY c.name
            ORDER BY Average_Progress DESC) as sax
            ;
            
-- this returned all the names            
select c.name as Course_Name, cast(avg(sc.progress) as decimal(10,1)) as Average_Student_Progress
from  course c, studentCourse sc
inner join facultyCourse fc on (sc.courseId = fc.courseId)
inner join faculty f on (fc.facultyId = f.id)
where c.id = sc.courseid
group by c.name;

-- 12
-- issue: yes please send help
select f.firstname as First_Name, f.lastname as Last_Name, cast(avg(sc.progress) as decimal(10,1)) as Average_Progress
from studentCourse sc
inner join facultyCourse fc on (sc.courseId = fc.courseId)
inner join faculty f on (fc.facultyId = f.id)
group by f.lastname, f.firstname
order by Average_Progress desc, First_Name asc, Last_Name asc;

-- 13
-- given the order by line
-- issue: yes please send help
-- i made too many conditions after "THEN" such as sc.progress = "F"
select s.firstname as First_Name, s.lastname as Last_Name, 
CASE
    WHEN min(sc.progress) < 40 THEN "F"
    WHEN min(sc.progress) < 50 THEN "D"
    WHEN min(sc.progress) < 60 THEN "C"
    WHEN min(sc.progress) < 70 THEN "B"
    WHEN min(sc.progress) >= 70 THEN "A"
END as Minimum_Grade, 
CASE
    WHEN max(sc.progress) < 40 THEN "F"
    WHEN max(sc.progress) < 50 THEN "D"
    WHEN max(sc.progress) < 60 THEN "C"
    WHEN max(sc.progress) < 70 THEN "B"
    WHEN max(sc.progress) >= 70 THEN "A"
END as Maximum_Grade
from student s, studentcourse sc
where s.id = sc.studentId
group by s.firstname, s.lastname
order by Minimum_Grade desc, Maximum_Grade desc, s.firstname asc, s.lastname asc;