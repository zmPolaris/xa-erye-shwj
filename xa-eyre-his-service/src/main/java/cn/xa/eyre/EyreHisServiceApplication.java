package cn.xa.eyre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动程序
 * 
 * @author zm
 */
@EnableTransactionManagement
@EnableFeignClients(basePackages = "cn.xa.eyre")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EyreHisServiceApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(EyreHisServiceApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  HIS数据访问服务启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
