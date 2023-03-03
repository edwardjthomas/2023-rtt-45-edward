-- 2
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
select c.name as Course_Name
from course c
where c.deptId = 1
order by Course_Name asc;

select * from course;
select * from faculty;
select * from facultyCourse;
