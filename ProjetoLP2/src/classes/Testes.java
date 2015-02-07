package classes;

import javax.swing.JOptionPane;

public class Testes {

	public static void main(String[] args) throws Exception {
		Hotel h = new Hotel();
		Endereco e = new Endereco("Campina", "Pedregal", "Beco da facada", "268", "", "Paraiba", "Brasil");
		Telefone t = new Telefone("83", "88888888");
		Hospede ho = new Hospede("Fabio", "14482680605","4745168764360175", "fabio@fabio", t, e);
		h.addHospede(ho);
		System.out.println(h.getMapaDeHospedes().size());
	}
}
