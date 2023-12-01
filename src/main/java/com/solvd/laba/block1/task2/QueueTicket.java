package com.solvd.laba.block1.task2;

public class QueueTicket {
    private ComputerInfo computer;
    private CustomerInfo customer;
    private ComputerProblem pcProblem;
    private ServiceTechnician technician;


    public ComputerInfo getComputer() {
        return computer;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public ComputerProblem getPcProblem() {
        return pcProblem;
    }

    public ServiceTechnician getTechnician() {
        return technician;
    }


    public static int getQueueTicket(int... tickets) {
        int counter = 0;
        for (int each : tickets) {
            counter += each;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Queue Ticket Number= " + "ticket degerini yaz" + "\n" +
                "Computer information= " + computer + "\n" +
                "Customer= " + customer + "\n" +
                "Computer Problem=" + pcProblem + "\n" +
                "Technician= " + technician;
    }
}
