package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.login.dao.*;
import com.models.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//create instance of user data access object
	private StudentDao studentdao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input parameters
		String studentName = request.getParameter("studentname");
		String studentNumber = request.getParameter("studentno");
		String studentEmail = request.getParameter("studentemail");
		String studentPassword = request.getParameter("password");
		byte[] passwordsalt = getSalt();
		//encrypt the password
		String securepassword = get_SHA_1_SecurePassword(studentPassword, passwordsalt);
		
		//set user variables from user object
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentNumber(studentNumber);
		student.setStudentEmail(studentEmail);
		student.setStudentPassword(securepassword);
		
		//try to save the user and throw an error if it goes wrong
		try {
			StudentDao.registerStudent(student);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		//send user to welcome jsp page
		HttpSession session = request.getSession();
		session.setAttribute("uname", fullname);
		
		response.sendRedirect("welcomePage.jsp");
	}
	
	public byte[] getSalt() {
		byte[] salt = new byte[8];
		return salt;
	}
	
	public static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				generatedPassword = sb.toString();
			}
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	}

}
