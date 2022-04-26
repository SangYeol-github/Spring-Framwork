package com.tjoeun.vo;

import org.springframework.stereotype.Component;

@Component
public class BookItem {
	private String title;
	private String pub;
	private int price;
	private int qty = 1;

	@Override
	public boolean equals(Object obj) {
		BookItem book = (BookItem) obj;
		return this.getTitle().equals(book.getTitle());
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
