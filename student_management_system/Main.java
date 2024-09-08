import java.util.Scanner;;
public class Main{
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static String CYAN = "\u001B[35m";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = null;

        // Program Flow:
        int flow;
        try{
            while(true){
                flow = display_dashboard(sc);
                switch(flow){
                    case 0 -> quit();
                    case 1 -> {sms = check_database(sms, sc); sms.display_all_students();}
                    case 2 -> {sms = check_database(sms, sc); sms = search_students(sms, sc);}
                    case 3 -> {sms = check_database(sms, sc); sms = add_students(sms, sc);}
                    case 4 -> {sms = check_database(sms, sc); sms = remove_students(sms, sc);}
                    default -> invalid_input();
                }
            }
        }catch(Exception e){
            invalid_input();
            System.out.println("Program Reset.");
            retry();
        }
    }

    public static int display_dashboard(Scanner sc){
        print_horizontal();
        System.out.print(YELLOW + "\t   Student Management System" + RESET);
        print_horizontal();
        System.out.println("\n1: View Database\t\t3. Add Student");
        System.out.println("2: Search Student\t\t4. Remove Student");
        System.out.print("\t\t    0: Exit\n");
        print_horizontal();
        int flow;
        {System.out.print("\nPlease enter a number: "); flow = sc.nextInt();}
        print_horizontal();
        return flow;
    }

    public static StudentManagementSystem check_database(StudentManagementSystem sms, Scanner sc){
        if(sms == null){
            int flow = no_database(sc);
            if(flow == 0){
                return create_database(sms, sc);
            }else{
                return sms;
            }
        }else{
            return sms;
        }
    }

    public static StudentManagementSystem create_database(StudentManagementSystem sms, Scanner sc){
        System.out.print("\nEnter database size: ");
        int db_size = sc.nextInt();
        print_horizontal();
        sms = new StudentManagementSystem(db_size);

        System.out.print("\nDatabase of size " + db_size + " created.\n");
        return sms;
    }

    public static StudentManagementSystem search_students(StudentManagementSystem sms, Scanner sc){
        System.out.println("\nAttributes: ");
        System.out.println("[ 0: ID | 1: first name | 2: last name | 3. grade level | 4. gpa ]");
        System.out.print("\nPlease Enter a Number: ");
        int flow = sc.nextInt();

        int id = 0, gradeLevel = 0;
        String firstName, lastName;
        double gpa = 0;
        sc.nextLine();

        switch(flow){
            case 0 -> {System.out.print("Please Enter Student ID: "); id = sc.nextInt(); sms.find_student_by_ID(id);}
            case 1 -> {System.out.print("Please Enter Student's First Name: "); firstName = sc.nextLine(); sms.find_student_by_firstName(firstName);}
            case 2 -> {System.out.print("Please Enter Student's Last Name: "); lastName = sc.nextLine(); sms.find_student_by_lastName(lastName);}
            case 3 -> {System.out.print("Please Enter Grade Level: "); gradeLevel = sc.nextInt(); sms.find_student_by_gradeLevel(gradeLevel);}
            case 4 -> {System.out.print("Please Enter GPA: "); gpa = sc.nextDouble(); sms.find_student_by_gpa(gpa);}
        }
        return sms;
    }

    public static StudentManagementSystem add_students(StudentManagementSystem sms, Scanner sc){
        int x;
        {System.out.print("\nPlease enter the number of students to add: "); x = sc.nextInt();}
        print_horizontal();

        Student student;
        String[] cases = {"Index", "ID", null, "First Name", "Last Name", "Grade Level", "GPA"};
        int index = 0, id = 0, gradeLevel = 0;
        String firstName = null, lastName = null;
        double gpa = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < cases.length; j++){
                switch(j){
                    case 0 -> {print_case(cases, j); index = sc.nextInt();}
                    case 1 -> {print_case(cases, j); id = sc.nextInt();}
                    case 2 -> {sc.nextLine();}  //to avoid the single line error
                    case 3 -> {print_case(cases, j); firstName = sc.nextLine();}
                    case 4 -> {print_case(cases, j); lastName = sc.nextLine();}
                    case 5 -> {print_case(cases, j); gradeLevel = sc.nextInt();}
                    case 6 -> {print_case(cases, j); gpa = sc.nextDouble();}
                    default -> {invalid_input(); j = 0;}
                }
            }
            student = new Student(id, firstName, lastName, gradeLevel, gpa);
            sms.add_student(index, student);
            print_horizontal();
        }
        return sms;
    }

    public static StudentManagementSystem remove_students(StudentManagementSystem sms, Scanner sc){
        System.out.print("\nPlease enter the number of students to remove: ");
        int x = sc.nextInt();
        print_horizontal();
        for(int i = 0; i < x; i++){
            System.out.print("\nEnter Index: ");
            int index = sc.nextInt();
            sms.remove_student(index);
        print_horizontal();
        }
        return sms;
    }

    public static int no_database(Scanner sc){
        System.out.println("\nNo existing database found. \n\nCreate Database?    [0: yes | 1: no]\n");
            int flow;
            {System.out.print("\nPlease Enter a Number: "); flow = sc.nextInt();}
            print_horizontal();
        return flow;
    }

    public static void print_horizontal(){
        System.out.print(CYAN + "\n=================================================\n" + RESET);
    }

    public static void print_case(String[] array, int index){
        System.out.print(array[index] + ": ");
    }

    public static void invalid_input(){
        System.out.println(RED + "\nInvalid Input. Please try again" + RESET);
    }

    public static void quit(){
        System.out.println("\nProgram Exited.");
        System.exit(0);
    }

    public static void retry(){
        main(null);
    }
}