package com;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCourse
 */
@WebServlet("/GetCourse")
public class GetCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int MasterId =0;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int Reference = Integer.parseInt(request.getParameter("Course"));
		System.out.println(Reference);
		String ProfId = "null";
		String CourseId = "null";
		int success = 0;
		int Section_Count =0;
		int Duplication_Count =0;
		int Dispatch_id = 0;
	
		String Message = " ";
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

          System.out.println("before first query");
          // Execute the query
          ResultSet rs = stmt.executeQuery( "SELECT * FROM mydb.courses_taught where reference = \""+Reference+"\";" ) ;
         
          System.out.println(rs+"123");
          
          // Loop through the result set
          while( rs.next() ) {
            System.out.println( rs ) ;
            
            ProfId = rs.getString("prof_id");
            CourseId = rs.getString("course_id");
            
            
            java.sql.Statement stmt22 = conn.createStatement() ;
            
            ResultSet rs22 = stmt22.executeQuery( "SELECT count(8) FROM mydb.master where prof_id="+ProfId+" And course_id=\""+CourseId+"\";" ) ;
             System.out.println(rs22);
            
    rs22.next();
    Duplication_Count = rs22.getInt(1);
            
    rs22.close();
    stmt22.close();
            
            System.out.println(ProfId);
          
            
           java.sql.Statement stmt2 = conn.createStatement() ;
            
           ResultSet rs2 = stmt2.executeQuery( "SELECT count(*) FROM mydb.master where course_id = \""+CourseId+"\";" ) ;
            System.out.println(rs2);
           
   rs2.next();
            Section_Count = rs2.getInt(1);
           
           System.out.println(Section_Count);
           
           Section_Count = Section_Count+1;
           
           System.out.println(Section_Count);
           
          rs2.close();
          stmt2.close() ;
          }
          
          if(Duplication_Count<=0){
                   
          java.sql.Statement stmt3 = conn.createStatement() ;
          
          success = stmt3.executeUpdate("insert into master(prof_id,course_id,section_id,master.references)values('"+ProfId+"',\""+CourseId+"\",'"+Section_Count+"','"+Reference+"');");
          System.out.println(success);
          
          if(success>=1){
         	 
         	 Message = "Course Scheduled Successfully ";
         	 java.sql.Statement stmt4 = conn.createStatement() ;
             
             ResultSet Mid = stmt4.executeQuery("SELECT * FROM mydb.master where master.references = "+Reference+";");
            
             while(Mid.next()){
            	 
            	 MasterId =Mid.getInt("m_id");
            	 Dispatch_id= 1;
             }
         	 
         	 
          }else if(success<1){
         	 
         	 
         
         	Dispatch_id = 2;
         	 
          }
          
          stmt3.close();
          }else if(Duplication_Count>0){
        	  
        	  Dispatch_id =3;
          }
          
          
          // Close the result set, statement and the connection
          
          rs.close() ;
          stmt.close() ;
          
          conn.close() ;
          
         
         
         }
      catch( SQLException se )
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
          
          
         } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	     
		

	     
	     
	     if(Dispatch_id ==1){
	     
	     
	     RequestDispatcher dispatcher2=request.getRequestDispatcher("/New_form_action_Course");
	       //Set the customer instance into request.Then only the customer object 
	       //will be available in the Welcome.jsp page
	     Course c2 = new Course();
	     c2.setMid(MasterId);
	     
	     ArrayList<Course> list2 = new ArrayList<Course>();
	     
	     list2.add(c2);
	       
	       request.setAttribute("mid",list2);
	       
	       System.out.println(MasterId);
	       
	       dispatcher2.forward(request, response);
	       }else if (Dispatch_id==2){
	    	   
	    	   Message = "Course  not scheduled please cotact The Admin for more details. We apologize for the inconveniance ";
	    	   
	    	   RequestDispatcher dispatcher=request.getRequestDispatcher("/NewOutput.jsp");
	    	   
	    	   request.setAttribute("Message",Message);
	           
	           
	           dispatcher.forward(request, response);
	    	   
	       }else if (Dispatch_id==3){
	    	   
	    	   Message = "You are trying to re-schedule a course(section) that has already been scheduled ";
	        	 
RequestDispatcher dispatcher=request.getRequestDispatcher("/NewOutput.jsp");
	    	   
	    	   request.setAttribute("Message",Message);
	           
	           
	           dispatcher.forward(request, response);
	    	   
	       }
	     
	     
	     
	     
	     
	     //  System.out.println("second request sent ...!");
	     
       //  
         //Set the customer instance into request.Then only the customer object 
         //will be available in the Welcome.jsp page
         
         //
         
         

      
	     
		
		
         System.out.println("first request sent ...!");
	}
	

	protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	   RequestDispatcher dispatcher2=request.getRequestDispatcher("/New_form_action_Course");
       //Set the customer instance into request.Then only the customer object 
       //will be available in the Welcome.jsp page
       
       request.setAttribute("mid",MasterId);
       
       
       dispatcher2.forward(request, response);
    //   System.out.println("second request sent ...!");
       
       
	}
	
	
	

}
