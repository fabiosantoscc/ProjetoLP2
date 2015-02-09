package classes;

public class TestHotel {

	static Hotel h = new Hotel();
	
	public static void main(String[] args) throws Exception {
		
//		Hotel hot = new Hotel();
//		Hotel hot2 = new Hotel();
		
		try {
			Endereco endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "32134321");
			Telefone telefone = new Telefone ("83", "99999999");
			Hospede hospede = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco);
			
			h.addHospede(hospede);
			h.pesquisaHospede("75265471855", "Anisio").setNome("chupa cabra");;
		} catch ( Exception e ) {
		}
		
//		Arquivos.salvaHotel(h);
//		hot = Arquivos.lerHotel();
	}
}
