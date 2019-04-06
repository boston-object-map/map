import GeoObjects.College;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Main {


	private String url;
	private String user;
	private String password;
	private Connection con = null;

	public Main() {
		this.url = System.getenv("DBURL");
		this.user = System.getenv("DBUSERNAME");
		this.password = System.getenv("DBPASSWORD");

	}

	public static void main(String[] args) throws SQLException {
		Main main = new Main();

		main.getConnection();
		main.getObjectsInView("X, Y", "college", -80, -60, 40, 44, main::buildColleges);
		main.closeConnection();

	}

	private void buildColleges(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.println(rs.getDouble("X"));
				System.out.println(rs.getDouble("Y"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(this.url, this.user, this.password);
				return con;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		}

		return con;
	}

	private void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void getObjectsInView(
			String columns, String table,
			double x0, double x1, double y0, double y1,
			Consumer<ResultSet> builder)
			throws SQLException {
		Statement stmt = con.createStatement();
		String sqlGet = "SELECT %s FROM %s WHERE X >= %f AND X <= %f AND Y >= %f AND Y <= %f";
		ResultSet rs = stmt.executeQuery(String.format(sqlGet, columns, table, x0, x1, y0, y1));
		builder.accept(rs);
		rs.close();
		stmt.close();
	}
}
