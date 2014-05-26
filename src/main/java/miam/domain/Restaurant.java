package miam.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

import java.util.List;

/**
 * This class represant the restaurant entity.
 */
public class Restaurant {

    @Id
    private Color color;

    private List<Meal> meals;

    public List<Meal> getMeals() {
        return meals;
    }

    public Restaurant setMeals(List<Meal> meals) {
        this.meals = meals;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Restaurant setColor(final Color color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "color=" + color +
                ", meals=" + meals +
                '}';
    }
}
