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

    private static boolean initializedOptionsToRedis=false;
    private static String optionsPreKey="IBLOGS.SITE.OPTIONS";

    public OptionServiceImpl(){
        if(!initializedOptionsToRedis){
            InitOptionsToRedis();
        }
    }

    private void InitOptionsToRedis()
    {
        if(initializedOptionsToRedis){
            return;
        }
        List<Options> allOptions=getAllOption();
        allOptions.forEach(u->{
            redisService.set(optionsPreKey+u.getName(),u.getValue());
        });
        initializedOptionsToRedis=true;
    }

    @Override
    public List<Options> getAllOption() {
        return optionsMapper.selectByExample(new OptionsExample());
    }
}
