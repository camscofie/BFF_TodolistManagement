package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoListRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoList;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoListCreateRequest;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING,
        withIgnoreMissing = IgnoreMissing.ALL,
        withCustom = CommonMapper.class)
public interface TodoListMapper {
    TodoListResponse toResponse(TodoList todoList);
    List<TodoListResponse> toResponses(List<TodoList> todoList);
    TodoListCreateRequest toApiRequest(CreateTodoListRequest request);
}
