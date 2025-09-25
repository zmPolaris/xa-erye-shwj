package cn.xa.eyre.comm.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.comm.mapper.DeptDictMapper;
import cn.xa.eyre.comm.mapper.UsersMapper;
import cn.xa.eyre.common.constant.CacheConstants;
import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.common.core.redis.RedisCache;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/comm")
public class CommController {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DeptDictMapper deptDictMapper;
    @Autowired
    private RedisCache redisCache;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void loadUsers(){
        logger.info("->loadUsers");
        List<Users> list = usersMapper.selectUserAll();
        for (Users user : list) {
            user.setUserName(CharsetUtil.convertToChinese(user.getUserName()));
            redisCache.setCacheObject(CacheConstants.SYS_COMM_USER_NAME_KEY + user.getUserName(), user);
            redisCache.setCacheObject(CacheConstants.SYS_COMM_DB_USER_KEY + user.getDbUser(), user);
        }
    }

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
        logger.info("->getUserByName接口，userName：{}", userName);
        Users user = redisCache.getCacheObject(CacheConstants.SYS_COMM_USER_NAME_KEY + userName);
        if (ObjectUtil.isNotEmpty(user)){
            return AjaxResult.success("接口调用成功", user);
        } else {
            user = redisCache.getCacheObject(CacheConstants.SYS_COMM_DB_USER_KEY + userName);
            if (ObjectUtil.isEmpty(user)){
                List<Users> users = usersMapper.selectUserByName(userName);
                return AjaxResult.success("接口调用成功", users.isEmpty() ? null : CharsetUtil.convertObject(users.get(0)));
            }
            return AjaxResult.success("接口调用成功", user);
        }
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
