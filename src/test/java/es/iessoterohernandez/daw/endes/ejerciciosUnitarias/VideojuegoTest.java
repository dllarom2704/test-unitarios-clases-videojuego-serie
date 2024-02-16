package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideojuegoTest {
	public static Videojuego videojuego;
	
	@BeforeEach
	public void initObject() {
		videojuego = new Videojuego("TituloVideojuego", 6, "GeneroVideojuego", "CompañiaVideojuego");
	}
	
	@Test
	public void entregarTest() {
		if (videojuego.isEntregado() == true) {
			assertTrue(videojuego.isEntregado());
		} else {
			assertFalse(videojuego.isEntregado());
		}
	}
	
	@Test
	public void devolverTest() {
		assertFalse(videojuego.isEntregado());
	}
	
	@Test
	public void compareToTest() {
		var v1 = new Videojuego();
		v1.setHorasEstimadas(4);
		
		var v2 = new Videojuego();
		v2.setHorasEstimadas(6);
		
		var v3 = new Videojuego();
		v3.setHorasEstimadas(4);
		
		assertEquals(Videojuego.MENOR, v1.compareTo(v2));
		assertEquals(Videojuego.MAYOR, v2.compareTo(v1));
		assertEquals(Videojuego.IGUAL, v3.compareTo(v1));
	}
	
	@Test
	public void toStringTest() {
		String cadenaEsperada = "Informacion del videojuego: \n" +
								"\tTitulo: TituloVideojuego\n" +
								"\tHoras estimadas: 6\n" +
								"\tGenero: GeneroVideojuego\n" +
								"\tcompañia: CompañiaVideojuego";
		
		assertEquals(cadenaEsperada, videojuego.toString());
	}
	
	@Test
	public void equalsTest() {
		var v = new Videojuego("TituloVideojuego", 6, "GeneroVideojuego", "CompañiaVideojuego");
		
		assertTrue(videojuego.equals(v));
		
		v.setTitulo("Titulo2Videojuego");
		
		assertFalse(videojuego.equals(v));
	}
}
