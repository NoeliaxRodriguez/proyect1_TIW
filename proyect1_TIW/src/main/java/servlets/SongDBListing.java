package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Song;

@WebServlet("/SongDBListing")
public class SongDBListing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "TIWDS")
	DataSource ds;
	Connection conn;

	public SongDBListing() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			conn = ds.getConnection();
			Statement sqlSt = conn.createStatement();
			ResultSet rs = 	sqlSt.executeQuery("SELECT * FROM songsdb");
			
			ArrayList<Song> songList  = new ArrayList<Song>();
			
			
			//(SongID int, SongName varchar(255),Duration int, Artist varchar(255), Score int)
			
			while(rs.next()) {
				
				String name = rs.getString("SongName");
				int duration = rs.getInt("Duration");
				String artist = rs.getString("Artist");
				int score = rs.getInt("Score");
				//Añadimos a la lista de canciones.
				songList.add(new Song(name,duration,artist,score));
				
				System.out.println("Songdb listing -----");
				
				
			}
			
			request.setAttribute("songList", songList);
			request.getRequestDispatcher("SongsTableView.jsp").forward(request, response);;
		
		}catch(Exception e) {
			
			System.out.println("Songdb listing error");
			out.println("CRAP: "+e.getClass() + " "+ e.getMessage()	);
			out.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
