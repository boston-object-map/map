package Database;

import GeoObjects.College;
import GeoObjects.IGeoObject;

import java.sql.*;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class DBUtils {


	private String url;
	private String user;
	private String password;
	private Connection con = null;

	public DBUtils() {
		this.url = System.getenv("DBURL");
		this.user = System.getenv("DBUSERNAME");
		this.password = System.getenv("DBPASSWORD");

	}

	public static void main(String[] args) throws SQLException {
		DBUtils dbUtils = new DBUtils();

		dbUtils.getConnection();
		List<IGeoObject> geodes = dbUtils.getObjectsInView("X, Y, OBJECTID, Name, Address, PhoneNumbe, NumStudents13", "college", -80, -60, 40, 44, College::buildColleges);
		dbUtils.closeConnection();

	}

	public void getConnection() {
		if (this.con == null) {
			try {
				this.con = DriverManager.getConnection(this.url, this.user, this.password);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		}
	}

	public void closeConnection() {
		try {
			this.con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<IGeoObject> getObjectsInView(
			String columns, String table,
			double x0, double x1, double y0, double y1,
			Function<ResultSet, List<IGeoObject>> builder)
			throws SQLException {
		Statement stmt = con.createStatement();
		String sqlGet = "SELECT %s FROM %s WHERE X >= %f AND X <= %f AND Y >= %f AND Y <= %f";
		ResultSet rs = stmt.executeQuery(String.format(sqlGet, columns, table, x0, x1, y0, y1));
		List<IGeoObject> geoObjects = builder.apply(rs);
		rs.close();
		stmt.close();
		return geoObjects;
	}
}
