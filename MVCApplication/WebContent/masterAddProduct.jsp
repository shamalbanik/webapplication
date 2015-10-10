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

<form class="form-horizontal" role="form"action="MasterServlet" method="POST">
   <div class="form-group">
      <label for="Name" class="col-sm-2 control-label">Product Name</label>
      <div class="col-sm-10">
         <input name="Name"type="text" class="form-control"
            placeholder="Product Name">
      </div>
   </div>
   <div class="form-group">
      <label for="Description" class="col-sm-2 control-label">Description</label>
      <div class="col-sm-10">
         <input name="Description"type="text" class="form-control"
            placeholder="Enter Description">
      </div>
   </div>
<div class="form-group">
      <label  for="price" class="col-sm-2 control-label">price</label>
      <div class="col-sm-10">
         <input name="price"type="text" class="form-control"
            placeholder="Enter price">
      </div>
   </div>
      <input name="fun" type="hidden" value="add">
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