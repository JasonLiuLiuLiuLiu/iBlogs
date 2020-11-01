package site.iblogs.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.iblogs.mapper.OptionMapper;
import site.iblogs.model.Option;
import site.iblogs.model.OptionExample;
import site.iblogs.portal.service.OptionService;
import site.iblogs.common.service.RedisService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private OptionMapper optionsMapper;

    private RedisService<Option> redisService;

    private static boolean initializedOptionsToRedis = false;
    private static String optionsPreKey = "IBLOGS.SITE.OPTIONS-";

    public OptionServiceImpl(OptionMapper optionsMapper, RedisService<Option> redisService) {
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
        List<Option> allOptions = getAllOption();
        allOptions.forEach(u -> {
            if (!StringUtils.isEmpty(u.getValue())) {
                redisService.set(optionsPreKey + u.getName(), u);
            }
        });
        initializedOptionsToRedis = true;
    }

    @Override
    public Option getOption(String key) {
        Option value = redisService.get(optionsPreKey + key);
        if (value == null || StringUtils.isEmpty(value.getValue())) {
            OptionExample example = new OptionExample();
            OptionExample.Criteria criteria=example.createCriteria();
            criteria.andDeletedEqualTo(false);
            criteria.andNameEqualTo(key.toString());
            List<Option> options = optionsMapper.selectByExample(example);
            if (options.size() > 0) {
                value = options.get(0);
                redisService.set(optionsPreKey + value.getName(), value);
            }
        }
        return value;
    }

    @Override
    public HashMap<String, String> getOptions(ArrayList<String> keys) {
        HashMap<String, String> result = new HashMap<>();
        if (keys == null) {
            return null;
        }

        for (String key : keys) {
            try {
                Option option = getOption(key);
                if (option == null || !option.getVisible()) {
                    result.put(key, null);
                } else {
                    String value = option.getValue();
                    result.put(key, value);
                }
            } catch (IllegalArgumentException ex) {
                result.put(key, null);
            }
        }
        return result;
    }

    @Override
    public List<Option> getAllOption() {
        OptionExample example=new OptionExample();
        example.createCriteria().andDeletedEqualTo(false);
        return optionsMapper.selectByExample(example);
    }
}
