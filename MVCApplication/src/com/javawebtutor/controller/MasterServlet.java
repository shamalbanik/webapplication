package com.javawebtutor.controller;

import java.io.IOException;
import java.math.*;
import java.text.DecimalFormat;
import java.util.Currency;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.Product;
import com.javawebtutor.model.User;
import com.javawebtutor.service.ProductService;



public class MasterServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd; 
       String a=request.getParameter("id");
       System.out.println("ss "+a);
		if(a.matches("1")){
			System.out.println("ss1 "+a);
			request.setAttribute("id", "2");
			System.out.println("aa 2 "+request.getAttribute("id"));
			rd = request.getRequestDispatcher("master.jsp");
			rd.forward(request, response);

		}
		
		if(a.matches("AddProduct")){
			System.out.println("ss1 "+a);
			request.setAttribute("id", "2");
			System.out.println("aa 2 "+request.getAttribute("id"));
			rd = request.getRequestDispatcher("masterAddProduct.jsp");
			rd.forward(request, response);

		}
		if(a.matches("EditProduct")){
		
			rd = request.getRequestDispatcher("masterEditProduct.jsp");
			System.out.println("aa wwwwwwwweeeeeee "+request.getParameter("productId"));
			rd.forward(request, response);
			
		}
		if(a.matches("DeletProduct")){
			 Long ProductId= Long.valueOf(request.getParameter("productId").toString());
			 ProductService piroductService=new ProductService();
			 if(piroductService.DeletProductDetails(ProductId)){
				 response.sendRedirect("master.jsp");
			 }
			 else{
				 response.sendRedirect("master.jsp");
			 }
		}
		
		
		
	}
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException{
		 String name = request.getParameter("Name");
		 System.out.println("debug: "+ name);
	     String description = request.getParameter("Description");
	     System.out.println("debug1: "+ description);
	     
	     int stock=0;
	     ProductService piroductService=new ProductService();
		 if(request.getParameter("fun").toString().matches("edit"))
		 {
			 System.out.println("debug3: ");
			 Long ProductId= Long.valueOf(request.getParameter("fun1").toString());
			 System.out.println("debug4: ");
		     Product product = new Product(ProductId,name,description,0.00f, stock,0.00f);
		     System.out.println("debug5: ");
			 if(piroductService.UpdateProductDetails(product)==true){
				 response.sendRedirect("master.jsp");
			 }
			 else{
				 System.out.println("error");
			 }
		 }
		 else if(request.getParameter("fun").toString().matches("add")){
			 String  money= request.getParameter("price");
		     System.out.println("debug2: "+ money);
			 Product product = new Product(name,description,Float.parseFloat(money), stock,Float.parseFloat("0.00"));
			 piroductService.AddProduct(product);
			 response.sendRedirect("master.jsp");
		 }
		 else{
		    	System.out.println("error");
		 }
	 }
}
