import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class customer  {
    protected String f_name;
    protected String l_name;
    protected String email;
    protected String password;
    private String phone_number;
    private String Confirm_password;
    private int age;
    private String gender;
    private file handler;
    public String address;
    Scanner input=new Scanner(System.in);
    public customer(){
       super();
    }
    public void Register() throws IOException{
        System.out.println("=== Register ===");
        System.out.print("Enter First Name: ");
        this.f_name = input.nextLine();
        System.out.print("Enter Last Name: ");
         this.l_name= input.nextLine();
        while (true) {
            System.out.print("Enter Email: ");
           this.email = input.nextLine();
            if (!this.email.contains("@")) {
                System.out.println("Invalid email! The email must contain '@'. Please try again.");
            } else {
                break;
            }
        }
        System.out.print("Enter Password: ");
         this.password = input.nextLine();
        while (true) {
            System.out.print("Please Confirm Your Password: ");
            this.Confirm_password = input.nextLine();
            if (this.Confirm_password.equals(this.password)) {
                break;
            } else {
                System.out.println("Invalid password");
                continue;
            }

        }
        System.out.print("Enter Phone Number: ");
         this.phone_number = input.nextLine();
         while (true) {
            System.out.print("Enter Age: ");
            this.age = input.nextInt();
            if (this.age < 12) {
                System.out.println("Age must be 12 or older. Please enter a valid age.");
            } else {
                break;
            }
         }
        System.out.print("Enter Gender (Male/Female): ");
          this.gender =input.next();
        String record=String.join("/",f_name,l_name,email,password,phone_number,Integer.toString(age),gender);
        List <String> data=file.read();
        data.add(record);
        file.write(data);
        System.out.println("Welcome, "+this.f_name+" "+this.l_name);
    }

    public void governorate(  ) throws IOException{
        String[] governorates = {"Cairo", "Alexandria", "Qalyubia"};
        String[][] areas = {
                {"Abbasiya", "Nasr City", "Maadi"},
                {"Montazah", "Roushdy", "Smouha"},
                {"Benha", "Shubra", "Kaliub"}
        };
        while (true) {
            System.out.println("\nWelcome to the Customer System");
            System.out.println("Please select a Governorate:");
            for (int i = 0; i < governorates.length; i++) {
                System.out.println((i + 1) + ". " + governorates[i]);
            }
            System.out.print("Choose a Governorate (1-3): ");
            int governorateChoice = input.nextInt();
            input.nextLine();
            if (governorateChoice < 1 || governorateChoice > governorates.length) {
                System.out.println("Invalid Governorate");
                continue;
            }
            String selectedGovernorate = governorates[governorateChoice - 1];
            System.out.println("Choose an Area in " + selectedGovernorate + ":");
            for (int j = 0; j < areas[governorateChoice - 1].length; j++) {
                System.out.println((j + 1) + ". " + areas[governorateChoice - 1][j]);
            }
            System.out.print("Choose an Area (1-3): ");
            int areaChoice = input.nextInt();
            input.nextLine();
            if (areaChoice < 1 || areaChoice > areas[governorateChoice - 1].length) {
                System.out.println("Invalid Area. Please try again.");
                continue;
            }
            String selectedArea = areas[governorateChoice - 1][areaChoice - 1];

            this.address=selectedGovernorate + " - " + selectedArea;
            break;
        }
    }
    
}










