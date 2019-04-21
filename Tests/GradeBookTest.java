package Tests;

import GradeBook.GradeBook;
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
}