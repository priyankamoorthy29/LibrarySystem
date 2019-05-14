package com.system.classificationdao;

import java.util.List;

import com.system.classifcationmodel.Classification;

public interface ClassifcationDao {
	
	public abstract  Classification createClassification(Classification classification);
	public abstract Classification getClassificationById(String classificationId);
	public abstract   Classification deleteClassificationById(String classificationId);
	public abstract Classification updateClassificationById(String classificationId, Classification classification);
	public abstract List<Classification> getClassificationList();
	

}
