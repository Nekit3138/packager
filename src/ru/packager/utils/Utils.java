package ru.packager.utils;

import ru.packager.exceptions.ArgumentNotFound;
import ru.packager.models.Argument;

import java.util.List;

public class Utils {
    public static boolean isAnyKey(String key) {
        return key.length() > 1 && key.startsWith("-");
    }

    public static boolean isLongKey(String key) {
        return key.length() > 2 && key.startsWith("--");
    }

    public static boolean isShortKey(String key) {
        return key.length() > 1 && key.charAt(0) == '-' && key.charAt(1) != '-';
    }

    public static Argument getByKey(List<Argument> argument, String key) throws ArgumentNotFound {
        for (int i = 0; i < argument.size(); i++)
            if (argument.get(i).key.equals(key.substring(2)))
                return argument.get(i);
        throw new ArgumentNotFound(key);
    }

    public static Argument getByShortKey(List<Argument> argument, String key) throws ArgumentNotFound {
        for (int i = 0; i < argument.size(); i++)
            if (argument.get(i).shortKey.equals(key.substring(1)))
                return argument.get(i);
        throw new ArgumentNotFound(key);
    }
}
