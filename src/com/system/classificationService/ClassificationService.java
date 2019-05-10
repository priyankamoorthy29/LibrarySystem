package com.system.classificationService;

import java.util.List;

import com.system.classifcationmodel.Classification;

public interface ClassificationService  {
	
	
	public abstract Classification addClassification(Classification classification);
	public abstract Classification fetchClassifcationById(Integer classificationId);
	public abstract Classification deleteClassificationById(Integer classificationId);
	public abstract Classification updateClassifcationById(Integer classificationId,Classification classification);
	public abstract List<Classification> FetchClassificationList();

}
