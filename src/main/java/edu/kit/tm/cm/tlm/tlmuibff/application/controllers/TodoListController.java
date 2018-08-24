package edu.kit.tm.cm.tlm.tlmuibff.application.controllers;

import edu.kit.tm.cm.tlm.tlmuibff.application.controllers.api.TodoListApi;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.TodoListMapper;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.TodoMapper;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoCreateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoListGenericRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoPatchRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.TodoUpdateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.services.TodoListService;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis.TodoManagementApi;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.Todo;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
public class TodoListController implements TodoListApi {

    private Logger logger = LoggerFactory.getLogger(TodoListController.class);

    @Autowired
    private TodoListService todoListService;

    @Autowired
    private TodoListMapper todoListMapper;

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private TodoManagementApi todoManagementApi;


    @Override
    public List<TodoListResponse> getTodoLists() {
        return todoListMapper.toResponses(todoManagementApi.getTodoListsUsingGET().getBody());
    }

    @Override
    public TodoListResponse getTodoList(@PathVariable Long id) {
        CompletableFuture<TodoList> todoList = CompletableFuture
                .supplyAsync(() -> todoManagementApi.getTodoListUsingGET(id).getBody());
        CompletableFuture<List<Todo>> todos = CompletableFuture
                .supplyAsync(() -> todoManagementApi.getTodosUsingGET(id).getBody());

        TodoListResponse response = todoListMapper.toResponse(todoList.join());
        response.setTodos(todoMapper.toResponses(todos.join()));

        return response;
    }

    @Override
    public TodoResponse getTodo(@PathVariable Long id, @PathVariable Integer number) {
        return todoMapper.toResponse(todoManagementApi.getTodoUsingGET(id, number).getBody());
    }

    @Override
    public TodoListResponse createTodoList(@Valid @RequestBody TodoListGenericRequest newTodoList) {
        return todoListMapper.toResponse(todoListService.createTodoList(todoListMapper.toApiRequest(newTodoList)));
    }

    @Override
    public TodoResponse createTodoInList(@PathVariable Long id, @RequestBody TodoCreateRequest newTodo) {
        return todoMapper.toResponse(todoListService.createTodoInList(id, todoMapper.toApiRequest(newTodo)));
    }

    @Override
    public TodoListResponse updateTodoList(@PathVariable Long id, @Valid @RequestBody TodoListGenericRequest updatedTodoList) {
        return todoListMapper.toResponse(todoListService.updateTodoList(id, todoListMapper.toApiRequest(updatedTodoList)));
    }

    @Override
    public TodoResponse patchTodo(@PathVariable Long id, @PathVariable Integer number, @RequestBody TodoPatchRequest updatedTodoAttributes) {
        return todoMapper.toResponse(todoListService.patchTodo(id, number, todoMapper.toApiRequest(updatedTodoAttributes)));
    }

    @Override
    public TodoResponse updateTodo(@PathVariable Long id, @PathVariable Integer number, @Valid @RequestBody TodoUpdateRequest updatedTodo) {
        return todoMapper.toResponse(todoListService.updateTodo(id, number, todoMapper.toApiRequest(updatedTodo)));
    }

    @Override
    public TodoListResponse changeTodoOrder(@PathVariable Long id, @RequestBody List<Integer> newOrder) {
        return todoListMapper.toResponse(todoListService.changeTodoOrder(id, newOrder));
    }

    @Override
    public void deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
    }

    @Override
    public void deleteTodoFromList(@PathVariable Long id, @PathVariable Integer number) {
        todoListService.deleteTodoFromList(id, number);
    }

    //    @GetMapping("/{id}/todos")
//    public List<Todo> getTodos(@PathVariable Long id) {
//        return this.todoListService.getTodoList(id).getTodos().parallelStream()
//                .peek(todo -> {
//                    Todo t = this.todoListService.getTodo(id, todo.getNumber());
//                    todo.setDescription(t.getDescription());
//                    logger.info(String.format("%d-%d", id, t.getNumber()));
//                })
//                .collect(Collectors.toList());
//    }

}
