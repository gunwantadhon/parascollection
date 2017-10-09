<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 

        

          <h1 class="my-4">Shop Name</h1>
          
          <div class="list-group">
           <c:forEach items="${categories}" var="category">
           
		<a href="/parascollection/show/category/${category.id}/products"
		class="list-group-item" id="a_${category.name}">${category.name}</a>
		
		</c:forEach> 

        </div>

       
      
      </div>
</body>
</html>