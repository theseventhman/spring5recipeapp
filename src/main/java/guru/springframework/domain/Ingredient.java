package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;



}
