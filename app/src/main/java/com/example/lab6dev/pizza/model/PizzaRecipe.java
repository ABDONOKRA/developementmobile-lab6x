package com.example.lab6dev.pizza.model;

import java.util.Objects;

// Fait par Abdelghafour
public class PizzaRecipe {
    private long id;
    private String name;
    private double price;
    private int imageRes;
    private String duration;
    private String ingredients;
    private String description;
    private String steps;

    public PizzaRecipe(long id, String name, double price, int imageRes, String duration, String ingredients, String description, String steps) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.duration = duration;
        this.ingredients = ingredients;
        this.description = description;
        this.steps = steps;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public PizzaRecipe copy(long id, String name, double price, int imageRes, String duration, String ingredients, String description, String steps) {
        return new PizzaRecipe(id, name, price, imageRes, duration, ingredients, description, steps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaRecipe that = (PizzaRecipe) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                imageRes == that.imageRes &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(ingredients, that.ingredients) &&
                Objects.equals(description, that.description) &&
                Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, imageRes, duration, ingredients, description, steps);
    }

    @Override
    public String toString() {
        return "PizzaRecipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageRes=" + imageRes +
                ", duration='" + duration + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", steps='" + steps + '\'' +
                '}';
    }
}
