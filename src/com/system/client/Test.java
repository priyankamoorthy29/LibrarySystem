package com.system.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.system.classifcationmodel.Author;
//import com.system.classifcationmodel.Author;
import com.system.classifcationmodel.Classification;
import com.system.classificationService.AuthorService;
import com.system.classificationService.ClassificationService;
import com.system.classificationServiceImpl.AuthorServiceImpl;
import com.system.classificationServiceImpl.ClassifcationServiceImpl;




public class Test {
	
public static void main (String[]args) {
	
AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
	
//	ClassificationService classificationService=ctx.getBean("classificationService", ClassifcationServiceImpl.class);
//
//Classification classification= new Classification();
//	classification.setId(3);
//	classification.setClassificationname("math");
//classificationService.addClassification(classification);

AuthorService authorService=ctx.getBean("authorService", AuthorServiceImpl.class);

Author author= new Author();
author.setId(5);
author.setAuthorname("math");
authorService.addAuthor(author);



//for(Classification classification1:classificationService.FetchClassificationList()) {
//		System.out.println(classification1.getId()+""+classification1.getClassificationname());
//	}
//	
//}

for(Author author1:authorService.FetchAuthorList()) {
	System.out.println(author1.getId()+""+author1.getAuthorname());
}

}

}
