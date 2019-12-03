package models;

import adapter.LocaleDateAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;


@XmlRootElement(name = "Worker")
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    /*
     *This method has fields such as:
     *airport number (id), name and head

     */
    @XmlElement
    @NotNull
    private Long id;

    @XmlElement
    @NotNull(message = "Name worker must be not null")
    @Size(min = 5, max = 32, message ="{Size.name}" )
    private String name;

    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    @NotNull(message = "DateOfBirth must be not null")
    private LocalDate dateOfBirth;

    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    @NotNull(message = "DateOfHiring must be not null")
    private LocalDate dateOfHiring;

    @XmlElement
    @NotNull(message = "PhoneNumber must be not null")
    @Size( max = 10, message ="{Size.phoneNumber}" )
    private int phoneNumber;

    @XmlElement
    @NotNull(message = "PasportNumber must be not null")
    @Size( max = 8, message ="{Size.passportNumber}" )
    private int passportNumber;

    @XmlElement
    @NotNull(message = "Education worker must be not null")
    @Size(min = 5, max = 32, message ="{Size.education}" )
    private String education;


    public Worker() {
    }
    /*
     *This is constryctors
     */

    public Worker(Long id, String name, LocalDate dateOfBirth, LocalDate dateOfHiring, int phoneNumber, int passportNumber, String education) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfHiring = dateOfHiring;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.education = education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Worker worker = (Worker) object;
        return id == worker.id &&
                phoneNumber == worker.phoneNumber &&
                passportNumber == worker.passportNumber &&
                java.util.Objects.equals(name, worker.name) &&
                java.util.Objects.equals(dateOfBirth, worker.dateOfBirth) &&
                java.util.Objects.equals(dateOfHiring, worker.dateOfHiring) &&
                java.util.Objects.equals(education, worker.education);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, dateOfBirth, dateOfHiring, phoneNumber, passportNumber, education);
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfHiring=" + dateOfHiring +
                ", phoneNumber=" + phoneNumber +
                ", passportNumber=" + passportNumber +
                ", education='" + education + '\'' +
                '}';
    }
    public static class Builder{
        private Worker newWorker;

        public Builder() {
            newWorker = new Worker();
        }
        public Builder withId(Long id){
            newWorker.id = id;
            return this;
        }
        public Builder withName(String name){
            newWorker.name = name;
            return this;
        }
        public Builder withDataOfBirth(LocalDate dateOfBirth){
            newWorker.dateOfBirth = dateOfBirth;
            return this;
        }
        public Builder withDateOfHiring(LocalDate dateOfHiring){
            newWorker.dateOfHiring = dateOfHiring;
            return this;
        }
        public Builder withPhoneNumber(int phoneNumber){
            newWorker.phoneNumber = phoneNumber;
            return this;
        }
        public Builder withPassportNumber(int passportNumber){
            newWorker.passportNumber = passportNumber;
            return this;
        }
        public Builder withEducation(String education){
            newWorker.education = education;
            return this;
        }
        public Worker build(){
            return newWorker;
        }
    }
}

