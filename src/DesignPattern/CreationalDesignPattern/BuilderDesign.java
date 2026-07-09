package DesignPattern.CreationalDesignPattern;


//1.main aim to create object of Student class with optional fields
//2.Student constructor is private so that it can't be manipulate / or someone can't create from outside
/*3.static StudentBuilder class has no existence alone. Its being use to create object of Student parent class
 Static makes "it belongs to student class"*/
/* 4.If StudentBuilder is NOT nested inside Student:
Student build() {
    return new Student(this); // ❌ compile error: Student() has private access
}*/
//5.build method will create final object

class Student{
    private String name;  //mandatory
    //optional
    private int rollno;
    private String address;
    private String email;

    private Student(StudentBuilder builder){
        this.name=builder.name;
        this.rollno=builder.rollno;
        this.address=builder.address;
        this.email=builder.email;
    }

static class StudentBuilder{
    private String name;  //mandatory
    //optional
    private int rollno;
    private String address;
    private String email;

    public StudentBuilder(String name){
        this.name=name;
    }

    public StudentBuilder setRollno(int rollno) {
        this.rollno = rollno;
         return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    Student build() {
        return new Student(this);
    }

}

}

public class BuilderDesign {
    static void main() {
        Student studentObj = new Student.StudentBuilder("Virendra").setAddress("iris block").setEmail("a@gmail.com").build();
        System.out.println(studentObj);
    }
}


