import java.util.HashMap;

public class SetNameChecker {
    //create reference to setName HashMap
    //Format is Cardmarket name : Card Kingdom name
    private HashMap<String,String> setNames = new HashMap<String,String>();

    //Initialize the HashMap when we create a SetNameChecker
    SetNameChecker(){
        //Put set names in the HashMap
        setNames.put("Adventures In The Forgotten Realms: Extras", "Adventures In The Forgotten Realms Varients");
        setNames.put("Commander: Innistrad: Midnight Hunt", "Innistrad: Midnight Hunt Commander Decks");
        setNames.put("Commander: Ikoria", "Commander 2020");
        setNames.put("Commander: Strixhaven", "Commander 2021");
        setNames.put("Commander Masters: Extras", "Commander Masters");
        setNames.put("Core 2020", "Core Set 2020");
        setNames.put("Core 2021", "Core Set 2021");
        setNames.put("Dominaria Remastered: Extras", "Dominaria Remastered Variants");
        setNames.put("Enchanting Tales", "Wilds of Eldraine Enchanting Tales");
        setNames.put("Magic: The Gathering Foundations", "Foundations");
        setNames.put("Mystery Booster", "Mystery Booster/The List");
        setNames.put("The List", "Mystery Booster/The List");
        setNames.put("Time Spiral Remastered: Extras", "Time Spiral Remastered");
    }

    //Check() checks if a set name is in the setName HashMap
    //If not, it returns the orginal string immediately
    //If the set name is present, is returns the value in the setName HashMap
    public String check(String cardmarketSetName){
        if (!setNames.containsKey(cardmarketSetName)){
            return cardmarketSetName;
        }

        //return the Card Kingdom set name
        return setNames.get(cardmarketSetName);
    }
}
