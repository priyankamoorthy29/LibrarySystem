package com.system.classificationServiceImpl;

import java.util.List;

import com.system.classifcationmodel.Classification;
import com.system.classificationService.ClassificationService;
import com.system.classificationdao.ClassifcationDao;

public class ClassifcationServiceImpl implements ClassificationService {
	
	
private ClassifcationDao classificationDAO;


public void setClassificationDAO(ClassifcationDao classificationDAO) {
	this.classificationDAO = classificationDAO;
}


@Override
public Classification addClassification(Classification classification) {
	
	return classificationDAO.createClassification(classification);
}



@Override
public Classification updateClassifcationById(String classificationId, Classification classification) {
	
	return classificationDAO.updateClassificationById(classificationId, classification);
}



@Override
public Classification deleteClassificationById(String deleteId) {

	
	return classificationDAO.deleteClassificationById( deleteId);
}


@Override
public List<Classification> fetchClassificationList() {

	return classificationDAO.getClassificationList();
}


@Override
public Classification fetchClassifcationById(String classificationId) {
	// TODO Auto-generated method stub
	return null;
}





}
