package cn.xa.eyre.comm.controller;

import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.comm.mapper.DeptDictMapper;
import cn.xa.eyre.comm.mapper.UsersMapper;
import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comm")
public class CommController {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DeptDictMapper deptDictMapper;

    @GetMapping("/getUserByPrimaryKey")
    public AjaxResult getUserByPrimaryKey(@RequestParam("dbUser") String dbUser){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(usersMapper.selectByPrimaryKey(dbUser)));
    }

    /**
     * 根据名称查询在职状态的员工信息，时间倒序，取第一个
     * @param userName
     * @return
     */
    @GetMapping("/getUserByName")
    public AjaxResult getUserByName(@RequestParam("userName") String userName){
        List<Users> users = usersMapper.selectUserByName(userName);
        return AjaxResult.success("接口调用成功", users.isEmpty() ? null : CharsetUtil.convertObject(users.get(0)));
    }

    @GetMapping("/getUserList")
    public AjaxResult getUserList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObjectList(usersMapper.selectUserList(num)));
    }

    @GetMapping("/getDeptList")
    public AjaxResult getDeptList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObjectList(deptDictMapper.selectDeptList(num)));
    }

    @GetMapping("/getDept{deptCode}")
    public AjaxResult getDept(@PathVariable("deptCode") String deptCode){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(deptDictMapper.selectByPrimaryKey(deptCode)));
    }
}
