package com.company.CompanyStructure;

abstract public class TechnicalEmployee extends Employee<TechnicalLead> {

    public TechnicalEmployee (String name) {
        super(name, 75_000);
    }

    public String employeeStatus() {
        return String.format("%d %s had no succesful checks.",
                this.getEmployeeID(), this.getName());
    }
}
