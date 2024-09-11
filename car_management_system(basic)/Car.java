package oop;

// Simple version of the "Car Management System Activity"

public class Car{
    // Private Attributes:
    private String brand;
    private String model;
    private int year;
    private String color;
    // set to 'private' sya para ma 'encapsulate' or mas ma secure

    // Constructor method: diri mag base kung mag instantiate ug object sa main
    // example:        Car car1 = new Car("Mitsubishi", "F46327", 2004, "Red");
    public Car(String brand, String model, int year, String color){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Public Methods: Methods nga ma access sa main file
    public void start_engine(){
        System.out.println(this.brand + " model " + this.model + " Engine started.");
    }   //example:    car1.start_engine();

    public void stop_engine(){
        System.out.println(this.brand + " model " + this.model + " Engine stopped.");
    }   //example:    car1.stop_engine();

    public void display_info(){
        System.out.println();
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Color: " + this.color);
        System.out.println();
    }   //example:    car1.display_engine();

    // Getter methods: Methods nga maka kuha ug info(or attribute) sa car object
    public String get_brand(){
        return this.brand;
    }   //example:    System.out.println("Brand: " + car1.get_brand());
    public String get_model(){
        return this.model;
    }   //example:    System.out.println("Model: " + car1.get_model());
    public int get_year(){
        return this.year;
    }   //example:    System.out.println("Year: " + car1.get_year());
    public String get_color(){
        return this.color;
    }   //example:    System.out.println("Color: " + car1.get_color());

    // Setter methods: Methods nga maka change ug attribute sa car object
    public void set_brand(String brand){
        this.brand = brand;
    }   //example:    car1.set_brand("Toyota");
    public void set_model(String model){
        this.model = model;
    }   //example:    car1.set_model("B773564");
    public void set_year(int year){
        this.year = year;
    }   //example:    car1.set_year(2004);
    public void set_color(String color){
        this.color = color;
    }   //example:    car1.set_year(2004);
}