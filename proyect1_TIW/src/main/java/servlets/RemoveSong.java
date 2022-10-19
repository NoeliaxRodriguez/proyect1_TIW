package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/RemoveSong")
public class RemoveSong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "TIWDS")
	DataSource ds;

	Connection conn;

	public RemoveSong() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			conn = ds.getConnection();

			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM songsdb WHERE SongID =" + id);

			request.getRequestDispatcher("SongDBListing").forward(request, response);
			conn.close();
		} catch (Exception e) {

			response.getWriter().append(" " + e.getStackTrace());

		}
	}

}
