package me.jvt.hacking.domain.service;

import java.util.Set;
import me.jvt.hacking.domain.model.Api;

public interface ApiService {
  Set<Api> findAll();
}
