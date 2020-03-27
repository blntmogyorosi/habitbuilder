package com.bgm.habitbuilder.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String icon;
    @OneToMany
    @Transient
    @JsonInclude(Include.NON_NULL)
    private List<HabitVersion> habitVersions;

    public Habit() {
    }

    public Habit(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<HabitVersion> getHabitVersions() {
        return this.habitVersions;
    }

    public void setHabitVersions(List<HabitVersion> habitVersions) {
        this.habitVersions = habitVersions;
    }

}