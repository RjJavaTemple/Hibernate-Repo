package Conn.Rj.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CoustomJdbcConnection implements ConnectionProvider {

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
		System.out.println("CoustomJdbcConnection.getConnection()");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:chintu","system","123");
		return con;
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("CoustomJdbcConnection.closeConnection()");
		con.close();

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
