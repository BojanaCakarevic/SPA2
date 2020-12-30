package tv01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.svetovid.Svetovid;

public class MrezaLinijaProgram {
	public static void main(String[] args) {

		MrezaLinija mreza = new MrezaLinija(Svetovid.in("res\\linije.txt"));

		Svetovid.out.println("Red voznje sadrzi sledece gradove:");
		Svetovid.out.println(mreza.gradovi());
		String polazniGrad = Svetovid.in.readLine("Unesite polazni grad:");
		String ciljniGrad = Svetovid.in.readLine("Unesite ciljni grad:");

		pronadjiPuteveRekurzivno(mreza, polazniGrad, ciljniGrad);

	}

	private static void pronadjiPuteveRekurzivno(MrezaLinija mreza, String polazniGrad, String ciljniGrad) {

		Put put = new Put();
		int brPuteva = pronadjiPuteveRekurzivno(mreza, put, 0, polazniGrad, ciljniGrad);
		if (brPuteva == 0) {
			Svetovid.out.println();
			Svetovid.out.println("Nazalost, ne postoji put izmadju datih gradova");
		}

	}

	private static int pronadjiPuteveRekurzivno(MrezaLinija mreza, Put put, int brPuteva, String polazniGrad,
			String ciljniGrad) {
		if (polazniGrad.equals(ciljniGrad)) {
			Svetovid.out.println(put);
			return ++brPuteva;

		}

		for (Linija linija : mreza.linije(polazniGrad)) {

			if (!put.sadrzi(linija.getDoGrada())) {
				put.produzi(linija);
				brPuteva = pronadjiPuteveRekurzivno(mreza, put, brPuteva, linija.getDoGrada(), ciljniGrad);
				put.skrati();
			}
		}
		return brPuteva;
	}
}
