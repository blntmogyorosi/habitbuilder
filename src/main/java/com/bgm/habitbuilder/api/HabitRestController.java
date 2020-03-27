package com.bgm.habitbuilder.api;

import java.util.List;

import com.bgm.habitbuilder.exception.ResourceNotFoundException;
import com.bgm.habitbuilder.model.Habit;
import com.bgm.habitbuilder.model.HabitVersion;
import com.bgm.habitbuilder.repository.HabitRepository;
import com.bgm.habitbuilder.repository.HabitVersionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HabitRestController {

    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private HabitVersionRepository habitVersionRepository;

    @GetMapping(value = "/api/habits")
    public List<Habit> getHabits() {
        return habitRepository.findAll();
    }

    @GetMapping(value = "/api/habits/{habitId}")
    public Habit getHabit(@PathVariable("habitId") Long habitId) {
        return habitRepository.findById(habitId).map(habit -> {
            List<HabitVersion> habitVersions = habitVersionRepository.findByHabitId(habitId);
            habitVersions
                    .sort((prev, next) -> prev.getHabitLevel().getValue().compareTo(next.getHabitLevel().getValue()));
            habit.setHabitVersions(habitVersions);
            return habit;
        }).orElseThrow(() -> new ResourceNotFoundException("Habit with id " + habitId + " not found"));
    }

    @PostMapping(value = "/api/habits")
    public Habit createHabit(@RequestBody Habit habit) {
        return habitRepository.save(habit);
    }

}