package myboss;

/**
 * A Parser that provides parsing methods.
 */
public class Parser {

    /**
     * Returns a string array that contains the first word of userCmd and the remaining string
     * as the first and second index of the array respectively.
     *
     * @param userCmd user command.
     * @return first word and remaining string split.
     */
    public static String[] splitUserCmd(String userCmd) {
        return userCmd.split(" ", 2);
    }

    public static String getUserCmd(String[] userCmdSplit) {
        return userCmdSplit[0];
    }

    /**
     * Returns the task index of the task number specified by the userCmd.
     *
     * @param userCmd user command.
     * @return index of task.
     */
    public static int getTaskIndex(String[] userCmd) throws MyBossException {
        assert userCmd[1] != null : "There should be a second argument in the command";
        String remainingUserInput = userCmd[1];
        String secondArgument = remainingUserInput.split(" ")[0];
        try {
            return Integer.parseInt(secondArgument) - 1;
        } catch (NumberFormatException e) {
            throw new MyBossException("Second argument for priority command is invalid!");
        }
    }

    /**
     * Returns the remaining string from a split user command.
     *
     * @param userCmd split user command.
     * @return remaining string from split user command.
     */
    public static String getRemainingUserCmd(String[] userCmd) {
        if (userCmd.length <= 1) {
            return "";
        }
        return userCmd[1];
    }

    /**
     * Returns the parsed input of a deadline command by removing /by and separating the remaining string
     * into the task name and deadline.
     *
     * @param userCmd user command.
     * @return parsed input of a deadline command.
     */
    public static String[] parseDeadlineUserCmd(String userCmd) {
        String taskName = userCmd.substring(0, userCmd.indexOf("/by") - 1);
        String timeBy = userCmd.substring(userCmd.indexOf("/by") + 4);
        return new String[] {taskName, timeBy};
    }

    /**
     * Returns the parsed input of an event command by removing /at and separating the remaining string
     * into the task name and time range.
     *
     * @param userCmd user command.
     * @return parsed input of an event command.
     */
    public static String[] parseEventUserCmd(String userCmd) {
        String taskName = userCmd.substring(0, userCmd.indexOf("/at") - 1);
        String timeRange = userCmd.substring(userCmd.indexOf("/at") + 4);
        return new String[] {taskName, timeRange};
    }

    public static String getPriorityLevel(String remainingUserCmd) {
        return remainingUserCmd.split(" ")[1];
    }
}
