import com.example.task.model.Person;
import com.example.task.service.PersonService;
import com.example.task.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceTest {

    private PersonService personServiceImpl=new PersonServiceImpl();

    @Test
    public void testAddPerson(){

        Person person = new Person(100,"test",1);
        assertEquals(person,personServiceImpl.addPerson(person));
        personServiceImpl.deletePerson(100);
    }

    @Test
    public void testDeletePerson(){

        Person person = new Person(100,"test",1);
        personServiceImpl.addPerson(person);
        assertEquals(100,personServiceImpl.deletePerson(100));
    }

    @Test
    public void testDeleteNotExistsPerson(){
        assertEquals(-1,personServiceImpl.deletePerson(1000));
    }
}
