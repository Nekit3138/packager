package ru.packager;

import ru.packager.exceptions.ArgumentNotFound;
import ru.packager.exceptions.InvalidSyntax;
import ru.packager.models.Argument;
import ru.packager.abs.ArgumentsConfigurable;
import ru.packager.abs.Command;
import ru.packager.abs.CommandsConfigurable;
import ru.packager.models.ParsedArguments;
import ru.packager.utils.ArgumentsParser;

import java.util.*;
import java.util.regex.Pattern;

public final class Packager {
    private List<Argument> arguments = new ArrayList<>();
    private Map<String, Class<? extends Command>> commands = new HashMap<>();

    public Packager(ArgumentsConfigurable arguments, CommandsConfigurable commands) {
        arguments.configure(this.arguments);
        commands.configure(this.commands);
    }

    public Packager(CommandsConfigurable commands) {
        commands.configure(this.commands);
    }


    public void run(String[] args) throws Exception {
        if (args.length == 0) {
            Class<? extends Command> help = commands.get("help");
            if (help != null) {
                help.newInstance().execute();
            } else {
                System.out.println("Help page is not specified");
            }
        } else {
            try {
                ParsedArguments parsed = ArgumentsParser.parse(arguments, args);
                if (parsed.command == null) {
                    System.out.println("Command not specified");
                }
                else if (!Arrays.stream(args).allMatch(i -> Pattern.matches("([a-z]|[-])+", i))) {
                    System.out.println("Invalid syntax");
                } else if (!commands.containsKey(parsed.command)) {
                    System.out.println("Command not found");
                } else {
                    commands.get(parsed.command)
                            .newInstance()
                            .execute(parsed.clone());
                }
            } catch (InvalidSyntax e) {
                System.out.println("Invalid syntax: " + e.getMessage());
            } catch (ArgumentNotFound e) {
                System.out.println("Argument not found: " + e.getMessage());
            }
        }
    }
}
