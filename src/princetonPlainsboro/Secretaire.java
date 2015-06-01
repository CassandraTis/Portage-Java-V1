/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * Classe Secretaire définissant les méthodes concernant un secrétaire médical
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class Secretaire extends Personne {

    private String identifiant;
    private String mdp;
    
    
    /**
     * Constructeur de la classe Secretaire
     * @param nom Nom du secrétaire
     * @param prenom Prénom du secrétaire
     * @param identifiant Identifiant du secrétaire
     * @param mdp Mot de passe du secrétaire
     */
    public Secretaire(String nom, String prenom, String identifiant, String mdp)
    {
        super(nom,prenom);
        this.identifiant=identifiant;
        this.mdp=mdp;
            
    
    }
    
    /**
     * Méthode hérité de la classe Personne permettant d'afficher les informations du secrétaire au niveau de la console
     */
    @Override
    public void afficherPersonne() {
        System.out.println(this.toString());    
    }

    /**
     * Méthode permettant d'obtenir les informations du secrétaire sous forme de chaîne de caractères
     * @return Retourne les informations du secrétaire sous forme de chaîne de caractères
     */
    public String toString()
    {
    return super.toString() + " \n ";
    }

    /**
     * Méthode permettant d'obtenir l'identifiant du secrétaire
     * @return Retourne l'identifiant de connexion du secrétaire sous forme de chaîne de caractères
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Méthode permettant de définir l'identifiant de connexion du secrétaire
     * @param identifiant Identifiant sous forme de chaîne de caractère que l'on définit pour le secrétaire
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Méthode permettant d'obtenir le mot de passe du secrétaire
     * @return Retourne le mot de passe du secrétaire sous forme de chaîne de caractères
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Méthode permettant de définir le mot de passe du secrétaire
     * @param mdp Mot de passe que l'on définit pour le secrétaire sous forme de chaîne de caractères
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Méthode permettant d'imprimer les informations relatives à un secrétaire médical
     * @param graphics
     * @param pageFormat
     * @param pageIndex
     * @return
     * @throws PrinterException 
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int retValue = Printable.NO_SUCH_PAGE;
        switch (pageIndex) {
            case 0: {
                /* On définit une marge pour l'impression */
                int marge = 30;

                /* On récupère les coordonnées des bords de la page */
                int x = (int) pageFormat.getImageableX();
                int y = (int) pageFormat.getImageableY();
                int w = (int) pageFormat.getImageableWidth();
                int h = (int) pageFormat.getImageableHeight();

                /* Dessin d'un cadre gris clair
                 graphics.setColor(Color.LIGHT_GRAY);
                 graphics.fillRect(x+10, y+10, w-20, h-20);*/

                /* On écrit une ligne de titre en rouge, en gras de taille 18 */
                graphics.setFont(new Font("Cambria", Font.BOLD, 18));
                graphics.setColor(Color.BLUE);
                graphics.drawString("Fiche Secrétaire \n ", x + marge, y + marge );
                
                

                /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics,this.toString(), x + marge, y + marge + 20);

                retValue = Printable.PAGE_EXISTS;
            }
        }
        return retValue;
    }

    }
    
    

