package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.PatchTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.UpdateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.Todo;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoCreateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoPatchRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = CommonMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TodoMapper {
    TodoResponse toResponse(Todo todo);
    List<TodoResponse> toResponses(List<Todo> todo);
    TodoCreateRequest toApiRequest(CreateTodoRequest request);
    TodoUpdateRequest toApiRequest(UpdateTodoRequest request);
    TodoPatchRequest toApiRequest(PatchTodoRequest request);
}
