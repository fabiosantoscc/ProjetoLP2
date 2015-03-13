package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import classes.dadosDoHospede.Hospede;
import classes.servicos.AluguelDeCarros;
import classes.servicos.BabySitter;
import classes.servicos.Restaurante;
import classes.servicos.Servico;
import excecoes.ContratoAbertoException;
import excecoes.HospedeInvalidoException;
import excecoes.StringInvalidaException;

/**
 * Classe que representa um hotel.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 10/02/2015.
 * 
 */

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	private Calendar dataDeInicio;
    private String pin;
    
    /* Variaveis statics para aumentar ou diminuir
    * a quantidade dos quartos.
    */

    private static int quartoPresidencial = 5;
	private static int quartoExecutivoSimples = 5;
	private static int quartoExecutivoDuplo = 15;
	private static int quartoExecutivoTriplo = 20;
	private static int quartoLuxoSimples = 5;
	private static int quartoLuxoDuplo = 15;
	private static int quartoLuxoTriplo = 20;
	private int maisRestaurante = 0;
	private int maisBaby = 0;
	private int maisAluguel = 0;
	private static HashMap<String, Integer> quartosUsados = new HashMap<String, Integer>();
	private double notaDeAceitacao = 0;
	private double lucroTotal;
	
	private HashMap<String, Double> LucroPorMes = new HashMap<String, Double>();
	private List<String> datasLucro = new ArrayList<String>();
	private List<Double> valorDosMeses = new ArrayList<Double>();
	private List<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	// map com um hospede como chave, e um List<Contrato> como valor para guardar todos os contratos do hospede.
	private HashMap<Hospede, List<Contrato>> hospedes = new HashMap<Hospede, List<Contrato>>();
	
	// Opinioes dos hospedes que fizeram checkout no hotel.
	private List<Opiniao> opinioes = new ArrayList<Opiniao>();
	
	/**
	 * Construtor da classe Hotel
	 * @param pin Codigo a ser usado na hora do cadastro
	 * @throws StringInvalidaException
	 */
	
	public Hotel( String pin ) throws StringInvalidaException {
		if ( pin == null || pin.equals("") ) {
			throw new StringInvalidaException("Pin nao pode ser vazio.");
		}
		
		this.pin = pin;
		dataDeInicio = Calendar.getInstance();
		iniciaMapaDeQuartos();
	}
	
	/**
	 * @return Numero do pin a ser usado no cadastro
	 */
	
	public String getPin() {
		return pin;
	}
	
	/**
	 * @return Mapa contendo todos os hospedes do hotel e seus contratos
	 */
	
	public HashMap<Hospede, List<Contrato>> getHospedes(){ 
		return hospedes;
	}
	
	
	/**
	 * @return Lista com os funcionarios cadastrados pelo sofware
	 */
	
	public List<Cadastro> getCadastros() {
		return cadastros;
	}
	
	/**
	 * @return Mapa dos quartos com a quantidade de vezes que cada um foi contratado
	 */
	
	public static HashMap<String, Integer> getMapaDeQuartos(){
		return quartosUsados;
	}
	
	/**
	 * Remove um hospede da lista de hospedes do hotel
	 * @param cpf Cpf do hospede a ser removido
	 * @throws HospedeInvalidoException
	 */
	
	public void removeHospede(String cpf) throws HospedeInvalidoException{
		hospedes.remove(this.pesquisaHospede(cpf));
	}
	
	//Metodo que inicializa a quantidade de vezes que cada quarto foi contratado
	//Eh chamado no construtor
	
	private void iniciaMapaDeQuartos(){
		quartosUsados.put("Quarto Presidencial", 0);
		quartosUsados.put("Quarto Executivo Simples", 0);
		quartosUsados.put("Quarto Executivo Duplo", 0);
		quartosUsados.put("Quarto Executivo Triplo", 0);
		quartosUsados.put("Quarto Luxo Simples", 0);
		quartosUsados.put("Quarto Luxo Duplo", 0);
		quartosUsados.put("Quarto Luxo Triplo", 0);
	}
	
	/**
	 * Metodo que verifica o quarto que foi mais alugado ate o momento
	 * @return Um string contendo o quarto e a quantidade de vezes que ele foi alugado
	 */
	
	public String verificaQuartoMaisAlugado(){
		int maximo = 0;
		String quartoMaisUsado = "";
		//Percorre o mapa de quarto e compara qual foi o mais usado
		for (String tipo : quartosUsados.keySet()){
			if (quartosUsados.get(tipo) >= maximo){
				maximo = quartosUsados.get(tipo);
				quartoMaisUsado = tipo;
			}
		}
		return "Quarto mais usado: "+ quartoMaisUsado +". Quantidade de vezes: "+maximo;
	}
	
	/**
	 * Adiciona novo cadastro à lista de cadastros para possibilitar o acesso de um novo funcionário ao software 
	 * @param funcionario - Cadastro com dados de um novo funcionario 
	 * @param pinFuncionario - O Número PIN inserido pelo funcionario para a autorização da criação da conta
	 * @throws Exception - Número PIN fornecido pelo funcionario não coincide com o do sistema.
	 */
	
	public void adicionarCadastro(Cadastro funcionario, String pinFuncionario) throws Exception{
		if (!(pinFuncionario.equals(pin))){
			throw new Exception("Pin Inválido!");
		}
		verificaCadastroExistente(funcionario.getNomeLogin());
		cadastros.add(funcionario);
	}
	
	/**
	 * Metodo que verifica qual foi o lucro de cada mes desde que o hotel foi aberto
	 */
	
	public void checaLucroMensal() {
		int mesInicio = dataDeInicio.get(Calendar.MONTH) + 1;
		int anoInicio = dataDeInicio.get(Calendar.YEAR);
		Calendar dataAtual = Calendar.getInstance();
		double totalMensal = 0;
		//Esse while co para quando mes do inicio (que vai sendo encrementada) for maior que mes atual
		while (mesInicio <= (dataAtual.get(Calendar.MONTH) + 1) && anoInicio <= dataAtual.get(Calendar.YEAR)) {
			//Percorre a lista de hospedes para cada mes percorrido no while acima
			for (Hospede h : hospedes.keySet()) {
				//Percorre cada contrato de cada hospede existente
				for (Contrato contrato : hospedes.get(h)){
					//Se o contrato nao estiver aberto e o mes for igual ao mes
					//da iteracao atual ele adiciona a variavel totalMensal o valor do contrato naquele mes
						if (contrato.isAberto()) continue;
						if ((contrato.getDataFinal().get(Calendar.MONTH) + 1) == mesInicio && 
								contrato.getDataFinal().get(Calendar.YEAR) == anoInicio) totalMensal += contrato.getValorAPagar();
					}
			}
			//Agora apos verificar todos os lucros em um mes ele adiona ao mapa o mes e o total de lucro obitido nele
			LucroPorMes.put(""+mesInicio+"/"+anoInicio, totalMensal);
			datasLucro.add("Mes: " + mesInicio + "Ano: " + anoInicio);
			valorDosMeses.add(totalMensal);
			if(mesInicio == 12) {
				mesInicio = 1;
				anoInicio++;
			}
			else mesInicio++;
			lucroTotal += totalMensal;
			totalMensal = 0;
		}
	}
	
	/**
	 * @return Calcula o redimento medio a partir do rendimento de cada mes
	 */
	
	public double calculaRendimentoMedioMensal(){
		return lucroTotal / valorDosMeses.size();
	}
	
	private void verificaCadastroExistente(String login) throws Exception{
		for (Cadastro cadastro : cadastros){
			if (cadastro.getNomeLogin().equals(login)){
				throw new Exception("Usuário já existente, altere o login!");
			}
		}	
	}
	
	/**
	 * 
	 * @return Retorna um mapa com os meses e o respectivo faturamento até entao
	 */
	public HashMap<String, Double> getLucroPorMes(){
		return LucroPorMes;
	}
	
	/**
	 * @return Retorna uma lista de meses que o hotel percorreu desde que esta aberto
	 */
	
	public List<String> getListaDeMeses(){
		return datasLucro;
	}
	
	/**
	 * Recupera o lucro mensal.
	 *  
	 * @return Uma lista de lucro mensal
	 */
	
	public List<Double> getLucroMensal(){
		return valorDosMeses;
	}
	
	/**
	 * Busca, se existe algum funcionario com o login passado como parâmetro 
	 * @param login - Login do funcionário que deseja encontrar
	 * @return Cadastro, se existente, do referido login
	 * @throws Exception Usuário não existe no sistema
	 */
	
	
	public Cadastro buscarCadastro(String login) throws Exception {
		for (Cadastro cadastro : cadastros) {
			if (cadastro.getNomeLogin().equals(login)) {
				return cadastro;
			}
		}
		throw new Exception("Usuário Inexistente");
	}
	
	/**
	 * Realiza o checkout de um contrato, ou seja, deixa ele como fechado.
	 * 
	 * @param hospede - Hospede do qual vai se fazer o checkout.
	 * @throws Exception
	 * @return Relatório com todas as informações do referente contrato
	 */
	
	public String realizaCheckout( Hospede hospede ) throws Exception {
		List<Contrato> contratos =  hospedes.get(hospede);
		Contrato contratoAberto = null;
		boolean existeContratoAberto = false;
		
		for ( Contrato contrato : contratos ) {
			if ( contrato.isAberto()) {
				contratoAberto = contrato;
				contrato.setAberto(false);
				existeContratoAberto = true;
				contrato.calculaDespesaTotal();
				contrato.setDataFinal();
			}
		}
		if ( !(existeContratoAberto) ) {
			throw new Exception("Não existe nenhum contrato aberto, impossivel remover contrato");
		}
		return contratoAberto.toString();
		
		
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
	
	public Hospede pesquisaHospede( String cpf ) throws HospedeInvalidoException {
		Hospede h = null;
		Set <Hospede> meusHospedes = hospedes.keySet();
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Hospede nao existente no hotel");
		
		for ( Hospede umHospede : meusHospedes ) {
			if ( umHospede.getCpf().equals(cpf) ) {
				h = umHospede;
			}
		}

		if ( h == null )
			throw new HospedeInvalidoException("Hospede nao existente no hotel.");
		
		return h;
	}
	
	/**
	 * @return Um mapa com a quantidade de vezes que servicos extra foram contratados
	 */
	
	public HashMap<String, Integer> ServicosContratados(){
		HashMap<String, Integer> servicos = new HashMap<String, Integer>();
		servicos.put("Aluguel de Veiculos", maisAluguel);
		servicos.put("Restaurante", maisRestaurante);
		servicos.put("Baby Sitter", maisBaby);
		return servicos;
	}
	
	/**
	 * Metodo que verifica o servico mais solicitado ate o momento no hotel.
	 * 
	 * @return Uma string com o servico mais solicitado e a quantidade de vezes que foi solicitado
	 */
	
	public String servicoPopular() {
		if (maisAluguel >= maisBaby && maisAluguel >= maisRestaurante) {
			return "Aluguel de Carros, com " + maisAluguel+" contratos";
		}
		
		if (maisBaby >= maisAluguel && maisBaby >= maisRestaurante) {
			return "Babby Sitter, com " + maisBaby+" contratos";
		}
		
		if (maisRestaurante >= maisAluguel && maisRestaurante >= maisBaby) {
			return "Restaurante, com " + maisRestaurante+" contratos"; 
		}
		
		return "Sem serviços adicionais contratados";
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
	 * @param hospede - Hospede onde vai se adicionar os servicos.
	 * @param meusServicos - Todos os servicos a serem adicionados con contrato.
	 * @throws ContratoAbertoException 
	 * @throws HospedeInvalidoException 
	 */

	public void adicionaVariosServicos(Hospede hospede, List<Servico> meusServicos) throws HospedeInvalidoException, ContratoAbertoException {
		
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
	 * Adiciona um servico ao contrato aberto do hospede, se existir.
	 * 
	 * @param esseHospede - Hospede a adicionar servico.
	 * @param umServico - Servico a adicionar.
	 * @throws ContratoAbertoException - Contrato fechado.
	 */
	
	public void adicionaServico( Hospede esseHospede, Servico umServico ) throws ContratoAbertoException {
		boolean isContratoAberto = false;
		
		List<Contrato> contratos = this.hospedes.get(esseHospede);
		for ( Contrato c : contratos ) {
			if ( c.isAberto() ) {
				if (umServico instanceof Restaurante){
					maisRestaurante++;
				}else if(umServico instanceof AluguelDeCarros){
					maisAluguel++;
				}else if(umServico instanceof BabySitter){
					maisBaby++;
				}
				c.adicionaServico(umServico);
				isContratoAberto = true;
			}
		}
		
		if ( !(isContratoAberto) ) {
			throw new ContratoAbertoException("Impossivel adicionar um servico\nO hospede nao possui nenhum contrato aberto.");
		}
	}
	
	/**
	 * Verifica Se há algum contrato aberto no hotel
	 * @param hospede Hospede que deve ser verificado
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
	 * @throws Exception.
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
	 * @return HashMap<Hospede, List<Contrato> - O HashMap com essas infromacoes.
	 */
	
	public HashMap<Hospede, List<Contrato>> getMapaDeHospedes() {
		return hospedes;
	}
	
	/**
	 * Recupera a lista de serviços de determinado hospede.
	 * 
	 * @param hospede - Hospede do qual deseja-se pesquisar a lista de servicos.
	 * @return - Todos os servicos do hospede.
	 * @throws Exception - Nao exixte contrato aberto.
	 */
	
	public List<Servico> getServicosHospede( Hospede hospede ) throws Exception {
		boolean isContratoAberto = false;
		List <Contrato> meusContratos = hospedes.get(hospede);
		List<Servico> servicos = null;
		
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
	 * Adiciona um hospede no hotel.
	 * 
	 * @param hospede - Hospede a ser adicionado no hotel.
	 * @throws HospedeInvalidoException - Hospede Invalido.
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

  /**
   * Calcula nota de aceitacao do hotel.
   * 
   * @param opinioes - Opinioes do hotel.
   */
	
  private void calculaNotaDeAceitacao( List<Opiniao> opinioes ) {
    double soma = 0.0;
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
		
	public static int getQuartoPresidencial() {
		return quartoPresidencial;
	}
	
	public static void setQuartoPresidencial(int quartoPresidencial) {
		Hotel.quartoPresidencial = quartoPresidencial;
	}

	public static int getQuartoExecutivoSimples() {
		return quartoExecutivoSimples;
	}

	public static void setQuartoExecutivoSimples(int quartoExecutivoSimples) {
		Hotel.quartoExecutivoSimples = quartoExecutivoSimples;
	}
	
	public static int getQuartoExecutivoDuplo() {
		return quartoExecutivoDuplo;
	}
	
	public static void setQuartoExecutivoDuplo(int quartoExecutivoDuplo) {
		Hotel.quartoExecutivoDuplo = quartoExecutivoDuplo;
	}

	public static int getQuartoExecutivoTriplo() {
		return quartoExecutivoTriplo;
	}
	
	public static void setQuartoExecutivoTriplo(int quartoExecutivoTriplo) {
		Hotel.quartoExecutivoTriplo = quartoExecutivoTriplo;
	}
	
	public static int getQuartoLuxoSimples() {
		return quartoLuxoSimples;
	}
	
	public static void setQuartoLuxoSimples(int quartoLuxoSimples) {
		Hotel.quartoLuxoSimples = quartoLuxoSimples;
	}
	
	public static int getQuartoLuxoDuplo() {
		return quartoLuxoDuplo;
	}
	
	public static void setQuartoLuxoDuplo(int quartoLuxoDuplo) {
		Hotel.quartoLuxoDuplo = quartoLuxoDuplo;
	}
	
	public static int getQuartoLuxoTriplo() {
		return quartoLuxoTriplo;
	}
	
	public static void setQuartoLuxoTriplo(int quartoLuxoTriplo) {
		Hotel.quartoLuxoTriplo = quartoLuxoTriplo;
	}
	
	public String getComentarios() {
		String comentarios = "";
		for ( Opiniao op : getListaOpinioes() ) {
			comentarios += op.getComentario();
			comentarios += "\n";
		}
		
		return comentarios;
	}

  /**
  * Recupera as opinios dos hospedes.
  * 
  * @return List<Opiniao> - Opinioes dos hospedes.
  */

  public List<Opiniao> getListaOpinioes(){
    return opinioes;
  }
}
