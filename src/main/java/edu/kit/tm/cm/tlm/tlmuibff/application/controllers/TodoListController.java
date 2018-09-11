package edu.kit.tm.cm.tlm.tlmuibff.application.controllers;

import edu.kit.tm.cm.tlm.tlmuibff.application.controllers.api.TodoListApi;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.TodoListMapper;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.TodoMapper;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoListRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.PatchTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.UpdateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.services.TodoListService;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis.TodoListsApiClient;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class TodoListController implements TodoListApi {

    private final TodoListService todoListService;
    private final TodoListMapper todoListMapper;
    private final TodoMapper todoMapper;
    private final TodoListsApiClient todoManagementApi;

    @Autowired
    public TodoListController(TodoListService todoListService, TodoListMapper todoListMapper, TodoMapper todoMapper, TodoListsApiClient todoManagementApi) {
        this.todoListService = todoListService;
        this.todoListMapper = todoListMapper;
        this.todoMapper = todoMapper;
        this.todoManagementApi = todoManagementApi;
    }

    @Override
    public List<TodoListResponse> getTodoLists() {
        List<TodoList> todoList = todoListService.getTodoLists();
        return todoListMapper.toResponses(todoList);
    }

    @Override
    public TodoListResponse getTodoList(@PathVariable Long id) {
        TodoListService.TodoListWithTodos todoListWithTodos = todoListService.getTodoList(id);

        TodoListResponse response = todoListMapper.toResponse(todoListWithTodos.getTodoList());
        response.setTodos(todoMapper.toResponses(todoListWithTodos.getTodos()));

        return response;
    }

    @Override
    public TodoResponse getTodo(@PathVariable Long id, @PathVariable Integer number) {
        Todo todo = todoListService.getTodo(id, number);
        return todoMapper.toResponse(todo);
    }

    @Override
    public TodoListResponse createTodoList(@Valid @RequestBody CreateTodoListRequest newTodoList) {
        TodoListCreateRequest newTodoListApiRequest = todoListMapper.toApiRequest(newTodoList);
        TodoList todoList = todoListService.createTodoList(newTodoListApiRequest);

        return todoListMapper.toResponse(todoList);
    }

    @Override
    public TodoResponse createTodoInList(@PathVariable Long id, @Valid @RequestBody CreateTodoRequest newTodo) {
        TodoCreateRequest newTodoApiRequest = todoMapper.toApiRequest(newTodo);
        newTodoApiRequest.setDescription(null);

        Todo todo = todoListService.createTodoInList(id, newTodoApiRequest);
        return todoMapper.toResponse(todo);
    }

    @Override
    public TodoResponse patchTodo(@PathVariable Long id, @PathVariable Integer number, @RequestBody PatchTodoRequest partialTodo) {
        TodoPatchRequest partialTodoApiRequest = todoMapper.toApiRequest(partialTodo);
        Todo todo = todoListService.patchTodo(id, number, partialTodoApiRequest);
        return todoMapper.toResponse(todo);
    }

    @Override
    public TodoResponse updateTodo(@PathVariable Long id, @PathVariable Integer number, @Valid @RequestBody UpdateTodoRequest updatedTodo) {
        TodoUpdateRequest updatedTodoApiRequest = todoMapper.toApiRequest(updatedTodo);
        Todo todo = todoListService.updateTodo(id, number, updatedTodoApiRequest);
        return todoMapper.toResponse(todo);
    }

    @Override
    public void deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
    }

    @Override
    public void deleteTodoFromList(@PathVariable Long id, @PathVariable Integer number) {
        todoListService.deleteTodoFromList(id, number);
    }

}
