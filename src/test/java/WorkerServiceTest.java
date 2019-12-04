import models.Department;
import models.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import streams.WorkerSt;

import java.time.LocalDate;
import java.util.*;

public class WorkerServiceTest {

    private WorkerSt workerService;

    private Department department = new Department();

    private Worker worker1 = new Worker();

    private Worker worker2 = new Worker();

    private List<Worker> workerList = new ArrayList<>();

    @Before
    public void setUp(){
        worker1.setId(1L);
        worker1.setName("Moiseienko Lisa");
        worker1.setDateOfBirth(LocalDate.parse("2000-08-23"));
        worker1.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker1.setPassportNumber(234567);
        worker1.setPhoneNumber(45647);
        worker1.setEducation("Economist");

        worker2.setId(2L);
        worker2.setName("Ilika Katya");
        worker2.setDateOfBirth(LocalDate.parse("2002-10-06"));
        worker2.setDateOfHiring(LocalDate.parse("2016-01-01"));
        worker2.setPassportNumber(874569);
        worker2.setPhoneNumber(34578);
        worker2.setEducation("Teacher");

        workerList.add(worker1);
        workerList.add(worker2);

        department.setId(1L);
        department.setName("Test");
    }

    @Before
    public void createWorkerService(){
        workerService = new WorkerSt(department);
    }

    @Test
    public void sortWorkersByPassportNumber(){
        department.setWorker(workerList);

        List<Worker> sortedWorkers = workerService.sortedWorkerByPassportNumber();
        List<Worker> expectedSortedWorkers = new ArrayList<>();
        expectedSortedWorkers.add(worker1);
        expectedSortedWorkers.add(worker2);

        Assert.assertEquals(expectedSortedWorkers, sortedWorkers);
    }

    @Test
    public void sortWorkersByBirthDate(){
        department.setWorker(workerList);

        List<Worker> sortedWorkers = workerService.sortedWorkerByBirthDate();
        List<Worker> expectedSortedWorkers = new ArrayList<>();
        expectedSortedWorkers.add(worker1);
        expectedSortedWorkers.add(worker2);

        Assert.assertEquals(expectedSortedWorkers, sortedWorkers);
    }

    @Test
    public void sortWorkersByHiringDate(){
        department.setWorker(workerList);

        List<Worker> sortedWorkers = workerService.sortedWorkerByHiringDate();
        List<Worker> expectedSortedWorkers = new ArrayList<>();
        expectedSortedWorkers.add(worker1);
        expectedSortedWorkers.add(worker2);

        Assert.assertEquals(expectedSortedWorkers, sortedWorkers);
    }

    @Test
    public void countWeaponTypeTest() {
        department.setWorker(workerList);

        long expectedCountWorker = 2;
        long countWorker = workerService.countWorker();
        Assert.assertEquals(expectedCountWorker, countWorker);
    }
}
