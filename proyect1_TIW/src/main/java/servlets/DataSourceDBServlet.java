package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/* Equivalente usando datasource */
@WebServlet("/DataSourceDBServlet")
public class DataSourceDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataSourceDBServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	InitialContext payaraContext;
	DataSource ds;
	Connection conn;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		try {
			payaraContext = new InitialContext();
		} catch (NamingException e1) {

			e1.printStackTrace();
		}

		try {
			ds = (DataSource) payaraContext.lookup("TIWDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		try {
			conn = ds.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			out.append("<h1> AY MAE </h1>");
			conn.setAutoCommit(true);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from users");

			// 5.- Iterate through the ResultSet obtained and add to the html page the id,
			// name and surname of the users
			// complete
			while (rs.next()) {
				int id = rs.getInt("idusers");
				String sName = rs.getString("name");
				String sSurname = rs.getString("surname");
				out.println("<h2>" + id + " - " + sName + " - " + sSurname + "</h2>");
			}

			// 6.- Close the statemente and the connection
			// complete
			conn.close();
		} catch (Exception e) {
			out.println("<FONT color=\"#ff0000\">" + e.getMessage() + "</FONT><BR>");
		}

	}

}
