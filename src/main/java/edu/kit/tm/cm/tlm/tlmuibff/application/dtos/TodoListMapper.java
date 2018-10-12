package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoListRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoList;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoListCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = CommonMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TodoListMapper {
    TodoListResponse toResponse(TodoList todoList);
    List<TodoListResponse> toResponses(List<TodoList> todoList);
    TodoListCreateRequest toApiRequest(CreateTodoListRequest request);
}
