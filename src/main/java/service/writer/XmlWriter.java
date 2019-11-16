package service.writer;

import models.Department;
import service.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class XmlWriter extends Writer<Department> {

    public XmlWriter(String path){
        super(path);
    }

    @Override
    public void writeToFile(Department department){
        try {
            serializeXml(department);
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    public void serializeXml(Department department) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(department, new File(path));
    }
}