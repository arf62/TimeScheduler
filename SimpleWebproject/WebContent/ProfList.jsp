<%@page import="com.Course"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table align="center" bgcolor="#FFFFCC" border="1" width="70%">
    
    <tr> <td>Professor Name </td>  <td> Get Schedule </td><td>  </td></tr>
    
    
    <%  
// retrieve your list from the request, with casting 
ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("prof");

// print the information about every category of the list
for(Course Co : list) {

%>
 <tr> <td><%= Co.getProfName() %> </td> <td><form name="input" action="to_proftime_Action" method="Post">
<input type="hidden" name="ProfId" value="<%= Co.getProfId() %>">
<input type="submit" value="Click">
</form></td></tr>

   
 <% 
}
%>
</table>
</body>
</html>