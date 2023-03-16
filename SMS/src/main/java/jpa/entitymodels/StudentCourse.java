package jpa.entitymodels;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "studentcourse")

public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "studentid", insertable = false, updatable = false)
	private Integer studentId;

	@Column(name = "courseid", insertable = false, updatable = false)
	private Integer courseId;
	
	// many to student
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "studentid", nullable = true)
	private Student student;
	
	// many to course
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "courseid", nullable = true)
	private Course course;
}
