package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

import excecoes.*;


/**
 * Classe que representa um hotel.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 10/02/2015 / Fabio Alexandre
 * 
 */

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static int camaExtra = 20;
	private static int quartoPresidencial = 5;
	private static int quartoExecutivoSimples = 5;
	private static int quartoExecutivoDuplo = 15;
	private static int quartoExecutivoTriplo = 20;
	private static int quartoLuxoSimples = 5;
	private static int quartoLuxoDuplo = 15;
	private static int quartoLuxoTriplo = 20;
	private double notaDeAceitacao = 0;
	private List<Opiniao> opinioes = new ArrayList<Opiniao>();
	
	// map com um hospede como chave, e um List<Contrato> como valor
	HashMap<Hospede, List<Contrato>> hospedes = new HashMap<Hospede, List<Contrato>>();
	
	/**
	 * Realiza o checkout de um método, ou seja, deixa ele como fechado.
	 * 
	 * @param hospede - Hospede do qual vai se fazer o checkout.
	 * @throws Exception
	 */
	
	public void realizaCheckout( Hospede hospede ) throws Exception {
		List<Contrato> contratos =  hospedes.get(hospede);
		boolean existeContratoAberto = false;
		
		for ( Contrato contrato : contratos ) {
			if ( contrato.isAberto() == true ) {
				contrato.setAberto(false);
				existeContratoAberto = true;
			}
		}
		
		if ( !(existeContratoAberto) ) {
			throw new Exception("Não existe nenhum contrato aberto, impossivel remover contrato");
		}
	}
	
	/**
	 * Recupera o contrato aberto de determinado hospede.
	 * 
	 * @param hospede - Hospede do qual vai se fazer a busca.
	 * @return Contrato - Contrato aberto do hospede.
	 * @throws Exception
	 */
	
	public Contrato getContratoAberto(Hospede hospede) throws Exception {
		List<Contrato> contratos =  hospedes.get(hospede);
		for ( Contrato contrato : contratos ) {
			if ( contrato.isAberto() == true ) {
				return contrato;
			}
		}
		
		throw new Exception("Não existe nenhum contrato aberto");
	}
	
	/**
	 * Recupera algum hospede no hotel, de acordo com o cpf ou o nome.
	 * 
	 * @param cpf - cpf do hospede a ser pesquisado.
	 * @return Hospede - Hospede pesquisado, se existir.
	 * @throws HospedeInvalidoException
	 */
	
	public Hospede pesquisaHospede( String cpf, String nome ) throws HospedeInvalidoException {
		Hospede h = null;
		Set <Hospede> meusHospedes = hospedes.keySet();
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Hospede nao existente no hotel");
		
		for ( Hospede umHospede : meusHospedes ) {
			if ( umHospede.getCpf().equals(cpf) || umHospede.getNome().equals(nome)) {
				h = umHospede;
			}
		}
		
		if ( h == null )
			throw new HospedeInvalidoException("Hospede nao existente no hotel.");
		
		return h;
	}
	
	/**
	 * Recupera a lista de contratos do hospede.
	 * 
	 * @param hospedeAtual - Hospede do qual se vai buscar os contratos.
	 * @return Contrato - Todos os contratos do hospede, seja ele aberto ou fechado.
	 */
	
	public List<Contrato> pesquisarContratos(Hospede hospedeAtual){
		return hospedes.get(hospedeAtual);
	}
	
	/**
	 * Adiciona varios servicos a determinado hospede.
	 * 
	 * @param hospede - Hosped onde vai se adicionar os servicos.
	 * @param meusServicos - Todos os servicos a serem adicionados con contrato.
	 * @throws ContratoAbertoException 
	 * @throws HospedeInvalidoException 
	 */
	
	public void adicionaVariosServicos(Hospede hospede, List<Servicos> meusServicos) throws HospedeInvalidoException, ContratoAbertoException {
		
		List<Contrato> contratos =  hospedes.get(hospede);
		boolean contratoAberto = false;
		
		for ( Contrato meuContrato : contratos ) {
			if ( meuContrato.isAberto() ) {
				meuContrato.servicosContrato(meusServicos);
				contratoAberto = true;
			}
		}
		
		if ( contratoAberto == false ) {
			throw new ContratoAbertoException("Nenhum contrato aberto para o hospede");
		}
	}
	
	/**
	 * Retorna o restaurante da lista de servicos.
	 * 
	 * @param Hospede - Hospede do qual vai se fazer a pesquisa.
	 * @return - O restaurante do contrato
	 * @throws Exception
	 */
	
	public Restaurante getRestaurante( Hospede hospede ) throws Exception {
		Set <Hospede> meusHospedes = hospedes.keySet();
		boolean restauranteEncontrado = false;
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Nao existe hospedes no hotel.");

		for ( Hospede umHospede :  meusHospedes ) {
			
			if ( umHospede.getCpf().equals(hospede.getCpf()) || umHospede.getNome().equals(hospede.getNome()) ) {
				List<Contrato> contratos = hospedes.get(umHospede);
				for ( Contrato contrato : contratos ) {
					if ( contrato.isAberto()) {
						List<Servicos> servicos = contrato.getServicos();
						for ( Servicos servico : servicos ) {
							if ( servico instanceof Restaurante )
								return (Restaurante) servico;
						}
					}	
				}
			}
		}
		
		if ( restauranteEncontrado == false ) {
			throw new Exception("Restaurante inexistente");
		}
		
		return null;
	}
	
	/**
	 * Adiciona um servico ao contrato aberto do hospede, se existir.
	 * 
	 * @param esseHospede
	 * @param umServico
	 * @throws ContratoAbertoException 
	 */
	
	public void adicionaServico( Hospede esseHospede, Servicos umServico ) throws ContratoAbertoException {
		boolean isContratoAberto = false;
		
		List<Contrato> contratos = this.hospedes.get(esseHospede);
		for ( Contrato c : contratos ) {
			if ( c.isAberto() ) {
				c.adicionaServico(umServico);
				isContratoAberto = true;
			}
		}
		
		if ( !(isContratoAberto) ) {
			throw new ContratoAbertoException("Impossivel adicionar um servico\nO hospede nao possui nenhum contrato aberto.");
		}
	}
	
	/**
	 * 
	 * @param hospede
	 * @throws HospedeInvalidoException
	 * @throws ContratoAbertoException
	 */
	
	public void verificaContratoAberto( Hospede hospede ) throws HospedeInvalidoException, ContratoAbertoException {
		Set <Hospede> meusHospedes = hospedes.keySet();
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Para criar um contrato eh necessario\nque exista hospede no hotel.");

		for ( Hospede umHospede :  meusHospedes ) {
			
			if ( umHospede.getCpf().equals(hospede.getCpf()) || umHospede.getNome().equals(hospede.getNome()) ) {
				List<Contrato> contratos = hospedes.get(umHospede);
				for ( Contrato contrato : contratos ) {
					if ( contrato.isAberto())
						throw new ContratoAbertoException("Impossivel abrir outro contrato para o cliente\nJá existe um contrato em aberto");
				}
			}
		}
	}
	
	/**
	 * Cria um contrato para o hospede, checkin.
	 * 
	 * @param hospede - Hospede do qual vai se criar cum contrato.
	 * @param noites - Noite de estadia no hotel.
	 * @throws Exception
	 */
	
	public void criaContrato( Hospede hospede, int noites ) throws Exception {

		verificaContratoAberto(hospede);
		Contrato addContrato = new Contrato(noites);
		List<Contrato> contratos = hospedes.get(hospede);
		contratos.add(addContrato);
	}
	
	/**
	 * Retorna o HashMap Hospede : Contratos do hotel.
	 * 
	 * @return O HashMap com essas infromacoes.
	 */
	
	public HashMap<Hospede, List<Contrato>> getMapaDeHospedes() {
		return hospedes;
	}
	
	/**
	 * Recupera a lista de serviços de determinado hospede.
	 * 
	 * @param hospede - Hospede do qual deseja-se pesquisar a lista de servicos.
	 * @return - Todos os servicos do hospede.
	 * @throws Exception
	 */
	
	public List<Servicos> getServicosHospede( Hospede hospede ) throws Exception {
		boolean isContratoAberto = false;
		List <Contrato> meusContratos = hospedes.get(hospede);
		List<Servicos> servicos = null;
		
		for ( Contrato meuContrato : meusContratos ) {
			if ( meuContrato.isAberto() ) {
				servicos = meuContrato.getServicos();
				isContratoAberto = true;
			}
		}
		
		if ( isContratoAberto == false ) {
			throw new Exception("Não existe nenhum contrato aberto.");
		}
		
		return servicos;
	}
	
	/**
	 * Adiciona um hospede no hotel
	 * 
	 * @param hospede - Hospede a ser adicionado no hotel
	 * @throws HospedeInvalidoException 
	 */
	
	public void addHospede( Hospede hospede ) throws HospedeInvalidoException {
		Set <Hospede> meusHospedes = hospedes.keySet();
		
		for ( Hospede esseHospede: meusHospedes ) {
			if ( esseHospede.getCpf().equals(hospede.getCpf()) || esseHospede.getNome().equals(hospede.getNome()) ) {
				throw new HospedeInvalidoException("Esse hospede ja esta cadastrado no hotel.");
			}
		}
		
		List<Contrato> contratos = new ArrayList<Contrato>();
		hospedes.put(hospede, contratos);
	}
	
	/**
	 * Recupera a nota de aceitacao do hotel.
	 * 
	 * @return NotaDeAceitacao - A nota de aceitacao do hotel.
	 */
	
	public double getNotaDeAceitacao() {
		return notaDeAceitacao;
	}
	
	private void calculaNotaDeAceitacao( List<Opiniao> opinioes ) {
		int soma = 0;
		for ( int i = 0; i < opinioes.size(); i++) {
			soma += opinioes.get(i).getNota();
		}
		
		double nota = soma / opinioes.size();
		this.notaDeAceitacao = nota;
	}
	
	/**
	 * 
	 * Metodo que adiciona uma opiniao no hotel e toda vez que adiciona ja calcula a nota de aceitacao
	 * baseada na ultima opiniao
	 * 
	 * @param umaOpiniao - Opiniao a ser adicionada oriunda de algum hospede
	 */
	
	public void adicionaOpiniao( Opiniao umaOpiniao ) {
		this.opinioes.add(umaOpiniao);
		calculaNotaDeAceitacao(opinioes);
	}
	
	/**
	 * Recupera a quantidade de cama extra do hotel.
	 * 
	 * @return - Cama extra - A quantidade de camas extra do hotel.
	 */
	
	public static int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * Atribui uma nova quantidade de cama extra.
	 * 
	 * @param camaExtra - Nova quantidade a ser atribuida.
	 */
	
	public static void setCamaExtra(int camaExtra) {
		Hotel.camaExtra = camaExtra;
	}
	
	/**
	 * Recupera a quantidade de quarto presidencial do hotel.
	 * 
	 * @return - Quantidade de Quarto Presidencial do hotel.
	 */
	
	public static int getQuartoPresidencial() {
		return quartoPresidencial;
	}

	/**
	 * 
	 * @param quartoPresidencial
	 */
	
	public static void setQuartoPresidencial(int quartoPresidencial) {
		Hotel.quartoPresidencial = quartoPresidencial;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoSimples() {
		return quartoExecutivoSimples;
	}

	/**
	 * 
	 * @param quartoExecutivoSimples
	 */
	
	public static void setQuartoExecutivoSimples(int quartoExecutivoSimples) {
		Hotel.quartoExecutivoSimples = quartoExecutivoSimples;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoDuplo() {
		return quartoExecutivoDuplo;
	}

	/**
	 * 
	 * @param quartoExecutivoDuplo
	 */
	
	public static void setQuartoExecutivoDuplo(int quartoExecutivoDuplo) {
		Hotel.quartoExecutivoDuplo = quartoExecutivoDuplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoTriplo() {
		return quartoExecutivoTriplo;
	}

	/**
	 * 
	 * @param quartoExecutivoTriplo
	 */
	
	public static void setQuartoExecutivoTriplo(int quartoExecutivoTriplo) {
		Hotel.quartoExecutivoTriplo = quartoExecutivoTriplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoSimples() {
		return quartoLuxoSimples;
	}

	/**
	 * 
	 * @param quartoLuxoSimples
	 */
	
	public static void setQuartoLuxoSimples(int quartoLuxoSimples) {
		Hotel.quartoLuxoSimples = quartoLuxoSimples;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoDuplo() {
		return quartoLuxoDuplo;
	}

	/**
	 * 
	 * @param quartoLuxoDuplo
	 */
	
	public static void setQuartoLuxoDuplo(int quartoLuxoDuplo) {
		Hotel.quartoLuxoDuplo = quartoLuxoDuplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoTriplo() {
		return quartoLuxoTriplo;
	}

	/**
	 * 
	 * @param quartoLuxoTriplo
	 */
	
	public static void setQuartoLuxoTriplo(int quartoLuxoTriplo) {
		Hotel.quartoLuxoTriplo = quartoLuxoTriplo;
	}
	
	public List<Opiniao> getListaOpinioes(){
		return opinioes;
	}
	
	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "";
	}
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !( obj instanceof Hotel ) ) {
			return false;
		}
		return true;
	}
}
