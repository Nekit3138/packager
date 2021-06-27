package ru.packager.exceptions;

public class ArgumentNotFound extends Throwable {
    public ArgumentNotFound() {
    }

    public ArgumentNotFound(String message) {
        super(message);
    }
}
