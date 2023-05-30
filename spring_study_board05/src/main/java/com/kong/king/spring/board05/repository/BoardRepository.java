package com.kong.king.spring.board05.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kong.king.spring.board05.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b, w from Board b left join b.writer w where b.bno = :bno")
    Object geBoardWithWriter(@Param("bno") Long bno);

    @Query("select b, r from Board b left join Reply r on r.board = b where b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query(value = "select b, w, count(r)" +
                    " from Board b " +
                    " left join b.writer w" +
                    " left join Reply r on r.board = b" +
                    " group by b", countQuery = "select count(b) from Board b")
    Page<Board> getBoardWithReplyCount(Pageable pageable);

    @Query("select b, w, count(r)" +
                    " from Board b left join b.writer w" +
                    " left outer join Reply r on r.board = b" +
                    " where b.bno = :bno")
    Object getBoardByBno(@Param("bno") Long bno);

    Page<Object[]> searchPage(String type, String keyword, PageRequest pageable);
}
