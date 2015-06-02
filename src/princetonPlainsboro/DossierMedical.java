package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;
import java.util.Vector;
/**
 * Classe regroupant l'ensemble des fiches de soins créées dans une liste
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class DossierMedical implements Printable {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'

    /**
     * Constructeur de la classe DossierMedical qui instancie un Vector
     */
    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
    }
    
    /**
     * Méthode permettant de transformer les informations du DossierMedical en chaîne de caractères
     * @return Retourne l'ensemble des fiches de soins contenus dans le DossierMedical sous forme de chaîne de caractère
     */
    public String toString()
    {
        String s = "Dossier medical informatise :" +"\n"+"-----------------------------" +"\n";
                for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            s=s+f.toString();
                }
                s=s+"--------------------------------------";
                
    return s;
    }
    
    /**
     * Méthode affichant l'ensemble des médecins des fiches de soins
     */
    public void afficherMedecins()
    {
        for (int i=0; i<getFiches().size(); i++)
        {
            getFiches().get(i).getMedecin().afficherPersonne();
        
        }
    
    }
    
    /**
     * Méthode affichant l'ensemble des Patients des fiches de soins
     */
    public void afficherPatients()
    {
        for (int i=0; i<getFiches().size(); i++)
        {
            getFiches().get(i).getPatient().afficherPersonne();
        
        }
    
    }

    /**
     * Méthode permettant d'ajouter une fiche de soin au DossierMedical
     * @param fiche Fiche de soin à ajouter
     */
    public void ajouterFiche(FicheDeSoins fiche) {
        getFiches().add(fiche);
    }

    /**
     * Méthode permettant l'affichage du dossier médical dans la console
     */
    public void afficher() {
        System.out.println("Dossier medical informatise :");
        System.out.println("-----------------------------");
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println("--------------------------------------");
        }
    }

    /**
     * Méthode de calcul du coût d'un patient (en cumulant toutes ses fiches de soin)
     * @param p Patient dont on veut connaître le coût
     * @return Retourne la valeur du coût du patient en double
     */
    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            if (p.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Méthode permettant de calculer le cout d'un médecin (sur toutes ses fiches de paie)
     * @param m Médecin dont on veut connaître le coût
     * @return Retourne le coût en double du Médecin concerné
     */
    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Méthode permettant de calculer le coût d'une spécialité
     * @param specialite Nom de la spécialité concernée
     * @return Retourne le cout de la spécialité en double
     */
    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            if (specialite.equals(f.getMedecin().getSpecialite())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Méthode permettant d'afficher la liste des patients d'un médecin
     * @param m Médecin dont on veut afficher les patients
     */
    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    /**
     * Méthode permettant de connaître le nombre de fiches de soin entre deux dates
     * @param d1 première date
     * @param d2 seconde date
     * @return Retourne le nombre sous forme d'entier de fiches crées entre les deux dates
     */
    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < getFiches().size(); i++) {
            FicheDeSoins f = getFiches().get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }
    
    /**
     * Méthodes permettant d'afficher toutes les fiches de soins entre deux dates connues
     * @param d1 première date
     * @param d2 seconde date
     */
    public void afficherFichesEntreDate( Date d1, Date d2)
    {
    
        for (int i=0; i<getFiches().size(); i++)
        {
            if (getFiches().get(i).getDate().compareTo(d1)>=0 && getFiches().get(i).getDate().compareTo(d2)<=0 )
            {
                getFiches().get(i).afficher();
            
            }
        
        }
    
    }

    /**
    * Méthode permettant de trier les fiches de soin d'une instance de DossierMedical selon leurs dates
    */
    public void trierDates() {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(getFiches());

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    // tri generique :
    public void trier(ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(getFiches());

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    /**
     * @return les fiches de soin
     */
    public List<FicheDeSoins> getFiches() {
        return fiches;
    }

    /**
     * @param fiches the fiches to set
     */
    public void setFiches(List<FicheDeSoins> fiches) {
        this.fiches = fiches;
    }

    /**
     * Methode permettant d'imprimer baaaaah pour l'instant on sait pas trop !
     * @param graphics
     * @param pageFormat
     * @param pageIndex
     * @return retourne un int ? Problème non ?
     * @throws PrinterException 
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            
           int retValue = Printable.NO_SUCH_PAGE;
        if (pageIndex==0)
           {
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
                graphics.drawString("Dossiers Médical \n ", x + marge, y + marge );
                
                

                /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics, this.toString(), x + marge, y + marge + 20);

                retValue = Printable.PAGE_EXISTS;
                pageIndex++;
            }
        
        else if (pageIndex>0 && pageIndex <4)
        {
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
                graphics.drawString("Dossiers Médical \n ", x + marge, y + marge );
                
                

                /* On écrit une ligne en noir de taille 14 */
                graphics.setFont(new Font("Cambria", Font.PLAIN, 14));
                graphics.setColor(Color.BLACK);
                drawString(graphics, this.toString(), x + marge, y + marge + 20);

                retValue = Printable.PAGE_EXISTS;
        
        
        
        }
          return retValue;
        
        }
      
    

     private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
        
        
    }


