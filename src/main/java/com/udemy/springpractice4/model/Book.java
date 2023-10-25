package com.udemy.springpractice4.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "booksinfo")
// @Tableで対応するテーブルを設定
public class Book {
	
	//本のidを保持
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	//本のidフィールドを保持するフィールド
	private Integer id;
	
	
	@Column(name="title")
	//本のタイトルを保持するフィールド
	private String title;
	
	@Column(name="price")
	//本の値段を保持するフィールド
	private Integer price;
	
	@Column(name="office_location")
	//支社を保持するフィールド
	private String office_location;
	
	@Column(name="date")
	//登録日を保持するフィールド
	private LocalDate date;
}
