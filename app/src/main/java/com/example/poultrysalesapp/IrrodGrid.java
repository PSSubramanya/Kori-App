package com.example.poultrysalesapp;

public class IrrodGrid
{
    private String Price1;
    private String BreedName1;
    private int Thumbnail1;


    public IrrodGrid()
    {

    }

    public IrrodGrid(String price1, String breedName1, int thumbnail1)
    {
        Price1 = price1;
        BreedName1 = breedName1;
        Thumbnail1 = thumbnail1;
    }

    public String getPrice1() {
        return Price1;
    }

    public String getBreedName1() {
        return BreedName1;
    }

    public int getThumbnail1() {
        return Thumbnail1;
    }


    public void setPrice1(String price1) {
        Price1 = price1;
    }

    public void setBreedName1(String breedName1) {
        BreedName1 = breedName1;
    }

    public void setThumbnail1(int thumbnail1) {
        Thumbnail1 = thumbnail1;
    }
}
