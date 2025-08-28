import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class ConvertPowerToolsToCardKingdom{
    static Scanner file;
    static SetNameChecker setNameChecker = new SetNameChecker();

    public static void main(String[] args) {
        //open file
        loadFile(args[0]);
        //write to new file
        makeFiles();
    }

    public static void loadFile(String filename){
        try{
            file = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            System.out.println("Ooopsie whoopsie! You made a fuckie wuckie! "+filename+" doesn't exist bro.");
            System.exit(1);
        }
    }

    public static void makeFiles(){
        //Skip the first line
        file.nextLine();
        int lineCounter = 0;
        int fileCounter = 0;
        PrintWriter newFile = null;
        //Define the CSV diveder as ","
        char doubleQuotes = '"';
        char[] dividerArray = {doubleQuotes,',',doubleQuotes};
        String divider = new String(dividerArray);

        while (file.hasNextLine()){
            //Make a new file every 500 lines
            if (lineCounter == 0){
                try{
                    newFile = new PrintWriter("CKfile"+fileCounter+".csv");
                    fileCounter++;
                } catch (Exception e){
                    System.out.println("Ahhh!! We could not make another file after file "+fileCounter);
                    System.exit(1);
                }
            }


            //turn the string into an array
            String[] line = file.nextLine().strip().split(divider);
            //Declare the string to print to the CardKingdom File
            String cardKingdomLine;
            //CK format:  title, set, foil, quantity
            //get the title
            cardKingdomLine = doubleQuotes+line[2].substring(0, line[2].length())+doubleQuotes;
            //get the set
            String setName = line[3].substring(0, line[3].length());
            cardKingdomLine += ","+setNameChecker.check(setName);
            //set foil or not
            if (line[8].substring(0, line[8].length()).equals("true")){
                cardKingdomLine += ","+"true";
            } else{
                cardKingdomLine += ","+"false";
            }
            //get quantitiy
            cardKingdomLine += ","+line[1].substring(0, line[1].length() );
            //Add the new line to the file
            newFile.println(cardKingdomLine);
            

            //increment the lineCounter
            lineCounter++;
            //After printing 500 lines, reset the count.  This will cause a new file to be created
            if (lineCounter == 500){
                newFile.close();
                lineCounter = 0;
            }
        }
        if (lineCounter != 0) newFile.close();
    }
}