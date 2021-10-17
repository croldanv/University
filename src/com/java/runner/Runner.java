package com.java.runner;

import cam.java.data.*;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        University yale = new University();
        yale.setCreateTeacher(new FullTimeTeacher("Albert", 1000F, 5));
        yale.setCreateTeacher(new FullTimeTeacher("Andrew", 1650F, 8));
        yale.setCreateTeacher(new FullTimeTeacher("Camilo", 1200F, 6));
        yale.setCreateTeacher(new PartTimeTeacher("Gilbert", 1850F, 7));
        yale.setCreateTeacher(new PartTimeTeacher("Anna", 1900F, 8));
        yale.setCreateTeacher(new PartTimeTeacher("Briar", 2000F, 10));

        yale.setCreateStudent(new Student("Bryan", 27));
        yale.setCreateStudent(new Student("Sophia", 24));
        yale.setCreateStudent(new Student("Elizabeth", 24));
        yale.setCreateStudent(new Student("Camilo", 21));
        yale.setCreateStudent(new Student("Benjamin", 25));
        yale.setCreateStudent(new Student("Benedict", 23));

        yale.setCreateLecture(new Lecture("Econometrics", yale.getTeacherList().get(0), 201));
        yale.setCreateLecture(new Lecture("Geopolitics", yale.getTeacherList().get(1), 203));
        yale.setCreateLecture(new Lecture("Law", yale.getTeacherList().get(2), 206));
        yale.setCreateLecture(new Lecture("Accountability", yale.getTeacherList().get(3), 209));

        yale.addStudentToLecture(1, 1);
        yale.addStudentToLecture(2, 2);
        yale.addStudentToLecture(3, 3);
        yale.addStudentToLecture(4, 4);
        yale.addStudentToLecture(4, 3);
        yale.addStudentToLecture(3, 1);

        boolean isMenuActive = true;

        while(isMenuActive){
            System.out.println("Choose one of the options: \n" +
                    "1. Check students info. \n" +
                    "2. Add students to the system \n" +
                    "3. Check Lectures info. \n" +
                    "4. Add Lectures to the system. \n" +
                    "5. Check teachers info \n" +
                    "6. Add teachers to the system \n" +
                    "0. Exit");

            Scanner scanner = new Scanner(System.in);
            int menuOption = scanner.nextInt();

            switch (menuOption){
                case 1:
                    boolean isStudentMenuActive = true;
                    while(isStudentMenuActive){
                        System.out.println("Please insert student ID to check info.");
                        System.out.println("Select 0 to exit");
                        for (Student i: yale.getStudentList()){
                            System.out.println(i.getId()+ "- " + i.getName());
                        }
                        Scanner scanner4 = new Scanner(System.in);
                        int studentId = scanner4.nextInt();
                        if (studentId > 0 && studentId <= yale.getStudentList().size()){
                            System.out.println(yale.getStudentList().get(studentId-1).toString());
                            System.out.println("Registered in the following lectures:\n" +
                            "----------------------------");
                            for (Lecture i: yale.getLectureList()) {
                                for (Student j: i.getStudentList()) {
                                    if(studentId == j.getId()){
                                        System.out.println(i.toString());
                                    }
                                }
                            }
                        } else if(studentId == 0){
                            isStudentMenuActive = false;
                        } else{
                            System.out.println("Please insert a valid option");
                        }
                    }

                    break;
                case 2:
                    Scanner subMenuScanner0 = new Scanner(System.in);
                    System.out.println("Please insert student name");
                    String studentName = subMenuScanner0.nextLine();
                    System.out.println("Please insert student age");
                    int studentAge = subMenuScanner0.nextInt();
                    yale.setCreateStudent(new Student(studentName, studentAge));
                    break;
                case 3:
                    boolean subMenu1 = true;
                    while(subMenu1){
                        System.out.println("Select the lecture:");
                        for (int i=1; i <= yale.getLectureList().size(); i++){
                            System.out.println(i + "." + yale.getLectureList().get(i-1).getName());
                        }
                        System.out.println("0. return");

                        Scanner subMenuScanner = new Scanner(System.in);
                        int subMenuOption2 = subMenuScanner.nextInt();
                        if(subMenuOption2 > 0 && subMenuOption2 <= yale.getLectureList().size()){
                            yale.getLectureList().get(subMenuOption2-1).toString();
                            for(Student i: yale.getLectureList().get(subMenuOption2-1).getStudentList()) {
                                System.out.println(i.toString());
                            }
                        } else if(subMenuOption2 == 0){
                                subMenu1 = false;
                            } else{
                            System.out.println("please type a valid option");
                            }
                    }
                    break;
                case 4:
                    boolean subMenu3 = true;
                    while(subMenu3){
                        Scanner subMenuScanner2 = new Scanner(System.in);
                        System.out.println("Select an option: \n" +
                                "1. Create lecture \n" +
                                "2. Add student \n" +
                                "0. Return");
                        int subMenuOption2 = subMenuScanner2.nextInt();

                        switch (subMenuOption2){
                            case 1:
                                Scanner subMenu2 = new Scanner(System.in);
                                System.out.println("Insert name of the new lecture");
                                String lectureName = subMenu2.nextLine();
                                System.out.println("Insert ID of teacher to add");
                                int teacherId = subMenu2.nextInt();
                                System.out.println("Insert classroom of the lecture");
                                int classRoom = subMenu2.nextInt();
                                if(teacherId > 0 && teacherId <= yale.getTeacherList().size()){
                                    yale.setCreateLecture(new Lecture(
                                            lectureName,
                                            yale.getTeacherList().get(teacherId-1),
                                            classRoom));
                                } else {
                                    System.out.println("error: please insert a teacher sequential ID");
                            }

                                break;
                            case 2:
                                Scanner subMenu4 = new Scanner(System.in);
                                System.out.println("Insert ID of the student");
                                int studentId = subMenu4.nextInt();
                                System.out.println("Insert ID of the lecture where the student will be added");
                                int lectureId = subMenu4.nextInt();
                                if(studentId > 0 && lectureId > 0 && studentId <= yale.getStudentList().size() && lectureId <= yale.getLectureList().size()){
                                    yale.addStudentToLecture(lectureId, studentId);
                                    System.out.println("Student successfully added");
                                } else {
                                    System.out.println("Type a valid option");
                                }
                                break;
                            case 0:
                                subMenu3 = false;
                                break;
                            default:
                                System.out.println("Invalid Option");
                                break;
                        }

                    }

                    break;
                case 5:
                    for(Teacher i: yale.getTeacherList()){
                        System.out.println(i.toString());
                    }
                    break;
                case 6:
                    boolean subMenu = true;
                    while(subMenu){
                        System.out.println("Select teacher contract: \n" +
                                "1. Part Time \n" +
                                "2. Full Time \n" +
                                "0. Back to main menu");
                        Scanner subMenuScanner = new Scanner(System.in);
                        int subMenuOption1 = subMenuScanner.nextInt();
                        switch (subMenuOption1){

                            case 1:
                                Scanner subMenuScanner1 = new Scanner(System.in);
                                System.out.println("Insert name of the teacher");
                                String namePt = subMenuScanner1.nextLine();
                                System.out.println("Insert base salary: ");
                                float baseSalaryPt = subMenuScanner1.nextFloat();
                                System.out.println("Insert years of experience");
                                int yearsOfExperiencePt = subMenuScanner1.nextInt();
                                yale.setCreateTeacher(new FullTimeTeacher(namePt, baseSalaryPt, yearsOfExperiencePt));

                                System.out.println("Entry registered");

                                break;
                            case 2:
                                Scanner subMenuScanner2 = new Scanner(System.in);
                                System.out.println("Insert name of the teacher");
                                String nameFt = subMenuScanner2.nextLine();
                                System.out.println("Insert base salary: ");
                                float baseSalaryFt = subMenuScanner2.nextFloat();
                                System.out.println("Insert hours per week");
                                float yearsOfExperienceFt = subMenuScanner2.nextFloat();
                                yale.setCreateTeacher(new PartTimeTeacher(nameFt, baseSalaryFt, yearsOfExperienceFt));

                                System.out.println("Entry registered");

                                break;
                            case 0:
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Please insert a valid option");
                                break;

                        }
                    }
                    break;
                case 0:
                    System.out.println("Goodbye :) \n" +
                            "------------------------");
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("option not valid");
                    break;
            }
        }

    }
}
