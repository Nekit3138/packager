package ru.packager.utils;

import ru.packager.exceptions.ArgumentNotFound;
import ru.packager.exceptions.InvalidSyntax;
import ru.packager.models.Argument;
import ru.packager.models.ParsedArgument;
import ru.packager.models.ParsedArguments;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsParser {
    public static ParsedArguments parse(List<Argument> arguments, String[] args) throws ArgumentNotFound, InvalidSyntax {
        List<ParsedArgument> result = new ArrayList<>();
        String command = null;

        for (int i = 0; i < args.length; i++) {
            if (Utils.isAnyKey(args[i])) {
                Argument argument;
                if (Utils.isShortKey(args[i])) {
                    argument = Utils.getByShortKey(arguments, args[i]);
                } else {
                    argument = Utils.getByKey(arguments, args[i]);
                }

                result.add(new ParsedArgument(argument.key, null, argument.hasBody));
            } else {
                if (command == null) {
                    command = args[i];
                } else if (!result.isEmpty() && result.get(result.size() - 1).hasValue) {
                    result.get(result.size() - 1).value = args[i];
                } else {
                    throw new InvalidSyntax("Cannot parse");
                }
            }
        }

        ParsedArguments parsedArguments = new ParsedArguments();
        parsedArguments.command = command;

        for (ParsedArgument parsedArgument : result) {
            if (parsedArgument.hasValue) {
                String val = parsedArgument.value;
                if (val == null) throw new InvalidSyntax("Value for --" + parsedArgument.key + " not specified");
                parsedArguments.args.put(parsedArgument.key, parsedArgument.value);
            } else {
                parsedArguments.flags.add(parsedArgument.key);
            }
        }

        return parsedArguments;
    }
}
