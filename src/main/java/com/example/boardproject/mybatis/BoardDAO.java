package com.example.boardproject.mybatis;

import com.example.boardproject.dto.BoardDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardDAO {


    @Select("select bId,bContent,bDate,bPw,bTitle,bWriter from board where bId=#{bId}")
    BoardDTO getContent(int bId);

    @Update("update board set bTitle=#{bTitle}, bContent=#{bContent} where bId=#{bId}")
    int update(String bTitle, String bContent, int bId);

    @Select("select bId,bTitle,bContent,bWriter,bPw from board where bId=#{bId}")
    BoardDTO updateSelect(int bId);

    @Select("select bPw from board where bId=#{bId}")
    String checkPW(int bId);

    @Delete("delete from board where bId=#{bId}")
    int delete(int bId);

    @Select("select bId, bTitle, bWriter, bDate from board")
    List<BoardDTO> list();

}
