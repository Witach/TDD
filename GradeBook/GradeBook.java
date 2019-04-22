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
        subjects = new ArrayList<Subject>();
    }
    public Subject getSubject(String name) throws Exception{
        for(Subject i:subjects){
            if(i.name==name)
                return i;
        }
        throw new Exception("Nie ma takiego przedmiotu");
    }
    public void addSubject(Subject subject) throws Exception{
        for(Subject i: subjects){
            if(i.name.equals(subject.name))
                throw new Exception("Przedmiot o takiej nazwie już istnieje");
        }
        subjects.add(subject);
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
    static  void  validateIndex (long index)throws Exception {
        if (index < 0) {
            throw new Exception("Cos jest nei tak z indexem");
        }
    }

    public void addMark(String name, double mark) throws Exception{
        if(!validateMark(mark))
            throw new Exception("Wprowadzono błędną ocene");
        Subject tmp = getSubject(name);
        tmp.marks.add(mark);
    }
    static boolean validateMark(double mark){
        if(mark<1||mark>6||mark%0.5!=0)
            return false;
        return true;
    }

    public double calcAvgFromSubject(String name) throws Exception{
        Subject tmp = getSubject(name);
        if(tmp.marks.isEmpty())
            throw new Exception("Nie ma ocen w tym przedmiocie");
        double sum=0;
        int length=0;
        for(double i: tmp.marks){
            sum+=i;
            length++;
        }
        return sum/(double)length;
    }

    public double clacAvg() throws Exception{
        if(subjects.isEmpty())
            throw new Exception("nie ma żadnego przedmiotu");
        ArrayList<Double> tmp = new ArrayList<>();
        int len=0;
        for(Subject i:subjects)
            tmp.add(this.calcAvgFromSubject(i.name));
        double sum=0;
        for(double i:tmp){
            len++;
            sum+=i;
        }
        return sum/(double)len;
    }
}
