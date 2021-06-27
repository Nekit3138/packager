package ru.packager.models;

public class ParsedArgument {
    public String key ;
    public String value;
    public boolean hasValue;

    public ParsedArgument(String key, String value, boolean hasValue) {
        this.key = key;
        this.value = value;
        this.hasValue = hasValue;
    }
}
