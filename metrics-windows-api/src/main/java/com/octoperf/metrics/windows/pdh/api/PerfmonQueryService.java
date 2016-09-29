package com.octoperf.metrics.windows.pdh.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PerfmonQueryService {

  List<String> getInstances(String object);

  double getRawValue(String object, String key);

  Map<String, Double> getFormattedValues(String object, Set<String> keys);
}
