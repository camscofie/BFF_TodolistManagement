package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TodoUpdateRequest
 */
@Validated
@JsonInclude
public class TodoUpdateRequest {
    @JsonProperty("position")
    private Integer position = null;

    @JsonProperty("content")
    private String content = null;

    @JsonProperty("done")
    private Boolean done = null;

    @JsonProperty("description")
    private String description = null;

    public TodoUpdateRequest position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * Get position
     *
     * @return position
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public TodoUpdateRequest content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
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
     *
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
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


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
        return Objects.equals(this.position, todoUpdateRequest.position) &&
                Objects.equals(this.content, todoUpdateRequest.content) &&
                Objects.equals(this.done, todoUpdateRequest.done) &&
                Objects.equals(this.description, todoUpdateRequest.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, content, done, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoUpdateRequest {\n");

        sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

