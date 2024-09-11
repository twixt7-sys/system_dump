package oop;

// Simple version of the "Car Management System Activity"

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // creates an array(or database) of cars
        System.out.print("Please enter database size: ");
        CarManagementSystem cms = new CarManagementSystem(sc.nextInt());
        // ang size sa car management system database kay depende sa integer nga ienter ni user

        sc.nextLine();  //pang prevent ug specific nga bug

        // creates and adds car objects into the array
        for(int i = 0; i < cms.get_database_length(); i++){     // magrepeat ang loop based sa size ni cms
            // magprompt kay user sa attributes sa car nga i add
            System.out.println();   //for spacing
            System.out.print("Brand: \t");
            String brand = sc.nextLine();
            System.out.print("Model: \t");
            String model = sc.nextLine();
            System.out.print("Year: \t");
            int year = sc.nextInt();
            sc.nextLine();  //pang prevent ug specific nga bug
            System.out.print("Color: \t");
            String color = sc.nextLine();
            System.out.println();   //for spacing
            // Adds the prompted car into the array (or database)
            cms.add_car(i, new Car(brand, model, year, color));
        }

        System.out.println("Starting engines: ");
        for(int i = 0; i < cms.get_database_length(); i++){     // magrepeat ang loop based sa size ni cms
            cms.get_car(i).start_engine();
        }
        System.out.println();   //for spacing

        System.out.println("Dislaying information:");
        for(int i = 0; i < cms.get_database_length(); i++){     // magrepeat ang loop based sa size ni cms
            cms.get_car(i).display_info();
        }
        System.out.println();   //for spacing

        // Bonus
        System.out.println("Comparing two cars");
        System.out.print("Please enter the index of the first car: ");
        int num1 = sc.nextInt();
        System.out.print("Please enter the index of the second car: ");
        int num2 = sc.nextInt();
        cms.compare_cars(cms.get_car(num1), cms.get_car(num2));
    }
}
