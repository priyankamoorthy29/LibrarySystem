package com.system.classificationServiceImpl;

import java.util.List;

import com.system.classifcationmodel.Author;
import com.system.classificationService.AuthorService;
import com.system.classificationdao.AuthorDao;


public class AuthorServiceImpl   implements AuthorService{
	
	private AuthorDao authorDAO;
	

	public AuthorDao getAuthorDAO() {
		return authorDAO;
	}

	public void setAuthorDAO(AuthorDao authorDAO) {
		this.authorDAO = authorDAO;
	}

	@Override
	public Author addAuthor(Author author) {
		
		return authorDAO.createAuthor(author);
	}

	@Override
	public Author fetchAuthorById(Integer authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author deleteAuthorById(Integer authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author updateAuthorById(Integer authorId, Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> FetchAuthorList() {
	
		return authorDAO.getAllAuthorDetails();
		}
	
	


	

}
