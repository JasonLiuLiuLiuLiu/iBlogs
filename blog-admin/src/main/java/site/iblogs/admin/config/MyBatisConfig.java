package site.iblogs.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 21:42
 */
@Configuration
@MapperScan({"site.iblogs.mapper", "site.iblogs.admin.dao"})
public class MyBatisConfig {
}
