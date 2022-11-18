package handlers;

import entities.AttendanceType;
import entities.Lesson;
import entities.Student;
import helpers.InputHelper;
import helpers.YesNoAnswer;

import java.util.Collection;
import java.util.Random;

public class RandomStudentCommandHandler implements Handler {
    @Override
    public void Handle(Lesson lesson, Collection<Student> students) {
        var random = new Random();
        var studentArray = students.toArray(new Student[0]);
        Student student;
        var skippedStudentsCount = students.stream()
                .filter(st -> st.getMarksByLesson(lesson).stream().anyMatch(mark -> mark.getAttendance() != AttendanceType.Attended))
                .count();
        while (true) {
            if (skippedStudentsCount == studentArray.length) {
                System.out.println("К сожалению, никого нет на паре.");
                return;
            }
            student = studentArray[random.nextInt(studentArray.length)];
            var marks = student.getMarksByLesson(lesson);
            if (marks.stream().noneMatch(mark -> mark.getAttendance() != AttendanceType.Attended)) {
                break;
            }
        }
        System.out.printf("Отвечает %s%n", student.getName());
        System.out.println("Присутствует ли на паре (y/n)?");
        var attendanceAnswer = InputHelper.GetYesNoFromInput();
        if (attendanceAnswer == YesNoAnswer.Yes) {
            System.out.println("Оценка (от 1 до 10): ");
            var mark = InputHelper.GetNumberFromInput(1, 10);
            student.addMark(lesson, AttendanceType.Attended, mark);
        }
        else {
            student.addMark(lesson, AttendanceType.Skipped, 0);
        }
    }
}
