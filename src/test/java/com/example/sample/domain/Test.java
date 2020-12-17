package com.example.sample.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sample.repository.BoardRepository;

public class Test {
	
	@Autowired
	static
	BoardRepository boardRepository;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Board board = Board.builder().username("testUser" + i).content("test").build();
			boardRepository.save(board);
		}
		boardRepository.findBoardByContent("test").forEach(board -> System.out.println(board));
	}

}
