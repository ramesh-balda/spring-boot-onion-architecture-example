package me.jvt.hacking.application;

import me.jvt.hacking.domain.service.ApiService;
import me.jvt.hacking.domain.service.NoopApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
  @Bean
  public ApiService apiService() {
    return new NoopApiService();
  }
}
