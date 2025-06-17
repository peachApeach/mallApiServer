// todo 검색 용
package com.example.apiserver.repository.search;

import com.example.apiserver.domain.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<Todo> search1();
}
