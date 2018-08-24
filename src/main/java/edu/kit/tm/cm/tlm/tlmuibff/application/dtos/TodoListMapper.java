package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoList;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoListGenericRequest;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING,
        withIgnoreMissing = IgnoreMissing.ALL)
public interface TodoListMapper {
    TodoListResponse toResponse(TodoList todoList);
    List<TodoListResponse> toResponses(List<TodoList> todoList);
    TodoListGenericRequest toApiRequest(edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoListGenericRequest request);
}
