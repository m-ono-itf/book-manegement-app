package com.udemy.springpractice4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.springpractice4.form.BookForm;
import com.udemy.springpractice4.form.EditBookForm;
import com.udemy.springpractice4.model.Book;
import com.udemy.springpractice4.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	//DBから本の一覧を取得
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	//DBに本を登録
	public void insert(BookForm bookForm) {
		//データベースに登録する値を保持するインスタンス
		Book book = new Book();
		
		//日付取得
		
		
		//画面から受け取った値をDBに保存するインスタンスへ渡す
		book.setTitle(bookForm.getTitle());
		book.setPrice(bookForm.getPrice());
		book.setOffice_location(bookForm.getOffice_location());
		book.setDate(bookForm.getDate());
		
		//DBに登録する
		repository.save(book);
	}
	
	//受け取ったidからデータを取得してFormを返却する
	public EditBookForm getOneBook(Integer id) {
		
		//idを指定して本の情報を取得する
		Book book = repository.findById(id).orElseThrow();
		
		//画面返却用のFormに値を設定する
		EditBookForm editBook = new EditBookForm();
		editBook.setId(book.getId());
		editBook.setTitle(book.getTitle());
		editBook.setPrice(book.getPrice());
		editBook.setOffice_location(book.getOffice_location());
		editBook.setDate(book.getDate());
		
		return editBook;
	}
	
	
	//本を更新する
	public void update(EditBookForm editBook) {
		//データベースに登録する値を保持するインスタンスの作成
		Book book = new Book();
		
		//画面から受け取った値を設定する
		book.setId(editBook.getId());
		book.setTitle(editBook.getTitle());
		book.setPrice(editBook.getPrice());
		book.setOffice_location(editBook.getOffice_location());
		book.setDate(editBook.getDate());
		
		//データベースを更新する
		repository.save(book);
	}
	
	//本を削除する
	public void delete(Integer id) {
		
		//idを指定してDBからデータを削除する
		repository.deleteById(id);
	}
	
}
