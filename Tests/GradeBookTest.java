package Tests;

import GradeBook.GradeBook;
import Subject.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest {
    GradeBook marks;

    GradeBookTest() throws Exception {
        try{
            marks= new GradeBook("Dawid","Witaszek",215920);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    @BeforeEach
    void addition() throws Exception{
        marks.addSubject(new Subject("Fizyka"));
    }
    @Test
    void createThrows(){
        assertAll(
                ()->assertThrows(Exception.class,()->new GradeBook("2","21",-2)),
                ()->assertThrows(Exception.class,()->new GradeBook("","2133",2))
        );
    }
    @Test
    void create(){
        assertAll(()->assertEquals("Dawid",marks.name),
                ()->assertEquals("Witaszek",marks.lastName),
                        ()->assertEquals(215920,marks.index));
    }

    @Test
    void getSubjectThrow(){
        assertThrows(Exception.class,()->marks.getSubject("Chemia"));
    }

    @Test
    void getSubject() throws Exception {
        marks.addSubject(new Subject("Chemia"));
        assertEquals("Chemia",marks.getSubject("Chemia").name);
    }

    @Test
    void addSubjectThrow() throws Exception{
        marks.addSubject(new Subject("Chemia"));
        assertThrows(Exception.class,()->marks.addSubject(new Subject("Chemia")));
    }

    @Test
    void addSubject() throws Exception{
        marks.addSubject(new Subject("Chemia"));
        assertEquals("Chemia",marks.getSubject("Chemia").name);
    }
    @Test
    void addMark() throws Exception {
        marks.addMark("Fizyka",3);
        Subject tmp = null ;
        for(Subject i:marks.subjects){
            if(i.name=="Fizyka") {
                tmp = i;
                break;
            }
        }
        assertNotNull(tmp);
       double a = tmp.marks.get(0);
       assertEquals(3,a);
    }

    @Test
     void addMarkThrow(){
        assertAll(
                ()->assertThrows(Exception.class,()->marks.addMark("",3)),
                ()->assertThrows(Exception.class,()->marks.addMark("Chemia",0))
        );
    }

    @Test
    void calcAvgFromSubject() throws Exception{
        double[] marks_list = {3, 3.5, 2.5, 1, 6};
        for(double i: marks_list){
            marks.addMark("Fizyka",i);
        }
        assertEquals(3.2,marks.calcAvgFromSubject("Fizyka"));
    }

    @Test
    void calcAvgFromSubjectThrow(){
        assertAll(
                ()->assertThrows(Exception.class,()->marks.calcAvgFromSubject("Chemia")),
                ()->assertThrows(Exception.class,()->marks.calcAvgFromSubject("Fizyka"))
        );
    }

    @Test
    void clacAvg() throws Exception{
        double[] marks_list = {3, 3.5, 2.5, 1, 6};
        for(double i: marks_list){
            marks.addMark("Fizyka",i);
        }
        marks.addSubject(new Subject("Chemia"));
        marks_list = new double[]{2.5, 2.0, 2.5, 2.5, 2.5, 5.5, 3.5, 1.5};
        for(double i: marks_list){
            marks.addMark("Chemia",i);
        }
        assertEquals(3.00625,marks.clacAvg());
    }

    @Test
    void calcAvgThrow(){
        assertThrows(Exception.class,()->new GradeBook("Dawid","Witaszek",21599).clacAvg());
    }

    @Test
    void calcAvgThrow2(){
        assertThrows(Exception.class,()->marks.clacAvg());
    }

}