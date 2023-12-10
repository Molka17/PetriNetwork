package org.pneditor.petrinet.adapters.oumol;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.oumol.Transition;

public class TransitionAdapter extends AbstractTransition{
	Transition t ;
	public TransitionAdapter(String label , Transition t) {
		super(label);
		this.t = t; 
		
		// TODO Auto-generated constructor stub
	}
	public Transition getT() {
		return t;
	}
	public void setT(Transition t) {
		this.t = t;
	}

}
