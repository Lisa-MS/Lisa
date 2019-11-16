import models.Department;
import models.Worker;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    private List<Worker> workers = new ArrayList<>();

    private Worker head = new Worker();

    @Before
    public void createWorker(){
        Worker worker1 = new Worker();
        worker1.setId(1);
        worker1.setName("Worker 1");
        worker1.setDateOfBirth(LocalDate.parse("1985-12-31"));
        worker1.setDateOfHiring(LocalDate.parse("2017-12-31"));
        worker1.setPhoneNumber(56742);
        worker1.setPassportNumber(847653);
        worker1.setEducation("Education");
        workers.add(worker1);

        Worker worker2 = new Worker();
        worker2.setId(2);
        worker2.setName("Worker 2");
        worker2.setDateOfBirth(LocalDate.parse("2001-12-31"));
        worker2.setDateOfHiring(LocalDate.parse("2017-06-30"));
        worker2.setPhoneNumber(56879);
        worker2.setPassportNumber(823453);
        worker2.setEducation("Teacher");
        workers.add(worker2);

        head.setId(2);
        head.setName("Worker 3");
        head.setDateOfBirth(LocalDate.parse("1988-12-31"));
        head.setDateOfHiring(LocalDate.parse("2017-04-30"));
        head.setPhoneNumber(56819);
        head.setPassportNumber(828453);
        head.setEducation("Minister");
    }

    @Test
    public void departmentBuilderTest(){
        Department.Builder department = new Department.Builder()
                .withId(1)
                .withDepartmentName("Finance")
                .withHead(head)
                .withWorker(workers);

    }

   /* @Test
    public void setNameException(){
        Worker worker = new Worker();
        worker.setName("bwbvbwkvunwkvnlwvwnvlwjvlwnviwnv");
    }

    @Test
    public void setEducationException(){
        Worker worker = new Worker();
        worker.setEducation("wjjiownviknineiuvnwunignoid");
    }*/
}
