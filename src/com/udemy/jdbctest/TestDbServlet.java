package com.udemy.jdbctest;

import javax.servlet.ServletException;
		import javax.servlet.annotation.WebServlet;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import java.io.IOException;
		import java.io.PrintWriter;
		import java.sql.Connection;
		import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection to database

		try (final PrintWriter writer = resp.getWriter()){
			writer.println("Connecting to database: " + url);
			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(url, user, pass);
			writer.println("SUCCESS !!!");
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException();
		}

	}
}