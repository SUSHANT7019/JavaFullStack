package com.example.SpringExample;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long studentId;

@Column(name="firstName", nullable = false)
private String firstName;

@Column(name="lastName", nullable = false)
private String lastName;

@Column(name="gender", nullable = false)
private String gender;

@Column(name="DOB", nullable = false)
private Date dob;

@Column(name="email", nullable = false ,unique = true)
private String email;

@Column(name="phone", nullable = false, unique = true)
private String phone;

@Column(name="address", nullable = false)
private String address;
@Column(name="city", nullable = false)
private String city;

@Column(name="state", nullable = false)
private String state;
@Column(name="pincode", nullable = false)
private String pincode;

@Column(name="enrollmentDate", nullable = false)
private Date enrollmentDate;

@Column(name="course", nullable = false)
private String course;
public StudentEntity() {}


public StudentEntity(Long studentId, String firstName, String lastName, String gender, Date dob, String email,
		String phone, String address, String city, String state, String pincode, Date enrollmentDate, String course) {

	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.dob = dob;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.enrollmentDate = enrollmentDate;
	this.course = course;
}


public Long getStudentId() {
	return studentId;
}
public void setStudentId(Long studentId) {
	this.studentId = studentId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public Date getEnrollmentDate() {
	return enrollmentDate;
}
public void setEnrollmentDate(Date enrollmentDate) {
	this.enrollmentDate = enrollmentDate;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}


@Override
public int hashCode() {
	return Objects.hash(address, city, course, dob, email, enrollmentDate, firstName, gender, lastName, phone, pincode,
			state, studentId);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	StudentEntity other = (StudentEntity) obj;
	return Objects.equals(address, other.address) && Objects.equals(city, other.city)
			&& Objects.equals(course, other.course) && Objects.equals(dob, other.dob)
			&& Objects.equals(email, other.email) && Objects.equals(enrollmentDate, other.enrollmentDate)
			&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
			&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
			&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
			&& Objects.equals(studentId, other.studentId);
}


@Override
public String toString() {
	return "StudentEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
			+ gender + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", address=" + address + ", city="
			+ city + ", state=" + state + ", pincode=" + pincode + ", enrollmentDate=" + enrollmentDate + ", course="
			+ course + "]";
}


}
