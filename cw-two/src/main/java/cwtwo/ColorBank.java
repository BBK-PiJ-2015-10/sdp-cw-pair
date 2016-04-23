package cwtwo;

import com.google.inject.Inject;
import cwtwo.colors.Colour;

import java.util.Hashtable;
import java.util.List;

/**
 * A class that facilitates the storage of available colors and provides colors.
 */
//@Singleton
public class ColorBank {

    private  Hashtable<Character, Colour> colorBank = new Hashtable<>();
    
    private  Hashtable<String,Colour> rightOrAlmost = new Hashtable<>();
    
    private  List<Colour> colours;
    
    private  Colour[] rightWrong;
    

    /**
     * Constructor for the class.
     * @param colours . The list of input colors to be stored in the colorbank.
     * @param rightOrAlmost . The list of feedback colors to be stored in the colorbank.
     */ 
    @Inject
    public ColorBank(List<Colour> colours, Colour[] rightOrAlmost) {

        this.colours = colours;
        this.rightWrong = rightOrAlmost;
        fillColorBank();

    }

    /**
     * Fills a colorbank.
     */
    public  void fillColorBank() {
        for (Colour colour : colours) {
            colorBank.put(colour.getName().charAt(0), colour);
        }
       rightOrAlmost.put("Right",rightWrong[1]);
       rightOrAlmost.put("Almost",rightWrong[0]);
    }

    /**
     * Returns a color from the colorbank based on an index #.
     * @param index . The index # of the color to be retrieved.
     * @return Colour. A colour based on the index # provided.
     */
    public  Colour getColour(int index) {
        return colorBank.get(colorBank.keySet().toArray()[index]);
    }
    
    /**
     * Returns a color from the colorbank based on a key.
     * @param key . The key of the color to be retrieved. 
     * @return Colour. A colour based on the key provided.
     */
    public  Colour getColourByKey(Character key) {
        return colorBank.get(key);
    }
    
    /**
     * Provides the list of input colours in the colobank.
     * @return a list of colours. The list of colors in the colorbank.
     */
    public List<Colour> getColours(){
        return this.colours;
    }

    /**
     * Provides a color associated with a correct guess.
     * @return Color. Provides a color associated with a correct guess.
     */
    public  Colour getRight() { return rightOrAlmost.get("Right"); }
    
    
    /**
     * Provides a color associated with a guess in the code, but not in the right 
     * position.
     * @return Color. Provides a color associated with a close guess.
     */
    
    public  Colour getAlmost() { return rightOrAlmost.get("Almost"); }
    
    /**
     * Provides the number of colors in the colorbank.
     * @return int. Number of colors in the colorbank.
     */
    public  int numColors(){ return colorBank.size(); }


}
