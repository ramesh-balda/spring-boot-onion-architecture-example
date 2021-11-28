package me.jvt.hacking.controller;

import java.util.Set;
import me.jvt.hacking.model.Api;
import me.jvt.hacking.model.ApiResponseContainer;
import me.jvt.hacking.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class ApiController {

  private final ApiService service;

  public ApiController(ApiService service) {
    this.service = service;
  }

  @GetMapping
  public ApiResponseContainer getAll() {
    Set<Api> apis = service.findAll();
    return new ApiResponseContainer(apis);
  }
}
