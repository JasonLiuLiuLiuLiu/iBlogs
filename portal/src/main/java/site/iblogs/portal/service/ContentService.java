package site.iblogs.portal.service;

import site.iblogs.portal.mbg.model.Contents;

import java.util.List;

/**
 * 内容服务类
 *
 * @author Liu Zhenyu on 3/11/2020
 */

public interface ContentService {

    List<Contents> listAllContent();

    List<Contents> listContent(int pageNum,int pageSize);
}
