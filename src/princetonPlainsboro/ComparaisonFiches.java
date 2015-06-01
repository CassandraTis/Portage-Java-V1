package princetonPlainsboro;
/**
 * interface contenant une méthode abstraite permettant une comparaison entre deux fiches de soins
 * @author DULAC Julia, MUSCIO Cassandra, RAINAUT Jennifer, TREBOSSEN Lucie
 */
// cette interface permet de representer une comparaison entre deux FicheDeSoins
public interface ComparaisonFiches {
    // la fonction 'comparer' doit retourner :
    //    <0  si fiche1 < fiche2
    //     0  si fiche1 == fiche2
    //    >0  si fiche1 > fiche2
    /**
     * méthode abstraite de comparaison entre deux fiches
     * @param fiche1
     * @param fiche2
     * @return retourne un int permettant de connaître le résultat de la comparaison
     * inférieur à 0 si fiche 2 supérieur à fiche 1
     * supérieur à 0 si fiche 1 supérieur à fiche 2
     * égal à 0 si fiche 1 égale à fiche 2
     */
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2);
}
