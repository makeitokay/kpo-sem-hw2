package helpers;

import entities.Lesson;
import entities.Student;
import providers.CommandType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class InputHelper {
    public static CommandType GetCommandFromInput() {
        var scanner = new Scanner(System.in);
        System.out.println("Input command: ");
        var input = scanner.nextLine();
        if (input.length() < 2 || !input.contains("/")) {
            return CommandType.Unknown;
        }
        return switch (input.split("/")[1]) {
            case "r" -> CommandType.GetRandomStudent;
            case "p" -> CommandType.GetStudentList;
            case "h" -> CommandType.Help;
            case "q" -> CommandType.Quit;
            default -> CommandType.Unknown;
        };
    }

    public static Lesson GetLessonFromInput() {
        var scanner = new Scanner(System.in);
        System.out.println("Input your subject name:");
        var subjectName = scanner.nextLine();
        System.out.println("Input your pair number (from 1 to 7): ");
        var pairNumber = GetNumberFromInput(1, 7);
        return new Lesson(subjectName, pairNumber);
    }

    public static Collection<Student> GetStudentsFromInput() {
        var students = new ArrayList<Student>();
        System.out.println("Input student count (from 1 to 40):");
        var studentCount = GetNumberFromInput(1, 40);
        for (int i = 0; i < studentCount; ++i) {
            var student = GetStudentFromInput(i + 1);
            students.add(student);
        }
        return students;
    }

    private static Student GetStudentFromInput(int studentNumber) {
        var scanner = new Scanner(System.in);
        System.out.printf("Input name of student #%s (your line must only contain name and surname separated by space): ", studentNumber);
        while (true) {
            var studentName = scanner.nextLine();
            var splitted = studentName.split(" ");
            if (splitted.length != 2) {
                System.out.println("Please, input name and surname separated by space!\nTry again: ");
                continue;
            }
            return new Student(studentName);
        }
    }

    public static YesNoAnswer GetYesNoFromInput() {
        var scanner = new Scanner(System.in);
        System.out.println("y/n: ");
        while (true) {
            var answer = scanner.nextLine();
            if (answer.equals("y")) {
                return YesNoAnswer.Yes;
            }
            else if (answer.equals("n")) {
                return YesNoAnswer.No;
            }
            else {
                System.out.println("Incorrect input, try again\ny/n: ");
            }
        }
    }

    public static int GetNumberFromInput(int minValue, int maxValue) {
        var scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Please, input only numbers");
                scanner.next();
                continue;
            }
            var number = scanner.nextInt();
            if (number < minValue || number > maxValue) {
                System.out.printf("Please, input number from %s to %s%n", minValue, maxValue);
                continue;
            }
            return number;
        }
    }
}
