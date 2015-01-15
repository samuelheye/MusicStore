	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
<!-- 	<div class="container-fluid"> -->
		<div class="navbar-header">
			<div class="logo">
					<a href="<%=request.getContextPath()%>/"><img height="52px" 
						src="<%=request.getContextPath()%>/resources/images/logo.PNG"
						alt="" /> 
				</div></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/">Home</a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle">Manage Songs<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/MusicStore/getAddSongPage">Add Song</a></li>
						<li><a href="/MusicStore/	">View Songs</a></li>
					</ul></li>
			</ul>

			<div class="col-sm-3 col-md-3 pull-right">
				<form class="navbar-form" role="search"
					action="/MusicStore/searchSong">
					<div class="input-group ">
					<input type="text" class="form-control" style="width:280px"
						placeholder="Search song by name or by artist name"
						name="criteria" value="" />
					<div class="input-group-btn">
						<button type="submit" class="form-control btn btn-success">
							<span class="glyphicon glyphicon-search"></span>	
						</button>
					</div>
					
					
					</div>
				</form>
			</div>
			
		</div>
	
	</nav>