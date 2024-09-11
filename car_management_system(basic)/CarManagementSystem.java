package oop;

// Simple version of the "Car Management System Activity"

public class CarManagementSystem {

    // Private Attribute:
    private Car[] database;
    // maghimo syag array of car objects (or group of cars)
    // set to 'private' sya para ma 'encapsulate' or mas ma secure

    // Constructor method: diri mag base kung mag instantiate ug object sa main
    public CarManagementSystem(int size){
        this.database = new Car[size];
        System.out.println("\nDatabase of size " + size + " created.\n");
    }// example:  CarManagementSystem cms = new CarManagementSystem(10);

    // Getter Method: returns the length of the Car Management System's database
    public int get_database_length(){
        return this.database.length;
    }   // example:         System.out.println("Length of car array: " + cms.get_database_length());

    // Getter method: returns the car object in a specific index
    public Car get_car(int index){
        return database[index];
    }   // example:         System.out.println(cms.get_car(2).get_brand());

    public void add_car(int index, Car car){
        this.database[index] = car;
    }   // example:         car1.add_car(0, car1);      <--     adds car1 in index 1

    public void remove_car(int index){
        this.database[index] = null;
    }   // example:         car1.remove_car(0);         <--     removes car1 in index 1

    // This method shows the difference of years between 2 cars (gamiton sa main)
    public void compare_cars(Car car1, Car car2){
        int difference = Math.abs(car1.get_year() - car2.get_year());     // Math.abs makes the answer always positive
        System.out.print("\n" + car1.get_brand() + " model " + car1.get_model());
        System.out.print(" is " + difference + " year/s. apart from ");
        System.out.print(car2.get_brand() + " model " + car2.get_model());
        // example:         cms.compare_cars(car1, car2);
    }   // sample output:   "Mitsubishi model 46F234 is 7 years apart from Toyota model QZ23534"
}
