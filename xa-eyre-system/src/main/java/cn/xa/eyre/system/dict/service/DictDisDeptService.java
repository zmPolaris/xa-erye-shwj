package cn.xa.eyre.system.dict.service;

import cn.xa.eyre.common.constant.CacheConstants;
import cn.xa.eyre.common.core.redis.RedisCache;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class DictDisDeptService {

    @Resource
    DictDisDeptMapper dictDisDeptMapper;

    @Autowired
    private RedisCache redisCache;

    @PostConstruct
    public void init()
    {
        loadingDictDisDept();
    }

    public void loadingDictDisDept() {
        List<DictDisDept> dictDisDepts = dictDisDeptMapper.selectAll();
        for (DictDisDept dictDisDept : dictDisDepts) {
            redisCache.setCacheObject(CacheConstants.SYS_DICT_DEPT_KEY + dictDisDept.getEmrCode(), dictDisDept);
        }
    }

    public void clearDictDisDeptCache()
    {
        Collection<String> keys = redisCache.keys(CacheConstants.SYS_DICT_DEPT_KEY + "*");
        redisCache.deleteObject(keys);
    }

    public DictDisDept getCacheDisDept(String emrCode) {
        DictDisDept cache = redisCache.getCacheObject(CacheConstants.SYS_DICT_DEPT_KEY + emrCode);
        if (null != cache){
            return cache;
        }
        DictDisDept disDept = new DictDisDept();
        disDept.setEmrCode(emrCode);
        disDept = dictDisDeptMapper.selectByCondition(disDept);
        redisCache.setCacheObject(CacheConstants.SYS_DICT_DEPT_KEY + emrCode, disDept);
        return disDept;
    }
}
