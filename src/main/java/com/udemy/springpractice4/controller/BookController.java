package com.udemy.springpractice4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.udemy.springpractice4.form.BookForm;
import com.udemy.springpractice4.form.EditBookForm;
import com.udemy.springpractice4.model.Book;
import com.udemy.springpractice4.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/booklist")
	public String bookList(Model model) {
		//serviceを使って本の一覧を取得
		List<Book> bookList = service.findAll();
		//modelに本の一覧を設定し画面に渡す
		model.addAttribute("bookList", bookList);
		//bookList.htmlの表示
		return "bookList";
	}
	
	//新規登録画面を表示
	@GetMapping("/book-register")
	public String registerBook(Model model) {
		model.addAttribute("bookForm", new BookForm());
		
		return "add";
	}
	
	//DBに本を登録する
	@PostMapping("/book-register")
	public String saveBook(@ModelAttribute @Validated
			BookForm bookForm,
			BindingResult result,
			Model model
			) {
		//バリデーションエラーの場合
		if(result.hasErrors()) {
			return "add";
		}
		
		//本を登録する
		service.insert(bookForm);
		
		//本の一覧表示画面にリダイレクト
		return "redirect:/booklist";
	}
	
	//編集画面を表示する
	@GetMapping("/book-edit")
	public String editBook(Model model, EditBookForm editBook) {
		
		editBook = service.getOneBook(editBook.getId());
		model.addAttribute(editBook);
		
		return "edit";
	}
	
	//本の情報を更新する
	@PostMapping("/book-edit")
	public String update(@ModelAttribute @Validated
			EditBookForm editBook,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			//編集画面に遷移
			return "edit";
		}
		
		//本を更新する
		service.update(editBook);
		
		//本の一覧画面にリダイレクト
		return "redirect:/booklist";
		
	}
	
	//本の削除を行う
	@GetMapping("/book-delete")
	public String deleteBook(Model model, Book book) {
		
		// DBのデータを削除
		service.delete(book.getId());
		
		// 本の一覧画面にリダイレクト
		return "redirect:/booklist";
	}
	
	//削除確認画面を表示
		@GetMapping("/delete-confirmation")
		public String deleteConfirm(Model model, EditBookForm editBook) {
			
			editBook = service.getOneBook(editBook.getId());
			model.addAttribute(editBook);
			
			return "delete-confirmation";
		}

	
}
