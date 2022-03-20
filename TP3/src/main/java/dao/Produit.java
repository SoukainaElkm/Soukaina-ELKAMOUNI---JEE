package dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity //Important
@Table(name ="PRODUITS")

public class Produit implements Serializable {

    @Id //important
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="REF")
    private long id;

    @Column(name = "DES")
    private String designation;

    private double prix;
    private int quantite;

    public Produit( String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    // ================= Constructeur par défaut ================================
    public Produit() {
    }

    // ======================= Getters et Setters ===============================

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
