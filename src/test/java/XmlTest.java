
import models.Department;
import models.Worker;
import org.junit.Assert;
import org.junit.Test;
import service.Parser;
import service.Writer;
import service.parser.XmlParser;
import service.writer.XmlWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class XmlTest {
    @Test
    public void serializeTest() {


        String path = "department.xml";
        Writer<Department> writer = new XmlWriter(path);

        List<Worker> workerList = new ArrayList<>();
        Worker worker1 = new Worker();
        worker1.setId(1L);
        worker1.setName("Moiseienko Lisa");
        worker1.setDateOfBirth(LocalDate.parse("2000-08-23"));
        worker1.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker1.setPassportNumber(234567);
        worker1.setPhoneNumber(45647);
        worker1.setEducation("Economist");

        Worker worker2 = new Worker();
        worker2.setId(2L);
        worker2.setName("Ilika Katya");
        worker2.setDateOfBirth(LocalDate.parse("2002-10-06"));
        worker2.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker2.setPassportNumber(874569);
        worker2.setPhoneNumber(34578);
        worker2.setEducation("Teacher");

        Worker worker3 = new Worker();
        worker3.setId(3L);
        worker3.setName("Grushka Yulia");
        worker3.setDateOfBirth(LocalDate.parse("2001-05-14"));
        worker3.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker3.setPassportNumber(467362);
        worker3.setPhoneNumber(98076);
        worker3.setEducation("Programmer");

        workerList.add(worker1);
        workerList.add(worker2);

        Department department = new Department();
        department.setId(1L);
        department.setName("Test");
        department.setHead(worker3);
        department.setWorker(workerList);

        writer.writeToFile(department);


        Parser<Department> parser = new XmlParser(path);
        Department department1 = parser.parse().orElseThrow(RuntimeException::new);


        Assert.assertEquals(department.toString().trim(), department1.toString().trim());
    }
}