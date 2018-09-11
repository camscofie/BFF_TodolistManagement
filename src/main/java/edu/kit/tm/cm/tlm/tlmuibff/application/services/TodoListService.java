package edu.kit.tm.cm.tlm.tlmuibff.application.services;

import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis.TodoListsApiClient;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.*;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TodoListService {

    private final TodoListsApiClient todoManagementApi;

    @Autowired
    public TodoListService(final TodoListsApiClient todoManagementApi) {
        this.todoManagementApi = todoManagementApi;
    }

    public List<TodoList> getTodoLists() {
        return todoManagementApi.getTodoListsUsingGET().getBody();
    }

    public TodoListWithTodos getTodoList(Long id) {
        CompletableFuture<ResponseEntity<TodoList>> todoList = CompletableFuture
                .supplyAsync(() -> todoManagementApi.getTodoListUsingGET(id));
        CompletableFuture<ResponseEntity<List<Todo>>> todos = CompletableFuture
                .supplyAsync(() -> todoManagementApi.getTodosUsingGET(id));

        return new TodoListWithTodos(todoList.join().getBody(), todos.join().getBody());
    }

    public Todo getTodo(Long listId, Integer number) {
        return todoManagementApi.getTodoUsingGET(listId, number).getBody();
    }

    public TodoList createTodoList(TodoListCreateRequest request) {
        return todoManagementApi.createTodoListUsingPOST(request).getBody();
    }

    public Todo createTodoInList(Long id, TodoCreateRequest request) {
        return todoManagementApi.createTodoInListUsingPOST(id, request).getBody();
    }

    public Todo patchTodo(Long id, Integer number, TodoPatchRequest request) {
        return todoManagementApi.patchTodoUsingPATCH(id, number, request).getBody();
    }

    public Todo updateTodo(Long id, Integer number, TodoUpdateRequest request) {
        return todoManagementApi.updateTodoUsingPUT(id, number, request).getBody();
    }

    public void deleteTodoList(Long id) {
        todoManagementApi.deleteTodoListUsingDELETE(id);
    }

    public void deleteTodoFromList(Long id, Integer number) {
        todoManagementApi.deleteTodoFromListUsingDELETE(id, number);
    }

    @Value
    public class TodoListWithTodos {
        private TodoList todoList;
        private List<Todo> todos;
    }

}
