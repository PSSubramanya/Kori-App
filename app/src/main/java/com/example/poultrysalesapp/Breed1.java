package com.example.poultrysalesapp;

public class Breed1
{

    private String Price;
    private String BreedName;
    private int Photo;

    public Breed1(String price, String breedName, int photo)
    {
        Price = price;
        BreedName = breedName;
        Photo = photo;
    }

    public String getPrice() {
        return Price;
    }

    public String getBreedName() {
        return BreedName;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setBreedName(String breedName) {
        BreedName = breedName;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
