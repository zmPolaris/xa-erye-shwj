package cn.xa.eyre.ordadm.mapper;

import cn.xa.eyre.ordadm.domain.Orders;
import cn.xa.eyre.ordadm.domain.OrdersKey;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(OrdersKey key);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(OrdersKey key);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> getDeathInfo();
}