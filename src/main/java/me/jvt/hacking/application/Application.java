package me.jvt.hacking.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.jvt.hacking"})
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
