package org.pneditor.petrinet.models.oumol;
/**
 * La classe ArcVideur représente un arc videur, un type spécial d'arc sortant.
 * Elle hérite de la classe ArcSortant.
 */
public class ArcVideur extends ArcSortant {

    /**
     * Constructeur de la classe ArcVideur.
     *
     * @param transition La transition associée à l'arc videur.
     */
    public ArcVideur(Transition transition) {
        super(1, transition); // Un arc videur a toujours un poids sortant de 1
    }

    /**
     * Méthode permettant de tirer l'arc videur, renvoie le nombre de jetons tirés.
     *
     * @return Le nombre de jetons tirés lors du vidage de la place source.
     */
    @Override
    public int tirer() {
        int jetonsAvantVidage = getSource().getJeton(); // Sauvegarde du nombre de jetons avant vidage
        getSource().setJeton(0); // Mise à zéro du nombre de jetons dans la place source
        return jetonsAvantVidage; // Renvoie le nombre de jetons qui ont été tirés 
    }
}