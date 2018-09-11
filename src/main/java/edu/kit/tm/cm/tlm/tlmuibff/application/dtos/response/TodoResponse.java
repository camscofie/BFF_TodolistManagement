package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Todo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoResponse {
    @ApiModelProperty(position = 1)
    int number;

    @ApiModelProperty(position = 2)
    int position;

    @ApiModelProperty(position = 3)
    String content;

    @ApiModelProperty(position = 4)
    boolean done;

    @ApiModelProperty(position = 5)
    String description;
}
