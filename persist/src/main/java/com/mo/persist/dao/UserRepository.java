package com.mo.persist.dao;

import com.mo.persist.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
