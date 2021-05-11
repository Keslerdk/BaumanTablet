package com.example.baumantablet;

public class TabletModel {
    String subjectName;
    String lessonNum;
    String time;

    public TabletModel(String subjectName, String lessonNum) {
        this.subjectName = subjectName;
        this.lessonNum = lessonNum;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getLessonNum() {
        return lessonNum;
    }
}
