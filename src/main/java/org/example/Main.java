package org.example;



import businessobjects.*;
import builders.*;
import commands.*;
import java.beans.PropertyChangeListener;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductProcessPipeline pipeline = new ProductProcessPipeline();
    private static final CEO ceo = new CEO("Wigell");
    private static Object lastCreatedItem;
    private static Customer customer;


    public static void main(String[] args) {


        customer = new Customer();

        System.out.println("Welcome to Wigell's Clothes-on-Demand Shop");
        customer.setName(readString("Please enter your name:"));
        customer.setAddress(readString("Please enter your address:"));
        customer.setEmail(readString("Please enter your email:"));


        ceo.addPropertyChangeListener(event -> {
            System.out.println("Notification to CEO: " + event.getPropertyName() + " changed.");
        });

        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Create Pants");
            System.out.println("2. Create Skirt");
            System.out.println("3. Create T-Shirt");
            System.out.println("4. Print Last Created Item Details");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createPants();
                    break;
                case 2:
                    createSkirt();
                    break;
                case 3:
                    createTShirt();
                    break;
                case 4:
                    printLastItemDetails();
                    break;
            }
        } while (choice != 0);
    }

    private static void createPants() {
        System.out.println("Creating Pants...");
        String material = readString("Enter material (Cotton/Polyester):");
        String type = readString("Enter type (Regular/Shorts/LongShorts):");
        String fit = readString("Enter fit (Slim/Regular/Baggy):");
        String color = readString("Enter color:");
        double price = readDouble("Enter price:");

        PantsBuilder builder = new PantsBuilder(ceo);
        Pants pants = builder.addMaterial(material).addType(type).addFit(fit).addPrice(price).build();

        SetColorCommand setColorCommand = new SetColorCommand(pants, color);
        SetMaterialCommand setMaterialCommand = new SetMaterialCommand(pants, material);
        SetPriceCommand setPriceCommand = new SetPriceCommand(pants,price);

        pipeline.addCommand(setColorCommand);
        pipeline.addCommand(setMaterialCommand);
        pipeline.addCommand(setPriceCommand);

        pipeline.executeCommands();
        lastCreatedItem = pants;

        System.out.println("Pants created: " + pants.toString());

    }
    private static void createSkirt() {
        System.out.println("Creating Skirt...");
        String material = readString("Enter material (Cotton/Polyester):");
        String pattern = readString("Enter pattern (Checkers/Circles/Flowers):");
        String color = readString("Enter color:");
        int waistline = readInt("Enter waistline size:");
        double price = readDouble("Enter price:");

        SkirtBuilder skirtBuilder = new SkirtBuilder(ceo);
        Skirt skirt = skirtBuilder.addMaterial(material).addPattern(pattern).addWaistline(waistline).addPrice(price).build();

        SetColorCommand setColorCommand = new SetColorCommand(skirt, color);
        SetMaterialCommand setMaterialCommand = new SetMaterialCommand(skirt, material);
        SetPriceCommand setPriceCommand = new SetPriceCommand(skirt,price);
        pipeline.addCommand(setColorCommand);
        pipeline.addCommand(setMaterialCommand);
        pipeline.addCommand(setPriceCommand);
        pipeline.executeCommands();
        lastCreatedItem = skirt;


        System.out.println("Skirt created: " + skirt.toString());
    }

    private static void createTShirt() {
        System.out.println("Creating T-Shirt...");
        String material = readString("Enter material (Cotton/Polyester):");
        String color = readString("Enter color:");
        int sleeves = readInt("Enter sleeve length (in cm):");
        int neck = readInt("Enter neck size (in cm):");
        double price = readDouble("Enter price:");

        TShirtBuilder tShirtBuilder = new TShirtBuilder(ceo);
        TShirt tShirt = tShirtBuilder.addMaterial(material).addSleeve(sleeves).addNeck(neck).addPrice(price).build();

        SetColorCommand setColorCommand = new SetColorCommand(tShirt, color);
        SetMaterialCommand setMaterialCommand = new SetMaterialCommand(tShirt, material);
        SetPriceCommand setPriceCommand = new SetPriceCommand(tShirt,price);
        pipeline.addCommand(setColorCommand);
        pipeline.executeCommands();
        pipeline.addCommand(setMaterialCommand);
        pipeline.addCommand(setPriceCommand);
        lastCreatedItem = tShirt;



        System.out.println("T-Shirt created: " + tShirt.toString());

    }



    private static void printLastItemDetails() {
        if (lastCreatedItem != null) {

            System.out.println("Receipt for Customer:");
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("-------------------------------------------");


            if (lastCreatedItem instanceof Pants) {
                Pants pants = (Pants) lastCreatedItem;
                System.out.println("Last created Pants details: " + pants.toString());
            } else if (lastCreatedItem instanceof Skirt) {
                Skirt skirt = (Skirt) lastCreatedItem;
                System.out.println("Last created Skirt details: " + skirt.toString());
            } else if (lastCreatedItem instanceof TShirt) {
                TShirt tShirt = (TShirt) lastCreatedItem;
                System.out.println("Last created T-Shirt details: " + tShirt.toString());
            }
        } else {
            System.out.println("No items have been created yet.");
        }
    }



    private static String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a valid number.");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    private static double readDouble(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("That's not a valid number. Please enter a valid number.");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }

}
