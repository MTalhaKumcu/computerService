package com.solvd.laba.block1.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleAppointmentForCustomer {
    private CustomerInfo customer;
    private String date;
    private String time;


    public ScheduleAppointmentForCustomer(String date, String time) {
        this.date = date;
        this.time = time;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }



    public String createAppointment() {
        if (customer != null && date != null && time != null) {
            return "Appointment created for " + customer.getCustomerName() + " on " + date + " at " + time;
        } else {
            return "Appointment information is incomplete.";
        }
    }


    @Override
    public String toString() {
        return "Appointment= " +
                "customer= " + customer +
                " date= " + date + '\'' +
                " time= " + time + '\'';
    }
    public String scheduleAppointmentForCustomer(String computerIssue) {

        if (computerIssue != null && computerIssue.contains("Computer Power Does not work")) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime newDateTime = currentDateTime.plusDays(2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String formattedDate = newDateTime.format(formatter);

            return "Appointment scheduled for " + computerIssue + ". Appointment date: " + date;
        } else {
            return "Invalid computer issue for scheduling an appointment.";
        }



    }
}
