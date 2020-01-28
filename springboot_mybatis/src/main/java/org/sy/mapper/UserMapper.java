package org.sy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sy.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUsers();
}
