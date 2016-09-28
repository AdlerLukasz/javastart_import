package pl.javastart.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PersonEmbeddedKey key;
    private Integer age;
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
