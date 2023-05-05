package com.example.weluvwine.review.entity;

import com.example.weluvwine.member.entity.Member;
import com.example.weluvwine.review.dto.ReviewRequestDto;
import com.example.weluvwine.util.Timestamped;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Review extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Review (ReviewRequestDto requestDto, Member member){
        this.content = requestDto.getContent();
        this.member = member;
    }

    public void update(ReviewRequestDto requestDto){
        this.content = requestDto.getContent();
    }
}
