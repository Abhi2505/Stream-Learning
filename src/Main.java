import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // In stream we have to type of operations
    //Intermediate and terminal operation
    //Intermediate : map(), filter(), distinct(), sorted(), limit(), skip()
    //Terminal : forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Student s1=new Student(1,"abhi","Mechanical",234,"Male" ,21,Arrays.asList("9340345","21213312332"));
        Student s2=new Student(2,"ravi","Computer", 43,"Female",15,Arrays.asList("329340345","21213312423"));
        Student s3=new Student(3,"kavi","Computer", 10,"Male",34,Arrays.asList("9332340345","21213311223"));
        Student s4=new Student(4,"raki","Electrical", 521,"Male",64,Arrays.asList("9424340345","2121323123"));
        Student s5=new Student(5,"ajobhi","Electrical", 1,"Female",43,Arrays.asList("934242q40345","2132133123"));
        Student s6=new Student(6,"haihi","Mechanical",32, "Male",22,Arrays.asList("9323140345","2123133123"));
        Student s7=new Student(7,"rpmi","Mechanical", 545,"Female", 32,Arrays.asList("93403232345","2312133123"));
        Student s8=new Student(8,"rwmi","Electrical", 53,"Female",21, Arrays.asList("3493403232345","2312133123"));
        Student s9=new Student(9,"wapmi","Electrical", 353,"Male",22,Arrays.asList("341293403232345","2312133123"));
        List<Student>l=new ArrayList<Student>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        l.add(s6);
        l.add(s7);
        l.add(s8);
        l.add(s9);
        //1) find the list of student who have the rank in between 10 to 200
        List<Student>withRankFilter=l.stream().filter((s)->s.getRank()>10 && s.getRank()<200).collect(Collectors.toList());
        System.out.println(withRankFilter);
        //2) find the list of student working in cs department in sort order of theri name
        List<Student>list=l.stream().filter((s)->s.getDept().equals("Computer")).sorted((a1,a2)->a1.getName().compareTo(a2.getName())).collect(Collectors.toList());
        System.out.println(list);
        //3) find all the department names
        List<String>departments=l.stream().map((s)->s.getDept()).distinct().collect(Collectors.toList());
        System.out.println(departments);
        //4) find all contactnumbers
        List<String>contact=l.stream().flatMap((s)->s.getContact().stream()).collect(Collectors.toList());
        System.out.println(contact);
        //5) group the students by the department name
        Map<String,List<Student>>std=l.stream().collect(Collectors.groupingBy((s)->s.getDept()));
        System.out.println(std);
        //6) if we the count of students along with the departmenat name
        Map<String,Long>stdnt=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.counting()));
        System.out.println(stdnt);
        //7) the max student present in which department
        Map.Entry<String,Long>e=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(e);
        //8) find the average age of mail and femail
        Map<String,Double>avg=l.stream().collect(Collectors.groupingBy((stt)->stt.getGender(),Collectors.averagingInt((ss)->ss.getAge())));
        System.out.println(avg);
        //9) find the highest rank(min value) in each department
        Map<String,Optional<Student>>info=l.stream().collect(Collectors.groupingBy((s)->s.getDept(),Collectors.minBy((e1,e2)->e1.getRank()-e2.getRank())));
        //Collectors.minBy(Comparator.comparing(Student::getRank());
        System.out.println(info);
        //10) find the student who has the second rank
        List<Student>secrank=l.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secrank);

    }
}