package org.pneditor.petrinet.adapters.oumol;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.oumol.Arc;
import org.pneditor.petrinet.models.oumol.ArcEntrant;
import org.pneditor.petrinet.models.oumol.ArcSortant;
import org.pneditor.petrinet.models.oumol.ArcVideur;
import org.pneditor.petrinet.models.oumol.ArcZero;
import org.pneditor.petrinet.models.oumol.Place;
import org.pneditor.petrinet.models.oumol.Transition;

public class ArcAdapter extends AbstractArc {
	Arc a ; 
	
	
	public ArcAdapter(Arc a)
	{
		this.a = a; 
		
	}


	@Override
	public AbstractNode getSource() {
		if (a instanceof ArcSortant) {
			PlaceAdapter p =new PlaceAdapter("" , ((ArcSortant) a).getSource());  
			return p ; 
		}else {
			
			TransitionAdapter t =new TransitionAdapter("" ,((ArcEntrant) a).getTransition()); 
			return t ; 
		}
	}


	@Override
	public AbstractNode getDestination() {
		if (a instanceof ArcSortant) {
			Transition t0 = ((ArcSortant) a).getTransition();
			TransitionAdapter t =new TransitionAdapter("" , t0); 
			return t ;
		}else {
			Place p0 = ((ArcEntrant) a).getCible();  
			PlaceAdapter p =new PlaceAdapter("" , p0); 
			return p ; 	
		}
	}


	@Override
	public boolean isReset() {
		
		return a instanceof ArcVideur; 
	}


	@Override
	public boolean isRegular() {
		
		return true;
	}
//arc zeroooo

	@Override
	public boolean isInhibitory() {
		
		return a instanceof ArcZero;
	}


	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return a.getPoids();
	}


	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		a.setPoids(multiplicity);
		
	}
	
	

}
