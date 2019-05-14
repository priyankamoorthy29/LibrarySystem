package com.system.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.system.classifcationmodel.Classification;
import com.system.classificationService.ClassificationService;
import com.system.classificationServiceImpl.ClassifcationServiceImpl;


@WebServlet("/ClassificationController")
public class ClassificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClassificationController() {
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ClassificationService classificationService = ctx.getBean("classificationService" , ClassifcationServiceImpl.class);
		
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
	    JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();
		
	   for(Classification classification:classificationService.fetchClassificationList()) {
		   JsonObject planJson = planBuilder.add("id",classification.getId()).add("classificationname", classification.getClassificationname()).build();
	  arrayBuilder.add(planJson);
	  System.out.println(classification.getId());
	   
	   }
	   
	   JsonObject root = rootBuilder.add("classification", arrayBuilder).build();
//	   System.out.print(root+"Json");
	   writer.print(root);
	   writer.flush();
	   writer.close();
	   
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
//		int a=Integer.parseInt(id);
	
		String classificationname=request.getParameter("classificationname");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
	ClassificationService classificationService=ctx.getBean("classificationService", ClassifcationServiceImpl.class);
	
	String action= (request.getParameter("action"));
	response.getWriter().println(action);
	
	if(action.equalsIgnoreCase("delete")) {
		String deleteId= request.getParameter("id");
		classificationService.deleteClassificationById(deleteId);
	}
	else if(action.equalsIgnoreCase("edit")) {
		String classificationId = request.getParameter("classificationId");
		String classificationName = request.getParameter("classificationName");
		
		Classification classification = new Classification();
		classification.setId(id);
		classification.setClassificationname(classificationname);
		
		classificationService.updateClassifcationById(id, classification);
	}
	else if(action.equalsIgnoreCase("fetchsingle")) {
		//response.getWriter().println("fetch responded");
		String editId = request.getParameter("id") ;
		Classification classification=classificationService.fetchClassifcationById(editId);
//		classificationService.updateClassification(editId, );
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		JsonObjectBuilder classificationBuilder = Json.createObjectBuilder();
		JsonObject classificationJson = classificationBuilder.add("classificationId",classification.getId())
				.add("classificationName", classification.getClassificationname()).build();
		writer.print(classificationJson);
	}
	else if(action.equalsIgnoreCase("insert")) {
	
	String classificationId = request.getParameter("classificationId");
	String classificationName = request.getParameter("classificationName");	Classification classification= new Classification();
    classification.setId(id);
	classification.setClassificationname(classificationname);
	classificationService.addClassification(classification);
				
		
	}

	}
}
