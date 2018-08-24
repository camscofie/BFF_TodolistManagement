package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoCreateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoPatchRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoUpdateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.Todo;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING,
        withIgnoreMissing = IgnoreMissing.ALL)
public interface TodoMapper {

    TodoResponse toResponse(Todo todo);
    List<TodoResponse> toResponses(List<Todo> todo);
    edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoCreateRequest toApiRequest(TodoCreateRequest request);
    edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoUpdateRequest toApiRequest(TodoUpdateRequest request);
    edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoUpdateRequest toApiRequest(TodoPatchRequest request);
}
