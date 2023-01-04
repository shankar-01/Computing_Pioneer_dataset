/**
 * main method
 * display menus : display data, display sorted data, store data in csv file, exit, display menu
 * take choice and call appropriate method.
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PioneersData pioneer = new PioneersData("ComputingPioneers.txt");

        displayMenu();

        int num = 0;
        while (true) {
            System.out.print("Enter your choice : ");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    pioneer.display();
                    break;
                case 2:
                    pioneer.displaySort();
                    break;
                case 3:
                    pioneer.storeInFile();
                    break;
                case 4:
                    return;
                default:
                    displayMenu();
            }
        }
    }
    static void displayMenu(){
        System.out.println("Menu");
        System.out.println("1 : Display data.");
        System.out.println("2 : Display sorted data.");
        System.out.println("3 : Store data in csv file.");
        System.out.println("4 : exit");
        System.out.println("Enter any other number to see menu.");
    }
}
