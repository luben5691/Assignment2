////////////////////////////////////////////////////////////////////
// Luca Benetazzo 1122109
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum items { Panino, Fritto, Bevanda }
    private items itemType;
    private String name;
    private double price;

    public MenuItem(String n, items t, double p){
        this.itemType = t;
        this.name = n;
        this.price = p;
    }

    public String getName(){
        return name;
    }
    
    public items getType(){
        return itemType;
    }

    public double getPrice(){
        return price;
    }
}