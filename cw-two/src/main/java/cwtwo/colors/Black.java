package cwtwo.colors;

import com.google.inject.Singleton;

/**
 * Created by elianne on 21/02/2016.
 */

@Singleton
public class Black extends Color {

    private static Black instance = new Black();

    private void Black(){
        this.name = "Black";
    }

    public static Black getInstance(){
        return instance;
    }

}