package org.pneditor.petrinet.models.oumol;
/**
 * La classe ArcZero représente un arc avec un poids sortant égal à zéro.
 * Elle hérite de la classe ArcSortant.
 */
public class ArcZero extends ArcSortant {

    /**
     * Constructeur de la classe ArcZero.
     *
     * @param transition La transition associée à l'arc zéro.
     */
    public ArcZero(Transition transition) {
        super(0, transition); // Un arc avec un poids sortant de zéro
    }

    /**
     * Méthode permettant de tirer l'arc zéro, renvoie toujours zéro.
     *
     * @return Toujours zéro, car l'arc a un poids sortant égal à zéro.
     */
    @Override
    public int tirer() {
        return 0; 
    }
}