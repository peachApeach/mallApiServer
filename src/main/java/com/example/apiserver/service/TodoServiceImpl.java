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
}
