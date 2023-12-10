package org.pneditor.petrinet.models.oumol;

import java.util.LinkedList;
import java.util.List;

/**
 * La classe Place représente une place dans un réseau de Petri.
 * Elle peut avoir un nombre de jetons, des arcs entrants et des arcs sortants associés.
 */
public class Place {
    public static int nbrPlace;
    private String nom;
    private int jeton;
    private LinkedList<ArcSortant> arcsSortants;
    private LinkedList<ArcEntrant> arcsEntrants;

    /**
     * Constructeur pour initialiser une Place avec un nombre de jetons spécifié.
     *
     * @param jeton Le nombre de jetons initial pour la Place.
     */
    public Place(int jeton) {
        this.jeton = jeton;
        Place.nbrPlace++;
        this.nom = "Place_" + Place.nbrPlace;
        LinkedList<ArcSortant> arcsSortants= new LinkedList<ArcSortant>();
        LinkedList<ArcEntrant> arcsEntrants= new LinkedList<ArcEntrant>();
    }
   
    /**
     * Constructeur pour initialiser une Place avec un nombre de jetons, des arcs sortants et des arcs entrants spécifiés.
     *
     * @param jeton        Le nombre de jetons initial pour la Place.
     * @param arcsSortants La liste des arcs sortants associés à cette Place.
     * @param arcsEntrants La liste des arcs entrants associés à cette Place.
     */
    public Place(int jeton, LinkedList<ArcSortant> arcsSortants, LinkedList<ArcEntrant> arcsEntrants) {
        this.jeton = jeton;
        this.arcsSortants = arcsSortants;
        this.arcsEntrants = arcsEntrants;
        Place.nbrPlace++;
        this.nom = "Place_" + Place.nbrPlace;
    }
    public String getNom()
    {
    	return this.nom;
    }
    /**
     * Retire un nombre spécifié de jetons.
     *
     * @param n Le nombre de jetons à retirer.
     * @throws IllegalArgumentException Si le nombre spécifié est inférieur à zéro ou
     *                                  s'il est supérieur au nombre de jetons actuels.
     */
    public void removeJeton(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de jetons à enlever doit être supérieur ou égal à zéro.");
        }

        if (this.jeton >= n) {
            this.jeton -= n;
        } else {
            throw new IllegalArgumentException("Le nombre de jetons à enlever est supérieur au nombre de jetons actuels.");
        }
    }

    /**
     * Ajoute un nombre spécifié de jetons.
     *
     * @param n Le nombre de jetons à ajouter.
     * @throws IllegalArgumentException Si le nombre spécifié est inférieur à zéro.
     */
    public void addJeton(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre de jetons à ajouter doit être supérieur ou égal à zéro.");
        }
        this.jeton += n;
    }

    /**
     * Obtient le nombre de jetons dans la place.
     *
     * @return Le nombre de jetons dans la place.
     */
    public int getJeton() {
        return jeton;
    }

    /**
     * Modifie le nombre de jetons dans la place.
     *
     * @param jeton Le nouveau nombre de jetons dans la place.
     */
    public void setJeton(int jeton) {
        this.jeton = jeton;
    }

    /**
     * Obtient la liste des arcs entrants associés à cette place.
     *
     * @return La liste des arcs entrants associés à cette place.
     */
    public List<ArcEntrant> getArcsEntrants() {
        return this.arcsEntrants;
    }

    /**
     * Obtient la liste des arcs sortants associés à cette place.
     *
     * @return La liste des arcs sortants associés à cette place.
     */
    public List<ArcSortant> getArcsSortants() {
        return this.arcsSortants;
    }

    /**
     * Ajoute un arc entrant à la place.
     *
     * @param arc L'arc entrant à ajouter.
     * @throws IllegalArgumentException Si un arc entrant avec la même place cible et sortant de la même transition existe déjà quelque soit le poids.
     */
    public void addArc(ArcEntrant arc, Transition t) {
    	if (arcsEntrants == null && arc != null) {
    		arcsEntrants = new LinkedList<>(); // Initialize the list if it's null
    		arcsEntrants.add(arc);
            arc.setCible(this);
        } else {
            if (arc != null) {
                // Vérifie si un arc entrant avec la même place cible existe déjà
                for (ArcEntrant arcExistant : arcsEntrants) {
                    if ((arcExistant.getTransition().equals(arc.getTransition()))) {
                        throw new IllegalArgumentException("Un arc entrant avec la même place cible existe déjà.");
                    }
                }
                arcsEntrants.add(arc);
                arc.setCible(this);
                arc.setTransition(t);
            }
        }
    }

    /**
     * Ajoute un arc sortant à la place.
     *
     * @param arc L'arc sortant à ajouter.
     * @throws IllegalArgumentException Si un arc sortant de la même place et dirigeant vers la même transition existe déjà, quelque soit la valeur de poids.
     */
    public void addArc(ArcSortant arc, Transition t) {
    	if (arcsSortants == null && arc != null) {
            arcsSortants = new LinkedList<>(); // Initialize the list if it's null
            arcsSortants.add(arc);
            arc.setSource(this);
        }
        else {
                for (ArcSortant arcExistant : arcsSortants) {
                    if ((arcExistant.getTransition().equals(arc.getTransition()))) {
                        throw new IllegalArgumentException("Un arc sortant avec la même place de sortie existe déjà.");
                    }
                }
                arcsSortants.add(arc); // on ajoute l'arc s'il n'est pas doublé
                arc.setSource(this);
                arc.setTransition(t);
            
        }
    }

    /**
     * Modifie la liste des arcs sortants associés à cette place.
     *
     * @param arcsSortants La nouvelle liste des arcs sortants associés à cette place.
     */
    public void setArcsSortants(LinkedList<ArcSortant> arcsSortants) {
        this.arcsSortants = arcsSortants;
    }

    /**
     * Modifie la liste des arcs entrants associés à cette place.
     *
     * @param arcsEntrants La nouvelle liste des arcs entrants associés à cette place.
     */
    public void setArcsEntrants(LinkedList<ArcEntrant> arcsEntrants) {
        this.arcsEntrants = arcsEntrants;
    }

    /**
     * Méthode toString pour obtenir une représentation sous forme de chaîne de caractères de la place.
     *
     * @return Une représentation sous forme de chaîne de caractères de la place.
     */
    @Override
    public String toString() {
        return "Place: " + nom + " = " + this.getJeton() + "\n";
    }
}