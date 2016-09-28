package pl.javastart.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class User {

    @NotNull
    private String username;
    @Past
    private Date birthDate;
    @Size(min = 11, max = 11)
    private String pesel;
    @Size(min = 2, max = 30)
    private String firstName;
    private String lastName;
    @Min(13)
    private int age;
    @Email
    @Size(min = 5)
    private String email;

    public User(String username, Date birthDate, String pesel, 
            String firstName, String lastName, int age, String email) {
        this.username = username;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}