package ru.packager.models;

import java.util.*;

public class ParsedArguments implements Cloneable {
    public Map<String, String> args = new HashMap<>();
    public String command = null;
    public Set<String> flags = new HashSet<>();

    @Override
    public String toString() {
        return "ParsedArguments{" +
                "args=" + args +
                ", command='" + command + '\'' +
                ", flags=" + flags +
                '}';
    }

    @Override
    public ParsedArguments clone() {
        ParsedArguments parsed = new ParsedArguments();
        parsed.command = command;
        parsed.flags.addAll(flags);
        parsed.args.putAll(args);
        return parsed;
    }
}
