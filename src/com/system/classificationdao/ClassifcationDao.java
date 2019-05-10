package com.system.classificationdao;

import java.util.List;

import com.system.classifcationmodel.Classification;

public interface ClassifcationDao {
	
	public abstract  Classification createClassification(Classification classification);
	public abstract Classification getClassificationById(int classificationId);
	public abstract   Integer deleteClassificationById(int classificationId);
	public abstract Classification updateClassificationById(int classificationId);
	public abstract List<Classification> getAllClassificationDetails();
	public abstract List<Classification> getClassificationList();

}
