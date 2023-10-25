package com.udemy.springpractice4.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookForm {
	
	//本のタイトルを保持する
	@NotBlank(message="タイトルを入力してください。")
	private String title;
	
	//本の値段を保持する
	@NotNull(message="値段を入力してください。")
	@Positive(message="値段はプラスの値を入力してください。")
	private Integer price;
	
	//本の所属オフィスを保持する
	private String office_location;
	
	//登録日付を保持する
	@NotNull(message="購入日もしくは登録日を選択してください")
	private LocalDate date;
}
