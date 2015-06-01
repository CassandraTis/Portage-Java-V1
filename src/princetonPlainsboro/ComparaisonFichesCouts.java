package princetonPlainsboro;
/**
 * Classe permettant de comparer les coûts de deux fiches de soins
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
public class ComparaisonFichesCouts implements ComparaisonFiches {
/**
 * implémentation de la méthode abstraite "comparer" héritée de l'interface ComparaisonFiches, ici appliquée à des coûts
 * @param fiche1
 * @param fiche2
 * @return retourne un entier
 * supérieur à 0 si le coût de la fiche 1 est supérieur à celui de la fiche 2
 * inférieure dans le où le coût de la fiche 2 est supérieur à celui de la fiche 1
 * égal à 0 si les coûts sont égaux
 */
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        Double c1 = new Double(fiche1.coutTotal());
        Double c2 = new Double(fiche2.coutTotal());
        return c1.compareTo(c2);
        }
    }
