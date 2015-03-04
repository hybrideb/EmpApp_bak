package webapp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import webapp.dao.DeptDao;
import webapp.exception.ConnectionFailException;
import webapp.exception.DeptAccessException;
import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.util.EmployeeDataSource;
import webapp.util.GlobalVars;

public class DeptInfoService {
	DeptDao deptdao;
	DataSource dataSource;

	public void setDeptdao(DeptDao deptdao) {
		this.deptdao = deptdao;
	}

	public void setDatasource(DataSource datasource) {
		this.dataSource = datasource;
	}

	public Dept getDeptInfo(Integer deptno) {

		// All or Nothing
//		DataSourceTransactionManager tm = new DataSourceTransactionManager(
//				dataSource);
//		TransactionStatus status = null;
//		try {
//			status = tm.getTransaction(null);
//		} catch (TransactionException e) {
//			tm.rollback(status);
//			throw new ConnectionFailException("Transaction begin fail", e);
//		}
		// try {
		// Connection con = datasource.getConnection();
		// GlobalVars.con.set(con);
		// } catch (SQLException e) {
		// throw new ConnectionFailException("connection fail", e);
		// }

		Dept dept = deptdao.selectByDeptno(deptno);


		return dept;
	}
	
	public Dept getDeptInfoWithEmps(Integer deptno){
		
//		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
//		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//		definition.setReadOnly(true);
//		
//		TransactionStatus status = tm.getTransaction(definition);
//		
		Dept dept = deptdao.selectByDeptnoWithEmps(deptno);
		
//		if(dept == null)
//			throw new DeptAccessException("Dept Not Found");
//		
//		tm.commit(status);
		
		return dept;
	}

}
