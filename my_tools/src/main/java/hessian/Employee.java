package hessian;

import lombok.Data;

@Data
public class Employee {
    private String name;


    public Employee(String name) {
        this.name = name;
    }
}
