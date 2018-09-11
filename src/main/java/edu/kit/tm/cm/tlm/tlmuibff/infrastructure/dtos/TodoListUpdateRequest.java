package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TodoListUpdateRequest
 */
@Validated
@JsonInclude
public class TodoListUpdateRequest {
    @JsonProperty("title")
    private String title = null;

    @JsonProperty("color")
    private String color = null;

    public TodoListUpdateRequest title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TodoListUpdateRequest color(String color) {
        this.color = color;
        return this;
    }

    /**
     * HTML hex code
     *
     * @return color
     **/
    @ApiModelProperty(example = "#AABBCC", required = true, value = "HTML hex code")
    @NotNull


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoListUpdateRequest todoListUpdateRequest = (TodoListUpdateRequest) o;
        return Objects.equals(this.title, todoListUpdateRequest.title) &&
                Objects.equals(this.color, todoListUpdateRequest.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoListUpdateRequest {\n");

        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    color: ").append(toIndentedString(color)).append("\n");
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

