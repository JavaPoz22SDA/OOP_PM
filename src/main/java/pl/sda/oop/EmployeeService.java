package pl.sda.oop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    List<Employee> employees = new ArrayList();

    String firstCapitalLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public void showEmployeesMinimal() {
        for (Employee item : employees) {
            item.showEmployeeMinimal();
        }
    }

    public void addEmployee() {
        //todo Wykonanie sprawdzenia dla wpisywanych danych
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imię pracownika: ");
        String firstName = firstCapitalLetter(scanner.nextLine());
        System.out.print("Podaj nazwisko pracownika: ");
        String lastName = firstCapitalLetter(scanner.nextLine());
        System.out.print("Podaj płeć (K/M): ");
        char sex = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Podaj nr działu: ");
        int department = scanner.nextInt();
        System.out.print("Podaj płacę: ");
        Float salary = scanner.nextFloat();
        System.out.print("Podaj wiek: ");
        Integer age = scanner.nextInt();
        System.out.print("Podaj liczbę dzieci: ");
        Integer numberOfChildren = scanner.nextInt();
        System.out.print("Stan cywilny (true/false): ");
        boolean maritalStatus = scanner.nextBoolean();

        Employee employee = new Employee(firstName, lastName, sex);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setAge(age);
        employee.setNumberOfChildren(numberOfChildren);
        employee.setMaritalStatus(maritalStatus);

        employees.add(employee);
    }

    public void export() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj nazwę pliku do eksportu: ");
            FileWriter file = new FileWriter(scanner.nextLine() + ".txt");

            for (Employee emp : employees) {
                file.write(emp.getLastName() + " "
                        + emp.getFirstName() + " "
                        + emp.getSex() + " "
                        + emp.getDepartment() + " "
                        + emp.getSalary() + " "
                        + emp.getAge() + " "
                        + emp.getNumberOfChildren()
                        + "\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Numer pracownika: " + (i + 1) + "\n");
            employees.get(i).showEmployee();
        }

        System.out.println("Podaj numer pracownika do usunięcia: ");
        int getAnswer = scanner.nextInt()-1;
        if ((getAnswer >= 0) && (getAnswer < employees.size())) {
            employees.remove(getAnswer);
            System.out.println("Prcownik o następujących danych został usunięty:\n"
                    + employees.get(getAnswer).getLastName() + " "
                    + employees.get(getAnswer).getFirstName() + " "
                    + employees.get(getAnswer).getSex() + "\n");
        } else {
            System.out.println("Pracownik nie odnaleziony.");
        }

    }

    public void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Numer pracownika: " + (i + 1) + "\n");
            employees.get(i).showEmployee();
        }

        System.out.print("Podaj numer pracownika do edycji: ");
        int getAnswer = scanner.nextInt()-1;
        if ((getAnswer >= 0) && (getAnswer <= employees.size())) {
            boolean edit = true;
            while (edit) {
                employees.get(getAnswer).showEmployee();
                System.out.print("\nWybierz numer pola do edycji!\n" +
                        "1. Numer działu\n" +
                        "2. Płaca\n" +
                        "3. Wiek\n" +
                        "4. Liczba dzieci\n" +
                        "5. Stan cywilny\n");
                if (employees.get(getAnswer).getSex() == 'K') {
                    System.out.print("6. Nazwisko\n");
                }
                System.out.print("7. Zakończ edycję\n");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Podaj numer działu: ");
                        employees.get(getAnswer).setDepartment(scanner.nextInt());
                        break;
                    case "2":
                        System.out.print("Podaj płacę: ");
                        employees.get(getAnswer).setSalary(scanner.nextFloat());
                        break;
                    case "3":
                        System.out.print("Podaj wiek: ");
                        employees.get(getAnswer).setAge(scanner.nextInt());
                        break;
                    case "4":
                        System.out.print("Podaj liczbę dzieci: ");
                        employees.get(getAnswer).setNumberOfChildren(scanner.nextInt());
                        break;
                    case "5":
                        System.out.print("Podaj stan cywilny (true/false): ");
                        employees.get(getAnswer).setMaritalStatus(scanner.nextBoolean());
                        break;
                    case "6":
                        if (employees.get(getAnswer).getSex() == 'K') {
                            System.out.println("Podaj Nazwisko: ");
                            employees.get(getAnswer).setLastName(scanner.nextLine());
                        }
                        break;
                    case "7":
                        edit = false;
                        break;
                }

            }
        }
    }
    public void additionalFeatures () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodmenu - dodatkowe opcje: \n" +
                "1. Wyświetl liczbę pracowników powyżej pensji...\n" +
                "2. Obliczenie średniej płacy w dziale\n" +
                "3. Wyświetl najwyższe pensje kobiet i mężczyzn\n" +
                "4. Wyświetlenie działów z dodatkowymi informacjami\n" +
                "5. Średnia płaca kobiet i mężczyzn\n"+
                "6. Stosunek średniej płacy kobiet i mężczyzn\n"+
                "7. Zwiększenie pensji pracownikom o 10%\n" +
                "8. Zwiększenie pensji pracownikom o kwotę ...\n");

        switch (scanner.nextLine()){
            case "1":
                int empNumber = 0;
                System.out.print("Podaj pensję: ");
                float salaryMinimum = scanner.nextFloat();
                for (Employee emp: employees) {
                    if (emp.getSalary()>salaryMinimum) empNumber++;
                }
                System.out.println("Jest " + empNumber + " pracowników powyżej pensji " + salaryMinimum);
                break;
            case "2":
                System.out.print("Podaj numer działu: ");
                int numberOfDepartment = scanner.nextInt();
                float avgSalary = getAverageSalary(numberOfDepartment);
                if (avgSalary>0f) {
                    System.out.println("Średnia pensja w dziale " +numberOfDepartment+ " wynosi " + avgSalary);
                }
                else
                {
                    System.out.println("Nie odnaleziono wybranego działu");
                }
                break;
            case "3":
                float maxMen = 0;
                float maxWoman = 0;
                float getSalary;
                char getSex;

                for (Employee emp: employees) {
                    getSalary = emp.getSalary();
                    getSex = emp.getSex();
                    if (getSex == 'M' && getSalary>maxMen) maxMen = getSalary;
                    if (getSex == 'K' && getSalary>maxWoman) maxWoman = getSalary;
                }

                if (maxWoman>0) System.out.println("Najwyższa pensja kobiet wynosi "+ maxWoman);
                if (maxMen>0) System.out.println("Najwyższa pensja mężczyzn wynosi "+ maxMen);
                break;
            case "4":
                HashMap<Integer, List<Employee>> mapOfDepartments = new HashMap<>();

                for (Employee emp :employees) {
                    if (!mapOfDepartments.containsKey(emp.getDepartment())){
                        List<Employee> list = new ArrayList<>();
                        list.add(emp);
                        mapOfDepartments.put(emp.getDepartment(),list);
                    }
                    else{
                        mapOfDepartments.get(emp.getDepartment()).add(emp);
                    }
                }
                for (Integer deptNo:mapOfDepartments.keySet()) {
                    int numberOfMan =0;
                    int numberOfWoman = 0;
                    StringBuilder sb = new StringBuilder();

                    sb.append("Dział ").append(deptNo);
                    for (Employee emp:mapOfDepartments.get(deptNo)) {
                        if (emp.getSex() == 'M') numberOfMan++;
                        if (emp.getSex() == 'K') numberOfWoman++;
                    }
                    if (numberOfMan == numberOfWoman) sb.append(" posiada po równo kobieet i mężczyzn.");
                    if (numberOfMan > numberOfWoman) sb.append(" posiada więcej mężczyzn.");
                    if (numberOfMan < numberOfWoman) sb.append(" posiada więcej kobiet.");
                    sb.append(" Średnia pensja w dziale wynosi: ").append(getAverageSalary(deptNo));
                    System.out.println(sb.toString());
                }
                break;
            case "5":
                float salaryOfMan = averageSalary('M');
                float salaryOfWoman = averageSalary('K');

                if (salaryOfWoman>0) System.out.println("Średnia pensja kobiet wynosi "+salaryOfWoman);
                if (salaryOfMan>0) System.out.println("Średnia pensja mężczyzn wynosi "+salaryOfWoman);
                break;
            case "6":
                salaryOfMan = averageSalary('M');
                salaryOfWoman = averageSalary('K');

                if (salaryOfMan == 0) {
                    System.out.println("Brak mężczyzn w zestawieniu. Nie można obliczyć stosunku");
                }
                else{
                    if (salaryOfWoman == 0) System.out.println("Brak kobiet w zestawieniu. Nie można obliczyć stosunku");
                    else{
                        System.out.println(String.format("Sosunek pensji kobiet do mężczyzn w zaokrągleniu wynosi %.2f" ,(salaryOfWoman / salaryOfMan) ));
                    }
                }
                break;
            case "7":
                for (Employee emp:employees) {
                    emp.payRise(10);
                }
                break;
            case "8":
                System.out.print("Podaj kwotę podwyżki: ");
                float payRiseValue = scanner.nextFloat();
                float payRiseMan =0;
                float payRiseWoman =0;
                float payRiseSummary =0;

                for (Employee emp:employees) {
                    if (emp.getSex() == 'M'){
                        emp.setSalary(emp.getSalary()+payRiseValue);
                        payRiseMan += payRiseValue;
                    }
                    if (emp.getSex() == 'K'){
                        emp.setSalary(emp.getSalary()+payRiseValue);
                        payRiseWoman += payRiseValue;
                    }
                }
                payRiseSummary = payRiseMan+ payRiseWoman;
                System.out.println(String.format("Stosunek podwyżki pensji kobiet do mężczyzn wynosi: %.2f",(payRiseWoman/payRiseMan)));
                break;
            default:
                break;
        }
        //todo tu skończyłem
    }
    public float averageSalary(char gender){
        float avgSalary = 0f;
        int noOfPersons =0;
        for (Employee emp: employees) {
            if (emp.getSex() == gender){
                noOfPersons++;
                avgSalary += emp.getSalary();
            }
        }
        return avgSalary;
    }

    public void exportAndFeatures () {
    }

    public void getSystemInfo () {
        System.out.println("Program version 0.1 beta");
    }

    public void changeDatabaseName () {
    }

    float getAverageSalary(int numberOfDepartment){
        float avgSalary=0;
        int numberOfPeople=0;
        for (Employee emp: employees) {
            if (emp.getDepartment() == numberOfDepartment) {
                avgSalary += emp.getSalary();
                ++numberOfPeople;
            }
        }
        if (numberOfPeople>0) avgSalary = avgSalary/numberOfPeople;
        return avgSalary;
    }
}
