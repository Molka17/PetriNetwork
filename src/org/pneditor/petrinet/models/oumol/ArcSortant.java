package org.pneditor.petrinet.models.oumol;
/**
 * La classe ArcSortant représente un arc sortant associé à une transition et à une place source.
 * Elle hérite de la classe abstraite Arc.
 */
public class ArcSortant extends Arc {
    
    /**
     * La transition associée à l'arc sortant.
     */
    private Transition transition;
    
    /**
     * La place source de l'arc sortant.
     */
    private Place source;

    /**
     * Obtient la transition associée à l'arc sortant.
     *
     * @return La transition associée à l'arc sortant.
     */
    public Transition getTransition() {
        return transition;
    }

    /**
     * Modifie la transition associée à l'arc sortant.
     *
     * @param transition La nouvelle transition associée à l'arc sortant.
     */
    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    /**
     * Obtient la place source de l'arc sortant.
     *
     * @return La place source de l'arc sortant.
     */
    public Place getSource() {
        return source;
    }

    /**
     * Modifie la place source de l'arc sortant.
     *
     * @param source La nouvelle place source de l'arc sortant.
     */
    public void setSource(Place source) {
        this.source = source;
    }

    /**
     * Constructeur de la classe ArcSortant.
     *
     * @param poids Le poids de l'arc sortant.
     * @param transition La transition associée à l'arc sortant.
     */
    public ArcSortant(int poids, Transition transition) {
        super(poids);
        this.transition = transition;
        transition.getArcsSortants().add(this); 
    }

    /**
     * Obtient le poids de l'arc sortant.
     *
     * @return Le poids de l'arc sortant.
     */
    public int getPoidsSortant() {
        return super.getPoids();
    }

    /**
     * Modifie le poids de l'arc sortant.
     *
     * @param poids Le nouveau poids de l'arc sortant.
     */
    public void setPoids(int poids) {
        super.setPoids(poids);
    }

    /**
     * Méthode permettant de tirer l'arc sortant et retourne la valeur tirée.
     *
     * @return La valeur tirée lors du tir de l'arc sortant.
     */
    @Override
    public int tirer() {
        int poidsSortant = getPoidsSortant();

        if (Actif()) {
            // Si le nombre de jetons dans la place source est supérieur ou égal au poids de l'arc sortant,
            // appelle removeJeton sur la place source en passant le poids de l'arc
            source.removeJeton(poidsSortant);
            return poidsSortant; 
        } else {
            return 0; // Renvoie zéro si l'arc n'est pas activé
        }
    }

    /**
     * Méthode qui vérifie si l'arc sortant est activé (la place source contient un nombre de jetons
     * au moins égal au poids de l'arc sortant).
     *
     * @return true si l'arc sortant est activé, false sinon.
     */
    public boolean Actif() {
        int poidsSortant = getPoidsSortant();
        int jetonsDansSource = source.getJeton();

        return jetonsDansSource >= poidsSortant;
    }

    /**
     * Redéfinition de la méthode toString pour obtenir une représentation
     * sous forme de chaîne de caractères de l'objet ArcSortant.
     *
     * @return La représentation sous forme de chaîne de caractères de l'objet ArcSortant.
     */
    @Override
    public String toString() {
        return "ArcSortant [source = une place qui contient " + source.getJeton() + " vers une transition " + transition.toString() + "]";
    }
}