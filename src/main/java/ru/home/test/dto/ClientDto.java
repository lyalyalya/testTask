package ru.home.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {

  @JsonProperty
  private Integer id;

  @NotBlank
  @JsonProperty
  private String name;

}
