package tv01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.svetovid.io.SvetovidReader;

public class MrezaLinija {
	protected final Map<String, Set<Linija>> linije;

	public MrezaLinija() {
		linije = new HashMap<>();
	}

	public MrezaLinija(MrezaLinija mreza) {
		this();
		linije.putAll(mreza.linije);
	}

	public MrezaLinija(SvetovidReader in) {
		this();
		while (in.hasMore()) {
			String odGrada = null;
			do {
				odGrada = in.readLine();
			} while (odGrada != null && odGrada.isEmpty());

			String doGrada = in.readLine();
			double cenaKarte = in.readDoubleBoxed();

			if (odGrada != null & doGrada != null && cenaKarte != 0.0) {
				Linija linija = new Linija(odGrada, doGrada, cenaKarte);
				DodajLiniju(linija);
			}
		}
	}

	public List<String> gradovi() {

		Set<String> gradovi = new HashSet<>();

		for (Set<Linija> skup : linije.values()) {
			for (Linija linija : skup) {

				gradovi.add(linija.getOdGrada());
				gradovi.add(linija.getDoGrada());
			}
		}

		List<String> lista = new ArrayList<>(gradovi);

		Collections.sort(lista);
		return lista;

	}

	public Set<Linija> linije(String grad) {

		Set<Linija> rezultat = new HashSet<>();

		Set<Linija> skup = linije.get(grad);

		if (skup != null) {
			rezultat.addAll(skup);
		}

		return rezultat;

	}

	public void DodajLiniju(Linija linija) {
		String grad = linija.getOdGrada();
		Set<Linija> skup = linije.get(grad);

		if (skup == null) {
			skup = new HashSet<>();
			linije.put(grad, skup);
		}
		skup.add(linija);
	}

	public void ukloniLiniju(Linija linija) {

		String grad = linija.getOdGrada();
		Set<Linija> skup = linije.get(grad);

		if (skup == null) {
			return;
		}

		skup.remove(linija);

		if (skup.isEmpty()) {
			linije.remove(skup);
		}
	}
}
