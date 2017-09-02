package com.sz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sz.model.Book;
import com.sz.service.BookService;

public class BookAction extends HttpServlet {

	
	public BookAction() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String type= request.getParameter("type");
		BookService bookService = new BookService();
		
		System.out.println("type:"+type);
		
		if("list".equals(type))
		{
			ArrayList books = bookService.getAllBooks();
			request.setAttribute("books", books);
			request.getRequestDispatcher("/BookManager.jsp").forward(request, response);
		}else if("add".equals(type))
		{
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			/*System.out.println("������"+bookName);
			System.out.println("���ߣ�"+author);*/
			Book book = new Book();
			book.setBookName(bookName);
			book.setAuthor(author);
			if(bookService.addBook(book))
			{
				request.setAttribute("Info","��ӳɹ�");
				request.getRequestDispatcher("/Success.jsp").forward(request, response);
			}else
			{
				request.setAttribute("Info","���ʧ��");
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		}
		else if("delete".equals(type))
		{
			String id =request.getParameter("id");
			System.out.println("delete  id:"+id);
			if(bookService.deleteBookById(id))
			{
				request.getRequestDispatcher("/BookAction?type=list").forward(request, response);
			}
		}
		else if("updateLoad".equals(type))
		{
			String id =request.getParameter("id");
			System.out.println("updateLoad  id:"+id);
			
			Book book = bookService.getBookById(id);
			
			request.setAttribute("book",book);
			request.getRequestDispatcher("/BookUpdate.jsp").forward(request, response);
		}else if("update".equals(type))
		{
			String id =request.getParameter("id");
			System.out.println("update  id:"+id);
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			System.out.println("bookName:"+bookName);
			System.out.println("author:"+author);
			
			Book book = new Book();
			book.setId(Integer.parseInt(id));
			book.setBookName(bookName);
			book.setAuthor(author);
			
			if(bookService.updateBook(book))
			{
				request.setAttribute("Info","���³ɹ�");
				request.getRequestDispatcher("/Success.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Info","����ʧ��");
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	
}
