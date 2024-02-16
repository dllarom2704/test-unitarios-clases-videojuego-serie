package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerieTest {
	public static Serie serie;
	
	@BeforeEach
	public void initObject() {
		serie = new Serie("TituloSerie", 2, "GeneroSerie", "CreadorSerie");
	}
	
	@Test
	public void entregarTest() {
		if (serie.isEntregado() == true) {
			assertTrue(serie.isEntregado());
		} else {
			assertFalse(serie.isEntregado());
		}
	}
	
	@Test
	public void devolverTest() {
		assertFalse(serie.isEntregado());
	}
	
	@Test
	public void compareToTest() {
		var s1 = new Serie();
		s1.setnumeroTemporadas(2);
		
		var s2 = new Serie();
		s2.setnumeroTemporadas(4);
		
		var s3 = new Serie();
		s3.setnumeroTemporadas(4);
		
		assertEquals(Serie.MENOR, s1.compareTo(s2));
		assertEquals(Serie.MAYOR, s2.compareTo(s1));
		assertEquals(Serie.IGUAL, s3.compareTo(s2));
	}
	
	@Test
	public void toStringTest() {
		String cadenaEsperada = "Informacion de la Serie: \n" +
								"\tTitulo: TituloSerie\n" +
								"\tNumero de temporadas: 2\n" +
								"\tGenero: GeneroSerie\n" +
								"\tCreador: CreadorSerie";
		
		assertEquals(cadenaEsperada, serie.toString());
	}
	
	@Test
	public void equalsTest() {
		var s = new Serie("TituloSerie", 2, "GeneroSerie", "CreadorSerie");
		
		assertTrue(serie.equals(s));
		
		s.setTitulo("Titulo2Serie");
		
		assertFalse(serie.equals(s));
	}
}
