package org.pneditor.petrinet.adapters.oumol;

import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.oumol.ArcEntrant;

public class ArcEntrantAdapter extends ArcAdapter {
	ArcEntrant arcE;
	public ArcEntrantAdapter(ArcEntrant arcE) {
		super(arcE);
		
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
