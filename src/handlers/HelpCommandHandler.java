package handlers;

import entities.Lesson;
import entities.Student;

import java.util.Collection;

public class HelpCommandHandler implements Handler {
    @Override
    public void Handle(Lesson lesson, Collection<Student> students) {
        System.out.println("Commands:\n/r - random student;\n/p - student list;\n/q - quit");
    }
}
