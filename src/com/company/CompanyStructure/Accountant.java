package com.company.CompanyStructure;

public class Accountant extends BusinessEmployee {
    private TechnicalLead supportedTechnicalLead;

    public Accountant(String name) {
        super(name);
        this.setBonusBudget(0);
        this.supportedTechnicalLead = null;
    }

    public TechnicalLead getTeamSupported() {
        return this.supportedTechnicalLead;
    }

    public void supportTeam(TechnicalLead lead) {
        lead.setAccountantSupporting(this);
        this.supportedTechnicalLead = lead;

        double helpVar = 0.;
        for (Employee supportedEngineer : lead.getEngineerList()) {
            helpVar += supportedEngineer.getBaseSalary();
        }
        this.setBonusBudget(1.1 * helpVar);
    }

    public boolean approveBonus(double bonus) {
        return bonus < this.getBonusBudget() && this.getTeamSupported() != null;
    }

    public String employeeStatus() {
        return String.format("%d %s with a budget of %d is supporting %s",
                this.getEmployeeID(),
                this.getName(),
                this.getBonusBudget(),
                this.getTeamSupported().getName()
                );
    }
}
