package tv01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Put {
	private final List<Linija> linije;

	public Put() {
		linije = new ArrayList<>();
	}

	public Put(Put original) {
		this();
		linije.addAll(original.linije);
	}

	public boolean sadrzi(String grad) {

		if (!linije.isEmpty() && linije.get(0).getOdGrada().equals(grad)) {
			return true;
		}
		for (Linija linija : linije) {
			if (linija.getDoGrada().equals(grad)) {
				return true;
			}
		}
		return false;
	}

	public void produzi(Linija linija) {

		if (!linije.isEmpty()) {

			String poslednjiGrad = linije.get(linije.size() - 1).getDoGrada();

			if (!poslednjiGrad.equals(linija.getOdGrada())) {
				throw new IllegalArgumentException("linija");
			}
		}
		linije.add(linija);
	}

	public Linija skrati() {

		if (linije.isEmpty()) {
			throw new IllegalStateException("Prazan put ne moze da se skrati");
		}
		return linije.remove(linije.size() - 1);
	}

	public double ukupnaCena() {
		double ukupnaCena = 0.0;
		for (Linija linija : linije) {
			ukupnaCena = ukupnaCena + linija.getCenaKarte();
		}
		return ukupnaCena;
	}

	@Override
	public String toString() {
		return ukupnaCena() + " " + linije.toString();
	}
}
