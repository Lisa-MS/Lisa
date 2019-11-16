package service;

import models.Department;

public abstract class Writer<T> {

    protected final String path;

    protected Writer(String path) {
        this.path = path;
    }

    public abstract void writeToFile(Department department);
}
