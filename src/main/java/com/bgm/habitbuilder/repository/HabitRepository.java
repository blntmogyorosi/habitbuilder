package com.bgm.habitbuilder.repository;

import java.util.List;
import java.util.Optional;

import com.bgm.habitbuilder.model.Habit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    Optional<Habit> findById(Long id);
    List<Habit> findByName(String name);

}