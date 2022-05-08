package edu.qc.seclass.fim;

public class Floors {
    private String FloorType;
    private String Color;
    private String Size;
    private String Brand;
    private String Type;
    private String Price;
    private String Stock;
    private String Species;
    private String WaterResistant;
    private String Waterproof;
    private String ImageUrl;
    private int id;



    @Override
    public String toString() {
        return "Floors{" +
                "FloorType='" + FloorType + '\'' +
                ", Color='" + Color + '\'' +
                ", Size=" + Size +
                ", Brand='" + Brand + '\'' +
                ", Type='" + Type + '\'' +
                ", Price=" + Price +
                ", Stock=" + Stock +
                ", Species='" + Species + '\'' +
                ", WaterResistant='" + WaterResistant + '\'' +
                ", Waterproof='" + Waterproof + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", id=" + id +
                '}';
    }

    public Floors(String floorType, String color, String size, String brand, String type, String price, String stock, String species, String waterResistant, String waterproof, String imageUrl, int id) {
        FloorType = floorType;
        Color = color;
        Size = size;
        Brand = brand;
        Type = type;
        Price = price;
        Stock = stock;
        Species = species;
        WaterResistant = waterResistant;
        Waterproof = waterproof;
        ImageUrl = imageUrl;
        id = id;
    }

    public String getFloorType() {
        return FloorType;
    }

    public void setFloorType(String floorType) {
        FloorType = floorType;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getWaterResistant() {
        return WaterResistant;
    }

    public void setWaterResistant(String waterResistant) {
        WaterResistant = waterResistant;
    }

    public String getWaterproof() {
        return Waterproof;
    }

    public void setWaterproof(String waterproof) {
        Waterproof = waterproof;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
