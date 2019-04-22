package Tests;
import Subject.Subject;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {
    Subject marks;

    SubjectTest(){
        try {
            marks = new Subject("Chemia");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

    }
    @Test
    void create(){
        assertAll(
                ()->assertEquals("Chemia",marks.name)
        );
    }

    @Test
    void validateName(){
        assertTrue(Subject.validateName("Chemia"));
    }

}