package me.jvt.hacking.integration;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Set;
import me.jvt.hacking.controller.ApiController;
import me.jvt.hacking.model.Api;
import me.jvt.hacking.service.ApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(ApiController.class)
@AutoConfigureMockMvc
class ApiControllerIntegrationTest {
  @Autowired private MockMvc mvc;

  @MockBean private ApiService service;

  @Nested
  class GetAll {

    private ResultActions resultActions;

    @BeforeEach
    void setup() throws Exception {
      Api api0 = new Api("Contacts API", "https://example.com/contacts");
      Api api1 = new Api("Publishing API", "https://example.com/publishing");
      when(service.findAll()).thenReturn(Set.of(api0, api1));

      resultActions = mvc.perform(get("/apis"));
    }

    @Test
    void returns200() throws Exception {
      resultActions.andExpect(status().isOk());
    }

    @Test
    void returnsJson() throws Exception {
      resultActions.andExpect(header().string("content-type", "application/json"));
    }

    @Test
    void containsItems() throws Exception {
      resultActions.andExpect(jsonPath("$.apis").isArray());
    }

    @Test
    void containsApiData() throws Exception {
      resultActions
          .andExpect(
              jsonPath("$.apis[*].name")
                  .value(containsInAnyOrder("Contacts API", "Publishing API")))
          .andExpect(
              jsonPath("$.apis[*].url")
                  .value(
                      containsInAnyOrder(
                          "https://example.com/contacts", "https://example.com/publishing")));
    }
  }
}
