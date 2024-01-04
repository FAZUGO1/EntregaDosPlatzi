package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentDoctor> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }
    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    
    } 


    public ArrayList<AppointmentDoctor> getAppointmentNurses() {
        return appointmentNurses;
    }
    public void setAppointmentNurses(ArrayList<AppointmentDoctor> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    
    @Override
    public void showDataUser(){
        System.out.println("Paciente de:  santa clara");
        System.out.println("Remitodo de: Eps salud total");
    }
    @Override
    public String toString(){
        return super.toString()+ "\nAge: " + birthday +"\nWeigth: " + weight + "\nHeigth: " + height;
    }
    public Patient(String name, String email){
        super(name,email);
    }

    // 54.5
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // 54.5 Kg. String
    public String getWeight(){
        return this.weight + " Kg.";
    }


    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
