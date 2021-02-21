package com.corvid.todo.repositories;

import com.corvid.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo,Long>
{

    @Modifying
    @Query(value = "delete from todo t where t.todolist = :todolist",nativeQuery = true)
    void deleteByName(@Param("todolist") String todo);



    @Modifying
    @Query(value = "update todo t set t.todolist = :todolist where t.id :id",nativeQuery = true)
    void updatename(@Param("todolist") String todolist, @PathVariable("id") Long id);


    @Query(value="select id from todo t where t.todolist=:todolist",nativeQuery = true)
    int findbyname(@PathVariable("todolist") String todolist);


}
