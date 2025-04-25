package Model;

public class Employee {
    int EmployeeId;
    String firstName;
    String lastName;
    float balance;

    public Employee(int EmployeeId, String firstName, String lastName, float balance) {
        this.EmployeeId = EmployeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public float getBalance() {
        return balance;
    }
}