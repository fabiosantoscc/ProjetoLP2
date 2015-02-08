package classes;

public class TestHotel {

	public static void main(String[] args) {
		
		Hotel h = new Hotel();
		
		try {
			Endereco endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil");
			Telefone telefone = new Telefone ("83", "99999999");
			Hospede hospede = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco);
			
			h.addHospede(hospede);
			h.pesquisaHospede("75265471855", "Anisio").setNome("chupa cabra");;
			
			System.out.println(h.pesquisaHospede("", "chupa cabra").toString());
			
			
		} catch ( Exception e ) {
			e.getMessage();
		}
	}
}
