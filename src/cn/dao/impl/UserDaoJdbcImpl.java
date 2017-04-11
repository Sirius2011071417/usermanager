package cn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.dao.UserDao;
import cn.domain.User;
import cn.exception.DaoException;
import cn.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils.getConnect();
			String sql = "insert into users(id,username,password,email,birthday,nickname) values(?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setString(4, user.getEmail());
			st.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
			st.setString(6, user.getNickname());
			int num = st.executeUpdate();
			if(num<=0) {
				throw new RuntimeException();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public User find(String username, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils.getConnect();
			String sql = "select * from users where username=? and password=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setBirthday(rs.getDate("birthday"));
				user.setEmail(rs.getString("email"));
				user.setId(rs.getString("id"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				return user;
			}
			return null;
		}catch (Exception e) {
			throw new DaoException();
		}finally {
			JdbcUtils.release(conn, st, rs);
		}
	}

	@Override
	public boolean find(String username) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnect();
			String sql = "select * from users where username=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			
			rs = st.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		}catch (Exception e) {
			throw new DaoException(e); 
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
