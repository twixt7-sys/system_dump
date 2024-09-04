public class StudentManagementSystem{
    //database(array) to store collection of students
    public int databaseSize;
    public Student[] Students;

    public StudentManagementSystem(int databaseSize){
        this.Students = new Student[databaseSize];
    }

    public void add_student(int index, Student student){
        this.Students[index] = student;
        System.out.println("Student Recorded.");
    }

    public void display_all_students(){
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] == null){
                System.out.println("No existing student in index " + i);
            }else{
                System.out.println(this.Students[i]);
            }
        }
    }

    public void remove_student(int index){
        this.Students[index] = null;
        System.out.println("Student removed in index " + index);
    }

    public void find_student_by_ID(int id){
        int counter = 0;
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] != null){
                if(id == this.Students[i].get_studentID()){
                    print_student_found(i);
                    counter++;
                }
            }
        }
        if(counter == 0){
            System.out.println("\nNo student found.\n");
        }
    }

    public void find_student_by_firstName(String firstName){
        int counter = 0;
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] != null){
                if(firstName.compareTo(this.Students[i].get_firstName()) == 0){
                    print_student_found(i);
                    counter++;
                }
            }
        }
        if(counter == 0){
            System.out.println("\nNo student found.\n");
        }
    }

    public void find_student_by_lastName(String lastName){
        int counter = 0;
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] != null){
                if(lastName.compareTo(this.Students[i].get_lastName()) == 0){
                    print_student_found(i);
                    counter++;
                }
            }
        }
        if(counter == 0)
        System.out.println("\nNo student found.\n");
    }

    public void find_student_by_gradeLevel(int gradeLevel){
        int counter = 0;
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] != null){
                if(gradeLevel == this.Students[i].get_gradeLevel()){
                    print_student_found(i);
                    counter++;
                }
            }
        }
        if(counter == 0)
        System.out.println("\nNo student found.\n");
    }

    public void find_student_by_gpa(double gpa){
        int counter = 0;
        sort_byGPA();
        for(int i = 0; i < this.Students.length; i++){
            if(this.Students[i] != null){
                if(gpa == this.Students[i].get_GPA()){
                    print_student_found(i);
                    counter++;
                }
            }
        }
        if(counter == 0)
            System.out.println("\nNo student found.\n");
    }

    public void print_student_found(int i){
        System.out.println();
        System.out.println("Student Found: ");
        System.out.println(this.Students[i]);
        System.out.println();
    }

    public void sort_byGPA() {
        Student holder;
        for (int i = 0; i < this.Students.length - 1; i++) {
            for (int j = 0; j < this.Students.length - i - 1; j++) {
                if (this.Students[j].get_GPA() < this.Students[j + 1].get_GPA()) {
                    holder = this.Students[j];
                    this.Students[j] = this.Students[j + 1];
                    this.Students[j + 1] = holder;
                }
            }
        }
    }

    public void sort_byfirstName() {
        if (this.Students == null || this.Students.length <= 1)
            return;
        Student holder;
        boolean swapped;
        for(int i = 0; i < this.Students.length - 1; i++){
            swapped = false;
            for(int j = 0; j < this.Students.length - i - 1; j++){
                if(this.Students[j].get_firstName().compareTo(this.Students[j + 1].get_firstName()) > 0){
                    holder = this.Students[j];
                    this.Students[j] = this.Students[j+1];
                    this.Students[j + 1] = holder;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public void sort_by_lastName() {
        if (this.Students == null || this.Students.length <= 1)
            return;
        Student holder;
        boolean swapped;
        for(int i = 0; i < this.Students.length - 1; i++){
            swapped = false;
            for(int j = 0; j < this.Students.length - i - 1; j++){
                if(this.Students[j].get_lastName().compareTo(this.Students[j + 1].get_lastName()) > 0){
                    holder = this.Students[j];
                    this.Students[j] = this.Students[j+1];
                    this.Students[j + 1] = holder;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}