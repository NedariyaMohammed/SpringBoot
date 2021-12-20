<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
  
 <div class="container">
   
       <sp:form modelAttribute="post" action="/post/add" method="post">
		    <div class="form-group">
				<label>Title</label>
				<sp:input path="posttitle"   class="form-control" placeholder="Enter Post Title"/>
				<sp:errors path="posttitle" style="color:red"></sp:errors>
		    </div>
			<div class="form-group">
				<label>Post Summary</label>
				<sp:textarea path="message" class="form-control" placeholder="Enter Message"/>
				<sp:errors path="message" style="color:red"></sp:errors>
			</div>
			
				
			<div class="form-group">
				<input type="submit" value="Add Post" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</sp:form>

	</div>
</body>
</html>