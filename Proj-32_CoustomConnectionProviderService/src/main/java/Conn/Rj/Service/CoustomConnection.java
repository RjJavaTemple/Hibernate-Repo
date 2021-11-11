package Conn.Rj.Service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CoustomConnection implements ConnectionProvider 
{

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("CoustomConnection.getConnection()");
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:chintu");
		bds.setUsername("system");
		bds.setPassword("123");
		bds.setMaxTotal(20);
		bds.setMinIdle(5);
		//Connection object
		Connection con=bds.getConnection();
		return con;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
