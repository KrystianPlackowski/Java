package com.company.CompanyStructure;

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean access;
    private int checkinsCount;

    public SoftwareEngineer(String name) {
        super(name);
        this.access = false;
        this.checkinsCount = 0;
    }

    public boolean getCodeAccess() {
        return this.access;
    }

    public void setCodeAccess(boolean access) {
        this.access = access;
    }

    public int getSuccessfulCheckins() {
        return this.checkinsCount;
    }

    public boolean checkInCode() {
        if (this.getManager()!=null && ((TechnicalLead)this.getManager()).approveCheckIn(this)) {
            this.checkinsCount++;
            return true;
        }
        return false;
    }
}
