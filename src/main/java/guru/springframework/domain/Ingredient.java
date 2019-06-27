package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class Ingredient {
    public Ingredient(String description, BigDecimal bigDecimal, UnitOfMeasure eachUom,Recipe recipe) {
        this.description = description;
        this.amount = bigDecimal;
        this.uom = eachUom;
        this.recipe = recipe;
    }

    public Ingredient()
    {

    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


}
