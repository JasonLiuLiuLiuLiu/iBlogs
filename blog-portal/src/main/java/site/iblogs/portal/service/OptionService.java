package site.iblogs.portal.service;

import site.iblogs.model.Option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface OptionService {
    List<Option> getAllOption();

    Option getOption(String key);

    HashMap<String, String> getOptions(ArrayList<String> keys);
}
