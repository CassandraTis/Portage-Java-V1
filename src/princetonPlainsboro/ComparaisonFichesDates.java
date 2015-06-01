package princetonPlainsboro;
/**
 * Classe permettant de comparer les dates de deux fiches de soins
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class ComparaisonFichesDates implements ComparaisonFiches {
   /**
 * implémentation de la méthode abstraite "comparer" héritée de l'interface ComparaisonFiches, ici appliquée à des dates
 * @param fiche1
 * @param fiche2
 * @return retourne un entier
 * supérieur à 0 si la date de la fiche 1 est supérieure à celle de la fiche 2
 * inférieure dans le où la date de la fiche 2 est supérieure à celle de la fiche 1
 * égal à 0 si les dates sont identiques
 */
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        return fiche1.getDate().compareTo(fiche2.getDate());
        }
    }
