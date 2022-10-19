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

import beans.Song;

@WebServlet("/EditSongData")
public class EditSongData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "TIWDS")
	DataSource ds;

	Connection conn;

	public EditSongData() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt( request.getParameter("id"));
			Song s = new Song(request.getParameter("name"), Integer.parseInt(request.getParameter("duration")),
					request.getParameter("artist"), Integer.parseInt(request.getParameter("score")));

			conn = ds.getConnection();

			//SongID int auto_increment PRIMARY KEY, SongName varchar(255),Duration int, Artist varchar(255), Score int
			
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE songsdb SET SongName = '" + s.getSongName() + "', Duration = " + s.getDuration()
					+ " ,  Artist= '" + s.getArtist() + "' , Score = " + s.getScore() + " WHERE SongID = " + id);

			request.getRequestDispatcher("SongDBListing").forward(request, response);

			conn.close();
		} catch (Exception e) {

			response.getWriter().append(" " + e.getMessage()).append("" + e.getClass()).close();
			;

		}
	}

}
