package cwtwo;

import com.google.inject.Inject;
import cwtwo.colors.Colour;

import java.util.Hashtable;
import java.util.List;


//@Singleton
public class ColorBank {

    private  Hashtable<Character, Colour> colorBank = new Hashtable<>();
    private  Hashtable<String,Colour> rightOrAlmost = new Hashtable<>();
    private  List<Colour> colours;
    private  Colour[] rightWrong;

    @Inject
    public ColorBank(List<Colour> colours, Colour[] rightOrAlmost) {

        this.colours = colours;
        this.rightWrong = rightOrAlmost;
        fillColorBank();


    }

    public  void fillColorBank() {

        for (Colour colour : colours) {
            colorBank.put(colour.getName().charAt(0), colour);
        }


       rightOrAlmost.put("Right",rightWrong[1]);
       rightOrAlmost.put("Almost",rightWrong[0]);

    }

    public  Colour getColour(int index) {
        return colorBank.get(colorBank.keySet().toArray()[index]);
    }
    public  Colour getColourByKey(Character key) {
        return colorBank.get(key);
    }

    public List<Colour> getColours(){
        return this.colours;
    }

    public  Colour getRight() { return rightOrAlmost.get("Right"); }
    public  Colour getAlmost() { return rightOrAlmost.get("Almost"); }
    
    public  int numColors(){ return colorBank.size(); }



}
