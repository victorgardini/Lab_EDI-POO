public class Employee{ // superclasse funcionário

    private String name; // nome do funcionário
    private int age; // idade do funcionário
    private double salary; // salário do funcionário

    // Construtor da classe funcionário
    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

}