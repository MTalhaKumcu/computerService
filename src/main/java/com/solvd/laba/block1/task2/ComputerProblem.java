package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.DiagnoseDoesNotFound;
import com.solvd.laba.block1.task2.Interfaces.IComputerInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.HashMap;
import java.util.Map;

public class ComputerProblem extends ComputerOptionScan implements IComputerInfo {
    private static final Logger logger = (Logger) LogManager.getLogger(ComputerProblem.class);

    private String issue;
    private double repaireCost;
    private Payment payment;
    private String diagnoses;
    private QueueTicket queueTicket;
    public ScheduleAppointmentForCustomer scheduleAppointmentForCustomer =
                  new ScheduleAppointmentForCustomer("12-12-12","08:08:08");


    public ReportOfDiagnostic report = new ReportOfDiagnostic();
    Map<Integer, String> issues = new HashMap<>();
    Map<String, Integer> diagnoseCostMap = new HashMap<>();

    public QueueTicket getQueueTicket() {
        return queueTicket;
    }

    public void setQueueTicket(QueueTicket queueTicket) {
        this.queueTicket = queueTicket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public int chooseComputerIssue() {
        getIssue();
        System.out.println("please select your problem");
        for (int i = 1; i <= issues.keySet().size(); i++) {
            System.out.println(i + " " + issues.get(i));
        }
        int option = scan.nextInt();

        String selectedIssue = issues.get(option);
        String diagnoses = getDiagnosis(selectedIssue);
        //double cost = getRepaireCost(diagnoses);

        logger.info("issue: " + selectedIssue);
        logger.info("Diagnose: " + diagnoses);
      //  logger.info("Cost: " + cost);
        System.out.println("Please push 1 to get invoce ");

        return scan.nextInt();
    }

    public  String getDiagnosis(String issue) {
        String diagnose;
        switch (issue) {
            case "Overheat":
                diagnose = "need to change cable";
                break;
            case "Broken Screen":
                diagnose = "need to change screen";
                break;
            case "Computer Power Does not work":
                diagnose = " need to change powersupply ";
                         System.out.println(scheduleAppointmentForCustomer.scheduleAppointmentForCustomer(scheduleAppointmentForCustomer.toString()));

                break;
            default:
                throw new DiagnoseDoesNotFound("There is no issue like that!");
        }
        return diagnose;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void getIssue() {
        this.issues.put(1, "Overheat");
        this.issues.put(2, "Broken Screen");
        this.issues.put(3, "Computer Power Does not work");
    }

    public double getRepaireCost(String diagnoses) {

        if (diagnoses.equals(getDiagnosis(issue))) {
            repaireCost = 50.00;

        } else if (diagnoses.equals(getDiagnosis(issue))) {
            repaireCost = 75.00;

        } else if (diagnoses.equals(getDiagnosis(issue))) {
            repaireCost = 100.00;
        }
        return repaireCost;
    }

    public void setRepaireCost(double repaireCost) {
        this.repaireCost = repaireCost;
    }


    public int processOption() {
        System.out.println("Welcome to our service. Please Select an option:");
        System.out.println("1 - Diagnose Problem  \nQ - Quit System");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                return chooseComputerIssue();
            default:
                break;
        }
        return option;
    }


    @Override
    public String toString() {
        return "ComputerProblem= " +
                "Issue= " + issue + "\n" +
                "Repaire cost= " + repaireCost + "\n" +
                "Diagnosis= " + diagnoses;
    }


}

