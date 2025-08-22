package cn.xa.eyre.ordadm.mapper;

import cn.xa.eyre.ordadm.domain.Orders;

import java.util.List;

public interface OrdersMapper {
    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> getICUAndAMVInfo();
}