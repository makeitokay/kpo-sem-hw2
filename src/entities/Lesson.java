package entities;

import java.util.Date;

public class Lesson {
    private Date Date;
    private final int PairNumber;
    private final String SubjectName;

    public Lesson(String subjectName, int pairNumber) {
        PairNumber = pairNumber;
        SubjectName = subjectName;
    }

    public int getPairNumber() {
        return PairNumber;
    }

    public String getSubjectName() {
        return SubjectName;
    }
}
