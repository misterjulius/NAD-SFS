package com.login.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.models.*;

public class StudentDao {
	String url = "jdbc:mysql://localhost:3306/studentfeedback";
	String username = "root";
	String password =""; 
	public int registerStudent(Student student) throws ClassNotFoundException{
		String insert_Student_Details = "INSERT INTO students" + "(name, studentno, email, password) VALUES " + "(?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			//1. connection to database
			Connection con = DriverManager.getConnection(url, username, password);
			//2.create a statement with connection object
			PreparedStatement addstudent = con.prepareStatement(insert_Student_Details);
			addstudent.setString(1,student.getStudentName());
			addstudent.setString(2, student.getStudentNumber());
			addstudent.setString(3, student.getStudentEmail());
			addstudent.setString(4, student.getStudentPassword());
			
			//3.Execute the query
			result = addstudent.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean checkLogin(String uname, String upass) {
		String sql = "select * from students where studentname=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, upass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}
}
