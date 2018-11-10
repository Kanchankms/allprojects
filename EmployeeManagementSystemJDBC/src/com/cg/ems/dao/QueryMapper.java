package com.cg.ems.dao;
public interface QueryMapper
{
	public static final String SELECTQRY1 = "SELECT * FROM emp112081";//static becoz no question mark
	public static final String SELECTQRY2 = "SELECT * FROM emp112081 WHERE emp_id = ?";
	public static final String SELECTQRY3 = "SELECT * FROM emp112081 WHERE emp_name = ?";
	public static final String DELETEQRY1 = "DELETE  FROM emp112081 WHERE emp_id = ?";
	public static final String INSERTQRY1 = 
								"INSERT INTO emp112081 VALUES(333,'SUNIL',34000,'24-Jan-2018')";
	public static final String INSERTQRY2 = "INSERT INTO emp112081 (emp_id,emp_name,emp_sal)"+
	                  								"VALUES(444,'Amit',60000)";
	public static final String INSERTQRY3 = "INSERT INTO emp112081 (emp_id,emp_name,emp_sal)"+
													"VALUES(?,?,?)";
	public static final String UPDATEQRY1 = "UPDATE emp112081 SET emp_name = ?,emp_sal = ?"+
										"WHERE emp_id = ?";
}
