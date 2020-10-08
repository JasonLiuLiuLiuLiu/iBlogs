package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.OptionUpdateParam;
import site.iblogs.admin.dto.response.OptionResponse;

import java.util.List;

public interface OptionService {
    List<OptionResponse> getVisibleOptions();
    Boolean updateOption(OptionUpdateParam param);
}
