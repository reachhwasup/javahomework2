package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    String major;
    double score;

    Student() {
    }

    public Student(int id, String name, String gender, String major, double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.score = score;
    }

    public void input(Scanner input) {
        boolean ValidId = false;
        do {
            String StrID;
            System.out.println("Enter student id: ");
            try {
                input.nextLine();
                StrID = input.nextLine();
                id = Integer.parseInt(StrID);
                ValidId = true;
            } catch (Exception e) {
                System.out.println("Invalid ID (Integer only!!!!)");
            }
        }while (!ValidId) ;

            System.out.println("Enter student name: ");
            name = input.nextLine();
            System.out.println("Enter student gender: ");
            gender = input.nextLine();
            System.out.println("Enter student major: ");
            major = input.nextLine();
            boolean isValidScore = false;
            String strScore;
            do {
                System.out.println("Enter student score: ");
                try{
                    strScore=input.nextLine();
                    score = Integer.parseInt(strScore);
                    isValidScore=true;

                }catch(Exception e){
                    System.out.println("Invalid score(Integer only!!!!)");
                }

            }while(!isValidScore);
    }
    public String toString() {
        return  id + "\t\t\t\t" + name + "\t\t\t\t" + gender +"\t\t\t\t " + major+ "\t\t\t\t" + score ;
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option;
        do{
            System.out.println("1.Add new student");
            System.out.println("2.Show all student");
            System.out.println("3.Search student");
            System.out.println("4.Delete student");
            System.out.println("5.Update student");
            System.out.println("6.Exit program");
            System.out.print(">>>>> Enter your option: ");
            option = input.nextInt();

            switch(option){
                case 1 :
                    System.out.println("-------------------Add new student--------------------");
                    Student newStudent = new Student();
                    newStudent.input(input);
                    array.add(newStudent);
                    System.out.println("Add successfully!!!!");
                    break;
                case 2:
                    System.out.println("-------------------Show all students--------------------");
                    Iterator<Student> i = array.iterator();
                    while(i.hasNext()){
                    Student student1 = i.next();
                    System.out.println(student1);
                    }
                    System.out.println("------------------------------------------------------------------------");
                    break;
                    case 3:
                        int id=0;
                        boolean isValidId = false;
                        boolean found = false;
                        String strID;
                    do{
                        System.out.println("-------------------Search student--------------------");
                        input.nextLine();
                        try {
                            System.out.println("Enter student id : ");
                            strID = input.nextLine();
                            isValidId = true;
                            id = Integer.parseInt(strID);
                        }catch (Exception e){
                            System.out.println("Invalid ID (Integer only!!!!)");
                        }
                    }while(!isValidId);
                        i = array.iterator();
                        while (i.hasNext()) {
                            Student student1 = i.next();
                            if (student1.id == id) {
                                System.out.println(student1);
                                found = true;
                                System.out.println("------------------------------------------------------------------------");
                            }
                        }
                    if(!found){
                        System.out.println("ID not found!!!!");
                    }

                    break;
                case 4:
                    id=0;
                    isValidId = false;
                    boolean remove=false;
                    String deleteId;
                    do{
                        System.out.println("-------------------Delete Student--------------------");
                        input.nextLine();

                        try {
                            System.out.println("Enter student id to delete : ");
                            deleteId = input.nextLine();
                            isValidId = true;
                            id = Integer.parseInt(deleteId);
                        }catch (Exception e){
                            System.out.println("Invalid ID (Integer only!!!!)");
                        }
                    }while(!isValidId);
                    i = array.iterator();
                    while (i.hasNext()) {
                        Student student1 = i.next();
                        if (student1.id == id) {
                            i.remove();

                            remove = true;
                        }
                    }
                    if(!remove){
                        System.out.println("ID not found can't be delete!!!!");
                    }else {
                        System.out.println("delete successfully!!!!!");
                        System.out.println("------------------------------------------------------------------------");
                    }

                    break;
                case 5:
                    System.out.println("-------------------------------------------------------------");
                    id=0;
                    isValidId = false;
                    found = false;

                    do{
                        System.out.println("-------------------Update new student--------------------");
                        input.nextLine();
                        try {
                            System.out.println("Enter student id : ");
                            strID = input.nextLine();
                            isValidId = true;
                            id = Integer.parseInt(strID);

                        }catch (Exception e){
                            System.out.println("Invalid ID (Integer only!!!!)");
                        }
                    }while(!isValidId);
                    i = array.iterator();
                    while (i.hasNext()){
                        Student student1 = i.next();
                        if(student1.id==id) {
                            found = true;
                            System.out.println("Enter new student name : ");
                            student1.name = input.nextLine();
                            System.out.println("Enter new student gender : ");
                            student1.gender = input.nextLine();
                            System.out.println("Enter new student major : ");
                            student1.major = input.nextLine();
                            boolean isValidScore = false;
                            do {
                                System.out.println("Enter new student score : ");
                                String strScore;
                                try {
                                    strScore = input.nextLine();
                                    student1.score = Integer.parseInt(strScore);
                                    isValidScore=true;
                                } catch (Exception e) {
                                    System.out.println("Invalid ID (Integer only!!!!)");
                                }
                            }while(!isValidScore);
                            System.out.println("Updating successfully!!!!");
                        }

                    }

                    if(!found){
                        System.out.println("ID not found!!!!");
                    }
                    break;
                default:
                    System.out.println("You enter the wrong option!!!!");
                    System.out.println("------------------------------------------------------------------------");
            }
        }while(option!=6);

    }
}



