package site.iblogs.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"site.iblogs.mapper", "site.iblogs.search.dao"})
public class MyBatisConfig {
}
