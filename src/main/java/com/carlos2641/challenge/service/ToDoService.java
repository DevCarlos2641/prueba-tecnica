package com.carlos2641.challenge.service;

import com.carlos2641.challenge.dto.ToDoRequest;
import com.carlos2641.challenge.model.ToDo;
import com.carlos2641.challenge.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<?> postToDo(ToDoRequest toDoRequest) {
        if(validateData(toDoRequest))
            return ResponseEntity.badRequest().build();

        if(isValidDate(toDoRequest.getDate()))
            return ResponseEntity.badRequest().body("La fecha tiene el formato incorrecto");

        ToDo newToDo = new ToDo();
        newToDo.setDescription(toDoRequest.getDescription());
        newToDo.setDate(convertDate(toDoRequest.getDate()));
        newToDo.setStatus(toDoRequest.getStatus());

        ToDo save = repository.save(newToDo);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId_todo())
                .toUri();
        return ResponseEntity.created(uri).body(save);

    }

    public ResponseEntity<?> getById(long id) {
        ToDo toDo = existToDo(id);
        if(toDo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(toDo);
    }

    public ResponseEntity<?> putToDo(ToDoRequest toDoRequest, long id) {
        ToDo thisToDo = existToDo(id);
        if(thisToDo == null)
            return ResponseEntity.notFound().build();

        if(validateData(toDoRequest))
            return ResponseEntity.badRequest().build();

        if(isValidDate(toDoRequest.getDate()))
            return ResponseEntity.badRequest().body("La fecha tiene el formato incorrecto");

        thisToDo.setDescription(toDoRequest.getDescription());
        thisToDo.setStatus(toDoRequest.getStatus());
        thisToDo.setDate(convertDate(toDoRequest.getDate()));
        repository.save(thisToDo);
        return ResponseEntity.ok(thisToDo);
    }

    public ResponseEntity<?> patchToDo(ToDoRequest toDoRequest, long id) {
        ToDo thisToDo = existToDo(id);
        if(thisToDo == null)
            return ResponseEntity.notFound().build();

        if(toDoRequest.getDescription() != null && !toDoRequest.getDescription().isEmpty())
            thisToDo.setDescription(toDoRequest.getDescription());
        if(toDoRequest.getDate() != null && !toDoRequest.getDate().isEmpty())
            thisToDo.setDate(convertDate(toDoRequest.getDate()));
        if(toDoRequest.getStatus() != null && !toDoRequest.getStatus().isEmpty())
            thisToDo.setStatus(toDoRequest.getStatus());

        repository.save(thisToDo);
        return ResponseEntity.ok(thisToDo);
    }

    public ResponseEntity<?> deleteToDo(long id) {
        ToDo thisToDo = existToDo(id);
        if(thisToDo == null)
            return ResponseEntity.notFound().build();

        repository.delete(thisToDo);
        return ResponseEntity.noContent().build();
    }


    //  --  -   -   -   -       -


    private boolean isValidDate(String str) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(str, format);
            return false;
        } catch (DateTimeParseException e) {
            return true;
        }
    }

    private boolean validateData(ToDoRequest toDo){
        if(toDo.getDescription() == null || toDo.getStatus() == null)
            return true;
        else return toDo.getDescription().isEmpty() || toDo.getStatus().isEmpty();
    }

    public static Date convertDate(String date) {
        LocalDate localDate = LocalDate.parse(date); // formato "yyyy-MM-dd"
        return Date.valueOf(localDate);
    }

    private ToDo existToDo(long id){
        Optional<ToDo> toDo = repository.findById(id);
        return toDo.orElse(null);
    }
}
