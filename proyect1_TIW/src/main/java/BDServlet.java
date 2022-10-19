


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Servlet implementation class BDServlet
 */
public class BDServlet extends HttpServlet {

	 
////////////////////////////////////////////////////////////////////////////////////////
public void init() {

	// Lee del contexto de servlet (Sesi�n a nivel de aplicaci�n)
	ServletContext context = getServletContext();
}


////////////////////////////////////////////////////////////////////////////////////////
public void doGet(HttpServletRequest req, HttpServletResponse res) 
throws IOException, ServletException {

String database = "usersdb";  // -> Change me
String servername = "localhost";
String port = "3306";
String username  = "alreyl"; // Change me
String password  = "alreyl"; // Change me

// Establece el Content Type
res.setContentType("text/html");
PrintWriter out = res.getWriter();

out.println("<HTML>");
out.println("<HEAD><TITLE>BDServlet</TITLE></HEAD>");
out.println("<BODY bgcolor=\"#ffff66\">");
out.println("<H1><FONT color=\"#666600\">Database: Users</FONT></H1></BR>");
out.println("<FORM METHOD=\"POST\" ACTION=\"" + "\">"); // Se llama as� mismo por POST        


try {

	// 1- Load driver
			// complete
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	// 2- Obtain a Connection object --> con
	String url = "jdbc:mysql://"+servername+":"+port+"/"+database+"?useSSL=false&serverTimezone=UTC";
			// complete
	Connection con = DriverManager.getConnection(url, username, password);

	if (con==null){
		System.out.println("--->UNABLE TO CONNECT TO SERVER:" + servername);
	} else {

	// 3- Obtain an Statement object -> st
		// complete
		Statement st = con.createStatement();
	// 4.- Execute the query "select * from users" 
		// complete
		ResultSet rs = st.executeQuery("select * from users");
				
				
	// 5.- Iterate through the ResultSet obtained and add to the html page the id, name and surname of the users
		// complete
		while (rs.next()) {
			int id = rs.getInt("idusers");
			String sName = rs.getString("name");
			String sSurname = rs.getString("surname");		
			out.println("<h2>"+id+" - "+sName+" - "+sSurname+"</h2>");
		}
		
	// 6.- Close the statemente and the connection
		// complete
		con.close();
	}
} catch (Exception e) {
	out.println("<FONT color=\"#ff0000\">"+e.getMessage()+"</FONT><BR>");
}




out.println("</FORM>");
out.println("</BODY></HTML>");

out.close();
}

////////////////////////////////////////////////////////////////////////////////////////  	
public void doPost(HttpServletRequest req, HttpServletResponse res) 
throws IOException, ServletException {    
}
}