package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * Classe Medecin héritant de Personne (et des méthodes de l'interface Printable)
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class Medecin extends Personne {

    private String specialite;
    private String tel;
    private String mdp;
    private String identifiant;

    /**
     * Constructeur de la classe Medecin, permet de créer un nouveau médecin
     * avec un login et mot de passe
     *
     * @param nom Nom du médecin
     * @param prenom Prénom du médecin
     * @param specialite Spécialité du médecin
     * @param tel Téléphone du médecin
     * @param mdp Mot de passe du médecin
     * @param identifiant Identifiant du médecin
     */
    public Medecin(String nom, String prenom, String specialite, String tel, String mdp, String identifiant) {
        super(nom, prenom);
        this.specialite = specialite;
        this.mdp = mdp;
        this.tel = tel;
        this.identifiant = identifiant;
    }

    /**
     * Méthode permettant d'affiche les informations d'un médecin sur la console
     */
    public void afficherPersonne() {
        System.out.println(this.toString());
    }

    /**
     * Méthohde permettant de récupérer la spécialité d'un médecin
     *
     * @return Retourne la spécialité sous forme de chaîne de caractères
     */
    public String getSpecialite() {
        return specialite;
    }

    
    public void setSpecialite(String spe){
        this.specialite=spe;
    }
    /**
     * Méthode permettant de transformer les informations d'un médecin en chaîne
     * de caractères
     *
     * @return Retourne une chaîne de caractères contenant les informations
     */
    public String toString() {
        return "Dr " + super.toString() + ", " + this.specialite + "\n" + ""
                + " Telephone : " + this.tel;
    }

    /**
     * Méthode permettant de savoir si deux médecins sont les mêmes
     *
     * @param o Précondition : 'o' doit être une instance de la classe Medecin
     * @return Retourne un booléen true s'il s'agit du même médecin false dans
     * le cas contraire
     */
    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    /**
     * Méthode permettant de récupérer le téléphone d'un médecin
     *
     * @return Retourne le téléphone sous forme de chaîne de caractères
     */
    public String getTel() {
        return tel;
    }

    /**
     * Méthode permettant de définir le téléphone d'un médecin
     *
     * @param tel Téléphone que l'on définit pour le médecin
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Méthode permettant de récupérer le mot de passe d'un médecin
     *
     * @return Retourne le mot de passe sous forme de chaîne de caractères
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Méthode permettant de définir le mot de passe d'un médecin
     *
     * @param mdp Mot de passe que l'on définit pour le médecin
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Méthode permettant l'impression des informations concernant un médecin
     *
     * @param graphics
     * @param pf
     * @param i
     * @return
     * @throws PrinterException
     */
    @Override
    public int print(Graphics graphics, PageFormat pf, int i) throws PrinterException {
        int retValue = Printable.NO_SUCH_PAGE;
        String newLine = System.getProperty("line.separator");
        switch (i) {
            case 0: {
                /* On définit une marge pour l'impression */
                int marge = 30;

                /* On récupère les coordonnées des bords de la page */
                int x = (int) pf.getImageableX();
                int y = (int) pf.getImageableY();
                int w = (int) pf.getImageableWidth();
                int h = (int) pf.getImageableHeight();

                /* On écrit une ligne de titre en rouge, en gras de taille 18 */
                graphics.setFont(new Font("Cambria", Font.BOLD, 18));
                graphics.setColor(Color.BLUE);
                graphics.drawString("Fiche Médecin ", x + marge, y + marge);

                /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics, this.toString(), x + marge, y + marge + 90);

                retValue = Printable.PAGE_EXISTS;
            }
        }
        return retValue;
    }
   

    /**
     * Méthode permettant de récupérer l'identifiant d'un médecin
     *
     * @return Retourne l'identifiant sous forme de chaîne de caractères
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Méthode permettant de définir l'identifiant d'un médecin
     *
     * @param tel Identifiant que l'on définit pour le médecin
     */
    
    
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

}
