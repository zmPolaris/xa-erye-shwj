package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.StaffDict;

public interface StaffDictMapper {
    int deleteByPrimaryKey(String empNo);

    int insert(StaffDict record);

    int insertSelective(StaffDict record);

    StaffDict selectByPrimaryKey(String empNo);

    int updateByPrimaryKeySelective(StaffDict record);

    int updateByPrimaryKey(StaffDict record);
}