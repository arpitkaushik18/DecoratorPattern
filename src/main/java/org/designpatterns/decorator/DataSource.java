package org.designpatterns.decorator;

public interface DataSource {

    public void writeData(String data);
    public String readData();
}
