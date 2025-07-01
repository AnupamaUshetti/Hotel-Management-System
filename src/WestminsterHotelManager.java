import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterHotelManager implements HotelManager{
    private ArrayList<HotelStaff> hotelStaffList;
    private ArrayList<Guest> hotelGuestList;
    private int staffLimit;

    public WestminsterHotelManager(int maxMembersNumber) {
        hotelStaffList = new ArrayList<>();
        hotelGuestList = new ArrayList<>();
        staffLimit = maxMembersNumber;

    }

    @Override
    public boolean runMenu() {
        boolean exit = false; // Exit flag
        System.out.println("\n-- HOTEL MANAGEMENT SYSTEM CONSOLE MENU--");
        System.out.println("To save and exit, press 0");
        System.out.println("To Add a new staff member, press 1");
        System.out.println("To Print the list of staff members press 2");
        System.out.println("To Add a guest, press 3");
        System.out.println("To Open GUI, press 4");
        System.out.println("To Change Staff name, press 5");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        switch (choice) {
            case 0:
                exit = true;
                break;
            case 1:
                this.addHotelStaff();
                break;
            case 2:
                this.printHotelStaffList();
                break;
            case 3:
                this.addGuest();
                break;
            case 4:
                this.runGUI();
                break;
            case 5:
                this.editStaffName();
                break;
        }
        return exit;
    }

    @Override
    public void addHotelStaff() {
        Scanner s = new Scanner(System.in);
        if (hotelStaffList.size() < staffLimit) {
            System.out.println("Press 1 if you want to add a Manager");
            System.out.println("Press 2 if you want to add a Housekeeper");

            int choiceStaff = s.nextInt();
            s.nextLine();

            // Common questions
            System.out.println("Enter the first name");
            String name = s.nextLine();

            System.out.println("Enter the last name");
            String surname = s.nextLine();

            System.out.println("Enter the staff ID");
            String staffID = s.nextLine();

            System.out.println("Enter the date of birth (dd/MM/yyyy format only!)");
            LocalDate date = null;
            String dob = null;
            boolean parsingSucceeds = false;
            while (!parsingSucceeds) {
                dob = s.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    date = LocalDate.parse(dob, formatter);
                    parsingSucceeds = true; // If parsing succeeds, the format is correct
                } catch (DateTimeParseException e) {
                    System.out.println("Enter the correct format. It should be dd/MM/yyyy!");
                    parsingSucceeds = false;
                }
            }


            // Check if the staff is a manager or a guest
            switch (choiceStaff) {
                case 1:
                    // It is a manager
                    System.out.println("Enter the license number");
                    String licenseNum = s.nextLine();

                    // Create a new Manager and add to the list
                    Manager manager = new Manager(name, surname);
                    manager.setLicenceNumber(licenseNum);
                    manager.setDateOfBirth(date);
                    manager.setStaffID(staffID);
                    this.addStaffToList(manager);
                    break;

                case 2:
                    // It is a HouseKeeper
                    System.out.println("Enter the years of experience");
                    int yearsOfExperience = s.nextInt();
                    s.nextLine();


                    HouseKeeper housekeeper = new HouseKeeper(name, surname);
                    housekeeper.setYearsOfExperience(yearsOfExperience);
                    housekeeper.setDateOfBirth(date);
                    housekeeper.setStaffID(staffID);
                    this.addStaffToList(housekeeper);
                    break;

            }
        } else {
            System.out.println("No more space in the system");
        }
    }

    public void addStaffToList(HotelStaff staff) {
        if (this.hotelStaffList.size() < staffLimit) {
            hotelStaffList.add(staff);
        } else {
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void printHotelStaffList() {
        if (!hotelStaffList.isEmpty()) {
            for (HotelStaff member : hotelStaffList) {
                System.out.println(member.toString());
            }
        } else {
            System.out.println("There are no staff members in the system.");
        }
    }

    @Override
    public void addGuest() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the first name");
        String name = s.nextLine();

        System.out.println("Enter the last name");
        String surname = s.nextLine();

        System.out.println("Enter the room number");
        int roomNum = s.nextInt();
        s.nextLine();

        System.out.println("Enter the number of nights stayed");
        int nightsStayed = s.nextInt();
        s.nextLine();

        Guest guest = new Guest(name, surname);
        guest.setRoomNumber(roomNum);
        guest.setNightStayed(nightsStayed);

        hotelGuestList.add(guest);
    }

    @Override
    public void runGUI() {
        HotelTableGUI table = new HotelTableGUI(hotelStaffList);
        table.setVisible(true);
    }

    @Override
    public void editStaffName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Staff ID: ");
        String searchID = s.nextLine();

        boolean found = false;
        for (HotelStaff staff : hotelStaffList){
            if(staff.getStaffID().equalsIgnoreCase(searchID)){
                System.out.println("Name: " + staff.getName());
                System.out.println("Surname: " + staff.getSurname());
                System.out.println("DOB: " + staff.getDateOfBirth());

                if(staff instanceof Manager){
                    System.out.println("Staff type: Manager");
                }else if(staff instanceof HouseKeeper){
                    System.out.println("Staff type: HouseKeeper");
                }else{
                    System.out.println("Staff type: Other");
                }

                System.out.println("Enter a updated name:" );
                String newName = s.nextLine();
                staff.setName(newName);
                System.out.println("Enter a updated Surname:" );
                String newSurname = s.nextLine();
                staff.setSurname(newSurname);
                System.out.println("Name updated successfully" );

                found = true;
                break;
            }

        }
        if(!found) {
            System.out.println("No such staff");
        }
    }

}

