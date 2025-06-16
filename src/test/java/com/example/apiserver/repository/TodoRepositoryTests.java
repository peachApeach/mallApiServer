package com.example.apiserver.repository;

import com.example.apiserver.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoReository todoReository;

    @Test
    public void test1(){
        Assertions.assertNotNull(todoReository);

        log.info(todoReository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Todo todo = Todo.builder()
                .title("Title")
                .content("Contents...")
                .dueDate(LocalDate.of(2023,06,17))
                .build();

        todoReository.save(todo);
    }

    @Test
    public void testRead() {
        Long tno = 1L;

        // null 체크를 위하여 optional 사용
        Optional<Todo> result = todoReository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

    @Test
    public void testUpdate() {
        // 먼저 로딩하고 엔티티 객체를 변경
        // setter로 변경
        Long tno = 1L;

        Optional<Todo> result = todoReository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.setTitle("Update title");
        todo.setContent("update content");
        todo.setComplete(true);

        todoReository.save(todo);


    }
}
