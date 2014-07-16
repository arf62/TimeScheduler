<%@page import="com.Course"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer Details</title>
</head>
<body>

<table align="center" bgcolor="#FFFFCC" border="1" width="70%">
    
    <tr> <td>Course Name </td> <td> Course id</td> <td> Professor Id</td> <td> Class Level</td> <td> Credit hours</td> <td> Course Description </td><td>  </td></tr>
    
    
    <%  
// retrieve your list from the request, with casting 
ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("cust");

// print the information about every category of the list
for(Course Co : list) {

%>
 <tr> <td><%= Co.getcourse_name() %> </td> <td> <%= Co.getcourse_id() %></td> <td> <%= Co.getProfId() %></td> <td> <%= Co.getclass_level() %></td> <td> <%= Co.getcredit_hours() %></td> <td><%= Co.getCourse_desc() %> </td><td><form name="input" action="form_action_Course" method="Post">
<input type="hidden" name="Course" value="<%= Co.getReference() %>">
<input type="submit" value="Submit">
</form></td></tr>

   
 <% 
}
%>
     </table>
</body>
</html>