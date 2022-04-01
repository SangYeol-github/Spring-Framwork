package com.tjoeun.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.mapper.UserMapper;
import com.tjoeun.vo.User;

@Repository
public class UserMybatisDAO {
	
   @Autowired
   private UserMapper userMapper; 

   public int insert(User u) {
      return userMapper.insertUser(u);
   }
   
    public int addAndGetKey(User u) {
        return userMapper.addAndGetKey(u);
    }
   public User selectById(String uid) {
      return userMapper.getUserById(uid);
    }
   
   public List<User> getUserList() {
      return userMapper.getUserList();
    }
   
   public List<Map<String,Object>> getUserMap(){
      return userMapper.getUserMap();
   }

   public int update(User u) {
      return userMapper.updateUser(u);
   }
   
   public int updateByMap(Map<String,Object> map) {
      return userMapper.updateByMap(map);
   }
   
   public int delete(User u) {
      return userMapper.deleteUser(u);
   }

   public boolean idcheck(User u) {
	   if(userMapper.getUserById(u.getUid())!=null) {
		   return false;
	   } 
		 return true;  
	   }

   public boolean login(User user) {
	   
	   return userMapper.login(user)!=null;
   }
}
