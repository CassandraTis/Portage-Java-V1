package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * Classe Patient héritant de Personne (et des méthodes de l'interface
 * Printable)
 *
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class Patient extends Personne {

    private String adresse;
    private String secu;

    /**
     * Constructeur de la classe Patient
     *
     * @param nom Nom du patient
     * @param prenom Prénom du patient
     * @param secu N° de sécurité du patient
     * @param adresse Adresse du Patient
     */
    public Patient(String nom, String prenom, String secu, String adresse) {
        super(nom, prenom);
        this.adresse = adresse;
        this.secu = secu;

    }

    /**
     * Méthode permettant d'obtenir l'adresse du patient sous forme de chaîne de
     * caractères
     *
     * @return Retourne l'adresse sous forme de chaîne de caractères
     */
    public String getAdresse() {
        return this.adresse;

    }

    /**
     * Méthode permettant d'obtenir le numéro de sécu du patient sous forme de
     * chaîne de caractères
     *
     * @return Retourne le numéro de sécu sous forme de chaîne de caractères
     */
    public String getSecu() {
        return this.secu;

    }

    /**
     * Méthode permettant de définir l'adresse du patient
     *
     * @param adresse Adresse en String à définir
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;

    }

    /**
     * Méthode permettant de définir le numéro de sécu du patient
     *
     * @param secu Chaîne de caractères qu'on définit pour le patient
     */
    public void setSecu(String secu) {
        this.secu = secu;

    }

    /**
     * Méthode retournant les informations du patient sous forme de chaîne de
     * caractères
     *
     * @return Retourne les informations du médecin
     */
    public String toString() {
        return this.getPrenom() + " " + this.getNom() + " \n"
                + " " + this.adresse + " \n" + this.secu;
    }

    /**
     * Méthode permettant d'afficher les informations concernant un patient au
     * niveau de la console
     */
    public void afficherPersonne() {
        System.out.println(this.toString());
    }

    /**
     * Méthode permettant de vérifier si deux patients sont identiques
     *
     * @param o Précondition ; 'o' doit être une instance de la classe Patient
     * @return Retourne un booléen true s'il s'agit du même patient false dans
     * le cas contraire
     */

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    /**
     * Méthode permettant de rester le numéro de sécurité
     * @return Retourne un booléen
     * true si le numéro est valide
     * false dans le cas contraire
     */
    public boolean testSecu() {
        boolean res = false;
        long num = Long.parseLong(this.getSecu());
        long complement = (num / 100) % 97;
        long cle = 97 - complement;
        if (cle > 0 && cle < 98) {
            res = true;
        }
        return res;
    }

    /**
     * Méthode permettant d'imprimer les informations relatives à un patient
     *
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

                graphics.drawString("Fiche Patient \n ", x + marge, y + marge );
                
                

                /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics, this.toString(), x + marge, y + marge + 20);

                retValue = Printable.PAGE_EXISTS;
            }
        }
        return retValue;
    }

}
