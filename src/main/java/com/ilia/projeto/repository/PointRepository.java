package com.ilia.projeto.repository;


import com.ilia.projeto.models.Ponto;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Ponto, Long> {

    Optional<Ponto> findByCreatedAtAndUserId(LocalDate creatdAt, Long id);

    List<Ponto> findByCreatedAtBetween(LocalDate initialDate, LocalDate finalDate);

}
