package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("TodoList")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoListResponse {
    @ApiModelProperty(position = 1, required = true)
    long id;

    @ApiModelProperty(position = 2, required = true)
    String title;

    @ApiModelProperty(position = 3, notes = "HTML hex code", example = "#AABBCC")
    String color;

    @ApiModelProperty(position = 4)
    List<TodoResponse> todos;
}
