package be.ordina.boerenkostbe.boerenkost.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ingredient")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @Column
    private double weight;

    @ManyToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
    @JsonIgnore
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
