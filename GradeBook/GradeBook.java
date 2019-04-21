package GradeBook;
import Subject.Subject;

import java.util.ArrayList;

public class GradeBook {
    public ArrayList<Subject> subjects;
    public String name;
    public  String lastName;
    public long index;

    public GradeBook(String name, String lastName, long index) throws Exception {

        validateIndex(index);
        validateLastName(lastName);
        validateName(name);
        this.name=name;
        this.lastName=lastName;
        this.index=index;
    }
    static void  validateName(String name) throws Exception{
        if(name==null||name.length()<2){
            throw new Exception("Cos jest nei tak z imieniem");
        }
    }
    static void  validateLastName (String lastName)throws Exception{
        if(lastName==null||lastName.length()<2){
            throw new Exception("Cos jest nei tak z nazwiskiem");
        }
    }
    static  void  validateIndex (long index)throws Exception{
        if (index<0){
            throw new Exception("Cos jest nei tak z indexem");
        }
    }
}
