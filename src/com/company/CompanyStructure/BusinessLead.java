package com.company.CompanyStructure;

import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee {
    private int headCount;
    private int reportsCount;
    private List<Accountant> directReports;

    public BusinessLead(String name) {
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 2);
        this.headCount = 10;
        this.reportsCount = 0;
        this.directReports = new ArrayList<Accountant>();
    }

    public boolean hasHeadCount() {
        return reportsCount < headCount;
    }

    public boolean addReport(Accountant accountant, TechnicalLead teamToSupport) {
        if (hasHeadCount()) {
            teamToSupport.setAccountantSupporting(accountant);
            accountant.supportTeam(teamToSupport);
            directReports.add(accountant);
            reportsCount++;
            this.setBonusBudget(this.getBonusBudget() + 1.1 * accountant.getBaseSalary());
            return true;
        } else {
            return false;
        }
    }

    public int getReportsCount() {
        return this.reportsCount;
    }

    public boolean requestBonus(Accountant accountant, double bonus) {
        if (bonus < this.getBonusBudget()) {
            System.out.println(String.format("Bonus affordable for %d %s",
                    accountant.getEmployeeID(),
                    accountant.getName()
            ));
            return true;
        }
        return false;
    }

    public boolean approveBonus(SoftwareEngineer engineerToBonus, double bonus) {
        for (Accountant accountant : this.directReports) {
            TechnicalLead teamSupported = accountant.getTeamSupported();
            if (engineerToBonus.getManager().equals(teamSupported) &&
                    accountant.approveBonus(bonus)) {
                System.out.println(String.format("Bonus affordable for %d %s",
                        accountant.getEmployeeID(),
                        accountant.getName()
                ));
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus() {
        if (headCount == 0) {
            return String.format("%d %s has no supported teams yet.", this.getEmployeeID(), this.getName());
        }
        String answer = String.format("%d %s has %d reports and is managing:",
                this.getEmployeeID(),
                this.getName(),
                this.getReportsCount());
        for (Accountant accountant: directReports) {
            answer += String.format("\n %d %s has bonus budget of %.2f and is supporting team lead by %d %s",
                    accountant.getEmployeeID(),
                    accountant.getName(),
                    accountant.getBonusBudget(),
                    accountant.getTeamSupported().getEmployeeID(),
                    accountant.getTeamSupported().getName()
            );
        }
        return answer;
    }
}
