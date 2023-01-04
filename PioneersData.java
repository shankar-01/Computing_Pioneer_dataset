/**
 * PioneersData class
 * take filename and read data from file with the help of scanner and file reader class then store on queue
 * convert binary data into string (ascii) with the help of convert class methods
 * sort data according to first name with the help of sort class method
 * display data in formatted form with the help of string's repeat and format method
 * store data in csv file with the help of csv file
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PioneersData {
    /**
     * filename var: contain file name of file
     * pioneers is queue of pioneer's object for more info check pioneer class
     *
     *  These variable help us in display method for formatting
     * maxFname var: store length of maximum size first name
     * maxLname var: store length of maximum size last name
     * maxNotor var: store length of maximum size notoriety
     *
     * */
    private Queue<Pioneer> pioneers = null;
    private String filename = null;
    private int maxFnameLen = 0;
    private int maxLnameLen = 0;
    private int maxNotor = 0;
    /**
     * take filename as argument and call readData method
     * */
    public PioneersData(String filename){
        this.filename = filename;
        readData();
    }
    /**
     * readData read data from file
     * first it count number of lines so that we can create queue (we need queue size)
     * create pioneers queue
     * read data from file line by line spilt it using string's split method (split method take ',' as argument)
     * string will be split into 3 parts, change 1st two parts into spring (ascii)
     * during reading that find maxFname, maxLname, and maxNotor (see above comments)
     * */
    private void readData(){
        try {

            Scanner scanner = new Scanner(new File(filename));
            int numOfPioneer = 0;
            while (scanner.hasNextLine()){
                numOfPioneer++;
                scanner.nextLine();
            }

            scanner = new Scanner(new File(filename));
            pioneers = new Queue<Pioneer>(numOfPioneer);
            while (scanner.hasNextLine()){
                String[] fields = scanner.nextLine().split(",");

                if (fields.length == 3){
                    fields[0]= binToString(fields[0]);
                    fields[1]= binToString(fields[1]);
                    pioneers.enqueue(new Pioneer(fields[0], fields[1], fields[2]));

                    if (fields[0].length() > maxFnameLen)
                        maxFnameLen = fields[0].length();
                    if (fields[1].length() > maxLnameLen)
                        maxLnameLen = fields[1].length();
                    if (fields[2].length() > maxNotor)
                        maxNotor = fields[2].length();
                }
                else {
                    System.out.println("Invalid entry in file.");
                }
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Error : " + e.getMessage());
        }catch (Exception e){
            System.out.println(e);
        }
    }
    /**
     * change binary to string (ascii), it take binary string as argument
     * split string w.r.t ';'
     * string split into several parts each part will contain binary string of length 8 (1 byte)
     * change each byte into ascii character and concatenate into empty string
     * return that string
     * */
    private String binToString(String bin){
        String str = "";
        Convert convert = new Convert();
        for (String charBin: bin.split(";") ){
            str += convert.convertToChar(convert.convertToDec(charBin));
        }
        return str;
    }
    /**
     * formatted result
     * draw line with '-' character, print fields name , draw line
     * dequeue element from pioneers queue display it and then enqueue it again (repeat it for pioneers queue size)
     * draw line
     * */
    public void display(){
        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
        System.out.println(String.format("| %-"+maxFnameLen+"s | %-"+maxLnameLen+"s | %-"+maxNotor+"s |", "Firstname", "Lastname", "Notoriety"));
        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
        for (int i=0; i<pioneers.getQueueSize(); i++){
            Pioneer p = pioneers.dequeue();
            System.out.println(String.format("| %-"+maxFnameLen+"s | %-"+maxLnameLen+"s | %-"+maxNotor+"s |", p.getFirstName(), p.getSecondName(), p.getNotoriety()));
            pioneers.enqueue(p);
        }
        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
    }
    /**
     * store data in csv file
     * take file name
     * write fields name in file
     * dequeue element from pioneers queue write it in file and then enqueue it again (repeat it for pioneers queue size)
     * flust and close writer
     * */
    public void storeInFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name : ");
        String file = scanner.nextLine();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file+".csv");
            fileWriter.write("firstname,lastname,notoriety\n");
            for (int i = 0; i < pioneers.getQueueSize(); i++) {
                Pioneer p = pioneers.dequeue();
                fileWriter.write(p.getFirstName() + "," + p.getSecondName() +"," + p.getNotoriety() + "\n");

                pioneers.enqueue(p);
            }
            fileWriter.flush();
            fileWriter.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    /**
     * create array of pioneer which has same size as pioneers queue
     * dequeue element from pioneers queue store it in array at its approprite position and then enqueue it again (repeat it for pioneers queue size)
     * sort array and display it
     * */
    public void displaySort(){
        Pioneer[] arr = new Pioneer[pioneers.getQueueSize()];
        for (int i = 0; i < pioneers.getQueueSize(); i++) {
            arr[i] = pioneers.dequeue();
            pioneers.enqueue(arr[i]);
        }
        Sort<Pioneer> sort = new Sort<>();
        sort.sort(arr);

        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
        System.out.println(String.format("| %-"+maxFnameLen+"s | %-"+maxLnameLen+"s | %-"+maxNotor+"s |", "Firstname", "Lastname", "Notoriety"));
        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
        for (int i=0; i<arr.length; i++){
            System.out.println(String.format("| %-"+maxFnameLen+"s | %-"+maxLnameLen+"s | %-"+maxNotor+"s |", arr[i].getFirstName(), arr[i].getSecondName(), arr[i].getNotoriety()));
        }
        System.out.println("-".repeat(maxFnameLen+maxLnameLen+maxNotor+10));
    }
}
