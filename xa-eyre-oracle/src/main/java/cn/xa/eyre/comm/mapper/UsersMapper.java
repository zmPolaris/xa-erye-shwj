package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String dbUser);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String dbUser);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}