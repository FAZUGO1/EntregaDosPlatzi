package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import model.Doctor;

public class UIpatientMenu
 {
 public static void showPatientMenu(){
    int response = 0;
      do{
        System.out.println("\n\n ");
            System.out.println("*******PATIENT*******");
            System.out.println("Wellcome Patient " + UIMenu.patinetLogged.getName());
            System.out.println("1- Book Appointment");
            System.out.println("2. My Appointmnet");
            System.out.println("0. Logout");
          
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine()); 

            switch (response)    {
            case 1:
                    showBookAppointmentsMenu();
                     break;
            case 2:
                     showPatientMyAppointment();
                     break;
            case 0: UIMenu.showMenu();
                     break;
            }
            sc.close();
        }while(response!=0);
 
    }  



    private static void showBookAppointmentsMenu(){
        int response = 0;
         do{
            System.out.println("\n\n ");
            System.out.println("***Book Appointment Menu**");
            System.out.println("Select a Date: ");
            int k = 0;
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
            //se crea arraylist que solo capturo citas disponible por doctor
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". "+availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointments);
                 }
             }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine()); 
            Map<Integer,Doctor> doctAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate =0;
            Doctor doctorSelected = new Doctor(" "," ");

            for (Map.Entry<Integer, Doctor> doc: doctAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue(); 
             }

            System.out.println(doctorSelected.getName()+ 
                           ". Date "+doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                           ". Time "+doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                           );
                           System.out.println("Confirm your Appointment: \n1. YES \n2. Change Data ");
                           response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patinetLogged.addAppointmentDoctors(
                doctorSelected,
                doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
             }
             sc.close();                  
         }while(response!=0);
     }


     private static void showPatientMyAppointment(){
         int response = 0;
         do{
            System.out.println("***My Appointments***");
            if(UIMenu.patinetLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Dont Have Appointment");
                 break;
            }
            for (int i = 0; i < UIMenu.patinetLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". "+
                           "Date " + UIMenu.patinetLogged.getAppointmentDoctors().get(i).getDate()+
                           " Time " + UIMenu.patinetLogged.getAppointmentDoctors().get(i).getTime()+
                           "\n Doctor: " + UIMenu.patinetLogged.getAppointmentDoctors().get(i).getDoctor()    
                           );
            }
            System.out.println("o. Return");
            
        }while(response!=0);
     }
}
