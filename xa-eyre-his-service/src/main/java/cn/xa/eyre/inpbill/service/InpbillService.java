package cn.xa.eyre.inpbill.service;

import cn.xa.eyre.inpbill.domain.InpBillDetail;
import cn.xa.eyre.inpbill.mapper.InpBillDetailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InpbillService {

    @Resource
    InpBillDetailMapper inpBillDetailMapper;


    public List<String> selectCPAPInfo() {
        return inpBillDetailMapper.selectCPAPInfo();
    }
}
