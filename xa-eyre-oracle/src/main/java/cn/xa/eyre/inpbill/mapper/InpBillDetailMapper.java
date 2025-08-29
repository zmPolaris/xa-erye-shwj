package cn.xa.eyre.inpbill.mapper;

import cn.xa.eyre.inpbill.domain.InpBillDetail;
import cn.xa.eyre.inpbill.domain.InpBillDetailKey;

import java.util.List;

public interface InpBillDetailMapper {
    int deleteByPrimaryKey(InpBillDetailKey key);

    int insert(InpBillDetail record);

    int insertSelective(InpBillDetail record);

    InpBillDetail selectByPrimaryKey(InpBillDetailKey key);

    int updateByPrimaryKeySelective(InpBillDetail record);

    int updateByPrimaryKey(InpBillDetail record);

    List<String> selectCPAPInfo();
}