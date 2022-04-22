package com.tjoeun.svc;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.vo.BookItem;

@Service
public class CartSVC {
	public boolean addItem(BookItem book, List<BookItem> cart)
	{
		//동일 아이템이 이미 장바구니에 들어 있는지 확인
		if(cart.contains(book)) {
			int idx = cart.indexOf(book);
			cart.get(idx).setQty( cart.get(idx).getQty() + book.getQty() );
			return true;
		}
		cart.add(book);
		return true;
	}

	public int getTotalPrice(List<BookItem> cart)
	{
		int total = 0;
		for(int i=0;i<cart.size();i++) {
			total += cart.get(i).getPrice() * cart.get(i).getQty();
		}
		return total;
	}
	
	@Transactional(rollbackFor={Exception.class})
	public boolean order(List<BookItem> cart) {
		for(int i=0;i<cart.size();i++) {
			//dao.save(cart.get(i));
		}
		return true;
	}
}
