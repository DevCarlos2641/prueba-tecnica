package com.carlos2641.challenge.controllers;

import com.carlos2641.challenge.dto.ToDoRequest;
import com.carlos2641.challenge.model.ToDo;
import com.carlos2641.challenge.service.ToDoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@Tag(name = "ToDos", description = "API para la gestión de tareas")
public class ToDoController {

    private final ToDoService service;

    @GetMapping
    private ResponseEntity<?> get(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable long id){
        return service.getById(id);
    }

    @PostMapping
    private ResponseEntity<?> postToDo(@RequestBody ToDoRequest toDoRequest){
        return service.postToDo(toDoRequest);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> putToDo(@RequestBody ToDoRequest toDoRequest, @PathVariable long id){
        return service.putToDo(toDoRequest, id);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<?> patchToDo(@RequestBody ToDoRequest toDoRequest, @PathVariable long id){
        return service.patchToDo(toDoRequest, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteToDo(@PathVariable long id){
        return service.deleteToDo(id);
    }

}
