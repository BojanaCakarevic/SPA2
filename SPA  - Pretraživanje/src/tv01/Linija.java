package tv01;

public class Linija {
	private final String odGrada;
	private final String doGrada;
	private final double cenaKarte;

	public Linija(String odGrada, String doGrada, double cenaKarte) {
		if (doGrada == null) {
			throw new IllegalArgumentException("doGrada");
		}
		this.doGrada = doGrada;

		if (odGrada == null) {
			throw new IllegalArgumentException("odGrada");
		}
		this.odGrada = odGrada;

		if (cenaKarte < 0.0) {
			throw new IllegalArgumentException("cena karte");
		}
		this.cenaKarte = cenaKarte;
	}

	public String getOdGrada() {
		return odGrada;
	}

	public String getDoGrada() {
		return doGrada;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	@Override
	public int hashCode() {
		final int prost = 31;
		int rezultat = 1;
		long temp;
		temp = Double.doubleToLongBits(cenaKarte);
		rezultat = prost * rezultat + (int) (temp ^ (temp >>> 32));
		rezultat = prost * rezultat + ((doGrada == null) ? 0 : doGrada.hashCode());
		rezultat = prost * rezultat + ((odGrada == null) ? 0 : odGrada.hashCode());
		return rezultat;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Linija other = (Linija) obj;
		if (Double.doubleToLongBits(cenaKarte) != Double.doubleToLongBits(other.cenaKarte))
			return false;

		if (doGrada == null) {
			if (other.doGrada != null)
				return false;

		} else if (!doGrada.equals(other.doGrada))
			return false;

		if (odGrada == null) {
			if (other.odGrada != null)
				return false;

		} else if (!odGrada.equals(other.odGrada))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return odGrada + " - " + doGrada + " ( " + cenaKarte + " )";
	}
}
