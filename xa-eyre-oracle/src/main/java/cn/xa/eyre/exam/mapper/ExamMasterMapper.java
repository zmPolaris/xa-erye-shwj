package cn.xa.eyre.exam.mapper;

import cn.xa.eyre.exam.domain.ExamMaster;

public interface ExamMasterMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamMaster record);

    int insertSelective(ExamMaster record);

    ExamMaster selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamMaster record);

    int updateByPrimaryKey(ExamMaster record);
}