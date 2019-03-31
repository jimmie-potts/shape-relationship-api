package com.nuvalence.shaperelationship.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.nuvalence.shaperelationship"))
        .paths(regex("/.*"))
        .build()
        .apiInfo(metaData())
        .pathProvider(new BaseRelativePathProvider("/"));
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder().title("Shape Relationship API").version("1.0").build();
  }

  private class BaseRelativePathProvider extends AbstractPathProvider {
    private String basePath;

    public BaseRelativePathProvider(String basePath) {
      this.basePath = basePath;
    }

    @Override
    protected String applicationPath() {
      return basePath;
    }

    @Override
    protected String getDocumentationPath() {
      return "/";
    }

    @Override
    public String getOperationPath(String operationPath) {
      UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");

      return Paths.removeAdjacentForwardSlashes(
          uriComponentsBuilder.path(operationPath.replaceFirst(basePath, "")).build().toString());
    }
  }
}
