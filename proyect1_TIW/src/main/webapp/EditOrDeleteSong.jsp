<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Song"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	int id = (int) request.getAttribute("id");

	Song s = (Song) request.getAttribute("song");
	%>




	<form method="post" action="EditSongData">
		<input type="hidden" name="id" value="<%=id%>" /> <label>
			name</label> <input name="name" value="<%=s.getSongName()%>" /> <br><label>
			duration</label> <input name="duration" type="number"
			value="<%=s.getDuration()%>" /> <br> <label> artist</label> <input
			name="artist" value="<%=s.getArtist()%>" /> <br> <label> score</label> <input
			name="score" value="<%=s.getScore()%>" /> <br><input type="submit"
			value="Confirm Changes">

	</form>

	<form action="RemoveSong" method="post">
		<input type="hidden" name="id" value="<%=id%>" /> <input
			type="submit" value="Delete">

	</form>





</body>
</html>