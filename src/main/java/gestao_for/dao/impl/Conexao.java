package gestao_for.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static Connection conectar() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/cad_fornecedor?useTimezone=true&serverTimezone=UTC";
		user = "root";
		password = "123456";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
