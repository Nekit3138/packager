package ru.packager.abs;

import ru.packager.models.ParsedArguments;

public abstract class Command {
    public final void execute() {
        execute(null);
    }
    public abstract void execute(ParsedArguments parameters);
}
