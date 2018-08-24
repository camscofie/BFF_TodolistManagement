package edu.kit.tm.cm.tlm.tlmuibff.application.services;

import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis.TodoManagementApi;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoManagementApi todoManagementApi;

    @Autowired
    public TodoListService(final TodoManagementApi todoManagementApi) {
        this.todoManagementApi = todoManagementApi;
    }

    public TodoList createTodoList(TodoListGenericRequest request) {
        return todoManagementApi.createTodoListUsingPOST(request).getBody();
    }

    public Todo createTodoInList(Long id, TodoCreateRequest request) {
        return todoManagementApi.createTodoInListUsingPOST(id, request).getBody();
    }

    public TodoList updateTodoList(Long id, TodoListGenericRequest request) {
        return todoManagementApi.updateTodoListUsingPUT(id, request).getBody();
    }

    public Todo updateTodo(Long id, Integer number, TodoUpdateRequest request) {
        return todoManagementApi.updateTodoContentUsingPUT(id, number, request).getBody();
    }

    public Todo patchTodo(Long id, Integer number, TodoUpdateRequest request) {
        return todoManagementApi.updateTodoContentUsingPUT(id, number, request).getBody();
    }

    public TodoList changeTodoOrder(Long id, List<Integer> newOrder) {
        return null; // TODO: implement
    }

    public void deleteTodoList(Long id) {
        todoManagementApi.deleteTodoListUsingDELETE(id);
    }

    public void deleteTodoFromList(Long id, Integer number) {
        todoManagementApi.deleteTodoFromListUsingDELETE(id, number);
    }


//
//    public TodoList getTodoList(Long id) {
//        return this.api.getTodoListUsingGET(id).getBody();
//    }
//
//    public Todo getTodo(Long id, Integer number) {
//        return this.api.getTodoUsingGET(id, number).getBody();
//    }
//
//    public TodoDto patchTodo(Long listId, Integer todoNumber, TodoPatchRequest request) {
//        TodoList todoList = findTodoListById(listId);
//        Todo todo = findTodoByTodoListAndNumber(todoList, todoNumber);
//
//        if (request.getContent() != null) {
//            todoList.changeTodoContent(todo, request.getContent());
//        }
//
//        if (request.getDone() != null) {
//            if (request.getDone()) {
//                todoList.finishTodo(todo);
//            } else {
//                todoList.resetTodoStatus(todo);
//            }
//        }
//
//        return todoRepository.findDtoByTodoListIdAndNumber(listId, todoNumber)
//                .orElseThrow(todoNotFoundException(listId, todoNumber));
//    }
//
//    public TodoListDto reorder(Long id, List<Integer> order) {
//        TodoList todoList = findTodoListById(id);
//        todoList.reorder(order);
//
//        return findTodoListDtoById(id);
//    }
}
