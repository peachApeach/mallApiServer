package com.example.apiserver.repository.search;

import com.example.apiserver.domain.QTodo;
import com.example.apiserver.domain.Todo;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class TodoSearchImp extends QuerydslRepositorySupport implements  TodoSearch{

    public TodoSearchImp() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1() {
        log.info("search1------------------------------");

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        query.where(todo.title.contains("1"));

        Pageable pageable = PageRequest.of(1,10, Sort.by("tno"));

        this.getQuerydsl().applyPagination(pageable, query);

        query.fetch();      // 목록 데이터를 가져옴

        query.fetchCount();

        return null;
    }
}
