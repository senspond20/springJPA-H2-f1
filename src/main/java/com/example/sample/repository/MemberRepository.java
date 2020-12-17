package com.example.sample.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.sample.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{

}
