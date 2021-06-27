package ru.packager.abs;

import ru.packager.models.Argument;

import java.util.List;

public interface ArgumentsConfigurable {
    void configure(List<Argument> arguments);
}
