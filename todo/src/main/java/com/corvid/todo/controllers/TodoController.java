package com.corvid.todo.controllers;

import com.corvid.todo.models.Todo;
import com.corvid.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @PersistenceContext
    EntityManager entityManager;
    @GetMapping
    public List<Todo> list()
    {
        return todoRepository.findAll();

    }
    @PostMapping
    public boolean createTutorial( @Valid @RequestBody Todo todo) {

        try {
            todoRepository.save(todo);
            return true;
        }
        catch(Exception e)
        {
            
            return false;
        }



    }

    @GetMapping("/{todolist}")
    @ResponseBody
    public int getEmployeesByIdWithVariableName(@PathVariable("todolist") String employeeId) {

        int id= todoRepository.findbyname(employeeId);
       System.out.println(id);
        return id;

    }
    @DeleteMapping
    public String deleteByName(@RequestBody Todo todo)
    {
        //System.out.println(todo.getTodolist().toString());
        //System.out.println(todo.getTodolist().toString());
        todoRepository.deleteByName(todo.getTodolist().toString());
        return "Deleted";
    }

    @PutMapping("/{id}")
    public void saveandupdate(@PathVariable("id") Long id, @RequestBody Todo todo)
    {
        //Long id=Long.parseLong(id2);
        Optional<Todo> id1=todoRepository.findById(id);
        Todo value =todoRepository.findById(id).get();
        System.out.println(id);
        String v=(value.getTodolist().toString());
      // System.out.println(todo.getTodolist().toString());
        value.setTodolist(todo.getTodolist().toString());
        todoRepository.save(value);


    }






}
