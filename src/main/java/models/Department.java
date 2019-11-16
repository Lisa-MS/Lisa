package models;

import java.util.List;
import java.util.Objects;


public class Department {
    /*
     *This method has fields such as:
     *department number (id), departmentname and head

     */
    private int id;
    private String name;
    private Worker head;
    private List<Worker> worker;

//    {
//        "name": "Dep1",
//            "id": 1,
//            "head": {"id":1, "name" : "HEEEEAD", "dateOfBirth" : "2019-01-01", "phoneNumber": 656565}",
//            "worker": []
//    },


    public Department() {super();
    name="kkkk";}
    /*
     *This is constryctors
     */

    public Department(int id, String departamentname, Worker head, List<Worker> worker ) {
        this.id = id;
        this.name = departamentname;
        this.head = head;
        this.worker=worker;
    }

    /*
     *This method is used to obtain
     * the Id value
     */

    public int getId() {
        return id;
    }
    /*
     *This method is used to receiving
     * the Id value
     */


    public void setId(int id) {
        this.id = id;
    }
    /*
     *This method is used to obtain
     * the Id value
     */


    public String getName() {
        return name;
    }
    /*
     *This method is used to provide
     * departmentname
     */


    public void setName(String name) {
        this.name = name;
    }

    public Worker getHead() {
        return head;
    }

    public void setHead(Worker head) { this.head = head;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> woker) { this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                name.equals(that.name) &&
                head.equals(that.head) &&
                worker.equals(that.worker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, head, worker);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departamentname='" + name + '\'' +
                ", head=" + head +
                ", worker=" + worker +
                '}';
    }

    public static class Builder{
        private Department newDepartment;

        public Builder() {
            newDepartment = new Department();
        }
        public Builder withId(int id){
            newDepartment.id = id;
            return this;
        }
        public Builder withDepartmentName(String departmentname){
            newDepartment.name = departmentname;
            return this;
        }
        public Builder withHead(Worker head){
            newDepartment.head = head;
            return this;
        }
        public Builder withWorker(List<Worker> worker){
            newDepartment.worker = worker;
            return this;
    }
}}