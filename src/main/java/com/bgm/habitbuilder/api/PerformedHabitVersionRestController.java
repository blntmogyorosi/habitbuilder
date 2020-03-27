package com.bgm.habitbuilder.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.bgm.habitbuilder.exception.ResourceNotFoundException;
import com.bgm.habitbuilder.model.HabitVersion;
import com.bgm.habitbuilder.model.PerformedHabitVersion;
import com.bgm.habitbuilder.repository.HabitVersionRepository;
import com.bgm.habitbuilder.repository.PerformedHabitVersionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformedHabitVersionRestController {

    @Autowired
    private HabitVersionRepository habitVersionRepository;
    @Autowired
    private PerformedHabitVersionRepository performedHabitVersionRepository;

    @GetMapping(value = "/api/performed-habit-versions")
    public List<PerformedHabitVersion> getHabitVersionsFromTo(@RequestParam("from") String from,
            @RequestParam("to") String to) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return performedHabitVersionRepository.findAllByPerformDateBetween(format.parse(from), format.parse(to));
    }

    @PostMapping(value = "/api/habit-versions/{habitVersionId}/performed")
    public PerformedHabitVersion createPerformedHabitVersion(@PathVariable("habitVersionId") Long habitVersionId,
            @RequestBody PerformedHabitVersion performedHabitVersion) {
        HabitVersion habitVersion = habitVersionRepository.findById(habitVersionId).orElseThrow(
                () -> new ResourceNotFoundException("Habit version with id " + habitVersionId + " not found"));
        performedHabitVersion.setHabit(habitVersion.getHabit());
        performedHabitVersion.setHabitVersion(habitVersion);
        return performedHabitVersionRepository.save(performedHabitVersion);
    }

}