package com.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/registration")
public class Register extends HttpServlet {
	private static final String query="INSERT INTO BOOKDATA(BOOKNAME,BOOKEDITION,BOOKPRICE)VALUES(?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//get the book info
		String bookName=req.getParameter("bookName");
		String bookEdition=req.getParameter("bookEdition");
		float bookPrice=Float.parseFloat(req.getParameter("bookPrice"));
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
			ps.setString(1, bookName);
			ps.setString(2, bookEdition);
			ps.setFloat(3, bookPrice);
			int count=ps.executeUpdate();
			if(count==1) {
				pw.println("<h2>Record is registered succesfully");
			}else {
					pw.println("<h2>Record is not registered succesfully");
					
				}
			
		} catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1>"+se.getMessage()+"</h1");
		}catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h1");
		}
		pw.println("<a href='index.html'>Home</a>");
		pw.println("<br>");
		pw.println("<a href='bookList'>BOOK LIST</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
