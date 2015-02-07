package classes;

import excecoes.NumeroDeNoitesInvalidoException;

public class TestContrato {

	public static void main(String[] args) throws Exception {
		Contrato c = new Contrato(8);
		System.out.println(c.toString());
	}
}
