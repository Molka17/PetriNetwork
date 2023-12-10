package org.pneditor.petrinet.models.oumol;

/**
 * La classe ArcEntrant représente un arc entrant associé à une transition et à une place cible.
 * Il hérite de la classe abstraite Arc.
 */
public class ArcEntrant extends Arc {
   
    /**
     * La transition associée à l'arc entrant.
     */
    private Transition transition;

    /**
     * La place cible de l'arc entrant.
     */
    private Place cible;
   

    /**
     * Constructeur de la classe ArcEntrant.
     *
     * @param poids Le poids de l'arc entrant.
     * @param transition La transition associée à l'arc entrant.
     */
    public ArcEntrant(int poids, Transition transition) {
        super(poids);
        this.transition = transition;
        transition.getArcsEntrants().add(this); 
    }

    /**
     * Obtient le poids de l'arc entrant.
     *
     * @return Le poids de l'arc entrant.
     */
    public int getPoidsEntrant() {
        return super.getPoids();
    }

    /**
     * Modifie le poids de l'arc entrant.
     *
     * @param poids Le nouveau poids de l'arc entrant.
     */
    public void setPoids(int poids) {
        super.setPoids(poids);
    }

    /**
     * Méthode permettant de tirer l'arc avec une valeur spécifiée.
     *
     * @param valeurTiree La valeur spécifiée lors du tir de l'arc.
     */
    @Override
    public void tirer(int valeurTiree) {
        if (valeurTiree >= getPoidsEntrant()) {
            // Si la valeur tirée est supérieure ou égale au poids de l'arc,
            // on ajoute le poids de l'arc à la place cible
        	
            cible.addJeton(getPoidsEntrant());
         
        } else {
            // Sinon, on ajoute la valeur tirée à la place cible
            cible.addJeton(valeurTiree);
        }
    }

    /**
     * Obtient la transition associée à l'arc entrant.
     *
     * @return La transition associée à l'arc entrant.
     */
    public Transition getTransition() {
        return transition;
    }

    /**
     * Modifie la transition associée à l'arc entrant.
     *
     * @param transition La nouvelle transition associée à l'arc entrant.
     */
    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    /**
     * Obtient la place cible de l'arc entrant.
     *
     * @return La place cible de l'arc entrant.
     */
    public Place getCible() {
        return cible;
    }

    /**
     * Modifie la place cible de l'arc entrant.
     *
     * @param cible La nouvelle place cible de l'arc entrant.
     */
    public void setCible(Place cible) {
        this.cible = cible;
    }

    /**
     * Redéfinition de la méthode toString pour obtenir une représentation
     * sous forme de chaîne de caractères de l'objet ArcEntrant.
     *
     * @return La représentation sous forme de chaîne de caractères de l'objet ArcEntrant.
     */
    @Override
    public String toString() {
        return "ArcEntrant [transition=" + transition.toString() + ", cible une place qui contient =" + cible.getJeton() + "]";
    }
}