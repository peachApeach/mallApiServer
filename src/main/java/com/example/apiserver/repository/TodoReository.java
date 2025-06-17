package com.example.apiserver.repository;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoReository extends JpaRepository<Todo,Long>, TodoSearch {

}
