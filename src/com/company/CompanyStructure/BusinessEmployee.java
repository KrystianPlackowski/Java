package com.company.CompanyStructure;

abstract public class BusinessEmployee extends Employee<BusinessLead> {
    private double bonusBudget;

    public BusinessEmployee (String name) {
        super(name, 50_000);
        this.bonusBudget = 0;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    public String employeeStatus() {
        return String.format("%d %s had no succesful checks.",
                this.getEmployeeID(), this.getName());
    }
}

