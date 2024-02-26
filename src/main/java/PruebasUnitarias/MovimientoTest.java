package PruebasUnitarias;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import entities.Categoria;
import entities.Cuenta;
import entities.Movimiento;
import entities.TipoMovimiento;

class MovimientoTest {

	@Test
	void testCreateIngreso() {
		Cuenta cuenta = Cuenta.getById(1);
		Categoria cat = Categoria.getAllOfIngresoType().get(0);
		Movimiento mov = new Movimiento("pago mensual",new Date(),200.0,cuenta,cat,TipoMovimiento.INGRESO);
		
		boolean ingreso = Movimiento.createIngreso(mov);
		assertEquals(ingreso, true);
		
	}

}
