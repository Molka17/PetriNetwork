package org.pneditor.petrinet.models.oumol;
import java.util.ArrayList;

import java.util.List;

/**
 * La classe Transition représente une transition dans un réseau de Petri.
 * Elle peut avoir des arcs entrants et des arcs sortants associés.
 */
public class Transition {
    public static int nbrTransition;
    private String nom;
    private List<ArcSortant> arcsSortants;
    private List<ArcEntrant> arcsEntrants;

    /**
     * Constructeur par défaut pour initialiser une Transition sans arcs entrants et sortants.
     */
    public Transition() {
    	arcsSortants = new ArrayList<ArcSortant>(); 
    	arcsEntrants =new  ArrayList<ArcEntrant>();
    	
    	
    }
    public String getNom()
    {
    	return this.nom;
    }

    /**
     * Constructeur pour initialiser une Transition avec des arcs sortants et des arcs entrants spécifiés.
     *
     * @param arcsSortants La liste des arcs sortants associés à cette Transition.
     * @param arcsEntrants La liste des arcs entrants associés à cette Transition.
     */
    public Transition(List<ArcSortant> arcsSortants, List<ArcEntrant> arcsEntrants) {
        this.arcsSortants = arcsSortants;
        this.arcsEntrants = arcsEntrants;
        Transition.nbrTransition++;
        this.nom = "Transition_" + Transition.nbrTransition;
    }
    
    /**
     * Définit la liste des arcs sortants associés à cette transition.
     *
     * @param arcsSortants La liste des arcs sortants à associer à cette transition.
     */
    public void setArcsSortants(List<ArcSortant> arcsSortants) {
        this.arcsSortants = arcsSortants;
    }

    /**
     * Définit la liste des arcs entrants associés à cette transition.
     *
     * @param arcsEntrants La liste des arcs entrants à associer à cette transition.
     */
    public void setArcsEntrants(List<ArcEntrant> arcsEntrants) {
        this.arcsEntrants = arcsEntrants;
    }


    /**
     * Vérifie si la transition est tirable.
     * Une transition est tirable lorsque toutes les places qui y sont reliées par un arc contiennent au
     * moins autant de jetons qu’indiqué par la valeur de l’arc.
     *
     * @return true si la transition est tirable, sinon false.
     */
    public boolean verifTirable() {
        for (ArcSortant arcSortant : arcsSortants) {
            if (!arcSortant.Actif()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tire une transition si elle est tirable.
     * Cette méthode enlève des jetons aux places d'origine de la transition
     * et ajoute des jetons dans les places d’arrivée de la transition suivant leurs poids.
     */
    public void step() {
        if (verifTirable()) { // Vérifie si la transition est tirable
            int sommeJetonsTires = 0;

            // Tire chaque arc sortant
            for (ArcSortant arcSortant : arcsSortants) {
                int jetonsTires = arcSortant.tirer();
                sommeJetonsTires += jetonsTires;
            }

            // Distribue les jetons aux places cibles via les arcs entrants
            for (ArcEntrant arcEntrant : arcsEntrants) {
                arcEntrant.tirer(sommeJetonsTires);
            }
            System.out.print("je suis la somme hahahahaahah" + sommeJetonsTires);
        }
    }

    /**
     * Obtient la liste des arcs entrants associés à cette transition.
     *
     * @return La liste des arcs entrants associés à cette transition.
     */
    public List<ArcEntrant> getArcsEntrants() {
        return arcsEntrants;
    }

    /**
     * Obtient la liste des arcs sortants associés à cette transition.
     *
     * @return La liste des arcs sortants associés à cette transition.
     */
    public List<ArcSortant> getArcsSortants() {
        return arcsSortants;
    }

    /**
     * Supprime un arc sortant de la liste des arcs sortants associés à cette transition.
     *
     * @param arcSortant L'arc sortant à supprimer.
     */
    public void removeArc(ArcSortant arcSortant) {
        arcsSortants.remove(arcSortant);
    }

    /**
     * Supprime un arc entrant de la liste des arcs entrants associés à cette transition.
     *
     * @param arcEntrant L'arc entrant à supprimer.
     */
    public void removeArc(ArcEntrant arcEntrant) {
        arcsEntrants.remove(arcEntrant);
    }

    /**
     * Méthode equals pour comparer deux objets Transition.
     *
     * @param o L'objet à comparer.
     * @return true si les objets sont égaux, sinon false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition t = (Transition) o;
        return this.nom.equals(t.nom);
    }

    /**
     * Méthode toString pour obtenir une représentation sous forme de chaîne de caractères de la transition.
     *
     * @return Une représentation sous forme de chaîne de caractères de la transition.
     */
    @Override
    public String toString() {
        return nom + arcsEntrants.size() + " arc entrant"
                + (arcsEntrants.size() != 1 ? "s" : "")  // Pluriel si nécessaire
                + " et " + arcsSortants.size() + " arc sortant"
                + (arcsSortants.size() != 1 ? "s" : ""); // Pluriel si nécessaire
    }
}