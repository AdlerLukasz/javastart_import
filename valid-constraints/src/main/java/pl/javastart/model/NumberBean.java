package pl.javastart.model;

import pl.javastart.constraint.OddNumber;

public class NumberBean {

    @OddNumber
    private int number;
    
    public NumberBean(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    
}