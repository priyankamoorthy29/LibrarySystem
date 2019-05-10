package com.system.classificationdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.system.classifcationmodel.Author;
import com.system.classifcationmodel.Classification;
import com.system.classificationdao.AuthorDao;

public class AuthorDaoImpl implements AuthorDao {
	
	
	private DataSource dataSource;
	

	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}




	@Override
	public Author createAuthor(Author author) {
		
		Connection connection=null;
		PreparedStatement ps=null;
		
		
		try{
			connection=dataSource.getConnection();
			String SQL="INSERT INTO author(id,authorname)VALUES(?,?)";
			ps=connection.prepareStatement(SQL);
			ps.setLong(1, author.getId());
			ps.setString(2, author.getAuthorname());
			
			
			if(ps.executeUpdate()>0) {
				System.out.println("InsertSuccesfully ");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	




	@Override
	public Author getAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Integer deleteAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Author updateAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Author> getAllAuthorDetails() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Author> getAuthorList() {
	
		Connection connection=null;
		PreparedStatement ps=null;
		
		List<Classification> classificationList=  new ArrayList<Classification>();
		
		try{
			connection=dataSource.getConnection();
			String SQL="SELECT id, authorname FROM author";
			ps=connection.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Author author= new Author();
				author.setId(rs.getInt("id"));
				author.setAuthorname(rs.getString("authorname"));
				AuthorList.add(author);
					
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return  AuthorList;
		}

		
	}


}
