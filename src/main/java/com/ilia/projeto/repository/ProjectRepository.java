package com.ilia.projeto.repository;

import com.ilia.projeto.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCreatedAtBetween(LocalDate startDate, LocalDate finalDate);
}
