package com.example.apiserver;

import com.example.apiserver.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reository extends JpaRepository<Todo,Long> {

}
