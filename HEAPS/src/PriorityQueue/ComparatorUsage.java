package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorUsage {
    public static class Student{
        String name;
        int marks;
        int rollno;
        String dob;

    }
    private static class StudentComparator implements Comparator<Student> {
//        overriding
        public int compare(Student s1,Student s2){
            if(s1.marks> s2.marks){
                return 1;
            }else if(s1.marks<s2.marks){
                return -1;
            }else{
                if(s1.rollno> s2.rollno){
                    return-1;
                }else if(s1.rollno<s2.rollno){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> studentPriorityQueue=new PriorityQueue<>(new StudentComparator()); //min heap
        Student harsh=new Student();
        harsh.dob="12-12-2001";
        harsh.marks=99;
        harsh.name="Harsh";
        harsh.rollno=23;
        
        Student raghav=new Student();
        raghav.dob="03-06-2004";
        raghav.marks=97;
        raghav.name="raghav";
        raghav.rollno=14;

        studentPriorityQueue.add(harsh);
        studentPriorityQueue.add(raghav);
        System.out.println(studentPriorityQueue.remove().name);
        System.out.println(studentPriorityQueue.remove().marks);
    }
}
