package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllRoomsServlet
 */
@WebServlet("/AllRoomsServlet")
public class AllRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Room = request.getParameter("room");
		
		ArrayList<TimeSchedule> list = new ArrayList<TimeSchedule>();
	
        try
        {
         // Load the database driver
        	Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
           

         // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "root");            // Print all warnings
         
            for( SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning() )
            {
             System.out.println( "SQL Warning:" ) ;
             System.out.println( "State  : " + warn.getSQLState()  ) ;
             System.out.println( "Message: " + warn.getMessage()   ) ;
             System.out.println( "Error  : " + warn.getErrorCode() ) ;
            }

         // Get a statement from the connection
         java.sql.Statement stmt = conn.createStatement() ;
         //

         // Execute the query
         ResultSet rs = stmt.executeQuery( "select * from mydb."+Room+";" ) ;

         // Loop through the result set
         while( rs.next() ) {
        	 
        	 
        	 TimeSchedule cache = new TimeSchedule();
        	 
        cache.setTimeBlock(rs.getTime("Time"));
        	 ///////////// for monday
        	 int Monday= rs.getInt("monday");
        	 
        	 java.sql.Statement stmt2 = conn.createStatement() ;
        	 
        	ResultSet rs2 = stmt2.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id="+Monday+";");
         while(rs2.next()){  
        	String profName = rs2.getString("prof_name");
        	String courseName= rs2.getString("course_name");
        	String courseId = rs2.getString("course_id");
        	
        	System.out.println( rs ) ;
        	String temp = profName+" "+courseName+" "+courseId ;
        	
        	cache.setMonday(temp);
         }
        	rs2.close();
        	stmt2.close();
         
                         
        	
        	/////////////// for tuesday
        	
       	 int tuesday= rs.getInt("tuesday");
    	 
    	 java.sql.Statement stmt3 = conn.createStatement() ;
    	 
    	ResultSet rs3 = stmt3.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id="+tuesday+";");
       while(rs3.next()){
    	String TprofName = rs3.getString("prof_name");
    	String TcourseName= rs3.getString("course_name");
    	String TcourseId = rs3.getString("course_id");
    	
    	System.out.println( rs ) ;
    	String temp2 = TprofName+" "+TcourseName+" "+TcourseId ;
    	
    	cache.setTuesday(temp2);
       }
       rs3.close();
   	stmt3.close();
        	
           
           
        

	/////////////// for wednesday
	
	 int wednesday= rs.getInt("wednesday");

java.sql.Statement stmt4 = conn.createStatement() ;

ResultSet rs4 = stmt4.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id="+wednesday+";");
while(rs4.next()){
String wprofName = rs4.getString("prof_name");
String wcourseName= rs4.getString("course_name");
String wcourseId = rs4.getString("course_id");

System.out.println( rs ) ;
String temp3 = wprofName+" "+wcourseName+" "+wcourseId ;

cache.setWednesday(temp3);
}
rs4.close();
stmt4.close();
	




///////////// for thursday
int thursday= rs.getInt("thursday");

java.sql.Statement stmt5 = conn.createStatement() ;

ResultSet rs5 = stmt5.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id="+thursday+";");
while(rs5.next()){  
String hprofName = rs5.getString("prof_name");
String hcourseName= rs5.getString("course_name");
String hcourseId = rs5.getString("course_id");

System.out.println( rs ) ;
String temp5 = hprofName+" "+hcourseName+" "+hcourseId ;

cache.setThursday(temp5);
}
rs5.close();
stmt5.close();




///////////// for Friday
int friday= rs.getInt("friday");

java.sql.Statement stmt7 = conn.createStatement() ;

ResultSet rs7 = stmt7.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id="+friday+";");
while(rs7.next()){  
String fprofName = rs7.getString("prof_name");
String fcourseName= rs7.getString("course_name");
String fcourseId = rs7.getString("course_id");

System.out.println( rs ) ;
String temp7 = fprofName+" "+fcourseName+" "+fcourseId ;

cache.setFriday(temp7);
}
rs7.close();
stmt7.close();



           
list.add(cache);

         
         }
         // Close the result set, statement and the connection
         rs.close() ;
         stmt.close() ;
         conn.close() ;
        } catch( SQLException se )
        {
       	 
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null )
               {
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
               
               }
            
            
           }
        catch( Exception e )
           {
            System.out.println( e ) ;
            e.printStackTrace();
           }
	
	
        RequestDispatcher dispatcher=request.getRequestDispatcher("/DisplayRoom.jsp");
 	   
 	   request.setAttribute("var",list);
        
        
        dispatcher.forward(request, response);
        
        
	}

}
