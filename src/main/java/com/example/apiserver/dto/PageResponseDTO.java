package com.example.apiserver.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
// 페이징 결과물 (list dto)
public class PageResponseDTO<E> {
    private List<E> dtoList;

    private List<Integer> pageNumList;

    private PageRequestDTO pageRequestDTO;

    // 이전, 다음 버튼
    private boolean prev, next;
    
    private int totalCount, prevPage, nextPage, totalPage, current;

    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long total){
        this.dtoList = dtoList;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = (int)total;

        // end 페이지 계산
        int end = (int)(Math.ceil(pageRequestDTO.getPage() / 10.0) * 10);

        int start = end - 9;

        //total end 페이지 계산
        int last = (int)(Math.ceil(totalCount/(double)pageRequestDTO.getSize()));

        end = end > last ? last : end;

        this.prev = start>1;
        this.next = totalCount > end * pageRequestDTO.getSize();

        this.pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        this.prevPage = prev ? start -1 : 0;

        this.nextPage = next ? end + 1 : 0;
    }
}
