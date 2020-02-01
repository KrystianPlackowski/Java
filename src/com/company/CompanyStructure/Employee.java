package com.company.CompanyStructure;

abstract public class Employee<T extends Employee> {
    static int ID = 1;

    private int employeeID;
    private String name;
    private double baseSalary;
    private T manager;

    public Employee(String name, double baseSalary) {
        this.employeeID = ID++;
        this.name = name;
        this.baseSalary = baseSalary;
        this.manager = null;
    }

    public void setBaseSalary(double salary) {this.baseSalary = salary;}

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public void setManager(T manager) {
        this.manager = manager;
    }

    public T getManager() {
        return this.manager;
    }

    public boolean equals(Employee other) {
         return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString() {
        return String.format("%d %s", this.getEmployeeID(), this.getName());
    }

    abstract public String employeeStatus();
}
