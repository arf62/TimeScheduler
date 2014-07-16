<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String[] rooms={"fh_346", "fh_363", "fh_372", "fh_450a", "fh_451", "fh_457", "fh_460", "fh_462", "fh_463", "fh_464", "fh_535", "fh_557", "fh_560", "fh_560h"};
           
           
           
            %>


<table align="center" bgcolor="#99FFCC" border="1" width="70%">
   
   <% for(int i=0;i< rooms.length;i++) {%>
   
    <tr>
        <td><form name="input" action="get_room_details" method="Post">
<input type="hidden" name="room" value="<%= rooms[i]%>">
<input type="submit" value="<%= rooms[i]%>">
</form></td>
    </tr>
   <% }%>
    
    <tr>
        <td colspan="2" align="center"><a href="MasterPage.jsp">Back</a></td>
    </tr>
</table>


</body>
</html>