<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.ProductService"%>
<%@page import="com.javawebtutor.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/myScripts.css"/>
<title>Insert title here</title>
</head>
<body>


<div class="container">
	<div class="row">
		<div class="col-xs-12 " id="head"style="">
			<h1>web application</h1>
		</div>
		
	</div>
</div>	
	
<div class="container">	
	
	
	
	
	<h1><%
	request.getAttribute("id");
	
	
	%>
	</h1>
	<div class="row">
	<div class="col-md-12">
	<h1><a href="MasterServlet?id=AddProduct">ADD PRODUCT</a></h1>
	</div>
	</div>

   <table class="table table-hover">
      <caption>Product list</caption>
      <thead>
         <tr>
            <th>Product</th>
            <th>Description</th>
            <th>amount</th>
            <th>stock</th>
            <th>avg price</th>
         </tr>
      </thead>
      <tbody>
      <%
      ProductService productService = new ProductService();
                     List<Product> list = productService.getListOfProducts();
                     for (Product u : list) {
                 %>
         <tr>
            <td><%=u.getName().toString() %></td>
            <td><%=u.getDescription().toString()%></td>
            <td><%=u.getPrice()%></td>
            <td><%=u.getStock()%></td>
            <td><%=u.getAproxPrice() %></td>
            <td><a href="MasterServlet?id=EditProduct&productId=<%=u.getId()%>">edit</a></td>
            <td><a href="MasterServlet?id=DeletProduct&productId=<%=u.getId()%>">Remove</a></td>
         </tr>
         <%}%>
      </tbody>
   </table>

</div>	
	
	
<div class="container">	
	<div class="row">
		<div class="col-xs-12 " id="foot">
		
		
		</div>
	
	
	</div>
</div>



</body>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
</html>