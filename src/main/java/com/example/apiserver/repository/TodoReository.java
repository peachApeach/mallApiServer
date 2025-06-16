package com.example.apiserver.repository;

import com.example.apiserver.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoReository extends JpaRepository<Todo,Long> {

}
