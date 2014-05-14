package miam.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

import java.util.Date;

/**
 * Created by ismael on 12/05/14.
 *
 * This entity represents the meal
 * It has a type (entry, main, dessert) a price and a name
 */
public class Meal {

    @Id
    @ObjectId
    private String key;

    private MealType mealType;
    private String name;
    private float price;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Meal setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "key='" + key + '\'' +
                ", mealType=" + mealType +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
