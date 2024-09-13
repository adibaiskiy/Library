package lesson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> numberList = new ArrayList<>(50);
//        for (int i = 0; i < 50; i++) {
//            numberList.add(new Random().nextInt(1,100));
//        }
//
//        System.out.println(numberList);
//
//        List<Integer> evenNumber = new ArrayList<>();
//        List<Integer> oddNumber = new ArrayList<>();
//
//        Iterator<Integer> iterator = numberList.iterator();
//        while (iterator.hasNext()){
//           Integer element = iterator.next();
//        if (element % 2 == 0){
//            evenNumber.add(element);
//        }else{
//            oddNumber.add(element);
//        }
//        }
//        System.out.println(evenNumber);
//        System.out.println(oddNumber);


        //Student деген класс тузунуз (свойства: name, age, group).
//ArrayList тузуп аны 10 студент менен толтурунуз.
//1) Бардык студенттердин маалыматтарын консолго чыгарыныз.
//2) Ошол ArrayList ти группасы боюнча фильтрация кылып 2 жаны листке
//салыныз(Java,JavaScript)
//3) Жашы 19 дан 23 ко чейинки студенттерди жаны листке салыныз.
//        4) Аты "А"тамгасынан башталган студенттерди жаны листке салыныз
//Ар бир иш аракет учун озунчо метод тузуп, ал методдорду main класска чакырып иштетиниз.
//Маанилер main класстан берилуусу керек.

        System.out.println(getAll());
        System.out.println("students in Java");
        System.out.println(findStudentsByGroup("Java"));
        System.out.println("students in age 18-21");
        System.out.println(findByBetween(18, 21));
        System.out.println("students in enter start symbol");
        System.out.println(findStudentsByStartSymbol('n'));
    }

    public static List<Student> findStudentsByStartSymbol(char symbol){
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : getAll()) {
            if (student.getName().toUpperCase().startsWith(String.valueOf(symbol).toUpperCase())){
                students.add(student);
            }
        }return students;
    }

    public static List<Student> findByBetween(int fromAge, int toAge){
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : getAll()) {
            if (student.getAge() >= fromAge && student.getAge() <= toAge){
                students.add(student);
            }
        }
        return students;
    }
    public static List<Student> findStudentsByGroup(String group){
        List<Student> studentsByGroup = new ArrayList<>();
        for (Student student : getAll()) {
            if (group.equalsIgnoreCase(student.getGroup())){
                studentsByGroup.add(student);
            }
        }
        return studentsByGroup;
    }

public static List<Student> getAll(){
        return List.of(new Student("Adilet", 19,"Java"),
                new Student("Atay", 19,"Java"),
                new Student("Baisalbek", 19,"JavaScript"),
                new Student("Askat bayke", 35,"JavaScript"),
                new Student("Babakhan", 30,"Java"),
                new Student("Asylbek", 25,"Java"),
                new Student("Nuradil", 27,"Java"),
                new Student("Nurdin", 26,"JavaScript"),
                new Student("Belek", 15,"Java"),
                new Student("Bektur", 22,"JavaScript"),
                new Student("Azamat", 49,"Java")
        );
}















































}