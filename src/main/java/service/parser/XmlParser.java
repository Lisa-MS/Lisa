package service.parser;

import models.Department;
import service.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.Optional;

public class XmlParser extends Parser<Department> {

    public XmlParser(String path){
        super(path);
    }


    @Override

    public Optional<Department> parse(){
        try {
            return this.deserializeXml(path);
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Department> deserializeXml(String path) throws  JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Department department = (Department) unmarshaller.unmarshal(new File(path));
        return Optional.of(department);

    }
}