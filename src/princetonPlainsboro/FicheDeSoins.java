package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Date;
import java.util.Vector;
/**
 * Classe permettant de créer et accéder aux fiches de soin
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class FicheDeSoins extends Impression implements Printable  {

    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'

    /**
     * Constructeur de la classe FicheDeSoins
     * @param patient
     * @param medecin
     * @param date 
     */
    public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
    }

    /**
     * Méthode qui retourne le patient d'une fiche de soin
     * @return Retourne le patient de la fiche
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Méthode qui retourne le médecin affecté à la fiche de soin
     * @return Retourne le médecin de la fiche
     */
    public Medecin getMedecin() {
        return medecin;
    }

    /**
     * Méthode qui retourne la date d'une fiche de soin
     * @return Retourne la date à laquelle a été créée la fiche
     */
    public Date getDate() {
        return date;
    }

    /**
     * Méthode permettant d'ajouter un acte à une fiche de soins
     * @param acte Acte à ajouter à la fiche de soins
     */
    public void ajouterActe(Acte acte) {
        getActes().add(acte);
    }

    /**
     * Méthode permettant d'ajouter un acte qui n'a pas encore été créé à la fiche de soin
     * @param code Code de l'acte créé
     * @param coefficient Coefficient de l'acté créé
     */
    public void ajouterActe(Code code, int coefficient) {
        Acte acte = new Acte(code, coefficient);
        getActes().add(acte);
    }

    /**
     * Méthode permettant l'affichage d'une fiche de soins
     */
    public void afficher() {
        System.out.println("Fiche de soins du " + date.toString() + "\n" + "- medecin : "
                + medecin.toString() + "\n" + "- patient : " + patient.toString() + "\n" + "- actes medicaux : \n");

        for (int i = 0; i < getActes().size(); i++) {
            Acte a = getActes().get(i);
            System.out.println(a.toString());
        }
    }

    /**
     * Méthode passant une fiche de soins en chaîne de caractères
     * @return Retourne une chaîne de caratères correspondant à la fiche de soins
     */
    public String toString() {
        String s = "Fiche de soins du " + date.toString() + "\n" + "- medecin : "
                + medecin.toString() + "\n" + "- patient : " + patient.toString() + "\n" + "- actes medicaux : \n";
        for (int i = 0; i < getActes().size(); i++) {
            Acte a = getActes().get(i);
            s = s + a.toString();
        }
        for (int i=0; i<4 ; i++)
        {
        s=s+"\n";
                }
        return s;

    }

    /**
     * Méthode retournant le coût total de la fiche de soins
     * @return Retourne un double représentant le total de la fiche de soins
     */
    public double coutTotal() {
        double total = 0;
        for (int i = 0; i < getActes().size(); i++) {
            Acte a = getActes().get(i);
            total += a.cout();
        }
        return total;
    }

    /**
     * Méthode retournant les actes d'une fiche de soins
     * @return Retourne les actes
     */
    public Vector<Acte> getActes() {
        return actes;
    }

    /**
     * Méthodes permettant de modifier les actes d'une fiches de soins
     * @param actes Les actes à mettre
     */
    public void setActes(Vector<Acte> actes) {
        this.actes = actes;

    }

    /**
     * Méthode permettant d'imprimer une fiche de soins
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
                
                /* On écrit une ligne de titre en rouge, en gras de taille 18 */
                graphics.setFont(new Font("Cambria", Font.BOLD, 18));
                graphics.setColor(Color.BLUE);
                graphics.drawString("Fiche de Soin de \n " + this.getPatient().getNom().toString() + " " + this.getPatient().getPrenom().toString(), x + marge, y + marge);

                /* On écrit une ligne en noir de taille 14 */
          /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics, this.toString(), x + marge, y + marge + 90);

                retValue = Printable.PAGE_EXISTS;
            }
        }
        return retValue;
    }
}
