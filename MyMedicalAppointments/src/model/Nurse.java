package model;

public class Nurse extends User{

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
    }

   // @Override
   // public void m() {  }

    @Override
    public void showDataUser(){
        System.out.println("EMpleado de Hospital:  SAnta Clara");
        System.out.println("departamento: Urgencias");
    }
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}