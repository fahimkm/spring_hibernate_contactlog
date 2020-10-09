<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

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
<meta charset="ISO-8859-1">
<title>Update Contact</title>
</head>
<body>
<h1>Update Contact Details</h1><br>

<form action="update1" method="post">
		<table>
				<thead>
					<tr>
			<td>  Name : </td> <td><input type="text" name="name" value = "${contact.name}"></td></tr>
			
					<tr>
			<td>Number :</td><td>  <input type="text" name="number" value = "${contact.number}"></td>
					</tr>
					<tr>
			<td> Email :</td><td> <input type="text" name="email" value = "${contact.email}"></td>
					</tr>
					<tr>
	  <td>	AddressLine :</td><td> <input type="text" name="addressLine" value = "${contact.address.addressLine}"></td>
					</tr>
					<tr>
			<td> PinCode : </td><td><input type="text" name="pincode" value = "${contact.address.pincode}"></td>
					</tr>
					<tr>
		<td>	City : </td><td><input type="text" name="city" value = "${contact.address.city}"></td>
					<tr>
		<td>	Category :</td> <td><select name="category">
						<option>friends</option>
						<option>business</option>
						<option>family</option>
			</select>
			</td>
			</tr>
			<tr></tr>
			</thead>
			</table>
		<input type="submit" value="Update Employee"><br><br>
		

</form>
<a href="index1"><button>Go Back</button></a>
</body>
</html>