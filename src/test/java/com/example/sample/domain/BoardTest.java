package com.example.sample.domain;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sample.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository boardRepository;

//	@Test
	public void insert10() {
		for (int i = 0; i < 10; i++) {
			Board board = Board.builder().username("testUser" + i).content("test").build();
			boardRepository.save(board);
		}
	}

//	@Test
	public void findByContent() {
		boardRepository.findBoardByContent("test").forEach(board -> System.out.println(board));
	}

//	@Test
	public void testIdOrderByPaging() {
		Pageable pageable = PageRequest.of(0, 5);
		Collection<Board> boards = boardRepository.findByIdGreaterThanOrderByIdDesc(0l, pageable);
		boards.forEach(board -> System.out.println(board));
	}

//	@Test
	public void testPagingSort() {
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
		Page<Board> result = boardRepository.findByIdGreaterThan(0L, pageable);

		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGE: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());

		List<Board> list = result.getContent();
		System.out.println(list);
	}

	@Test
	public void testJpaQueryByUsername() {
		boardRepository.findBoardByUsername("testUser7").forEach(board -> System.out.println(board));
	}

//	@Test
	public void contextLoads() {
	}

}
