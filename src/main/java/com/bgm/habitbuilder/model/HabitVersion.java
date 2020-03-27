package com.bgm.habitbuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "habitversions")
public class HabitVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Habit habit;
    private String requirement;
    private HabitLevel habitLevel;

    public HabitVersion() {}

    public HabitVersion(String requirement, HabitLevel habitLevel) {
        this.requirement = requirement;
        this.habitLevel = habitLevel;
    }

    public HabitVersion(Habit habit, String requirement, HabitLevel habitLevel) {
        this.habit = habit;
        this.requirement = requirement;
        this.habitLevel = habitLevel;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habit getHabit() {
        return this.habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public HabitLevel getHabitLevel() {
        return this.habitLevel;
    }

    public void setHabitLevel(HabitLevel habitLevel) {
        this.habitLevel = habitLevel;
    }

}