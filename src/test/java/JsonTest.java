import models.Department;
import models.Worker;
import service.Parser;
import service.Writer;
import service.parser.JsonParser;
import service.writer.JsonWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
import com.lillink.parsefourtype.model.*;
import com.lillink.parsefourtype.service.*;
import com.lillink.parsefourtype.service.parser.JsonCompanyParser;
import com.lillink.parsefourtype.service.writer.JsonCompanyWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
*/

public class JsonTest {

   /* @Test
    public void serializeTest(){

        String path = "resume.json";
        Writer<Department> writer = new JsonWriter(path);

        List<Worker> workerList = new ArrayList<Worker>();
        Worker worker1 = new Worker();
        worker1.setId(1);
        worker1.setName("Moiseienko Lisa");
        worker1.setDateOfBirth(LocalDate.parse("2000-08-23"));
        worker1.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker1.setPassportNumber(234567);
        worker1.setPhoneNumber(45647);
        worker1.setEducation("Economist");

        Worker worker2 = new Worker();
        worker2.setId(2);
        worker2.setName("Ilika Katya");
        worker2.setDateOfBirth(LocalDate.parse("2002-10-06"));
        worker2.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker2.setPassportNumber(874569);
        worker2.setPhoneNumber(34578);
        worker2.setEducation("Teacher");

        Worker worker3 = new Worker();
        worker3.setId(3);
        worker3.setName("Grushka Yulia");
        worker3.setDateOfBirth(LocalDate.parse("2001-05-14"));
        worker3.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker3.setPassportNumber(467362);
        worker3.setPhoneNumber(98076);
        worker3.setEducation("Programmer");

        workerList.add(worker1);
        workerList.add(worker2);

        Department department = new Department();
        department.setId(1);
        department.setName("Test");
        department.setHead(worker3);
        department.setWorker(workerList);

    writer.writeToFile(department);

        Parser<Department> parser = new JsonParser(path);
        Department department1 = parser.parse().orElseThrow(RuntimeException::new);

        Assert.assertEquals(department.toString().trim(),department1.toString().trim());
    }*/
}