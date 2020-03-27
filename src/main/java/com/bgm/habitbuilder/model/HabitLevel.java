package com.bgm.habitbuilder.model;

public enum HabitLevel {

    MINI("Mini", 1), NORMAL("Normal", 2), ELITE("Elite", 3);

    private final String key;
    private final Integer value;

    HabitLevel(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

}