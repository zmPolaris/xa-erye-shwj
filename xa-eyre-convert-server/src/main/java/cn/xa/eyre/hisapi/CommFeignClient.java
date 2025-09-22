package cn.xa.eyre.hisapi;


import cn.xa.eyre.comm.domain.DeptDict;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "commService", url = Constants.HIS_URL)
public interface CommFeignClient {

    @GetMapping("/comm/getUserByName")
    public R<Users> getUserByName(@RequestParam("userName") String userName);

    @GetMapping("/comm/getUserList")
    public R<List<Users>> getUserList(@RequestParam("num") Integer num);

    @GetMapping("/comm/getDeptList")
    public R<List<DeptDict>> getDeptList(@RequestParam("num") Integer num);

    @GetMapping("/comm/getDept{deptCode}")
    public R<DeptDict> getDept(@PathVariable("deptCode") String deptCode);

    @GetMapping("/comm/getUserByPrimaryKey")
    public R<Users> getUserByPrimaryKey(@RequestParam("dbUser") String dbUser);
}
