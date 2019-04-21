package Tests;

import GradeBook.GradeBook;
import Subject.Subject;
import org.junit.jupiter.api.Assertions;
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
}