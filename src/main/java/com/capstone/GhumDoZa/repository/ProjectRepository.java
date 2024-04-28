package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.ProjectEntity;
import java.util.Optional;
import java.util.Set;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends
    JpaRepository<ProjectEntity, Long> {

  @NonNull Optional<ProjectEntity> findById(@NonNull Long id);

  @Query(value = """
      SELECT p.*
      FROM project p
      WHERE p.id IN (SELECT id
                           FROM project_team
                                    LEFT JOIN project_team pt ON p.id = pt.project_id
                                    LEFT JOIN team_user tu ON pt.team_id = tu.team_id
                           WHERE tu.user_id = ?1);""", nativeQuery = true)
  Set<ProjectEntity> findProjectsOfUserWithId(@NonNull Long id);
}