/**
 * 
 */
package searchapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import address.Address;

/**
 * @author Junaid Khan
 *
 */

@Entity
public class Student {

	private Long id;
	private String name;
	private String email;
	// in case of explicit date
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date date;

	private List<String> courses;
	private String studentType;
	private boolean status;

	//private Address address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email, Date date, List<String> courses, String studentType, boolean status) {
		super();
		this.name = name;
		this.email = email;
		this.date = date;
		this.courses = courses;
		this.studentType = studentType;
		this.status = status;
	}

	// u can also make it identity here we use now auto
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	 * 
	 * @JoinColumn(name = "id") public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + date + ", courses=" + courses
				+ ", studentType=" + studentType + ", status=" + status + "]";
	}

}
