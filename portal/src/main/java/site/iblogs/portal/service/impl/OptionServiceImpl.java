package site.iblogs.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.mapper.OptionsMapper;
import site.iblogs.model.Options;
import site.iblogs.model.OptionsExample;
import site.iblogs.portal.service.OptionService;
import site.iblogs.portal.service.RedisService;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionsMapper optionsMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public List<Options> getAllOption() {
        return optionsMapper.selectByExample(new OptionsExample());
    }
}
