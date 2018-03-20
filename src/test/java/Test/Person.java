package Test;

public class Person {
    private String id;
    private String name;
    private String age;
    private House house;
    public Person(String s, String aa, String s1) {
        this.id = s;
        this.name = aa;
        this.age = s1;
    }
    public Person(String s, String aa, String s1,House house) {
        this.id = s;
        this.name = aa;
        this.age = s1;
        this.house = house;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
