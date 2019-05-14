package com.system.classificationdaoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.system.classifcationmodel.Classification;
import com.system.classificationdao.ClassifcationDao;

public class ClassifcationDaoImpl  implements ClassifcationDao{
	
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	@Override
	public Classification createClassification(Classification classification) {

	Connection connection=null;
		PreparedStatement ps=null;
		
		
		try{
			connection=dataSource.getConnection();
			String SQL="INSERT INTO mainclassification(id,classificationname)VALUES(?,?)";
			ps=connection.prepareStatement(SQL);
			ps.setString(1, classification.getId());
			ps.setString(2, classification.getClassificationname());
			
			
			if(ps.executeUpdate()>0) {
				System.out.println("InsertSuccesfully ");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}



	@Override
	public Classification getClassificationById(String classificationId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Classification deleteClassificationById(String classificationId) {
		
		
		Connection connection = null;
		PreparedStatement  ps= null;
		try {
			connection = dataSource.getConnection();
			String sql = "DELETE FROM mainclassification WHERE id=?";
			ps=connection.prepareStatement(sql);
			ps.setString(1, classificationId);
			
			if(ps.executeUpdate()>0) {
				System.out.println("succesfully deleted with id :"+classificationId);
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		return null;
	}

	

	

	@Override
	public Classification updateClassificationById(String classificationId, Classification classification ) {
	
		Connection connection =null;
		PreparedStatement ps= null;
		try {
			connection = dataSource.getConnection();
			String sql= "UPDATE classification SET id = ?, classificationname= ?  WHERE id=?";
			ps.setString(1, classification.getId());
			ps.setString(2, classification.getClassificationname());
		    ps.setString(3, classificationId);
		
		if(ps.executeUpdate()>0) {
			System.out.println("sucessfully updated with id :" + classificationId);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Classification> getClassificationList() {
		Connection connection=null;
		PreparedStatement ps=null;
		
		List<Classification> classificationList=  new ArrayList<Classification>();
		
		try{
			connection=dataSource.getConnection();
			String SQL="SELECT * FROM mainclassification";
			ps=connection.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Classification classification= new Classification();
				classification.setId(rs.getString("id"));
				classification.setClassificationname(rs.getString("classificationname"));
				classificationList.add(classification);
					
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return  classificationList;
		}

		
	}





	

