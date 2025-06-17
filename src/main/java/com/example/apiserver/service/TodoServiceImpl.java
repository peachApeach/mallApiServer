package com.example.apiserver.service;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.TodoDTO;
import com.example.apiserver.repository.TodoReository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoReository todoReository;

    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoReository.findById(tno);

        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO dto) {

        Todo todo = DTOToEntity(dto);
        Todo result = todoReository.save(todo);
        return result.getTno();
    }

    @Override
    public void modify(TodoDTO dto) {
        Optional<Todo> result = todoReository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setComplete(dto.isComplete());
        todo.setDueDate(dto.getDueDate());

        todoReository.save(todo);
    }

    @Override
    public void remove(Long tno) {
        todoReository.deleteById(tno);
    }
}
