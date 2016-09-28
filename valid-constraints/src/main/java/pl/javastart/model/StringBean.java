package pl.javastart.model;

import pl.javastart.constraint.OddNumber;

public class StringBean {

    @OddNumber
    private String value;

    public StringBean(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
