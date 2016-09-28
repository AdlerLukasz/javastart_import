<html>
<head>
	<title>Product explorer</title>
</head>
<body>
<h1>Product manager</h1>

<h2>Add product</h2>
<form action="products?add=true" method="post">
	<input type="text" name="productName" placeholder="Product name" />
	<input type="number" name="productPrice" step="0.1" placeholder="Product price" />
	<input type="text" name="productCategory" placeholder="Product category" />
	<input type="submit" value="Add" />
</form>

<form action="products?add=false" method="post">
	<input type="text" name="query" placeholder="JPQL Query" style="width: 500px" />
	<input type="submit" value="Get" />
</form>

<a href="static">Get products ordered by price</a>
</body>
</html>
