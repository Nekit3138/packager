package ru.packager.exceptions;

public class InvalidSyntax extends Throwable {
    public InvalidSyntax() {
    }

    public InvalidSyntax(String message) {
        super(message);
    }
}
