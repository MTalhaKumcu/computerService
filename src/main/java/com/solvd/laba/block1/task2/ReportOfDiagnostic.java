package com.solvd.laba.block1.task2;

public class ReportOfDiagnostic {
    private String issue;
    private String diagnoses;
    private double repairCost;

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    @Override
    public String toString() {
        return "ReportOfDiagnostic= " + "\n" +
                "issue= " + issue + "\n" +
                "diagnoses= " + diagnoses + "\n" +
                "repairCost= " + repairCost;
    }
}
