package testes;

import excecoes.NotaInvalidaException;
import classes.Opiniao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import excecoes.ComentarioInvalidoException;
import excecoes.InputArgumentInvalidException;

/*
 * Testes da classe Opiniao
 * 
 * Autor: Fabio Alexandre Santos Silva Junior
 *
 * Ultima revisao: 06/01/2015
 */

public class OpiniaoTest {

	Opiniao op;
	Opiniao op2;
	
	@Before
	public void criaObjetos() throws Exception {
		op = new Opiniao("Bom Hotel", 10.0);
		op2 = new Opiniao("Pessimo Hotel", 5.0);
	}
	
	@Test
	public void testConstrutor() throws InputArgumentInvalidException {
		try {
			op2 = new Opiniao("Belo hotel, grande acomodacao", 11.0);
			Assert.fail("Esperava excecao, nota invalida");
		} catch ( NotaInvalidaException e ) {
			Assert.assertEquals("Nota invalida", e.getMessage());
		}
		
		try {
			new Opiniao("Belo Hotel", -1.0);
			Assert.fail("Esperava excecao, nota invalida");
		} catch ( NotaInvalidaException e ) {
			Assert.assertEquals("Nota invalida", e.getMessage());
		}
		
		try {
			new Opiniao("", 10.0);
			Assert.fail("Esperava excecao, comentario invalido");
		} catch ( ComentarioInvalidoException e ) {
			Assert.assertEquals("Comentario invalido", e.getMessage());
		}
		
		try {
			new Opiniao(null, 9.0);
			Assert.fail("Esperava excecao, comentario null");
		} catch ( ComentarioInvalidoException e ) {
			Assert.assertEquals("Comentario invalido", e.getMessage());
		}
		
		try {
			new Opiniao("", 7.0);
			Assert.fail("Esperava excecao, comentario vazio");
		} catch ( ComentarioInvalidoException e ) {
			Assert.assertEquals("Comentario invalido", e.getMessage());
		}
		
		try {
			new Opiniao("asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsdsdsdsdsdsd"
					+ "saaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadssssssssssdsfasfasfsd"
					+ "sssssssssssssssssssssssssssssssssssssssssssassssssssssssssssssdfdsfdsfsdfd"
					+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassfasfsfdfdfdfdfdfd", 10.0);
			
			Assert.fail("Esperava excecao, comentario invalido");
		} catch ( ComentarioInvalidoException e ) {
			Assert.assertEquals("Comentario invalido", e.getMessage());
		}
	}
	
	@Test
	public void testGetComentario() {
		Assert.assertEquals("Bom Hotel", op.getComentario());
		Assert.assertEquals("Pessimo Hotel", op2.getComentario());
	}
	
	@Test
	public void testGetNota() {
		Assert.assertTrue( op.getNota() == 10.0 );
		Assert.assertTrue( op2.getNota() == 5.0 );
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("Opiniao [ comentario = Bom Hotel, nota = 10.0 ]", op.toString());
		Assert.assertEquals("Opiniao [ comentario = Pessimo Hotel, nota = 5.0 ]", op2.toString());
	}
	
	@Test
	public void testEquals() throws InputArgumentInvalidException {
		Assert.assertFalse( op.equals(op2) );
		Opiniao op3 = new Opiniao("Bom Hotel", 10.0);
		Assert.assertTrue( op.equals(op3) );
	}
}