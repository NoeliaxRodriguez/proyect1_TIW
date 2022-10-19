package servlets;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Song;


@WebServlet("/SearchSongByIdForEdit")
public class SearchSongByIdForEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "TIWDS")
	DataSource ds;
	Connection conn;

	public SearchSongByIdForEdit() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			conn = ds.getConnection();

			Statement st = conn.createStatement();
			java.sql.ResultSet rs = st.executeQuery("SELECT * FROM songsdb WHERE SongID=" + id);
			rs.next();
			Song s = new Song(rs.getString("SongName"), rs.getInt("Duration"), rs.getString("Artist"),
					rs.getInt("Score"));

			request.setAttribute("id", id);
			request.setAttribute("song", s);

			request.getRequestDispatcher("EditOrDeleteSong.jsp").forward(request, response);
			conn.close();

		} catch (Exception e) {
			response.getWriter().append(" " + e.getStackTrace());
			System.out.println(e.getStackTrace());
		}
	}

}
