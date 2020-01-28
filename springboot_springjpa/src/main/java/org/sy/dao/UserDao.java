package org.sy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sy.bean.User;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
  //  public List<User> findAll();
}
