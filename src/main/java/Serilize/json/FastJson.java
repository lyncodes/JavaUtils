package Serilize.json;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * author lyn
 * create_date_time 2019/12/23 9:12
 */
public class FastJson {
    public static void main(String[] args) {
        Person p = new Person("name", 18);

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Build> builds = new ArrayList<Build>();


        for (int i = 0; i < 10; i++) {
            Student p1 = new Student("name" + i, i, "id" + i);
            Build b1 = new Build("build", "year" + i);
            students.add(p1);
            builds.add(b1);
        }

        School s = new School(students, builds);

        System.out.println(JSON.toJSONString(s));
    }


}

@Getter
@Setter
@NoArgsConstructor
class Person {
    public String name;
    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}


@Getter
@Setter
@NoArgsConstructor
class Student extends Person {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    public Student(String name, Integer age, String id) {
        super(name, age);
        this.id = id;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Build {
    public String name;
    public String establish;
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class School {
    public ArrayList<Student> students;
    public ArrayList<Build> builds;
}

