package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeService {

	private static final String URL = "jdbc:mysql://192.168.0.212/test_db?useSSL=no&characterEncoding=utf8";
	private static final String USER = "jungmin";
	private static final String PW = "joeun911!";
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	@Override
	public boolean saveEmployee(Employee e) {
		int status = 0;
		try {
			String sql = "insert into user (name, password, email, country) values (?, ?, ?, ?)";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return status == 1 ? true : false;
	}

	/**
	 * 데이터 베이스에 접근해서,
	 * 쿼리 결과를 리스트로 만들어서 리턴
	 * 
	 */
	@Override
	public List<Employee> listEmployee() {
		List<Employee> list = null;
		try {
			list = new ArrayList<Employee> ();
			String sql = "select id, name, email, country from user";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Employee emp = new Employee();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String country = rs.getString(4);
				
				emp.setId(id);
				emp.setName(name);
				emp.setEmail(email);
				emp.setCountry(country);
				
				list.add(emp);
			}
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int status = 0;
		try {
			String sql = "delete from user where id = ?";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status == 1 ? true : false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		int status = 0;
		try {
			String sql = "update user set name=?, password=?, email=?, country=? where id= ?";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			
			status = ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return status == 1 ? true : false;
	}

	@Override
	public Employee listEmployee(int id) {
		Employee emp = null;
		try {
			String sql = "select name, email, country from user where id = ?";
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				emp = new Employee();
				
				String name = rs.getString(1);
				String email = rs.getString(2);
				String country = rs.getString(3);
				
				emp.setName(name);
				emp.setEmail(email);
				emp.setCountry(country);
			}
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}

}
