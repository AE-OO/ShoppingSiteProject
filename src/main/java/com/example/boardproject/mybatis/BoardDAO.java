package com.example.boardproject.mybatis;

import com.example.boardproject.dto.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardDAO {
    @Select("select bId,bContent,bTitle,bWriter from board where bId=#{bId}")
    BoardDTO getContent(int bId);

    @Update("update board set bTitle=#{bTitle}, bContent=#{bContent} where bId=#{bId}")
    int update(String bTitle, String bContent, int bId);

    @Select("select storeFileName from files where fId=#{bId}")
    String selectImage(int bId);

    // @Select("select bId, bTitle, bContent, bWriter, bDate, f.* from board, (Select storeFileName from files where fId = #{bId}) f where board.bId = #{bId}")
    @Select("select bId,bTitle,bContent,bWriter,bDate from board where bId=#{bId}")
    BoardDTO updateSelect(int bId);

    @Select("select bWriter from board where bId=#{bId}")
    String checkWriter(int bId);

    @Delete("delete from board where bId=#{bId}")
    int delete(int bId);

    @Delete("delete from files where fId=#{bId}")
    int deleteImage(int bId);

    @Insert("insert into files values(#{fId},#{storeFileName},#{uploadFileName})")
    int insertImage(int fId,String storeFileName,String uploadFileName);

    @Select("select bId, bTitle, bWriter, bDate from board")
    List<BoardDTO> list();


}
