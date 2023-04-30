package lab3_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Group {
    private String groupName;
    public HashMap<Integer, ArrayList<Integer>> marks = new HashMap<>();

    public Group(String groupName, int sizeOfGroup, int weeksAmount) {
        this.groupName = groupName;

        for (int i = 0; i < sizeOfGroup; i++) {
            marks.put(i + 1, new ArrayList<>(Collections.nCopies(weeksAmount, 0)));
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void addMark(String groupName, Integer student, Integer mark, boolean isLecturer, int week) {
        synchronized (marks.get(student).get(week)) {
            if (Objects.equals(marks.get(student).get(week), 0) || isLecturer) {
                marks.get(student).set(week, mark);
            } else {
                System.out.println(Thread.currentThread().getName() + " can't change " + student + " " + groupName + " mark");
            }
        }
    }
}