package be.ordina.boerenkostbe.boerenkost.Model;

import javax.persistence.*;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    Long id;
    @Column
    String name;
    @Column
    String description;
    @Column
    String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
