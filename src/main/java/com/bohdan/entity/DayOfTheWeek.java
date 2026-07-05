package com.bohdan.entity;

public enum DayOfTheWeek {

        MONDAY("понеділок"),
        TUESDAY("вівторок"),
        WEDNESDAY("середа"),
        THURSDAY("четвер"),
        FRIDAY("п'ятниця"),
        SATURDAY("субота"),
        SUNDAY("неділя");

        private final String ukrainianName;

        DayOfTheWeek(String ukrainianName) {
            this.ukrainianName = ukrainianName;
        }

        public static DayOfTheWeek fromUkrainian(String name) {
            for (DayOfTheWeek day : values()) {
                if (day.ukrainianName.equalsIgnoreCase(name)) {
                    return day;
                }
            }
            throw new IllegalArgumentException("Невідомий день: " + name);
        }
    }

