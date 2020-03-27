package com.bgm.habitbuilder.api;

import java.util.List;

import com.bgm.habitbuilder.exception.ResourceNotFoundException;
import com.bgm.habitbuilder.model.HabitVersion;
import com.bgm.habitbuilder.repository.HabitRepository;
import com.bgm.habitbuilder.repository.HabitVersionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitVersionRestController {

    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private HabitVersionRepository habitVersionRepository;

    @GetMapping("/api/habit-versions")
    public List<HabitVersion> getHabitVersions() {
        return habitVersionRepository.findAll();
    }

    @GetMapping(value = "/api/habit-versions/{habitVersionId}")
    public HabitVersion getHabitVersion(@PathVariable("habitVersionId") Long habitVersionId) {
        return habitVersionRepository.findById(habitVersionId).orElseThrow(
                () -> new ResourceNotFoundException("Habit version with id " + habitVersionId + " not found"));
    }

    @GetMapping("/api/habits/{habitId}/habit-versions")
    public List<HabitVersion> getAllHabitVersionsByHabitId(@PathVariable("habitId") Long habitId) {
        return habitVersionRepository.findByHabitId(habitId);
    }

    @PostMapping(value = "/api/habits/{habitId}/habit-versions")
    public HabitVersion createHabitVersionForHabit(@PathVariable("habitId") Long habitId,
            @RequestBody HabitVersion habitVersion) {
        return habitRepository.findById(habitId).map(habit -> {
            habitVersion.setHabit(habit);
            return habitVersionRepository.save(habitVersion);
        }).orElseThrow(() -> new ResourceNotFoundException("Habit with id " + habitId + " not found"));
    }

}