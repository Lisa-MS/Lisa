package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Objects;

@XmlRootElement(name = "Head")
@XmlAccessorType(XmlAccessType.FIELD)
public class Head {

    @XmlElement
    private  int id;

    @XmlElement
    private String name;

    @XmlElement
    private LocalDate dateOfBirth;

    @XmlElement
    private int phoneNumber;

    public Head() {
    }

    public Head(int id, String name, LocalDate dateOfBirth, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Head head = (Head) o;
        return id == head.id &&
                phoneNumber == head.phoneNumber &&
                Objects.equals(name, head.name) &&
                Objects.equals(dateOfBirth, head.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, phoneNumber);
    }

    @Override
    public String toString() {
        return "Head{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    public static class Builder{
        private Head newHead;

        public Builder() {
            newHead = new Head();
        }
        public Builder withId(int id){
            newHead.id = id;
            return this;
        }
        public Builder withName(String name){
            newHead.name = name;
            return this;
        }
        public Builder withDataOfBirth(LocalDate dateOfBirth){
            newHead.dateOfBirth = dateOfBirth;
            return this;
        }
        public Builder withPhoneNumber(int phoneNumber){
            newHead.phoneNumber = phoneNumber;
            return this;
        }
    }

}