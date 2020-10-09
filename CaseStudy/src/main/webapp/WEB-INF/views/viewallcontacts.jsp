<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Contact List</title>
</head>
<body>


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
						<td><a href="removecontact?id=${emp.id}"><button>Delete</button></a>
						 : <a href="update?id=${emp.id}"><button>Update</button></a></td>
					</tr>
					</thead>
				</table>
				<Br><br>
				</c:forEach>


		</c:if>
		
	
		</div>
<br>
<a href="index1"><button>Go Back</button></a>
	

</body>
</html>