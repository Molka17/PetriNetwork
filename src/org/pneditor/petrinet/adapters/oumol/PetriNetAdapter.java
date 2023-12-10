package org.pneditor.petrinet.adapters.oumol;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.oumol.PetriNet;
import org.pneditor.petrinet.models.oumol.Place;
import org.pneditor.petrinet.models.oumol.Transition;
import org.pneditor.petrinet.models.oumol.Arc;
import org.pneditor.petrinet.models.oumol.ArcEntrant;
import org.pneditor.petrinet.models.oumol.ArcSortant;
import org.pneditor.petrinet.models.oumol.ArcVideur;
import org.pneditor.petrinet.models.oumol.ArcZero;

import org.pneditor.petrinet.models.*;
public class PetriNetAdapter extends PetriNetInterface{
	private PetriNet petri ;

	 public PetriNetAdapter() {
	        this.petri= new PetriNet();
	    }
	 
	
	@Override
	public AbstractPlace addPlace() {
		Place p0 = new Place(0); 
		String str= p0.getNom();
		PlaceAdapter p = new PlaceAdapter(str , p0); 
		petri.addPlace(p0);
		return p;
	}

	@Override
	public AbstractTransition addTransition() {
		Transition t0 = new Transition(); 
		String str= t0.getNom();
		TransitionAdapter t = new TransitionAdapter(str ,t0);
		petri.addTransition(t.t);
		return t;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if(source.isPlace())
		{
			PlaceAdapter s= (PlaceAdapter) source;
			TransitionAdapter d= (TransitionAdapter)destination;
			ArcSortant as = new ArcSortant(1, d.t);
			ArcSortantAdapter a = new ArcSortantAdapter(as);
			s.p.addArc(as, d.t);
			petri.addArc(as);
			AbstractArc arc = (AbstractArc)a ; 
			return arc;
		}else {
			PlaceAdapter d= (PlaceAdapter) destination;
			TransitionAdapter s= (TransitionAdapter)source;
			ArcEntrant ae= new ArcEntrant(1,s.t);
			ArcEntrantAdapter a = new ArcEntrantAdapter(ae);
			d.p.addArc(ae,  s.t);
			petri.addArc(ae);
			AbstractArc arc = (AbstractArc)a ; 
			return arc;
		}
	}
//arc zeroo
	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter s = (PlaceAdapter) place;
		TransitionAdapter t = (TransitionAdapter) transition;
		ArcZero as = new ArcZero( t.t);
		ArcSortantAdapter a = new ArcSortantAdapter(as);
		if (a.isInhibitory()) {
			s.p.addArc(as, t.t);
			petri.addArc(as);
			return a;
		}else throw (new UnimplementedCaseException("hkeya"));
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter s = (PlaceAdapter) place;
		TransitionAdapter t = (TransitionAdapter) transition;
		ArcVideur as = new ArcVideur( t.t);
		ArcSortantAdapter a = new ArcSortantAdapter(as);
		if (a.isInhibitory()) {
			s.p.addArc(as, t.t);
			petri.addArc(as);
			return a;
		}else throw (new UnimplementedCaseException("hkeya"));
	}

	@Override
	public void removePlace(AbstractPlace place) {
		PlaceAdapter p=(PlaceAdapter)place;
		petri.removePlace(p.p);
		
		for (ArcAdapter a : p.getAllArcsAdapter())
		{
			this.removeArc(a);
		}

			
		
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		TransitionAdapter t = (TransitionAdapter) transition;
        petri.removeTransition(t.t);
	}

	@Override
	public void removeArc(AbstractArc arc) {
		ArcAdapter a = (ArcAdapter) arc;;
		petri.removeArc(a.a);
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter t = (TransitionAdapter) transition;
		return t.t.verifTirable();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter t = (TransitionAdapter) transition;
		t.t.step();	
	}
}
