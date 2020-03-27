package com.bgm.habitbuilder.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PerformedHabitVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Habit habit;
    @ManyToOne
    private HabitVersion habitVersion;
    @Temporal(TemporalType.DATE)
    private Date performDate;

    public PerformedHabitVersion() {}

    public PerformedHabitVersion(Date performDate) {
        this.performDate = performDate;
    }

    public PerformedHabitVersion(Habit habit, HabitVersion habitVersion, Date performDate) {
        this.habit = habit;
        this.habitVersion = habitVersion;
        this.performDate = performDate;
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

	public HabitVersion getHabitVersion() {
		return this.habitVersion;
	}

	public void setHabitVersion(HabitVersion habitVersion) {
		this.habitVersion = habitVersion;
	}

	public Date getPerformDate() {
		return this.performDate;
	}

	public void setPerformDate(Date performDate) {
		this.performDate = performDate;
	}

}