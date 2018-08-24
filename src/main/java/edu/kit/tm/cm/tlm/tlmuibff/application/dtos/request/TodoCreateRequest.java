package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Todo-CreateRequest")
public class TodoCreateRequest {
    @NotNull
    @NotEmpty
    @ApiModelProperty(position = 1, required = true)
    String content;

    @ApiModelProperty(position = 2)
    String description;
}
