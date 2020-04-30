package com.kishore.servicebus.vo;

import java.io.Serializable;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseId = null;
	private String courseName = null;
	private String courseDesc = null;
	private String courseCatageory = null;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseCatageory() {
		return courseCatageory;
	}

	public void setCourseCatageory(String courseCatageory) {
		this.courseCatageory = courseCatageory;
	}

}
