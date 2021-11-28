package me.jvt.hacking.service;

import java.util.Collections;
import java.util.Set;
import me.jvt.hacking.model.Api;
import org.springframework.stereotype.Component;

@Component
public class NoopApiService implements ApiService {
  @Override
  public Set<Api> findAll() {
    return Collections.emptySet();
  }
}
