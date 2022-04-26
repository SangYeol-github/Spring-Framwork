package com.tjoeun.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tjoeun.vo.BoardVO;
import com.tjoeun.vo.Product;

@Mapper
public interface CartMapper {
	List<Product> getCartProd(List<Product> list);
}
