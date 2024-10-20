package com.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final String query="SELECT ID,BOOKNAME,BOOKEDITION,BOOKPRICE FROM BOOKDATA";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		
		//load jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//generate the connection
		try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOK", "root", "vinee27");
				PreparedStatement ps=con.prepareStatement(query);){
			ResultSet rs= ps.executeQuery();
			pw.print("<table border='1' align='center' >");
			pw.print("<tr>");
			pw.print("<th>Book ID</th>");
			pw.print("<th>Book Name</th>");
			pw.print("<th>Book Eidition</th>");
			pw.print("<th>Book Price</th>");
			pw.print("<th>Edit</th>");
			pw.print("<th>Delete</th>");
			pw.print("</tr>");
			
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+ "</td>");
				pw.print("<td>"+rs.getString(2)+ "</td>");
				pw.print("<td>"+rs.getString(3)+ "</td>");
				pw.print("<td>"+rs.getFloat(4)+ "</td>");
				pw.print("<td><a href='editScreen?id="+rs.getInt(1)+"'>Edit</a></td>");
				pw.print("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
				pw.print("</tr>");
				
			}
			pw.print("</table>");
		} catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1>"+se.getMessage()+"</h1");
		}catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h1");
		}
		pw.println("<a href='index.html'>Home</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
