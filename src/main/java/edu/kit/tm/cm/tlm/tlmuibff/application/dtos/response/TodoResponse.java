package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response;

import com.fasterxml.jackson.annotation.JsonView;
import edu.kit.tm.cm.tlm.tlmuibff.application.controllers.Views;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Todo")
public class TodoResponse {
    @JsonView(Views.Summary.class)
    @ApiModelProperty(position = 1)
    int number;

    @JsonView(Views.Summary.class)
    @ApiModelProperty(position = 2)
    int position;

    @JsonView(Views.Summary.class)
    @ApiModelProperty(position = 3)
    String content;

    @JsonView(Views.Summary.class)
    @ApiModelProperty(position = 4)
    boolean done;

    @ApiModelProperty(position = 5)
    String description;
}
