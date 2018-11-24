import java.util.Comparator;

public class MunicipioComparator implements Comparator<Municipio> {

	@Override
	public int compare(Municipio o1, Municipio o2) {
		// TODO Auto-generated method stub
		return o1.getMunicipio().compareToIgnoreCase(o2.getMunicipio());
	}

}
