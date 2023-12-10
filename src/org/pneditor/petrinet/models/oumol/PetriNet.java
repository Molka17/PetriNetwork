package org.pneditor.petrinet.models.oumol;


import java.util.LinkedList;
import java.util.List;

/**
 * La classe PetriNet représente un réseau de Petri avec des places, des transitions et des arcs.
 * Elle implémente l'interface IPetriNet.
 */
public class PetriNet implements IPetriNet {

    /**
     * Liste des places dans le réseau de Petri.
     */
    private LinkedList<Place> places;

    /**
     * Liste des transitions dans le réseau de Petri.
     */
    private LinkedList<Transition> transitions;

    /**
     * Liste des arcs dans le réseau de Petri.
     */
    private LinkedList<Arc> arcs;
    
    public List<Arc> getArcs() {
		return arcs;
	}
    /**
     * Constructeur de la classe PetriNet, initialise les listes de places, transitions et arcs.
     */
    public PetriNet() {
        places = new LinkedList<>();
        transitions = new LinkedList<>();
        arcs = new LinkedList<>();
    }

    /**
     * Ajoute une place au réseau de Petri.
     *
     * @param place La place à ajouter.
     */
    @Override
    public void addPlace(Place place) {
        places.add(place);
    }

    /**
     * Supprime une place du réseau de Petri.
     *
     * @param place La place à supprimer.
     */
    @Override
    public void removePlace(Place place) {
        places.remove(place);
        for(ArcEntrant a : place.getArcsEntrants())
        {
        	arcs.remove(a);
        }
        for(ArcSortant a : place.getArcsSortants())
        {
        	arcs.remove(a);
        }
    
    }

    /**
     * Ajoute une transition au réseau de Petri.
     *
     * @param t La transition à ajouter.
     */
    @Override
    public void addTransition(Transition t) {
        transitions.add(t);
    }

    /**
     * Supprime une transition du réseau de Petri.
     *
     * @param transition La transition à supprimer.
     */
    @Override
    public void removeTransition(Transition transition) {
        transitions.remove(transition);
    }

    /**
     * Obtient la liste des transitions dans le réseau de Petri.
     *
     * @return La liste des transitions.
     */
    @Override
    public List<Transition> getTransitions() {
        return transitions;
    }

    /**
     * Ajoute un arc au réseau de Petri.
     *
     * @param arc L'arc à ajouter.
     */
    @Override
    public void addArc(Arc arc) {
        arcs.add(arc);
    }
    
   /* public void addArcPlaceTransition(Place p, Transition t)
    {
    	ArcSortant arcsortnant= new ArcSortant(0, t);
    	arcsortnant.setSource(p);
    	arcsortnant.setTransition(t);
    	arcs.add(arcsortnant);
    	//arcsortnant.getSource().addArc(arcsortnant, t);
    	
    }
    public void addArcTransitionPlace( Transition t, Place p)
    {
    	ArcEntrant arcsortnant= new ArcEntrant(0, t);
    	arcsortnant.setCible(p);
    	arcsortnant.setTransition(t);
    	arcs.add(arcsortnant);
    	//arcsortnant.getCible().addArc(arcsortnant,t);;
    	
    }
*/
    /**
     * Supprime un arc du réseau de Petri.
     *
     * @param arc L'arc à supprimer.
     */
    @Override
    public void removeArc(Arc arc) {
        arcs.remove(arc);
    }

    /**
     * Méthode toString pour obtenir une représentation sous forme de chaîne de caractères du réseau de Petri.
     *
     * @return Une représentation sous forme de chaîne de caractères du réseau de Petri.
     */
    @Override
    public String toString() {
        String text = "PetriNet [" + Place.nbrPlace + " places=" + places + ","
                + Transition.nbrTransition + " transitions=" + transitions + ","
                + Arc.nbrArc + " arcs=" + arcs + "]\n"
                + "Liste des places :\n";
        for (Place p : places) {
            text = text + p.toString();
        }
        text = text + "\n Liste des Transitions:\n";
        for (Transition t : transitions) {
            text = text + t.toString();
        }
        text = text + "\n Liste des arcs:\n";
        for (Arc a : arcs) {
            text = text + a.toString();
        }
        return text;
    }

    /**
     * Méthode principale de test du réseau de Petri.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
     /*   PetriNet petriNet = new PetriNet();

        Place p = new Place(3);
        Place p1 = new Place(5);
        Place p2 = new Place(4);
        Place p3 = new Place(1);
        Place p4 = new Place(3);

        petriNet.addPlace(p);
        petriNet.addPlace(p1);
        petriNet.addPlace(p2);
        petriNet.addPlace(p3);
        petriNet.addPlace(p4);

        Transition t = new Transition();

        ArcSortant a = new ArcSortant(3, t);
        ArcSortant a1 = new ArcSortant(5, t);
        ArcSortant a2 = new ArcSortant(4, t);
        ArcEntrant a3 = new ArcEntrant(1, t);
        ArcEntrant a4 = new ArcEntrant(2, t);

        petriNet.addArc(a);
        petriNet.addArc(a1);
        petriNet.addArc(a2);
        petriNet.addArc(a3);
        petriNet.addArc(a4);

        ArrayList<ArcEntrant> ListEnt = new ArrayList<>();
        ListEnt.add(a3);
        ListEnt.add(a4);
        p3.setArcsEntrants(ListEnt);
        p4.setArcsEntrants(ListEnt);
        ArrayList<ArcSortant> ListSort = new ArrayList<>();
        ListSort.add(a);
        ListSort.add(a1);
        ListSort.add(a2);
        p.setArcsSortants(ListSort);
        p1.setArcsSortants(ListSort);
        p2.setArcsSortants(ListSort);
        t.setArcsEntrants(ListEnt);
        t.setArcsSortants(ListSort);

        petriNet.addTransition(t);

        p.addArc(a);
        p1.addArc(a1);
        p2.addArc(a2);
        p3.addArc(a3);
        p4.addArc(a4);

        System.out.println(petriNet.toString());
        
        t.step();

        System.out.println(petriNet.toString());
    }*/
}}

