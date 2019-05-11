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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ClassificationService classificationService = ctx.getBean("classificationService" , ClassifcationServiceImpl.class);
		
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
	    JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();
		
	   for(Classification classification:classificationService.FetchClassificationList()) {
		   JsonObject planJson = planBuilder.add("id",classification.getId()).add("classificationname", classification.getClassificationname()).build();
	  arrayBuilder.add(planJson);
	   
	   }
	   
	   JsonObject root = rootBuilder.add("classification", arrayBuilder).build();
//	   System.out.print(root+"Json");
	   writer.print(root);
	   writer.flush();
	   writer.close();
	   
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
//		int a=Integer.parseInt(id);
	
		String classificationname=request.getParameter("classificationname");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
	ClassificationService classificationService=ctx.getBean("classificationService", ClassifcationServiceImpl.class);
	
	Classification classification= new Classification();
    classification.setId(id);
	classification.setClassificationname(classificationname);
	classificationService.addClassification(classification);
				
		
	}

}
