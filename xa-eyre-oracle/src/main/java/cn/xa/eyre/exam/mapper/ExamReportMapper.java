package cn.xa.eyre.exam.mapper;

import cn.xa.eyre.exam.domain.ExamReport;

public interface ExamReportMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamReport record);

    int insertSelective(ExamReport record);

    ExamReport selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamReport record);

    int updateByPrimaryKey(ExamReport record);
}