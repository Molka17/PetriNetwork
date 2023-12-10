package org.pneditor.petrinet.models.oumol;
import java.util.List;

public interface IPetriNet {

    // Ajouter un emplacement (place)
    void addPlace(Place place);

    // Supprimer un emplacement (place)
    void removePlace(Place place);

    // Obtenir la liste des emplacements (places)
    //List<Place> getPlaces();

    // Supprimer une transition
    void removeTransition(Transition transition);

    // Obtenir la liste des transitions
    List<Transition> getTransitions();

    // Ajouter un arc
    void addArc(Arc arc);

    // Supprimer un arc
    void removeArc(Arc arc);
    
	void addTransition(Transition t);
}

