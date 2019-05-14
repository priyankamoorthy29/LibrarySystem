package com.system.classificationService;

import java.util.List;

import com.system.classifcationmodel.Classification;

public interface ClassificationService  {
	
	
	public abstract Classification addClassification(Classification classification);
	public abstract Classification fetchClassifcationById(String classificationId);
	public abstract Classification deleteClassificationById(String deleteId);
	public abstract Classification updateClassifcationById(String classificationId,Classification classification);
	public abstract List<Classification> fetchClassificationList();

	

}
