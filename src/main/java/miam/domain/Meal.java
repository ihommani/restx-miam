package miam.domain;

/**
 * Created by ismael on 12/05/14.
 *
 * This entity represents the meal
 * It has a type (entry, main, dessert) a price and a name
 */
public class Meal {

    private MealType mealType;
    private String name;
    private float price;

    public MealType getMealType() {
        return mealType;
    }

    public Meal setMealType(MealType mealType) {
        this.mealType = mealType;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Meal setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public Meal setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "mealType=" + mealType +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
