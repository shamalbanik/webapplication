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
<div class="row">

<div class="col-md-6" >

<%
 ProductService productService = new ProductService();
System.out.println("product sssssssssss");
System.out.println(request.getParameter("productId"));
System.out.println("product ddddddddddddd");

Long o=Long.valueOf(request.getParameter("productId").toString());
System.out.println("product "+o);

Product product=productService.getProductByProductId(o);	
System.out.println("product id"+product.getId());
System.out.println("product name"+product.getName());
System.out.println("product Description"+product.getDescription());



%>



<form class="form-horizontal" role="form"action="MasterServlet" method="POST">
   <div class="form-group">
      <label for="Name" class="col-sm-2 control-label">Product Name</label>
      <div class="col-sm-10">
         <input name="Name"type="text" class="form-control" value="<%=product.getName() %>"placeholder="Product Name">
      </div>
   </div>
   <div class="form-group">
      <label for="Description" class="col-sm-2 control-label">Description</label>
      <div class="col-sm-10">
         <input name="Description"type="text" class="form-control"
            placeholder="Enter Description"value=" <%=product.getDescription() %>">
      </div>
   </div>

   <input name="fun" type="hidden" value="edit">
   <input name="fun1" type="hidden" value="<%=product.getId() %>">
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">Sign in</button>
      </div>
   </div>
</form>

</div>

</div>

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