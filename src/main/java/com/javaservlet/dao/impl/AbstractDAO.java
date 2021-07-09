package com.javaservlet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.javaservlet.dao.IHandleDAO;
import com.javaservlet.dao.mapper.IRoleMapper;

public class AbstractDAO<T> implements IHandleDAO<T> {

	ResourceBundle bundle = ResourceBundle.getBundle("db");

	private final String URL = bundle.getString("url");
	private final String DRIVER = bundle.getString("driver");
	private final String USER = bundle.getString("user");
	private final String PASS = bundle.getString("pass");

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		// TODO Auto-generated method stub
		for (int i = 0; i < parameters.length; i++) {
			Object obj = parameters[i];
			int index = i + 1;
			try {
				if (obj instanceof Integer) {
					statement.setInt(index, (Integer) obj);
				} else if (obj instanceof String) {
					statement.setString(index, (String) obj);
				} else if (obj instanceof Double) {
					statement.setDouble(index, (Double) obj);
				} else if (obj instanceof Boolean) {
					statement.setBoolean(index, (Boolean) obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<T> select(String sql, IRoleMapper<T> roleMapper, Object... parameters) {
		// TODO Auto-generated method stub
		List<T> products = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			rs = statement.executeQuery();
			while (rs.next()) {
				products.add(roleMapper.roleMapper(rs));
			}
			connection.commit();
			return products;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void insertOrUpdate(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	@Override
	public T selectOne(String sql, IRoleMapper<T> roleMapper, Object... parameters) {
		// TODO Auto-generated method stub
		T obj = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			rs = statement.executeQuery();
			while (rs.next()) {
				obj = roleMapper.roleMapper(rs);
			}
			connection.commit();
			return obj;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return null;
	}

}
