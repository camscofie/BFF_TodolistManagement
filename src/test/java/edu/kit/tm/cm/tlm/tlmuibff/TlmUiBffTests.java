package edu.kit.tm.cm.tlm.tlmuibff;

import edu.kit.tm.cm.msutils.rest.ApiError;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoListResponse;
import edu.kit.tm.cm.tlm.tlmuibff.application.dtos.response.TodoResponse;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoListCreateRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoPatchRequest;
import edu.kit.tm.cm.tlm.tlmuibff.infrastructure.dtos.TodoUpdateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Temporary tests used for microservice + BFF integration
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TlmUiBffTests {

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String todoListsEnpoint() {
        return "http://localhost:" + port + "/todo-lists";
    }

    @Test
    public void shouldGetAllTodoLists() {
        ResponseEntity<List<TodoListResponse>> response = restTemplate.exchange(
                todoListsEnpoint(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TodoListResponse>>() {
                }
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        List<TodoListResponse> todoLists = response.getBody();
        assertThat(todoLists).isNotNull();
        assertThat(todoLists).size().isGreaterThan(2);
    }

    @Test
    public void shouldGetASingleTodoList() {
        ResponseEntity<TodoListResponse> response = restTemplate.getForEntity(
                todoListsEnpoint() + "/1",
                TodoListResponse.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        TodoListResponse todoList = response.getBody();
        assertThat(todoList).isNotNull();
        assertThat(todoList.getTodos()).size().isGreaterThan(5);
    }

    @Test
    public void shouldGetASingleTodo() {
        ResponseEntity<TodoResponse> response = restTemplate.getForEntity(
                todoListsEnpoint() + "/1/todos/1",
                TodoResponse.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        TodoResponse todo = response.getBody();
        assertThat(todo).isNotNull();
        assertThat(todo.getContent()).isNotNull();
    }

    @Test
    public void shouldNotGetATodoWithWrongId() {
        ResponseEntity<ApiError> response = restTemplate.getForEntity(
                todoListsEnpoint() + "/1/todos/111",
                ApiError.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(404);

        ApiError apiError = response.getBody();
        assertThat(apiError).isNotNull();
    }

    @Test
    public void shouldCreateATodoList() {
        TodoListCreateRequest request = new TodoListCreateRequest();
        request.setTitle("List title");

        ResponseEntity<TodoListResponse> response = restTemplate.postForEntity(
                todoListsEnpoint(),
                request,
                TodoListResponse.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(201);

        TodoListResponse todoList = response.getBody();
        assertThat(todoList).isNotNull();
        assertThat(todoList.getId()).isGreaterThan(1);
    }

    @Test
    public void shouldCreateATodoListWithEmptyTitle() {
        TodoListCreateRequest request = new TodoListCreateRequest();

        ResponseEntity<ApiError> response = restTemplate.postForEntity(
                todoListsEnpoint(),
                request,
                ApiError.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(400);

        ApiError apiError = response.getBody();
        assertThat(apiError).isNotNull();
        assertThat(apiError.getError()).isEqualTo("VALIDATION_ERROR");
        assertThat(apiError.getErrors()).containsKey("title");
    }

    @Test
    public void shouldDeleteATodoList() {
        ResponseEntity<String> response = restTemplate.exchange(
                todoListsEnpoint() + "/39",
                HttpMethod.DELETE,
                null,
                String.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
    }

    @Test
    public void shouldPatchTodo() {
        TodoResponse original = restTemplate.getForObject(todoListsEnpoint() + "/1/todos/1", TodoResponse.class);

        TodoPatchRequest todoPatchRequest = new TodoPatchRequest();
        todoPatchRequest.setDone(true);

        ResponseEntity<TodoResponse> response = restTemplate.exchange(
                todoListsEnpoint() + "/1/todos/1",
                HttpMethod.PATCH,
                new HttpEntity<>(todoPatchRequest),
                TodoResponse.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        TodoResponse todo = response.getBody();
        assertThat(todo).isNotNull();
        assertThat(todo.isDone()).isTrue();
        assertThat(todo.getContent()).isEqualTo(original.getContent());
        assertThat(todo.getDescription()).isEqualTo(original.getDescription());
    }

    @Test
    public void shouldUpdateTodo() {
        TodoResponse original = restTemplate.getForObject(todoListsEnpoint() + "/1/todos/2", TodoResponse.class);

        TodoUpdateRequest todoUpdateRequest = new TodoUpdateRequest();
        todoUpdateRequest.setPosition(original.getPosition());
        todoUpdateRequest.setContent("TESTASDF");
        todoUpdateRequest.setDone(true);
        todoUpdateRequest.setDescription("Example description");

        ResponseEntity<TodoResponse> response = restTemplate.exchange(
                todoListsEnpoint() + "/1/todos/2",
                HttpMethod.PUT,
                new HttpEntity<>(todoUpdateRequest),
                TodoResponse.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        TodoResponse todo = response.getBody();
        assertThat(todo).isNotNull();
        assertThat(todo.isDone()).isTrue();
        assertThat(todo.getContent()).isEqualTo("TESTASDF");
        assertThat(todo.getDescription()).isEqualTo("Example description");
    }


    @Test
    public void shouldUpdateTodoWithIncompleteObject() {
        TodoUpdateRequest todoUpdateRequest = new TodoUpdateRequest();
        todoUpdateRequest.setDone(true);
        todoUpdateRequest.setDescription("Example description");

        ResponseEntity<ApiError> response = restTemplate.exchange(
                todoListsEnpoint() + "/1/todos/3",
                HttpMethod.PUT,
                new HttpEntity<>(todoUpdateRequest),
                ApiError.class
        );

        assertThat(response.getStatusCodeValue()).isEqualTo(400);

        ApiError apiError = response.getBody();
        assertThat(apiError).isNotNull();
        assertThat(apiError.getError()).isEqualTo("VALIDATION_ERROR");
        assertThat(apiError.getErrors()).containsKey("content");
        assertThat(apiError.getErrors()).containsKey("position");
    }

}
