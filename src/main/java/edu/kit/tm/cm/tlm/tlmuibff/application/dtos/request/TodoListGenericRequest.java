package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("TodoList-GenericRequest")
public class TodoListGenericRequest {
    @ApiModelProperty(position = 1, required = true)
    String title;

    @ApiModelProperty(position = 2, notes = "HTML hex code", example = "#AABBCC")
    String color;
}
