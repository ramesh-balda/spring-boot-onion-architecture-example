package me.jvt.hacking.domain.service;

import java.util.Collections;
import java.util.Set;
import me.jvt.hacking.domain.model.Api;

public class NoopApiService implements ApiService {

  @Override
  public Set<Api> findAll() {
    return Collections.emptySet();
  }
}
