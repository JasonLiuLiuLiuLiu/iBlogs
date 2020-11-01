package site.iblogs.common.conventer;

import com.google.common.collect.Maps;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import site.iblogs.common.dto.enums.BaseEnum;

import java.util.Map;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:15
 */
public class StringCodeToEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    private static final Map<Class, Converter> CONVERTERS = Maps.newHashMap();

    /**
     * 获取一个从 Integer 转化为 T 的转换器，T 是一个泛型，有多个实现
     *
     * @param targetType 转换后的类型
     * @return 返回一个转化器
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = CONVERTERS.get(targetType);
        if (converter == null) {
            converter = new StringToEnumConverter<>(targetType);
            CONVERTERS.put(targetType, converter);
        }
        return converter;
    }
}
