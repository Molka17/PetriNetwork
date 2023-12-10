package org.pneditor.petrinet.models.oumol;
/**
 * @author user
 *
 */
/**
 * La classe abstraite Arc représente un arc dans un graphe, caractérisé par un poids.
 * Les arcs peuvent être tirés avec une valeur spécifiée.
 */
public  class Arc {
    
    /**
     * Le poids de l'arc.
     */
    protected int poids;

    /**
     * Le nombre total d'arcs créés.
     */
    public static int nbrArc; 

    /**
     * Constructeur de la classe Arc.
     *
     * @param poids Le poids de l'arc. Doit être un entier non négatif.
     * @throws IllegalArgumentException Si le poids est négatif.
     */
    public Arc(int poids) {
        if (poids < 0) {
            throw new IllegalArgumentException("Le poids de l'arc ne peut pas être négatif.");
        }
        
        this.poids = poids;
        Arc.nbrArc++ ; 
    }

    /**
     * Obtient le poids de l'arc.
     *
     * @return Le poids de l'arc.
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Modifie le poids de l'arc.
     *
     * @param poids Le nouveau poids de l'arc.
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Obtient une représentation sous forme de chaîne de caractères de l'objet Arc.
     * Cette méthode est redéfinie pour renvoyer le nombre total d'arcs créés.
     *
     * @return La représentation sous forme de chaîne de caractères de l'objet Arc.
     */
    @Override
    public String toString() {
        return "" + Arc.nbrArc;
    }
    
    /**
     * Méthode abstraite représentant le tir d'un arc avec une valeur spécifiée.
     *
     * @param valeurTiree La valeur spécifiée lors du tir de l'arc.
     */
    public void tirer(int valeurTiree) {};

    /**
     * Méthode abstraite représentant le tir de l'arc sans valeur spécifiée.
     *
     * @return La valeur tirée lors du tir de l'arc.
     */
    public int tirer() {return 0;};
}