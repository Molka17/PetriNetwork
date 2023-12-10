package org.pneditor.petrinet.adapters.oumol;

import java.util.LinkedList;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.oumol.Arc;
import org.pneditor.petrinet.models.oumol.ArcEntrant;
import org.pneditor.petrinet.models.oumol.Place;

public class PlaceAdapter extends AbstractPlace {
	Place p ;
	public Place getP() {
		return p;
	}

	public void setP(Place p) {
		this.p = p;
	}

	public PlaceAdapter(String label , Place p) {
		super(label);
		this.p = p; 
	}

	@Override
	public void addToken() {
		p.addJeton(1);
		
	}

	@Override
	public void removeToken() {
		p.removeJeton(this.getTokens());
		
	}

	@Override
	public int getTokens() {
		
		return p.getJeton();
	}

	@Override
	public void setTokens(int tokens) {
		p.setJeton(tokens);
		
	}
	public LinkedList<ArcAdapter> getAllArcsAdapter ()
	{
		LinkedList<ArcAdapter> allArcForPlace = new LinkedList<ArcAdapter>();
		for(Arc a : this.p.getArcsEntrants())
		{
			ArcAdapter ap = new ArcAdapter(a);
			allArcForPlace.add(ap);
		}
		for(Arc a : this.p.getArcsSortants())
		{
			ArcAdapter ap = new ArcAdapter(a);
			allArcForPlace.add(ap);
		}
		return allArcForPlace ;
		
	}

}
