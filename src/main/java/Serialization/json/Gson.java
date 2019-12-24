package Serialization.json;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * author lyn
 * create_date_time 2019/12/24 22:55
 */
public class Gson {
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
        System.out.println("using gson");
        com.google.gson.Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(s));
    }

}
