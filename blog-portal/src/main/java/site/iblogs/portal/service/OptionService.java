package site.iblogs.portal.service;

import site.iblogs.common.model.ConfigKey;
import site.iblogs.model.Options;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public interface OptionService {
    List<Options> getAllOption();

    Options getOption(String key);

    Hashtable<String, String> getOptions(ArrayList<String> keys);
}
