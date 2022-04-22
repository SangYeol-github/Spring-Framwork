package com.tjoeun.svc;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.vo.BookItem;

@Service
public class CartSVC {
	private HttpSession session;

	public void setSession(HttpSession session) {
		if(this.session==null) {
			this.session = session;
			List<BookItem> cart = new ArrayList<>();
			this.session.setAttribute("cart", cart);
			System.out.println("cart 생성, 세션에 저장");
		}
	}
	
	public boolean addItem(BookItem book, HttpServletRequest request) {
		//동일 아이템이 이미 장바구니에 들어 있는지 확인
		List<BookItem> cart = (List<BookItem>) request.getSession().getAttribute("cart");
		if(cart.contains(book)) {
			int idx = cart.indexOf(book);
			cart.get(idx).setQty( cart.get(idx).getQty() + book.getQty() );
			return true;
		}
		cart.add(book);
		return true;
	}
	
	public List<BookItem> getCart(HttpServletRequest request) {
		List<BookItem> cart = (List<BookItem>) request.getSession().getAttribute("cart");
		return cart;
	}
	
	public int getTotalPrice(HttpServletRequest request) {
		List<BookItem> cart = (List<BookItem>) request.getSession().getAttribute("cart");
		int total = 0;
		for(int i=0;i<cart.size();i++) {
			total += cart.get(i).getPrice() * cart.get(i).getQty();
		}
		return total;
	}
	
	@Transactional(rollbackFor={Exception.class})
	public boolean order(HttpServletRequest request) {
		List<BookItem> cart = (List<BookItem>) request.getSession().getAttribute("cart");
		for(int i=0;i<cart.size();i++)
		{
			//dao.save(cart.get(i));
		}
		return true;
	}
}
