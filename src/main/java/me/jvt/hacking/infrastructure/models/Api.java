package me.jvt.hacking.infrastructure.models;

/*
 * This could be a record, but I thought I'd leave it, so it's clear that it's a different type than the Domain Model's <code>API</code>.
 *
 * We may also generate this from OpenAPI/JSON Schema or need to i.e. add <code>@JsonProperty</code>s.
 */
public class Api {
  private String name;
  private String url;

  public Api() {}

  public Api(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }
}
