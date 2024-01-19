package dev.thebjoredcraft.bunnynationscore.util;

public enum Person {
    PROFESSOR("<#3b92d1><bold>[Professor Dr. Anonymus] <reset><#3b92d1>"),
    CONSOLE("<red><bold>[CONSOLE] <reset><red>"),
    PROXY("<color:#40d1db><bold>[Proxy] <reset><color:#40d1db>"),
    ALERT("<gold><bold>[Alert] <reset><gold>"),
    SERVER("<red><bold>[SERVER] <reset><red>");

    private final String msg;

     Person(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }
}