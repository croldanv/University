package cam.java.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List <Teacher> teacherList;
    private List <Student> studentList;
    private List <Lecture> lectureList;

    public University() {
        this.teacherList = new ArrayList<Teacher>();
        this.studentList = new ArrayList<Student>();
        this.lectureList = new ArrayList<Lecture>();
    }

    public void setCreateTeacher(Teacher teacher){
        this.teacherList.add(teacher);
    }

    public void setCreateStudent(Student student){
        this.studentList.add(student);
    }

    public void setCreateLecture(Lecture lecture){
        this.lectureList.add(lecture);
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public void addStudentToLecture(int lectureID, int studentID){
        this.lectureList.get(lectureID - 1).setAddStudent(this.studentList.get(studentID - 1));
    }
}
