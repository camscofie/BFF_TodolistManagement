package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.PatchTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.UpdateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.Todo;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoCreateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoPatchRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoUpdateRequest;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING,
        withIgnoreMissing = IgnoreMissing.ALL,
        withCustom = CommonMapper.class)
public interface TodoMapper {
    TodoResponse toResponse(Todo todo);
    List<TodoResponse> toResponses(List<Todo> todo);
    TodoCreateRequest toApiRequest(CreateTodoRequest request);
    TodoUpdateRequest toApiRequest(UpdateTodoRequest request);
    TodoPatchRequest toApiRequest(PatchTodoRequest request);
}
