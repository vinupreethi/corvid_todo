package com.corvid.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"todolist"})})
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @Column(unique=true,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Valid
    private String todolist;

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }


}
