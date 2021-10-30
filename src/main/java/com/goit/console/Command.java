package com.goit.console;

import java.text.ParseException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Command {

    Pattern pattern = Pattern.compile("^\\w+");

    void handle(String params, Consumer<Command> setActive) throws ParseException;
    void printActiveMenu();
    default Optional<String> getCommandString(String params) {
        Matcher matcher = pattern.matcher(params);
        if (matcher.find()) {
            return Optional.of(matcher.group());
        }
        else {
            return Optional.empty();
        }
    }
}