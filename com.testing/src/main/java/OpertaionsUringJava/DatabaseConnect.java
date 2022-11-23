package OpertaionsUringJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "postgres",
				"postgres");

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * from public.company_type");
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numCol = metaData.getColumnCount();
		// print the column names
		for (int j = 1; j <= numCol; j++) {
			System.out.print(metaData.getColumnName(j) + "\t\t");
			
		}
		System.out.println(" ");
		// Print the Column Data
		while (resultSet.next()) {

			for (int i = 1; i <= numCol; i++) {
				if ((metaData.getColumnTypeName(i)).contains("int") || (metaData.getColumnTypeName(i)).contains("num")
						|| (metaData.getColumnTypeName(i)).contains("serial")) {
					System.out.print(resultSet.getInt(i)+ "\t\t");
				} else if ((metaData.getColumnTypeName(i)).contains("char")) {
					System.out.print(resultSet.getString(i)+ "\t\t");
				} else {
					System.out.print(resultSet.getTime(i)+ "\t\t");
				}
			}
			System.out.println();
		}
		// Close Connection
		resultSet.close();
		statement.close();
		connection.close();
	}
}