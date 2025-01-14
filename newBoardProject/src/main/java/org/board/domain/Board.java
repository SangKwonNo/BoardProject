package org.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private Long id; //게시글 PK

    private String editor; // 보드 에디터종류

    private int type; //공지,일반

    private String category; //보드카테고리 -> 자유게시판,ㅇㅇ게시판

    private String writer ; //작성자

    private String name; //작성자닉네임

    private String title; // 제목

    @Lob
    private String contents; // 내용

    @CreationTimestamp //값이 입력될때 혹은 업데이트될때 자동으로 시간이 들어간다.
    private Timestamp createDate;

    private int count; //조회수

    @ManyToOne
    @JoinColumn(name = "integration_Id")
    @JsonIgnore //stackoverflow 방지
    private IntegrationBoard integrationBoard;

}
