package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TodoUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-22T18:44:27.867+02:00")

public class TodoUpdateRequest   {
  @JsonProperty("content")
  private String content = null;

  @JsonProperty("done")
  private Boolean done = null;

  @JsonProperty("description")
  private String description = null;

  public TodoUpdateRequest content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public TodoUpdateRequest done(Boolean done) {
    this.done = done;
    return this;
  }

  /**
   * Get done
   * @return done
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }

  public TodoUpdateRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Omit to delete description
   * @return description
  **/
  @ApiModelProperty(value = "Omit to delete description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoUpdateRequest todoUpdateRequest = (TodoUpdateRequest) o;
    return Objects.equals(this.content, todoUpdateRequest.content) &&
        Objects.equals(this.done, todoUpdateRequest.done) &&
        Objects.equals(this.description, todoUpdateRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, done, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoUpdateRequest {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

