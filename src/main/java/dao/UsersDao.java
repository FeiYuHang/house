package dao;

import org.apache.ibatis.annotations.Param;

import entity.Users;

public interface UsersDao {
     public Users userlogin(@Param("name") String name,@Param("password") String password);
}
