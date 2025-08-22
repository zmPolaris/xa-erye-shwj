package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.lab.domain.LabResultVo;
import cn.xa.eyre.lab.domain.LabTestItems;
import cn.xa.eyre.lab.domain.LabTestItemsKey;
import cn.xa.eyre.lab.domain.LabTestMaster;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "labService", url = Constants.HIS_URL)
public interface LabFeignClient {

    @GetMapping("/lab/getLabTestMaster/{testNo}")
    public R<LabTestMaster> getLabTestMaster(@PathVariable("testNo") String testNo);

    @PostMapping("/lab/getLabTestItems")
    public R<LabTestItems> getLabTestItems(@RequestBody LabTestItemsKey labTestItemsKey);

    @GetMapping("/lab/getResultItemsByTestNo/{testNo}")
    public R<List<LabResultVo>>  getResultItemsByTestNo(@PathVariable("testNo") String testNo);
}
