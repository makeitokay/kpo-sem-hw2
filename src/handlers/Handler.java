package handlers;

import entities.Lesson;
import entities.Student;

import java.util.Collection;

public interface Handler {
    void Handle(Lesson lesson, Collection<Student> students);
}
