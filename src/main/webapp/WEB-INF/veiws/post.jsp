<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<table class="table table-striped table-bordered">
		<tr>
			<th>PostId</th>
			<th>Title</th>
			<th>Summary</th>
		</tr>
		<c:forEach items="${psts}" var="post">
			<tr>
				<td>${post.postid}</td>
				<td>${post.posttitle}</td>
				<td>${post.message}</td>
				<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
					<td>
						<a href="" class="btn btn-warning">Edit</a>
						<a href="" class="btn btn-danger">Delete</a> 
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>