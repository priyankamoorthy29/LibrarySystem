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
public Classification fetchClassifcationById(Integer classificationId) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Classification deleteClassificationById(Integer classificationId) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Classification updateClassifcationById(Integer classificationId, Classification classification) {
	// TODO Auto-generated method stub
	return null;
}





@Override
public List<Classification> FetchClassificationList() {

	return classificationDAO.getClassificationList();
}





}
