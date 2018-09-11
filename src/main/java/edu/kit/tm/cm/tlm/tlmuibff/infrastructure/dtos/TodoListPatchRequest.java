package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * TodoListPatchRequest
 */
@Validated

public class TodoListPatchRequest {
    @JsonProperty("title")
    private String title = null;

    @JsonProperty("color")
    private String color = null;

    public TodoListPatchRequest title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @ApiModelProperty(value = "")


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TodoListPatchRequest color(String color) {
        this.color = color;
        return this;
    }

    /**
     * HTML hex code
     *
     * @return color
     **/
    @ApiModelProperty(example = "#AABBCC", value = "HTML hex code")


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
        TodoListPatchRequest todoListPatchRequest = (TodoListPatchRequest) o;
        return Objects.equals(this.title, todoListPatchRequest.title) &&
                Objects.equals(this.color, todoListPatchRequest.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TodoListPatchRequest {\n");

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

