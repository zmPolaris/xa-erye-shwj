package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.exam.domain.ExamMaster;
import cn.xa.eyre.exam.domain.ExamReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "examService", url = Constants.HIS_URL)
public interface ExamFeignClient {

    @GetMapping("/exam/getExamReport/{examNo}")
    public R<ExamReport> getExamReport(@PathVariable("examNo") String examNo);

    @GetMapping("/exam/getExamMaster/{examNo}")
    public R<ExamMaster> getExamMaster(@PathVariable("examNo") String examNo);
}
