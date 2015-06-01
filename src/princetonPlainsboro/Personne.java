/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.awt.print.Printable;

/**
 * Classe abstraite Personne implémentant Printable
 *
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public abstract class Personne extends Impression implements Printable {

    private String nom;
    private String prenom;

    /**
     * Constructeur de la classe Personne
     *
     * @param nom Nom de la Personne
     * @param prenom Prénom de la Personne
     */
    public Personne(String nom, String prenom) {
        this.prenom = prenom;
        this.nom = nom;

    }

    /**
     * Méthode permettant d'obtenir les informations d'un patient sous forme de
     * chaîne de caractères
     *
     * @return Retourne les informations de la personne sous forme de chaîne de
     * caractères
     */
    public String toString() {
        return this.nom + " " + this.prenom;

    }

    /**
     * Méthode permettant d'obtenir le nom d'une personne
     *
     * @return Retourne le nom d'une personne sous forme de chaîne de caractères
     */
    public String getNom() {
        return this.nom;

    }

    /**
     * Méthode permettant d'obtenir le prénom d'une personne
     *
     * @return Retourne le prénom d'une personne sous forme de chaîne de
     * caractères
     */
    public String getPrenom() {
        return this.prenom;

    }

    /**
     * Méthode permettant de définir le prénom d'une personne
     *
     * @param nom Prénom de la personne sous forme de chaîne de caractères
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;

    }

    /**
     * Méthode abstraite qui permettra d'afficher les caractéristiques de la
     * personne au niveau de la console
     */
    public abstract void afficherPersonne();

    /**
     * Méthode permettant de définir le nom d'une personne
     *
     * @param nom Nom de la personne sous forme de chaîne de caractères
     */
    public void setNom(String nom) {
        this.nom = nom;

    }
}
