<%@page import="com.TimeSchedule"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><table align="center" bgcolor="#FFFFCC" border="1" width="70%">
    
     <tr> <td>Time</td> <td>Monday</td> <td>Tuesday</td> <td>Wednesday</td> <td>Thursday</td> <td>Friday</td></tr>
    
    
    <%  
// retrieve your list from the request, with casting 
ArrayList<TimeSchedule> list = (ArrayList<TimeSchedule>) request.getAttribute("var");

// print the information about every category of the list
for(TimeSchedule Co : list) {

%>
 <tr> <td><%= Co.getTimeBlock() %> </td> <td> <%= Co.getMonday() %></td> <td> <%= Co.getTuesday() %></td> <td> <%= Co.getWednesday() %></td> <td> <%= Co.getThursday() %></td> <td><%= Co.getFriday() %> </td></tr>

   
 <% 
}
%>
    </table>

</body>
</html>