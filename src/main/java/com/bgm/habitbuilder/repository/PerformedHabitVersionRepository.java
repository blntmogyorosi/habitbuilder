package com.bgm.habitbuilder.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.bgm.habitbuilder.model.PerformedHabitVersion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformedHabitVersionRepository extends JpaRepository<PerformedHabitVersion, Long> {

    Optional<PerformedHabitVersion> findById(Long id);
    List<PerformedHabitVersion> findAllByPerformDateBetween(Date performDateStart, Date performDateEnd);

}