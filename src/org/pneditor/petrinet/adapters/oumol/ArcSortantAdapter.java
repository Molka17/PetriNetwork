package org.pneditor.petrinet.adapters.oumol;

import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.oumol.ArcSortant;

public class ArcSortantAdapter extends ArcAdapter{
	ArcSortant arcS;
	public ArcSortantAdapter(ArcSortant arcS) {
		super(arcS);
		// TODO Auto-generated constructor stub
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
