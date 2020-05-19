package pl.sda.oop;

public class Employee {
    private final String firstName;
    private String lastName;
    private final char sex;
    private int department;
    private float salary;
    private int age;
    private int numberOfChildren;
    private boolean maritalStatus;

    public Employee(String firstName, String lastName, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Employee(String firstName, String lastName, char sex, int department, float salary, int age, int numberOfChildren, boolean maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.numberOfChildren = numberOfChildren;
        this.maritalStatus = maritalStatus;
    }

    public void showEmployee(){
        String sb = "Imię: " + firstName + "\n" +
                "Nazwisko: " + lastName + "\n" +
                "Płeć: " + sex + "\n" +
                "Nr działu: " + department + "\n" +
                "Płaca: " + salary + "\n" +
                "Wiek: " + age + "\n" +
                "Liczba dzieci: " + numberOfChildren + "\n" +
                "Stan cywilny: " + maritalStatus + "\n";
        System.out.println(sb);
    }

    public void showEmployeeMinimal(){
        String sb = "Imię: " + firstName + "\n" +
                "Nazwisko: " + lastName + "\n" +
                "Płaca: " + salary + "\n";
        System.out.println(sb);
    }

    public void showEmployeeSpecial(){
        String sb = "Imię: " + firstName + "\n" +
                "Nazwisko: " + lastName + "\n";
        System.out.println(sb.toUpperCase());
    }

    public boolean checkSalaryAboveValue(float salary){
        return this.getSalary() > salary;
    }

    public void payRise(float valueInPercentage){
        valueInPercentage += getNumberOfChildren()*2;
        if (isMaritalStatus()) {
            valueInPercentage += 3;
        }
        this.setSalary(getSalary()*(1+valueInPercentage/100));
    }



    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        if ( getSex() == 'K'){
            this.lastName = lastName;
        }
    }

    public char getSex() {
        return sex;
    }


    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
