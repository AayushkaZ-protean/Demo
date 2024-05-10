package com.protean.openfinance.repository;

import com.protean.openfinance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //public List<User> findByTagsIgnoreCaseContaining(String name);

    User findByUserCode(String userCode);
}
