package me.jvt.hacking.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Set;
import me.jvt.hacking.model.Api;
import me.jvt.hacking.model.ApiResponseContainer;
import me.jvt.hacking.service.ApiService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApiControllerTest {
  @Mock private ApiService service;

  @InjectMocks private ApiController controller;

  @Nested
  class GetAll {
    /*
    This is a scaffolding test that can be removed when we have really implemented it
     */
    @Test
    void itReturnsContainer() {
      ApiResponseContainer actual = controller.getAll();

      assertThat(actual).isNotNull();
    }

    @Test
    void itReturnsInContainer() {
      Api api = new Api("The name", "https://example.foo/bar");
      when(service.findAll()).thenReturn(Set.of(api));

      ApiResponseContainer actual = controller.getAll();

      assertThat(actual.getApis()).contains(api);
    }
  }
}
