package com.xiaotuanti.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource ;

/**
 * 
 * @author rovo98
 * c3p0���ݿ����ӳ�
 */
public class C3p0Utils {
	
	// ͨ����ʶ����������Ӧ�����ݿ����ӳ�
	private static ComboPooledDataSource c3p0DataSource ;
	// ��̬�������ò���
	static {
		c3p0DataSource  = new ComboPooledDataSource("mysql") ;
	}
	
	/**
	 * �����ӳ��л�ȡһ�����ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return c3p0DataSource.getConnection() ;
		}catch (Exception e) {
			e.printStackTrace() ;
			return null ;
		}
	}
	/**
	 * �ͷ����ӷ������ӳ�
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close() ;
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close() ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close() ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
