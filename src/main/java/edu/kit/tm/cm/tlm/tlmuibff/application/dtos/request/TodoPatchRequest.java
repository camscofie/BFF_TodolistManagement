package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Todo-PatchRequest")
public class TodoPatchRequest {
    @ApiModelProperty(position = 1)
    String content;

    @ApiModelProperty(position = 2)
    Boolean done;
}
