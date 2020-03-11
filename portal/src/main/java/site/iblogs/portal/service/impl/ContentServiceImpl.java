package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.portal.mbg.mapper.ContentsMapper;
import site.iblogs.portal.mbg.model.Contents;
import site.iblogs.portal.mbg.model.ContentsExample;
import site.iblogs.portal.service.ContentService;

import java.util.List;

/**
 * 内容服务实现类
 *
 * @author Liu Zhenyu on 3/11/2020
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentsMapper contentsMapper;

    @Override
    public List<Contents> listAllContent() {
       return contentsMapper.selectByExample(new ContentsExample());
    }

    @Override
    public List<Contents> listContent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return contentsMapper.selectByExample(new ContentsExample());
    }
}
