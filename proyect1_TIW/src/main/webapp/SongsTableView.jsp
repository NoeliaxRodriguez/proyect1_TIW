<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Song"%>
<!DOCTYPE html>
<html>
<head>


<style>
* {
	box-sizing: border-box; 
	margin : 0;
	padding: 0;
}

thead {
	background: teal;
	color: white;
}

tbody {
	background: #cafc9c;
}

table {
	overflow-x: auto;
}
</style>
<meta charset="UTF-8">
<title>List songs</title>
</head>
<body>




	<jsp:useBean id="songList" class="java.util.ArrayList<Song>"
		scope="request" />


	<h1>All songs are here:</h1>

	<%
	boolean listEmpty = songList.isEmpty();

	if (!listEmpty) {
	%>
	<table>
		<thead>
			<tr>
				<th>Name
				<th />
				<th>Artist
				<th />
				<th>Duration
				<th />
				<th>Score
				<th />
			</tr>
		<thead />

		<tbody>
			<%
			for (Song song : songList) {
			%>
			<tr>
				<td><%=song.getSongName()%></td>
				<td><%=song.getArtist()%></td>
				<td><%=song.getDuration()%></td>
				<td><%=song.getScore()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%
	} else {
	%>

	<h2>No hay nada en la base de datous</h2>



	<%
	}
	%>



</body>
</html>