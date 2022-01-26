package me.jvt.hacking.infrastructure.controller;

import java.util.Set;
import java.util.stream.Collectors;
import me.jvt.hacking.domain.service.ApiService;
import me.jvt.hacking.infrastructure.models.Api;
import me.jvt.hacking.infrastructure.models.ApiResponseContainer;
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
    Set<Api> apis =
        service.findAll().stream()
            .map(ApiController::toApiResponseObject)
            .collect(Collectors.toSet());
    return new ApiResponseContainer(apis);
  }

  private static Api toApiResponseObject(me.jvt.hacking.domain.model.Api a) {
    return new Api(a.name(), a.url());
  }
}
