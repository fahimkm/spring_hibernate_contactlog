<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}
table, th, td {
  border: 1px solid black;
}
table.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>Search Contact</title>
</head>
<body>

<h1>Search For Contact </h1><br><br>
<form action="search1" method="post">
		<div>
			name : <input type="text" name="name"><br><br><br>
		</div>
		
		<div>
			<input type="submit" value="Search Database">
		</div>
		
		<h1>Contact List</h1>
		
			<div>
			
		<c:if test="${!empty contacts}">

				<c:forEach items="${contacts}" var="emp">
				<table align = 'center'>
					<thead>
		<tr><td><p style="color:red">Name : ${emp.name}</p></td>
		<td><p style="color:red">number : ${emp.number}</p></td></tr>
					
		<tr><td><p style="color:red">email : ${emp.email}</p></td>
		<td><p style="color:red">category : ${emp.category}</p></td></tr>
					
					<tr><td><p style="color:red">Address Line : ${emp.address.addressLine }</p></td>
					<td><p style="color:red">Pincode : ${emp.address.pincode }</p></td></tr>
					<tr><td><p style="color:red">City : ${emp.address.city }</p></td>
						<td><a href="removecontact?id=${emp.id}">Delete</a>
						 : <a href="update?id=${emp.id}">Update</a></td>
					</tr>
					</thead>
				</table>
				<Br><br>
				</c:forEach>


		</c:if>
		
	
		</div>
		<br><br>	
</form>
<a href="index1"><button>Go Back</button></a>
</body>
</html>
