<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url var="css" value="/resources/css"/>
<s:url var="images" value="/resources/images"/>
<s:url var="js" value="/resources/js"/>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <link href="${css}/myapp.css" rel="stylesheet">



    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    
     <link href="${css}/datatables.min.css" rel="stylesheet">
    
    
    

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot='${contextRoot}'
</script>


  </head>

  <body>
   
   <%@include file="./shared/navbar.jsp"%>
  
  
<div class="wrapper">
 <div class="container">

<c:if test="${userClickHome==true}">
<%@include file="home.jsp"%>
</c:if>


<c:if test="${userClickAbout==true}">
<%@include file="about.jsp"%>
</c:if>


<c:if test="${userClickContact==true}">
<%@include file="contact.jsp"%>
</c:if>

<c:if test="${userClickAllProducts==true}">
<%@include file="listProducts.jsp"%>
</c:if>

<c:if test="${userClickCategoryProducts==true}">
<%@include file="listProducts.jsp"%>
</c:if>


<!-- load only when user clicks show product -->
<c:if test="${userClickShowProduct==true}">
<%@include file="singleProduct.jsp"%>
</c:if>


<c:if test="${userClickMangerProducts==true}">
<%@include file="manageProduct.jsp"%>
</c:if>

  </div>  
 
  
         
    <%@include file="./shared/footer.jsp"%>
    
</div><!-- wrapper-->

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/popper.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    
    
    <!-- DataTable JQuery plugin-->
     <script src="${js}/jquery.dataTables.js"></script>
     
     <!-- Bootstrap jquery datatable -->
     <script src="${js}/dataTables.bootstrap.min.js"></script>
     
     <!--  SELF CODED JAVASCRIPT -->
      <script src="${js}/myapp.js"></script>
      
      
      
      <!-- for the Alert javascript bootbox -->
      <script src="${js}/bootbox.min.js"></script>
      
      <!-- JQuery Client Side Validation  -->
      
      <script src="${js}/jquery.validate.js"></script>
      
      
       
      


 
  </body>

</html>
