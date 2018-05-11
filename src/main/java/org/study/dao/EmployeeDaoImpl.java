package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeService {
	
	private static final String URL="jdbc:mysql://192.168.0.212/test_db?useSSL=no&characterEncoding=utf8";
	private static final String USER="jungmin";
	private static final String PW="joeun911!";
	
	public static Connection getConnection() {
		
		//db커넥션
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PW);//url,username,password
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	

	
	@Override
	public boolean SaveEmployee(Employee e) {
	
			int status = 0;
		
		try {
			String sql = "insert into user (name, password, email,country) values (?,?,?,?)";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			
			conn.close();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return status == 1?true:false;
	}

	@Override
	public List<Employee> ListEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean DeleteEmployee(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
