<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/resources/css" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap CSS theme -->

<!-- Bootstrap CSS theme -->
<link href="${css}/datatables.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>
<body>


<div class="wrapper">

<!-- Navigation -->
<nav clss="navbar navbar-inverse navbar-fixed-top">
<div class="container">
<div class="navbar-header">
<a class="navbar-brand" href="${contextRoot}/home">Home</a>
</div>
</div>
</nav>

<!-- Page Content -->
<div clss="content">
<div class="container">
<div class="row">
<div class="col-xs-12">
<div class="jumbotron">
<h2>${errorTitle }</h2>
<hr>
<blockquote>
${errorDescription}
</blockquote>
</div>
</div>
</div>
</div>
</div>
<!-- /.container -->

<!-- Footer -->
<%@include file="./shared/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="${js}/jquery.min.js"></script>
<script src="${js}/popper.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<!-- DataTable JQuery plugin-->
<script src="${js}/jquery.datatables.js"></script>
<!-- Bootstrap jquery datatable -->
<script src="${js}/datatables.bootstrap.js"></script>
<!-- SELF CODED JAVASCRIPT -->
<script src="${js}/myapp.js"></script>
</div>



</body>
</html>