package com.ilia.projeto.repository;

import com.ilia.projeto.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUid(UUID uuidd);

}
