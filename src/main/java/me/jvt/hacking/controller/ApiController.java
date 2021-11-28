package me.jvt.hacking.controller;

import java.util.Set;
import me.jvt.hacking.model.Api;
import me.jvt.hacking.model.ApiResponseContainer;
import me.jvt.hacking.service.ApiService;

public class ApiController {

  private final ApiService service;

  public ApiController(ApiService service) {
    this.service = service;
  }

  public ApiResponseContainer getAll() {
    Set<Api> apis = service.findAll();
    return new ApiResponseContainer(apis);
  }
}
