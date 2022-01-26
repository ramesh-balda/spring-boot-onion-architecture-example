package me.jvt.hacking.infrastructure.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Set;
import me.jvt.hacking.domain.service.ApiService;
import me.jvt.hacking.infrastructure.models.Api;
import me.jvt.hacking.infrastructure.models.ApiResponseContainer;
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
      me.jvt.hacking.domain.model.Api api =
          new me.jvt.hacking.domain.model.Api("The name", "https://example.foo/bar");
      when(service.findAll()).thenReturn(Set.of(api));
      Api expected = new Api("The name", "https://example.foo/bar");

      ApiResponseContainer actual = controller.getAll();

      assertThat(actual.getApis()).usingRecursiveFieldByFieldElementComparator().contains(expected);
    }
  }
}
