<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

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

<div class="container">
<div class="row">

 <div class="col-md-6 col-md-offset-3">

 <div class="panel panel-primary">

 <div class="panel-heading">
 <h4>Sign Up - Address</h4>
 </div>

 <div class="panel-body">

 <sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">

 
 <div class="form-group">
 <label class="control-label col-md-4" for="addressLineOne">Address
Line One</label>
 <div class="col-md-8">
 <sf:input type="text" path="addressLineOne" class="form-control"
 placeholder="Enter Address Line One" />
 </div>
 </div>
 
 <div class="form-group">
 <label class="control-label col-md-4" for="addressLineTwo">Address
Line Two</label>
 <div class="col-md-8">
 <sf:input type="text" path="addressLineTwo" class="form-control"
 placeholder="Enter Address Line Two" />
 </div>
 </div>
 
 <div class="form-group">
 <label class="control-label col-md-4" for="city">City</label>
 <div class="col-md-8">
 <sf:input type="text" path="city" class="form-control"
 placeholder="Enter City Name" />
 </div>
 </div>

 <div class="form-group">
 <label class="control-label col-md-4" for="postalCode">Postal
Code</label>
 <div class="col-md-8">
 <sf:input type="text" path="postalCode" class="form-control"
 placeholder="XXXXXX" />
 </div>
 </div>

 <div class="form-group">
 <label class="control-label col-md-4" for="state">State</label>
 <div class="col-md-8">
 <sf:input type="text" path="state" class="form-control"
 placeholder="Enter State Name" />
 </div>
 </div>
 
 <div class="form-group">
 <label class="control-label col-md-4" for="country">Country</label>
 <div class="col-md-8">
 <sf:input type="text" path="country" class="form-control"
 placeholder="Enter Country Name" />
 </div>
 </div>


 <div class="form-group">
 <div class="col-md-offset-4 col-md-8">
 <!-- submit button for moving to the personal -->
 
 <button type="submit" class="btn btn-primary"
name="_eventId_personal">
<span class="glyphicon glyphicon-chevronleft"></span>Previous
Personal
</button>

 <!-- submit button for moving to the confirm -->

 <button type="submit" class="btn btn-primary"
name="_eventId_confirm">
Next Confirm <span class="glyphicon glyphiconchevron-right"></span>
</button>
 </div>
 </div>


 </sf:form>
 </div>
 </div>
 </div>
 </div>
</div>
<%@include file="../shared/flow-footer.jsp"%>









</body>
</html>