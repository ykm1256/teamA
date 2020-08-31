package com.mypt.connection;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	
	private static DBConnection instance = new DBConnection();
	public static DBConnection getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception { // �ڹ�sql ����Ʈ
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");	//lookup���� ���� ã��
		DataSource ds = (DataSource)envCtx.lookup("jdbc/mysql");
		return ds.getConnection();
	}
	

}
