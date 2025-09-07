package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String dbUser);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String dbUser);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectUserByName(@Param("userName") String userName);

    List<Users> selectUserList(@Param("num") Integer num);
}