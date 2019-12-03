package models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "Department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
    /*
     *This method has fields such as:
     *department number (id), departmentname and head

     */

    @XmlElement
    @NotNull
    private Long id;

    @XmlElement
    @NotNull(message = "Name department must be not null")
    @Size(min = 5, max = 32, message ="{Size.name}" )
    private String name;

    @XmlElement
    @NotNull(message = "Name worker must be not null")
    @Size(min = 5, max = 32, message ="{Size.head}" )
    private Worker head;

    @XmlElement
    @XmlElementWrapper
    @NotNull(message = "Worker must be not null")
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

    public Department(Long id, String departamentname, Worker head, List<Worker> worker ) {
        this.id = id;
        this.name = departamentname;
        this.head = head;
        this.worker=worker;
    }

    /*
     *This method is used to obtain
     * the Id value
     */

    public Long getId() {
        return id;
    }
    /*
     *This method is used to receiving
     * the Id value
     */


    public void setId(Long id) {
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

    public void setWorker(List<Worker> worker) { this.worker = worker;
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
        public Builder withId(Long id){
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