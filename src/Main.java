import entities.Student;
import helpers.InputHelper;
import helpers.YesNoAnswer;
import providers.CommandHandlerProvider;
import providers.CommandType;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        var lesson = InputHelper.GetLessonFromInput();
        System.out.println("Random students? y - yes, random; n - no, I will input it myself");
        var randomStudentsAnswer = InputHelper.GetYesNoFromInput();
        Collection<Student> students;
        if (randomStudentsAnswer == YesNoAnswer.Yes) {
            students = StudentGenerator.GetRandomStudents();
        } else {
            students = InputHelper.GetStudentsFromInput();
        }
        while (true) {
            var command = InputHelper.GetCommandFromInput();
            if (command == CommandType.Quit) {
                break;
            }
            else if (command == CommandType.Unknown) {
                System.out.println("Unknown command, try again.");
                continue;
            }

            var handler = CommandHandlerProvider.Provide(command);
            handler.Handle(lesson, students);
        }
    }
}