package com.efinancialcareers.service;

import java.util.List;
import java.util.Map;

public interface Loader {

    Map<String, Object> loadAndPersist(List<String> scripts);

    Map<String, Object> load(List<String> scripts);

}
