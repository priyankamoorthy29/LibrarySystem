package com.system.classificationService;

import java.util.List;

import com.system.classifcationmodel.Author;


public interface AuthorService {
	
	public abstract Author addAuthor(Author author);
	public abstract Author fetchAuthorById(Integer authorId);
	public abstract Author deleteAuthorById(Integer authorId);
	public abstract Author updateAuthorById(Integer authorId,Author author);
	public abstract List<Author> FetchAuthorList();

	

}
