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
  border-collapse: collapse;
}
table.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
<body>
<h1>Add Contact to List</h1>

	<form action="addContact" method="post">
	<table>
				<thead>
					<tr>
			<td>  Name : </td> <td><input type="text" name="name"></td></tr>
			
					<tr>
			<td>Number :</td><td>  <input type="text" name="number"></td>
					</tr>
					<tr>
			<td> Email :</td><td> <input type="text" name="email"></td>
					</tr>
					<tr>
	  <td>	AddressLine :</td><td> <input type="text" name="addressLine"></td>
					</tr>
					<tr>
			<td> PinCode : </td><td><input type="text" name="pincode"></td>
					</tr>
					<tr>
		<td>	City : </td><td><input type="text" name="city"></td>
					<tr>
		<td>	Category :</td> <td><select name="category">
						<option>friends</option>
						<option>business</option>
						<option>family</option>
			</select>
			</td>
			</tr>
			</thead>
			</table>
		<input type="submit" value="Add Contact"><br><br>
	</form>
	<a href="index1"><button>Go Back</button></a>  <a href="viewallcontacts"><button>View All Contacts</button></a><br>
<br>
	
</body>
</html>