import java.util.Arrays;


public class String_Calculator {


    public  static int Addv2(String inputString) throws Exception {
        if(!inputString.isEmpty()){

            if(inputString.matches("[\\w~`!@#$%^&()\\-?+{}\\[<>\\]\\./]+[\\W\\w]\\n?[[^1-9]\\d{3}\\w\\W]*")) {
                int sum = 0;

                if(!inputString.contains("\n")){
                    if(!inputString.contains("-")) {

                        inputString = inputString.replaceAll("[^\\d]", "");
                        char[] characters = inputString.toCharArray();

                        for (int i = 0; i < characters.length; i++) {

                            int[] numbers = new int[characters.length];
                            numbers[i] = Character.getNumericValue(characters[i]);
                            sum += numbers[i];
                        }

                        return sum;

                    }else {
                        throw new Exception("'ERROR: negatives not allowed -1,-2");
                    }
                }

                if(inputString.substring(0,inputString.indexOf("\n")).length() < 2){

                    inputString = inputString.replaceAll("[^\\d]","");
                    char[] characters = inputString.toCharArray();

                    for (int i = 0; i < characters.length; i++) {

                        int[] numbers = new int[characters.length];
                        numbers[i] = Character.getNumericValue(characters[i]);
                        sum += numbers[i];
                    }

                    return  sum;
                }

                String rightString = inputString;
                inputString = inputString.substring(0,inputString.indexOf("\n"));
                inputString = inputString.replaceAll("[\\[\\]//]","");
                char[] unwantedChars = inputString.toCharArray();
                rightString  = rightString.substring(rightString.indexOf("\n") + 1);

                if(rightString.matches(".1\\d{3}.")) {
                    rightString =  rightString.substring(4);
                }

                char[] wantedString = rightString.toCharArray();

                for(int i=0; i<unwantedChars.length; i++){
                    for(int j =0; j<wantedString.length; j++){
                        if(unwantedChars[i] == wantedString[j]){
                            wantedString[j] =',';
                        }
                    }
                }
                String wantedNumbers = Arrays.toString(wantedString);
                wantedNumbers = wantedNumbers.replaceAll("[\\D]","");

                char[] FilteredNumbers = wantedNumbers.toCharArray();

                for (int i = 0; i < FilteredNumbers.length; i++) {

                    int[] numbers = new int[FilteredNumbers.length];
                    numbers[i] = Character.getNumericValue(FilteredNumbers[i]);
                    sum += numbers[i];
                }

                return sum;

            }else{
                throw new Exception("Invalid Input");
            }
        }
        return  0;
    }
    public static void main(String[] Args) throws Exception {

        System.out.println(Addv2("//[abc][777][:(]\n1abc27773:(1"));

    }
}


