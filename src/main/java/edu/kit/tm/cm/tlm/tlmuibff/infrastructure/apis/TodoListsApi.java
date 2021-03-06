/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis;

import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Api(value = "TodoLists", description = "the TodoLists API")
public interface TodoListsApi {

    @ApiOperation(value = "Creates a new todo for a specific todo list", nickname = "createTodoInListUsingPOST", notes = "", response = Todo.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Todo.class),
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")})
    @RequestMapping(value = "/todo-lists/{id}/todos",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.POST)
    ResponseEntity<Todo> createTodoInListUsingPOST(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "newTodo", required = true) @Valid @RequestBody TodoCreateRequest newTodo);


    @ApiOperation(value = "Creates a new todo list", nickname = "createTodoListUsingPOST", notes = "", response = TodoList.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = TodoList.class),
            @ApiResponse(code = 400, message = "Todo list was not valid")})
    @RequestMapping(value = "/todo-lists",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.POST)
    ResponseEntity<TodoList> createTodoListUsingPOST(@ApiParam(value = "newTodoList", required = true) @Valid @RequestBody TodoListCreateRequest newTodoList);


    @ApiOperation(value = "Deletes a specific todo from a list", nickname = "deleteTodoFromListUsingDELETE", notes = "", tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Todo list or todo not found")})
    @RequestMapping(value = "/todo-lists/{id}/todos/{number}",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTodoFromListUsingDELETE(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "number", required = true) @PathVariable("number") Integer number);


    @ApiOperation(value = "Deletes a specific todo list", nickname = "deleteTodoListUsingDELETE", notes = "", tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Todo list not found")})
    @RequestMapping(value = "/todo-lists/{id}",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTodoListUsingDELETE(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "Finds a specific todo list", nickname = "getTodoListUsingGET", notes = "", response = TodoList.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TodoList.class),
            @ApiResponse(code = 404, message = "Todo list not found")})
    @RequestMapping(value = "/todo-lists/{id}",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.GET)
    ResponseEntity<TodoList> getTodoListUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "Finds all todo lists", nickname = "getTodoListsUsingGET", notes = "", response = TodoList.class, responseContainer = "List", tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TodoList.class, responseContainer = "List")})
    @RequestMapping(value = "/todo-lists",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.GET)
    ResponseEntity<List<TodoList>> getTodoListsUsingGET();


    @ApiOperation(value = "Finds a specific todo in a list", nickname = "getTodoUsingGET", notes = "", response = Todo.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Todo.class),
            @ApiResponse(code = 404, message = "Todo list or todo not found")})
    @RequestMapping(value = "/todo-lists/{id}/todos/{number}",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.GET)
    ResponseEntity<Todo> getTodoUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "number", required = true) @PathVariable("number") Integer number);


    @ApiOperation(value = "Finds all todos for a specific todo list", nickname = "getTodosUsingGET", notes = "", response = Todo.class, responseContainer = "List", tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Todo.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Todo list not found")})
    @RequestMapping(value = "/todo-lists/{id}/todos",
            produces = "application/json",
            consumes = "",
            method = RequestMethod.GET)
    ResponseEntity<List<Todo>> getTodosUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "Updates specific fields of an existing todo list", nickname = "patchTodoListUsingPATCH", notes = "", response = TodoList.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TodoList.class),
            @ApiResponse(code = 400, message = "Todo list was not valid"),
            @ApiResponse(code = 404, message = "Todo list not found")})
    @RequestMapping(value = "/todo-lists/{id}",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.PATCH)
    ResponseEntity<TodoList> patchTodoListUsingPATCH(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "partialTodoList", required = true) @Valid @RequestBody TodoListPatchRequest partialTodoList);


    @ApiOperation(value = "Updates specific fields of a todo", nickname = "patchTodoUsingPATCH", notes = "", response = Todo.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Todo.class),
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list or todo not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")})
    @RequestMapping(value = "/todo-lists/{id}/todos/{number}",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.PATCH)
    ResponseEntity<Todo> patchTodoUsingPATCH(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "number", required = true) @PathVariable("number") Integer number, @ApiParam(value = "partialTodo", required = true) @Valid @RequestBody TodoPatchRequest partialTodo);


    @ApiOperation(value = "Updates an existing todo list", nickname = "updateTodoListUsingPUT", notes = "", response = TodoList.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TodoList.class),
            @ApiResponse(code = 400, message = "Todo list was not valid"),
            @ApiResponse(code = 404, message = "Todo list not found")})
    @RequestMapping(value = "/todo-lists/{id}",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.PUT)
    ResponseEntity<TodoList> updateTodoListUsingPUT(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "updatedTodoList", required = true) @Valid @RequestBody TodoListUpdateRequest updatedTodoList);


    @ApiOperation(value = "Updates a specific todo", nickname = "updateTodoUsingPUT", notes = "", response = Todo.class, tags = {"todo-lists",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Todo.class),
            @ApiResponse(code = 400, message = "Todo was not valid"),
            @ApiResponse(code = 404, message = "Todo list or todo not found"),
            @ApiResponse(code = 409, message = "Todo with the same content already exists in this list")})
    @RequestMapping(value = "/todo-lists/{id}/todos/{number}",
            produces = "application/json",
            consumes = "application/json",
            method = RequestMethod.PUT)
    ResponseEntity<Todo> updateTodoUsingPUT(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "number", required = true) @PathVariable("number") Integer number, @ApiParam(value = "updatedTodo", required = true) @Valid @RequestBody TodoUpdateRequest updatedTodo);

}
