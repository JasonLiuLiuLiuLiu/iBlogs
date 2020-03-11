package site.iblogs.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author Liu Zhenyu on 3/11/2020
 */

@Configuration
@MapperScan("site.iblogs.portal.mbg.mapper")
public class MyBatisConfig {

}
