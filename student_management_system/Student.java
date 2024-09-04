package f1;
public class Student{
    private int studentID;
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private double gpa;
    public Student(int studentID, String first_Name, String last_Name, int grade_Level, double gpa){
        this.studentID = studentID;
        this.firstName = first_Name;
        this.lastName = last_Name;
        this.gradeLevel = grade_Level;
        this.gpa = gpa;
    }
    // Student ID
    public void set_studentID(int studentID){                                   // setter
        this.studentID = studentID;
    }
    public int get_studentID(){                                                 // getter
        return studentID;
    }
    // First Name
    public void set_firstName(String firstName){                                // setter
        this.firstName = firstName;
    }
    public String get_firstName(){                                              // getter
        return firstName;
    }
    // Last Name
    public void set_lastName(String lastName){                                  // setter
        this.lastName = lastName;
    }
    public String get_lastName(){                                               // getter
        return lastName;
    }
    // Grade Level
    public void set_gradeLevel(int gradeLevel){                                 // setter
        this.gradeLevel = gradeLevel;
    }
    public int get_gradeLevel(){                                                // getter
        return gradeLevel;
    }
    // GPA
    public void set_GPA(double gpa){                                            // setter
        this.gpa = gpa;
    }
    public double get_GPA(){                                                    // getter
        return gpa;
    }
    @Override
    public String toString(){
        return (
            "------------------------------------------\n" +
            "Student Name:\t" + firstName + " " + lastName + "\n" +
            "Student ID:\t" + studentID + "\n" +
            "Grade Level:\t" + gradeLevel + "\n" +
            "GPA:\t\t" + gpa + "\n" +
            "------------------------------------------\n"
            );
    }
}