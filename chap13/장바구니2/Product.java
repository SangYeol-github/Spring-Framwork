package com.tjoeun.vo;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int num;
	private String pname;
	private String imgname;

	public Product() {}
	
	public Product(int num) {
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product p = (Product) obj;
		return this.num==p.num;
	}
	
	@Override
	public String toString() {
		return this.num+" "+this.pname+" "+this.imgname;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
}
