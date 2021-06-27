package ru.packager.models;

public class Argument {
    public String key;
    public String shortKey;
    public String help;
    public boolean hasBody;

    public Argument(String key, String shortKey, String help, boolean hasBody) {
        this.key = key;
        this.shortKey = shortKey;
        this.help = help;
        this.hasBody = hasBody;
    }
}
