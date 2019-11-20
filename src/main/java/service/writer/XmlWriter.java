package service.writer;

import models.Department;
import service.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class XmlWriter extends Writer<Department> {

    public XmlWriter(String path){
        super(path);
    }

    @Override
    public Optional<Department> writeToFile(Department department){
        try {
            return this.serializeXml(department);
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Department> serializeXml(Department department) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(department, new File(path));
        return Optional.of(department);
    }
}