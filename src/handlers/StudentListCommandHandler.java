package handlers;

import entities.AttendanceType;
import entities.Lesson;
import entities.Mark;
import entities.Student;

import java.util.Collection;

public class StudentListCommandHandler implements Handler {
    @Override
    public void Handle(Lesson lesson, Collection<Student> students) {
        System.out.printf("Пара №%s по %s%n", lesson.getPairNumber(), lesson.getSubjectName());
        for (var student : students) {
            System.out.printf("%s: ", student.getName());
            var marks = student.getMarksByLesson(lesson);
            if (marks.size() == 0) {
                System.out.println("-");
                continue;
            }
            if (marks.stream().anyMatch(mark -> mark.getAttendance() == AttendanceType.Skipped)) {
                System.out.println("ПРОГУЛЬЩИК!");
                continue;
            }
            System.out.println(marks.stream().mapToDouble(Mark::getScore).average().getAsDouble());
        }
    }
}
