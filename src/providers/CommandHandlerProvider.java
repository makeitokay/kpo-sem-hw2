package providers;

import handlers.Handler;
import handlers.HelpCommandHandler;
import handlers.RandomStudentCommandHandler;
import handlers.StudentListCommandHandler;

public class CommandHandlerProvider {
    public static Handler Provide(CommandType commandType) {
        return switch (commandType) {
            case GetRandomStudent -> new RandomStudentCommandHandler();
            case GetStudentList -> new StudentListCommandHandler();
            case Help -> new HelpCommandHandler();
            case Quit, Unknown -> throw new IllegalArgumentException();
        };
    }
}
