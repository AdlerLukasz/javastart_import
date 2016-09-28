<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<h2>Order manager</h2>

<h3>Add client with order</h3>
<form action="addclientorder" method="post">
	<input type="text" name="firstName" placeholder="Client first name" />
	<br />
	<input type="text" name="lastName" placeholder="Client last name" />
	<br />
	<input type="text" name="address" placeholder="Address" />
	<br />
	<input type="text" name="orderDetails" placeholder="Order details" />
	<br />
	<input type="submit" value="Add Client with order" />
</form>

<h3>Remove client</h3>
<form action="removeclient" method="post">
	<input type="number" name="clientId" placeholder="Client ID" />
	<br />
	<input type="submit" value="Remove Client" />
</form>

</body>
</html>