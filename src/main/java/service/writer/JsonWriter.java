package service.writer;

import adapter.LocaleDateAdapterJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Department;
import service.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class JsonWriter extends Writer<Department> {
    public JsonWriter(String path){
        super(path);
    }

    @Override
    public void writeToFile(Department department){
        try {
            serializeJson(department);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void serializeJson(Department department) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();

        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gson.toJson(department));
        fileWriter.close();

    }

}
