package streams;

import models.Department;
import models.Worker;

import java.util.*;
import java.util.stream.Collectors;

public class WorkerSt {

    private Department department;


    public WorkerSt(Department department   ) {
        this.department = department;
    }

    public List<Worker> getListWorker(String education){
        return department.getWorker().stream().filter(education1->education1.getEducation().equals(education)).collect(Collectors.toList());
    }

    public SortedMap<Worker, Long> getSortedWorkersByEducation(boolean ascending){
        SortedMap<Worker, Long> result = new TreeMap<>((a, b) ->
                ascending ? a.getEducation().compareTo(b.getEducation()):b.getEducation().compareTo(a.getEducation()));

        //result.putAll(worker.getPhoneNumber());
        return result;
    }

    public Long countWorker(){
        return department.getWorker().stream().count();
    }

    public List<Worker> sortedWorkerByBirthDate(){
        List<Worker> sortWorkers = new ArrayList<>();
        sortWorkers.stream()
                .sorted(Comparator.comparing(Worker::getDateOfBirth, Comparator.nullsLast(Comparator.reverseOrder())));
        sortWorkers.addAll(department.getWorker());
        return sortWorkers;
    }


    public List<Worker> sortedWorkerByPassportNumber(){
        List<Worker> sortWorkers = new ArrayList<>();
        sortWorkers.stream()
                .sorted(Comparator.comparing(Worker::getPassportNumber, Comparator.nullsLast(Comparator.reverseOrder())));
        sortWorkers.addAll(department.getWorker());
        return sortWorkers;
    }

    public List<Worker> sortedWorkerByHiringDate(){
        List<Worker> sortWorkers = new ArrayList<>();
        sortWorkers.stream()
                .sorted(Comparator.comparing(Worker::getDateOfHiring, Comparator.nullsLast(Comparator.reverseOrder())));
        sortWorkers.addAll(department.getWorker());
        return sortWorkers;
    }
}

