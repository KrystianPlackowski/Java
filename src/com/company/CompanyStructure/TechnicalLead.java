package com.company.CompanyStructure;

import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee implements {
    private int headCount;
    private int reportsCount;
    private List<SoftwareEngineer> directReports;
    private Accountant accountantSupporting;

    public TechnicalLead(String name) {
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 1.3);
        this.headCount = 4;
        this.reportsCount = 0;
        this.directReports = new ArrayList();
    }

    public boolean hasHeadCount() {
        return reportsCount < headCount;
    }

    public boolean addReport(SoftwareEngineer engineer) {
        if (hasHeadCount()) {
            engineer.setManager(this);
            directReports.add(engineer);
            reportsCount++;
            return true;
        } else {
            return false;
        }
    }

    public int getReportsCount() {
        return this.reportsCount;
    }

    public boolean approveCheckIn(SoftwareEngineer engineer) {
        return engineer.getCodeAccess() && this.equals((TechnicalLead)engineer.getManager());
    }

    public String getTeamStatus() {
        if (headCount == 0) {
            return String.format("%d %s has no direct reports yet.", this.getEmployeeID(), this.getName());
        }
        String answer = String.format("%d %s has %d reports and is managing:",
                this.getEmployeeID(),
                this.getName(),
                this.getReportsCount());
        for (SoftwareEngineer engineer : directReports) {
            answer += String.format("\n %d %s has %d successful check in(s)",
                    engineer.getEmployeeID(),
                    engineer.getName(),
                    engineer.getSuccessfulCheckins()
            );
        }
        return answer;
    }

    public List<SoftwareEngineer> getEngineerList() {
        return this.directReports;
    }

    public void setAccountantSupporting(Accountant accountant) {
        this.accountantSupporting = accountant;
    }

    public Accountant getAccountantSupporting() {
        return this.accountantSupporting;
    }

    public boolean requestBonus(SoftwareEngineer engineer, double bonus) {
        TechnicalLead engineersManager = engineer.getManager();
        if (engineersManager.equals(this) && this.accountantSupporting.approveBonus(bonus)) {
            System.out.println(String.format("Bonus affordable for %d %s",
                    this.accountantSupporting.getEmployeeID(),
                    this.accountantSupporting.getName()
            ));
        }
        return false;
    }
}
