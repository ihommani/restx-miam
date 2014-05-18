package miam.rest;

import com.google.common.base.Optional;
import miam.domain.Meal;
import miam.domain.Restaurant;
import org.bson.types.ObjectId;
import restx.Status;
import restx.annotations.*;
import restx.factory.Component;
import restx.jongo.JongoCollection;
import restx.security.PermitAll;

import javax.inject.Named;

import static restx.common.MorePreconditions.checkContainsKey;
import static restx.common.MorePreconditions.checkEquals;
import static restx.common.MorePreconditions.checkPresent;

@Component
@RestxResource
@PermitAll
public class RestaurantResource {
    private final JongoCollection restaurants;

    public RestaurantResource(@Named("restaurants") JongoCollection restaurants) {
        this.restaurants = restaurants;
    }

    @GET("/restaurants")
    public Iterable<Restaurant> findRestaurants(Optional<String> name) {
        if (name.isPresent()) {
            return restaurants.get().find("{name: #}", name.get()).as(Restaurant.class);
        } else {
            return restaurants.get().find().as(Restaurant.class);
        }
    }

    @POST("/restaurants")
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurants.get().save(restaurant);
        return restaurant;
    }

    @GET("/restaurants/{color}")
    public Optional<Restaurant> findRestaurantById(String color) {
        return Optional.fromNullable(restaurants.get().findOne(new ObjectId(color)).as(Restaurant.class));
    }

    @PUT("/restaurants/{color}")
    public Restaurant updateRestaurant(String color, Restaurant restaurant) {
        checkEquals("color", color, "restaurant.color", restaurant.getColor());
        restaurants.get().save(restaurant);
        return restaurant;
    }

    @DELETE("/restaurants/{color}")
    public Status deleteRestaurant(String color) {
        restaurants.get().remove(new ObjectId(color));
        return Status.of("deleted");
    }

    @GET("/restaurants/{color}/meals")
    public Iterable<Meal> getMeals(String color) {
        Optional<Restaurant> restaurantById = this.findRestaurantById(color);
        //TODO: Use precondition checkPresent instead
        if (restaurantById.isPresent()) {
            Restaurant restaurant = restaurantById.get();
            return restaurant.getMeals();
        }
        return null;
    }

    @POST("/restaurants/{color}/meals")
    public Meal createMeal(String color, Meal meal) {
        Optional<Restaurant> restaurantOptional = Optional.fromNullable(restaurants.get().findOne(new ObjectId(color)).as(Restaurant.class));
        //TODO: Use precondition checkPresent instead
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.getMeals().add(meal);
            restaurants.get().save(restaurantOptional.get());

            return meal;
        }
        return null;
    }

    @GET("/restaurants/{color}/meals/{mid}")
    public Iterable<Meal> getMeals(String color, String mid) {
        Optional<Restaurant> restaurantById = this.findRestaurantById(color);
        //TODO: Use precondition checkPresent instead
        if (restaurantById.isPresent()) {
            Restaurant restaurant = restaurantById.get();
            return restaurant.getMeals();
        }
        return null;
    }
}
