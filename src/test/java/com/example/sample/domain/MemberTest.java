package com.example.sample.domain;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sample.repository.MemberRepository;

@SpringBootTest
public class MemberTest {

	@Autowired
	MemberRepository MemberRepository;
	
	@Test
	public void testRegister() {
		Member member1 = new Member("admin","gun");
		MemberRepository.save(member1);
		
		Member member2 = new Member("user01","jae");
		MemberRepository.save(member2);
		
		Member member3 = new Member("user02","pa");
		MemberRepository.save(member3);
		
		Member member4 = new Member("user03","foo");
		MemberRepository.save(member4);
	}
	
	@Test
	public void testList() {
		Iterable<Member> memberList = MemberRepository.findAll();
		System.out.println("### :" + memberList);
		for(Member member : memberList) {
			System.out.println(member);
		}
	}

}
