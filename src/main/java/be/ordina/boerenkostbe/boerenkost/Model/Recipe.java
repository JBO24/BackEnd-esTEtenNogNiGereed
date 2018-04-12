package be.ordina.boerenkostbe.boerenkost.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="recipe")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String label;

    @Column
    private String image;

    @Column
    private String source;

    @Column
    private String url;

    @Column
    private Float calories;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @JsonProperty("hits")
    private void unpackNested(Map<String, Object> recipe) {
        this.label = (String)recipe.get("recipe");
        this.image = (String)recipe.get("image");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", image='" + image + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
