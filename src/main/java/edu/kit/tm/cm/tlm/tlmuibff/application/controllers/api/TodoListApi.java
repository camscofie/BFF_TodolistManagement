package edu.kit.tm.cm.tlm.tlmuibff.application.controllers.api;

import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoListRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.CreateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.PatchTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.request.UpdateTodoRequest;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/todo-lists")
@Api(tags = "todo-lists", description = "Manages todo lists and their todos")
public interface TodoListApi {
    @GetMapping
    @ApiOperation(value = "Finds all todo lists")
    List<TodoListResponse> getTodoLists();

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds a specific todo list")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Todo list not found")
    })
    TodoListResponse getTodoList(@PathVariable Long id);

    @GetMapping("/{id}/todos/{number}")
    @ApiOperation(value = "Finds a specific todo in a list")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Todo list or todo not found")
    })
    TodoResponse getTodo(@PathVariable Long id, @PathVariable Integer number);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new todo list", code = 201)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Todo list was not valid")
    })
    TodoListResponse createTodoList(@Valid @RequestBody CreateTodoListRequest newTodoList);

    @PostMapping("/{id}/todos")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new todo for a specific todo list", code = 201)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")
    })
    TodoResponse createTodoInList(@PathVariable Long id, @Valid @RequestBody CreateTodoRequest newTodo);

    @PatchMapping("/{id}/todos/{number}")
    @ApiOperation(value = "Updates selected attributes of a specific todo")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list or todo not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")
    })
    TodoResponse patchTodo(@PathVariable Long id,
                           @PathVariable Integer number,
                           @ApiParam(value = "A subset of the following attributes to update", required = true)
                           @RequestBody PatchTodoRequest partialTodo
    );

    @PutMapping("/{id}/todos/{number}")
    @ApiOperation(value = "Updates a specific todo")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list or todo not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")
    })
    TodoResponse updateTodo(@PathVariable Long id,
                            @PathVariable Integer number,
                            @Valid @RequestBody UpdateTodoRequest updatedTodo
    );

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletes a specific todo list", code = 204)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Todo list not found")
    })
    void deleteTodoList(@PathVariable Long id);

    @DeleteMapping("/{id}/todos/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletes a specific todo from a list", code = 204)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Todo list or todo not found")
    })
    void deleteTodoFromList(@PathVariable Long id, @PathVariable Integer number);
}
