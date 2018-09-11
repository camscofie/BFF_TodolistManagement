package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("Todo-CreateRequest")
public class CreateTodoRequest {
    @NotEmpty
    @ApiModelProperty(position = 1, required = true)
    String content;
}
