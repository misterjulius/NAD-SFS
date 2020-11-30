package com.login.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import com.login.bean.LoginBean;
import com.login.util.DBConnection;
 
public class LoginDao {
 

	private static final String connectionUrl = "jdbc:mysql://localhost/studentfeedback";
	private static final String user = "root";
	private static final String dbpassword = "";
	
	
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getUserName();
    String password = loginBean.getPassword();
    
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        conn = DBConnection.createConnection(connectionUrl,user,dbpassword);
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select username,password,role from users");
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
            return "Admin_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
            return "Editor_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
            return "User_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}