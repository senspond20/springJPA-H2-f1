package com.example.sample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {
    @Id
    @GeneratedValue
    Long id;

    private String username;
    private String content;

    @Builder
    public Board(String username, String content) {
        this.username = username;
        this.content = content;
    }
}
