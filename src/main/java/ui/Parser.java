package ui;

import exception.CommandInputException;
import exception.JobSelectException;
import exception.NameInputException;

public class Parser {
    private static final String NAME = "^[a-zA-Z ]{1,15}$";
    private static final int NAME_LENGTH_LIMIT = 15;

    public static String parseName(String input) throws NameInputException {
        if (input.matches(NAME)) {
            return input;
        }
        if (input.length() <= NAME_LENGTH_LIMIT) {
            throw new NameInputException("please enter a valid name, try again!\n");
        }
        throw new NameInputException(
                "Oops! Your name is too long! Please enter a name with less than 15 characters.\n");
    }

    public static String parseCareer(String input) throws JobSelectException {
        switch (input.toLowerCase().trim()) {
        case "/r":
            ResponseManager.echoChosenIndustry("Robotics");
            return "Robotics";

        case "/s":
            ResponseManager.echoChosenIndustry("Semi-conductor");
            return "Semi-conductor";

        case "/a":
            ResponseManager.echoChosenIndustry("Artificial Intelligence");
            return "Artificial intelligence";

        default:
            throw new JobSelectException("Please enter a valid job type, try again!\n");
        }
    }

    public static CommandType parseCommand(String input) throws CommandInputException {
        return CommandType.analyseInput(input.trim().toLowerCase());
    }

    public static String[] separateCommand(String input) {
        return input.split("\\s", 2);
    }

    public static int decodeInfo(String input) throws CommandInputException {
        try {
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            throw new CommandInputException("Invalid number, please try again\n");
        }
    }

    public static boolean isAccept(String response) throws CommandInputException {
        String yesRegex = "(?i)(y|yes)";
        String noRegex = "(?i)(n|no)";
        if (response.matches(yesRegex)) {
            return true;
        } else if (response.matches(noRegex)) {
            return false;
        } else {
            throw new CommandInputException("Invalid input. Please try again.");
        }
    }

}
