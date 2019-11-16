package service.parser;

import adapter.LocaleDateAdapterJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Department;
import service.Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class JsonParser extends Parser<Department> {

    public JsonParser(String path){
        super(path);
    }

    @Override
    public Optional<Department> parse(){
        try {
            return this.deserializeJson(path);
        }
        catch (IOException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Department> deserializeJson(String path) throws IOException{
        File file = new File(path);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();
        return Optional.of((gson.fromJson(new FileReader(file),Department.class)));
    }
}