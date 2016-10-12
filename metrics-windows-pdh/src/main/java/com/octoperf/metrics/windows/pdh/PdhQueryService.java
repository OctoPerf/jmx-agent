package com.octoperf.metrics.windows.pdh;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import javaslang.control.Try;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.ImmutableList.copyOf;

@Service
@ConditionalOnBean(Pdh.class)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
final class PdhQueryService extends CacheLoader<PdhQueryService.PdhQuery, Map<String, Double>> implements PerfmonQueryService {
  private static final String SEP = "\\";
  private static final String[] NONE = new String[0];

  @NonNull
  Pdh pdh;

  LoadingCache<PdhQuery, Map<String, Double>> formatted = CacheBuilder
      .newBuilder()
      .refreshAfterWrite(5, TimeUnit.SECONDS)
      .build(this);

  @Override
  public synchronized List<String> getInstances(final String object) {
    return copyOf(Try.of(() -> Pdh.getInstances(object)).getOrElse(NONE));
  }

  @Override
  public synchronized double getRawValue(final String object, final String key) {
    return Try.of(() -> pdh.getRawValue(toPath(object, key))).getOrElse(-1d);
  }

  @Override
  public synchronized Map<String, Double> getFormattedValues(
      final String object,
      final Set<String> keys) {
    return formatted.getUnchecked(new PdhQuery(object, keys));
  }

  private static String toPath(final String object, final String key) {
    return SEP + object + SEP + key;
  }

  @Override
  public Map<String, Double> load(final PdhQuery query) throws Exception {
    final Map<String, String> counterToKey = new LinkedHashMap<>();
    final String object = query.getObject();
    for(final String key : query.getKeys()) {
      counterToKey.put(toPath(object, key), key);
    }

    final Map<String, Double> computed = Try
        .of(() -> pdh.getFormattedValues(copyOf(counterToKey.keySet())))
        .getOrElse(ImmutableMap::of);

    final Map<String, Double> result = new HashMap<>();
    for(final Map.Entry<String, Double> entry : computed.entrySet()) {
      result.put(counterToKey.get(entry.getKey()), entry.getValue());
    }
    return result;
  }

  @Value
  static final class PdhQuery {
    String object;
    Set<String> keys;
  }
}
