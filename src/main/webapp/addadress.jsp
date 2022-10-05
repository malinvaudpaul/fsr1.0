<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form method="post" action="AddContactServlet">
		<table>
			<tr>
				<th><h2>Voici un premier exemple de composant web avec un servlet</h2></th>
				<tr>
					<td><i>street: <input type="text" name="street" size="25"></i></td>
				</tr>
				<tr>
					<td><i>city: <input type="text" name="city" size="25"></i></td>
				</tr>
				<tr>
					<td><i>zip: <input type="text" name="zip" size="25"></i></td>
				</tr>
				<tr>
					<td><i>"country": <input type="text" name="country" size="25"></i></td>
				</tr>
				
				<tr>
					<td><input class="button" type="submit" value="Submit" /><input class="button" type="reset" value="Reset"></td>
				</tr>
			
		</table>
	</form>
</html>