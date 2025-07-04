package com.example.apiserver.repository.search;

import com.example.apiserver.domain.QTodo;
import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.PageRequestDTO;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements  TodoSearch{

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDTO pageRequestDTO) {
        log.info("search1------------------------------");

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        query.where(todo.title.contains("1"));

        Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1,pageRequestDTO.getSize(), Sort.by("tno"));

        this.getQuerydsl().applyPagination(pageable, query);

        List<Todo> list = query.fetch();      // 목록 데이터를 가져옴

        long total = query.fetchCount();

        return new PageImpl<>(list, pageable, total);
    }
}
