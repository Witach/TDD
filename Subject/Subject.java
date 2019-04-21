package Subject;

import java.util.ArrayList;

public class Subject {
    public String name;
    public ArrayList<Double> marks;
    public Subject(String name) throws Exception{
        if(!validateName(name))
            throw new Exception("Coś jest nie tak z  nazwą przedmiotu");
        this.name=name;
    }
    public static boolean validateName(String name){
        if(name.length()<2){
            return false;
        }
        return true;
    }
}
