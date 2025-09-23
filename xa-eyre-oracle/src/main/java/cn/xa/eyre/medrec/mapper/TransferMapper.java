package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.Transfer;
import cn.xa.eyre.medrec.domain.TransferKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferMapper {
    int deleteByPrimaryKey(TransferKey key);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(TransferKey key);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);

    List<Transfer> getICUInfo();

    List<Transfer> getCPAPDeptInfo(@Param("patientIds") List<String> patientIds);
}