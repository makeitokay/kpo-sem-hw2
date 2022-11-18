import entities.Student;

import java.util.*;

public class StudentGenerator {
    private static final List<String> NAMES = Arrays.asList(
            "Аввакум",
            "Агриппин",
            "Акакий",
            "Бронислав",
            "Гвидон",
            "Нектарий"
    );

    private static final List<String> SURNAMES = Arrays.asList(
            "Сосиска",
            "Сухозад",
            "Карась",
            "Лютый",
            "Фундамент"
    );

    public static Collection<Student> GetRandomStudents() {
        var random = new Random();
        var result = new ArrayList<Student>();
        var count = random.nextInt(1, 40);
        for (int i = 0; i < count; ++i) {
            var name = NAMES.get(random.nextInt(NAMES.size()));
            var surname = SURNAMES.get(random.nextInt(SURNAMES.size()));
            result.add(new Student(name + " " + surname));
        }
        return result;
    }
}
