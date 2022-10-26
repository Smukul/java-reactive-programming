package practice.helper;

import lombok.Data;
import lombok.ToString;
import practice.Util;

@Data
@ToString
public class Person {
    private String name;
    private Integer age;

    public Person() {
        this.name = Util.faker().name().fullName();
        this.age = Util.faker().random().nextInt(10,30);
    }
}
