package com.example.boardproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
public class PageResultDTO<DTO, Entity> {

    private PageRequestDTO pageRequestDTO;

    @Autowired
    public PageResultDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }

    private int totalPage;
    private int start;
    private int end;
    private int pageSize;
    private int page;
    private boolean prev;
    private boolean next;
    private List<DTO> dtoList;
    private List<Integer> pageList;

    private Long totalElement;

    private int number;

    private int size;

    public PageResultDTO(Page<Entity> result, Function<Entity, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();

        number = result.getNumber();
        size = result.getSize();


        makePageList(result.getPageable());

    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.pageSize = pageable.getPageSize();

        int tempEnd = (int) (Math.ceil(page / (double) (pageSize))) * pageSize;

        start = tempEnd - 9;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        prev = start > 1 ? true : false;
        next = totalPage > tempEnd ? true: false;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

    }
}
