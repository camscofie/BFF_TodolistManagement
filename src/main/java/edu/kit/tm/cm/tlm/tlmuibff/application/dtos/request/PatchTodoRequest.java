package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Todo-PatchRequest")
public class PatchTodoRequest {
    @ApiModelProperty(position = 1)
    Boolean done;
}
