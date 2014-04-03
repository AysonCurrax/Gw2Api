<%@page import="java.util.*, java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
	WORLD:
	<select>
		<c:forEach var="world" items="${world_list}">
		<option>${world.name}</option>
		</c:forEach>
	</select>
	MAP:
	<select>
		<c:forEach var="map" items="${map_list}">
		<option>${map.name}</option>
		</c:forEach>
	</select>
	</form>
	<c:forEach var="event" items="${events}">
		${event.worldId} - ${event.mapId} - ${event.eventId} - ${event.state}
		
	</c:forEach>
<input type="button" value="Reload Page" onClick="document.location.reload(true)">
</body>
</html>