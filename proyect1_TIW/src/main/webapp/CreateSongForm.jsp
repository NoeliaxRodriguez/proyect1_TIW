<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Crea una nueva canción: </h1>

	<form action="CreateSong" method="post">

		<label for="i-name"> Nombre </label> <input id="i-name" type="text"
			name="name" /> <br><label for="i-duration"> Duration </label> <input
			id="i-duration" type="text" name="duration" /> <br> <label for="i-artist">
			Artist </label> <input id="i-artist" type="text" name="artist" /> <br> <label
			for="i-score"> Score </label> <input id="i-score" type="text"
			name="score" />  <br> <input type="submit" value="Submit" />
	</form>




</body>
</html>