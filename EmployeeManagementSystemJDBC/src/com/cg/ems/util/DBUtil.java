package com.cg.ems.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil
{
	static String url =null;
	static String usn =null;
	static String pwd =null;
	public static Connection getCon() throws Exception
	{
		Properties props=loadDbInfo();
		url=props.getProperty("dbUrl");
		usn=props.getProperty("dbUserName");
		pwd=props.getProperty("dbPassword");
		Connection con = null;
		if(con == null)
		{
			con=DriverManager.getConnection(url,usn,pwd);
			return con;
			
		}
		return con;
		
	}
	
	public static Properties loadDbInfo() throws Exception
	{
		FileReader fr = new FileReader("dbInfo.properties");
		Properties myProps = new Properties();
		myProps.load(fr);
		return myProps;
	}

}