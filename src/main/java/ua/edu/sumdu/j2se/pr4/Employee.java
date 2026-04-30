package ua.edu.sumdu.j2se.pr4;

/**
 * Клас працівника.
 */
public class Employee {

    private String name;
    private int age;
    private double salary;
    private String position;

    /**
     * Конструктор класу Employee.
     */
    public Employee(String name,
                    int age,
                    double salary,
                    String position) {

        setName(name);
        setAge(age);
        setSalary(salary);
        setPosition(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Ім'я не може бути порожнім");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age <= 0) {

            throw new IllegalArgumentException(
                    "Вік має бути більше 0");
        }

        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary < 0) {

            throw new IllegalArgumentException(
                    "Зарплата не може бути від'ємною");
        }

        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {

        if (position == null
                || position.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Посада не може бути порожньою");
        }

        this.position = position;
    }

    @Override
    public String toString() {

        return "Employee{name='"
                + name
                + "', age="
                + age
                + ", salary="
                + salary
                + ", position='"
                + position
                + "'}";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null
                || getClass() != obj.getClass()) {

            return false;
        }

        Employee employee = (Employee) obj;

        return age == employee.age
                && salary == employee.salary
                && name.equals(employee.name)
                && position.equals(employee.position);
    }
}