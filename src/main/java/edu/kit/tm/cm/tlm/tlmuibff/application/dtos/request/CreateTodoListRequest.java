package edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@ApiModel("TodoList-CreateRequest")
public class CreateTodoListRequest {
    @NotEmpty
    @ApiModelProperty(position = 1, required = true)
    String title;

    @NotNull
    @ApiModelProperty(position = 2, required = true, notes = "HTML hex code", example = "#AABBCC")
    Optional<String> color;
}
