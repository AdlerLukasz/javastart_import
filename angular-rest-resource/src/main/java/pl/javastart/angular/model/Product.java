package pl.javastart.angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    private Integer kcal;

    Product() {}
    
    public Product(String name, String producer, Integer kcal) {
        this.name = name;
        this.producer = producer;
        this.kcal = kcal;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public Integer getKcal() {
        return kcal;
    }
    public void setKcal(Integer kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", producer=" + producer + ", kcal=" + kcal + "]";
    }
    
}