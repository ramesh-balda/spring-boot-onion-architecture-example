package me.jvt.hacking.infrastructure.models;

import java.util.Set;

public class ApiResponseContainer {
  private final Set<Api> apis;

  public ApiResponseContainer(Api... apis) {
    this.apis = Set.of(apis);
  }

  public ApiResponseContainer(Set<Api> apis) {
    this.apis = Set.copyOf(apis);
  }

  public Set<Api> getApis() {
    return apis;
  }
}
