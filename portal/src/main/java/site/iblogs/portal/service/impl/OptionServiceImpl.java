package site.iblogs.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.iblogs.common.model.ConfigKey;
import site.iblogs.mapper.OptionsMapper;
import site.iblogs.model.Options;
import site.iblogs.model.OptionsExample;
import site.iblogs.portal.service.OptionService;
import site.iblogs.portal.service.RedisService;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private OptionsMapper optionsMapper;

    private RedisService redisService;

    private static boolean initializedOptionsToRedis = false;
    private static String optionsPreKey = "IBLOGS.SITE.OPTIONS";

    public OptionServiceImpl(OptionsMapper optionsMapper, RedisService redisService) {
        this.optionsMapper = optionsMapper;
        this.redisService = redisService;
        if (!initializedOptionsToRedis) {
            InitOptionsToRedis();
        }
    }

    private void InitOptionsToRedis() {
        if (initializedOptionsToRedis) {
            return;
        }
        List<Options> allOptions = getAllOption();
        allOptions.forEach(u -> {
            if (!StringUtils.isEmpty(u.getValue())) {
                redisService.set(optionsPreKey + u.getName(), u.getValue());
            }
        });
        initializedOptionsToRedis = true;
    }

    @Override
    public String getOption(ConfigKey key) {
        String value = redisService.get(key.name());
        if (StringUtils.isEmpty(value)) {
            OptionsExample example = new OptionsExample();
            List<Options> options = optionsMapper.selectByExample(example);
            if (options.size() > 0) {
                redisService.set(optionsPreKey + options.get(0).getName(), options.get(0).getValue());
            } else {
                return null;
            }
        }
        return value;
    }

    @Override
    public List<Options> getAllOption() {
        return optionsMapper.selectByExample(new OptionsExample());
    }
}
