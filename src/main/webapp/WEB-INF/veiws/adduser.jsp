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
      <c:if test="${u==null}">
       <sp:form modelAttribute="user" action="/user/add" method="post">
		    <div class="form-group">
				<label>Enter Username</label>
				<sp:input path="username"   class="form-control" placeholder="Enter Username"/>
				<sp:errors path="username" style="color:red"></sp:errors>
		    </div>
			<div class="form-group">
				<label>Enter Email</label>
				<sp:input path="email" class="form-control" placeholder="Enter Email"/>
				<sp:errors path="email" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter mobileNumber</label>
				<sp:input path="mobile"  class="form-control" placeholder="Enter mobile number"/>
				<sp:errors path="mobile" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter ZipCode</label>
				<sp:input path="add.zipcode"  class="form-control" placeholder="Enter ZipCode"/>
				<sp:errors path="add.zipcode" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter City</label>
				<sp:input path="add.city"  class="form-control" placeholder="Enter City"/>
				<sp:errors path="add.city" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter State</label>
				<sp:input path="add.state"  class="form-control" placeholder="Enter State"/>
				<sp:errors path="add.state" style="color:red"></sp:errors>
			</div>
				<div class="form-group">
				<label>Enter Password</label>
				<sp:input path="password"  class="form-control" placeholder="Enter Password"/>
				<sp:errors path="password" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<input type="submit" value="Add User" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</sp:form>
	</c:if>
	
	  <c:if test="${u!=null}">
       <sp:form modelAttribute="u" action="/user/update" method="post">
			<div class="form-group">
				<label>Userid</label>
				<sp:input path="userid" placeholder="Enter Userid" class="form-control"/>
				<sp:errors path="userid" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Username</label>
				<sp:input path="username" placeholder="Enter Username" class="form-control"/>
				<sp:errors path="username" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<sp:input path="email" placeholder="Enter Email" class="form-control"/>
				<sp:errors path="email" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Mobile</label>
				<sp:input path="mobile" placeholder="Enter Mobile" class="form-control"/>
				<sp:errors path="mobile" class="text-danger"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter ZipCode</label>
				<sp:input path="add.zipcode"  class="form-control" placeholder="Enter ZipCode"/>
				<sp:errors path="add.zipcode" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter City</label>
				<sp:input path="add.city"  class="form-control" placeholder="Enter City"/>
				<sp:errors path="add.city" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter State</label>
				<sp:input path="add.state"  class="form-control" placeholder="Enter State"/>
				<sp:errors path="add.state" style="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<sp:hidden path="authority" />
				<sp:hidden path="enabled"/>
				<sp:hidden path="password"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Update" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
        </sp:form>
	</c:if>
	</div>
</body>
</html>