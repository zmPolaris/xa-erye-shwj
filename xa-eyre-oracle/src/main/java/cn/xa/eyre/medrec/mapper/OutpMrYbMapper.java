package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.OutpMrYb;
import cn.xa.eyre.medrec.domain.OutpMrYbKey;

public interface OutpMrYbMapper {
    int deleteByPrimaryKey(OutpMrYbKey key);

    int insert(OutpMrYb record);

    int insertSelective(OutpMrYb record);

    OutpMrYb selectByPrimaryKey(OutpMrYbKey key);

    int updateByPrimaryKeySelective(OutpMrYb record);

    int updateByPrimaryKey(OutpMrYb record);

    OutpMrYb selectOutpMrYb(OutpMrYb outpMrYb);
}