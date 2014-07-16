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
 * Servlet implementation class GetProfServlet
 */
@WebServlet("/GetProfServlet")
public class GetProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	ArrayList<Course> list = new ArrayList<Course>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	    
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
         //java.sql.Statement stmt2 = conn.createStatement() ;

         // Execute the query
         ResultSet rs = stmt.executeQuery( "SELECT * FROM mydb.professor;" ) ;

         // Loop through the result set
         while( rs.next() ) {
           System.out.println( rs ) ;
           Course prof=new Course();
           prof.setProfId(rs.getInt("prof_id"));  
           prof.setProfName(rs.getString("prof_name"));
           
          
           
                         
           list.add(prof);
           
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
         
         
        }
     catch( Exception e )
        {
         System.out.println( e ) ;
         e.printStackTrace();
        }
    
        
        
        
        
         
        //Set the Customer values into Customer Bean or POJO(Plain Old Java Object) class
        
       
         
        RequestDispatcher dispatcher=request.getRequestDispatcher("/ProfList.jsp");
        //Set the customer instance into request.Then only the customer object 
        //will be available in the Welcome.jsp page
        request.setAttribute("prof",list);
        dispatcher.forward(request, response);

		
		
		
		
	}

}
