package site.iblogs.common.conventer;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Maps;
import org.springframework.core.convert.converter.Converter;
import site.iblogs.common.dto.enums.BaseEnum;

import java.util.Map;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:14
 */
public class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {
    private Map<String, T> enumMap = Maps.newHashMap();

    public StringToEnumConverter(Class<T> enumType) {
        T[] enums = enumType.getEnumConstants();
        for (T e : enums) {
            enumMap.put(e.getCode().toString(), e);
        }
    }

    @Override
    public T convert(String source) {
        T t = enumMap.get(source);
        if (ObjectUtil.isNull(t)) {
            throw new IllegalArgumentException("无法匹配对应的枚举类型");
        }
        return t;
    }
}
