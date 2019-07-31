public class Employee{ // superclasse funcionário

    private String name; // nome do funcionário
    private int age; // idade do funcionário
    private double salary; // salário do funcionário

    // Construtor da classe funcionário
    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        setSalary(salary);
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

    public void setSalary(double novo_salario) { // quando o funcionário ganha o campeonato, ele ganha também um aumento
        salary = novo_salario;
    }

    public void setSalary(double novo_salario, double bonus) { // quando o funcionário ganha o campeonato, ele ganha também um aumento
        salary += novo_salario * bonus;
    }

    public String getFullInformation() {
        return "Nome: " + getName() + "\nIdade: " + getAge() + "\nSalário: " + getSalary();
    }
}