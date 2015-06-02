package princetonPlainsboro;
/**
 * Classe permettant de créer et étudier une ou des dates de fiches de soins
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class Date implements Comparable {
    
    private int jour;
    private int mois;
    private int annee;
    
    /**
     * Constructeur de la classe Date, prend 3 paramètres
     * @param jour le jour de la date créée
     * @param mois le mois de la date créée
     * @param annee l'année de la date créée
     */
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        }
    
    /**
     * Méthode d'affichage de la date dans la console
     * @return Retourne une chaîne de caractères affichant la date
     */
    public String toString() {
        return jour + "-" + mois + "-" + annee;
        }
    
    /**
     * Méthode permettant de savoir si deux dates sont identiques
     * @param o précondition ; 'o' est une instance de 'Date'
     * @return Retourne un booléen
     * true si les deux dates sont identiques
     * false dans le cas contraire
     */
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date)o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour);
            }
        else
            return false;
        }
    
    /**
     * Méthode permettant de connaître le laps de temps entre deux dates
     * @param o précondition ; 'o' est une instance de 'Date'
     * @return Retourne un entier représentant la différence de temps entre les deux dates, soit en années, soit en mois, soit en jours
     */
    public int compareTo(Object o) {
        Date d = (Date)o;
        if (annee != d.annee)
            return annee - d.annee;
        // ici on a forcement annee == d.annee :
        if (mois != d.mois)
            return mois  - d.mois;
        // ici on a forcement annee == d.annee et mois == d.mois :
        return jour - d.jour;
        }
    
    }
