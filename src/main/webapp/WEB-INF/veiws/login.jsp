<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	 <div class="container">
	      <sp:form  action="loginaction" method="post">
		    <div class="form-group">
				<label>Enter Username</label>
				<input type="text" name ="username"  class="form-control" placeholder="Enter Username"/>
		    </div>
		
			<div class="form-group">
				<label>Enter Password</label>
				<input type="password" name ="password" class="form-control" placeholder="Enter Password"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Login" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</sp:form>
	 </div>
</body>
</html>