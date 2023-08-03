package org.designpatterns.decorator;

import java.io.*;
import java.nio.file.Files;

public class FileSourceDecorator implements DataSource{

    private String name;

    public FileSourceDecorator(String name) {
        this.name = name;
    }

    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = Files.newOutputStream(file.toPath())) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
