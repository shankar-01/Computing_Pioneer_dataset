/**
 * convert byte (string type binary) to decimal
 * convert decimal to ascii
 * */
public class Convert {
    /**
     * push each character into stack separately
     * create a variable power2 which in intial 1
     * then pop each character from stack and check if it is one add power2 into decValue(output of method) and in each cycle double power2
     * return decValue(output : binary in int)
     * */
    public int convertToDec(String binValue){
        int decValue = 0;
        Stack stack = new Stack(8);
        for (char c: binValue.toCharArray()) {
            stack.push(c);
        }
        int power2 = 1;
        while (!stack.isEmpty()){
            if (stack.pop().equals('1')){
                decValue += power2;
            }
            power2 *= 2;
        }
        return decValue;
    }
    /**
     * take integer as argument
     * type cast it to char store it in other variable and return it
     * */
    public char convertToChar(int decValue){
        char letter = ' ';
        letter = (char)decValue;
        return letter;
    }
}
