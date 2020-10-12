package site.iblogs.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.iblogs.common.conventer.IntegerCodeToEnumConverterFactory;
import site.iblogs.common.conventer.StringCodeToEnumConverterFactory;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 枚举类的转换器工厂 addConverterFactory
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new IntegerCodeToEnumConverterFactory());
        registry.addConverterFactory(new StringCodeToEnumConverterFactory());
    }
}
