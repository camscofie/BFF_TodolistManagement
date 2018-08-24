package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Todo-UpdateRequest")
public class TodoUpdateRequest {
    @NotNull
    @NotEmpty
    @ApiModelProperty(position = 1, required = true)
    String content;

    @NotNull
    @ApiModelProperty(position = 2, required = true)
    Boolean done;

    @ApiModelProperty(position = 3, notes = "Omit to delete description")
    String description;
}
