package me.jvt.hacking.service;

import java.util.Set;
import me.jvt.hacking.model.Api;

public interface ApiService {
  Set<Api> findAll();
}
