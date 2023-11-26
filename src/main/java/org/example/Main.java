package org.example;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
/**
 *  1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 */

        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000001))
                .limit(1000)
                .toList();

/**
 * 1.1 Найти максимальное
 */

        System.out.println(list.stream().max(Comparator.naturalOrder()).get());

  /**
   *  1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
   */

        System.out.println(list.stream().filter(it -> it > 500000).map(it -> it*5-150).reduce(0,(a,b) -> a+b));

/**
 * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

        System.out.println(list.stream().filter(it -> it* it< 100000).toList().size());

/**
 * * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 *    * 2.1 Создать список из 10-20 сотрудников
 */

        List<Employee>employeeList = new ArrayList<>();
        Employee employee1 = new Employee("Ivan", 26, 20000, "Склад");
        Employee employee2 = new Employee("alex", 26, 40000, "Склад");
        Employee employee3 = new Employee("max", 26, 200000, "Склад");
        Employee employee4 = new Employee("anna", 26, 50000, "Склад");
        Employee employee5 = new Employee("fedor", 26, 70000, "Склад");
        Employee employee6 = new Employee("zhenya", 26, 90000, "Бухгалтерия");
        Employee employee7 = new Employee("sergei", 26, 80000, "Бухгалтерия");
        Employee employee8 = new Employee("vasya", 26, 2000, "Бухгалтерия");
        Employee employee9 = new Employee("kolya", 26, 30000, "Бухгалтерия");
        Employee employee10 = new Employee("yula", 26, 45000, "Бухгалтерия");
        Employee employee11 = new Employee("sveta", 26, 56000, "Отдел продаж");
        Employee employee12 = new Employee("olesya", 26, 76000, "Отдел продаж");
        Employee employee13 = new Employee("irina", 26, 205400, "Отдел продаж");
        Employee employee14 = new Employee("anton", 26, 230000, "Отдел продаж");
        Employee employee15 = new Employee("semen", 26, 54000, "Отдел продаж");
        Employee employee16 = new Employee("rinat", 26, 430000, "Отдел продаж");
        Employee employee17 = new Employee("igor", 26, 7000, "Доставка");
        Employee employee18 = new Employee("sasha", 26, 67700, "Доставка");
        Employee employee19 = new Employee("roma", 26, 8000, "Доставка");
        Employee employee20 = new Employee("katya", 26, 90000, "Доставка");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        employeeList.add(employee9);
        employeeList.add(employee10);
        employeeList.add(employee11);
        employeeList.add(employee12);
        employeeList.add(employee13);
        employeeList.add(employee14);
        employeeList.add(employee15);
        employeeList.add(employee16);
        employeeList.add(employee17);
        employeeList.add(employee18);
        employeeList.add(employee19);
        employeeList.add(employee20);

        /**
         * * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
         */

        List<String> departments = employeeList.stream().map(it -> it.getDepartment()).distinct().toList();
        System.out.println(departments);

        /**
         * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
          */
        employeeList.stream().filter(it -> it.getSalary()<10000).forEach(it -> it.setSalary(it.getSalary()*1.2));
        System.out.println(employeeList);

        /**
         * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
         */
        Map<String, List<Employee>> listMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        System.out.println(listMap);

        /**
         * 2.5 * Из списка сотрудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
         */
        Map<String, Double> salaryMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(salaryMap);
    }
       static class  Employee{
        String name;
        int age;
        double salary;
        String department;

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }

}