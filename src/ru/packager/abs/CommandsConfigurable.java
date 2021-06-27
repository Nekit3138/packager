package ru.packager.abs;

import java.util.Map;

public interface CommandsConfigurable {
    void configure(Map<String, Class<? extends Command>> commands);
}
