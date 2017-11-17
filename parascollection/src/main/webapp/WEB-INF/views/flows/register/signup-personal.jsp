<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="ss"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Online Shopping ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap CSS theme -->
<link href="${css}/paper-bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap CSS theme -->
<link href="${css}/datatables.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<script type="text/javascript">
window.menu = '${title}';
window.contextRoot='${contextRoot}'
</script>

</head>
<body>

<div class="row">

<div class="col-md-6 col-md-offset-3">

 <div class="panel panel-primary">

 <div class="panel-heading">
 <h4>Sign Up - Personal</h4>
 </div>

 <div class="panel-body">

 <ss:form  method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">


 <div class="form-group">
 <label class="control-label col-md-4">First Name</label>
 <div class="col-md-8">
 <ss:input type="text" path="firstname" class="form-control" placeholder="First Name" />
 </div>
 </div>
 
 <%-- <div class="form-group">
 <label class="control-label">FirstName</label>
<ss:input type="text" path="firstname" class="form-control"/>
 
 
 </div> --%>
 
 
 
 
 <div class="form-group">
 <label class="control-label col-md-4">Last Name</label>
 <div class="col-md-8">
 <ss:input type="text" path="lastname" class="form-control" placeholder="Last Name" />
 </div>
 </div>

 <div class="form-group">
 <label class="control-label col-md-4">Email</label>
 <div class="col-md-8">
 <ss:input type="text" path="email" class="form-control" placeholder="abc@zyx.com" />
 </div>
 </div>
 
 <div class="form-group">
 <label class="control-label col-md-4">Contact Number</label>
 <div class="col-md-8">
 <ss:input type="text" path="contactNumber" class="form-control" placeholder="XXXXXXXXXX" maxlength="10" />
 </div>
 </div>

 <div class="form-group">
 <label class="control-label col-md-4">Password</label>
 <div class="col-md-8">
 <ss:input type="password" path="password" class="form-control" placeholder="Password" />
 </div>
 </div>

 <!-- radio button using bootstrap class of radio-inline -->
 <div class="form-group">
 <label class="control-label col-md-4">Select Role</label>
 <div class="col-md-8">
 <label class="radio-inline"><ss:radiobutton path="role" value="USER" checked="checked"/>User</label>
 <label class="radio-inline">
 <ss:radiobutton path="role" value="SUPPLIER"/> Supplier
 </label>
 </div>
 </div>
 
 <div class="form-group">
 <div class="col-md-offset-4 col-md-8">
 
<!-- submit button inside the form -->
<button type="submit" class="btn btn-primary" name="_eventId_billing">
Next Billing <span class="glyphicon glyphiconchevron-right"></span>
</button>

 </div>
 </div>
 
 </ss:form>
 
 </div>
 </div>
 </div>

 </div>
 

<%@include file="../shared/flow-footer.jsp"%>
</body>
</html>