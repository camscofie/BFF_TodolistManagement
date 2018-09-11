package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@ApiModel("Todo-UpdateRequest")
public class UpdateTodoRequest {
    @NotNull
    @ApiModelProperty(position = 1, required = true)
    Integer position;

    @NotEmpty
    @ApiModelProperty(position = 2, required = true)
    String content;

    @NotNull
    @ApiModelProperty(position = 3, required = true)
    Boolean done;

    @NotNull
    @ApiModelProperty(position = 4, required = true)
    Optional<String> description;
}
