package com.bgm.habitbuilder.repository;

import java.util.List;
import java.util.Optional;

import com.bgm.habitbuilder.model.HabitVersion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitVersionRepository extends JpaRepository<HabitVersion, Long> {

    Optional<HabitVersion> findById(Long id);
    List<HabitVersion> findByHabitId(Long habitId);

}