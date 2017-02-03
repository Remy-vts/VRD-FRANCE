package hei.devweb.projet.dao.impl;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Before;

import hei.devweb.projet.dao.impl.DataSourceProvider;

public abstract class AbstractDaoTestCase {

	@Before
	public void initDataBase() throws Exception {
		try(
	        Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
	        Statement statement = connection.createStatement()){
	        this.insertDataSet(statement);
		}
	}
	
	public abstract void insertDataSet(Statement statement) throws Exception;
}
