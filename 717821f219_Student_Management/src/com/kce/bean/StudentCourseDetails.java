package com.kce.bean;

public class StudentCourseDetails{
           private int course_id;
           public String course_name;
           public int course_duration;
           public String course_staff;
           public int marks;
		public StudentCourseDetails(int course_id,
				String course_name, int course_duration, String course_staff, int marks) {
			this.course_id = course_id;
			this.course_name = course_name;
			this.course_duration = course_duration;
			this.course_staff = course_staff;
			this.marks = marks;
		}
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
		public String getCourse_name() {
			return course_name;
		}
		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}
		public int getCourse_duration() {
			return course_duration;
		}
		public void setCourse_duration(int course_duration) {
			this.course_duration = course_duration;
		}
		public String getCourse_staff() {
			return course_staff;
		}
		public void setCourse_staff(String course_staff) {
			this.course_staff = course_staff;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		@Override
		public String toString() {
			return "StudentCourseDetails [course_id=" + course_id + ", course_name=" + course_name
					+ ", course_duration=" + course_duration + ", course_staff=" + course_staff + ", marks=" + marks
					+ "]";
		}
		public void courseDetails() {
			System.out.println(toString());
		}
           
           
}
