package com.system.classificationdao;

import java.util.List;

import com.system.classifcationmodel.Author;


public interface AuthorDao {

	public abstract Author createAuthor(Author author);
	public abstract Author getAuthorById(int authorId);
	public abstract   Integer deleteAuthorById(int authorId);
	public abstract Author updateAuthorById(int authorId);
	public abstract List<Author> getAllAuthorDetails();
	public abstract List<Author> getAuthorList();
}
