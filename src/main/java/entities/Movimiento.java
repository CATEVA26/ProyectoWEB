package entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Grupo 7
 */
@Entity
@Table(name="Movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Movimiento() {
	}

	public Movimiento(String concepto, Date fecha, double valor, Cuenta cuenta, Categoria categoria,
			TipoMovimiento movimiento) {
		this.concepto = concepto;
		this.fecha = fecha;
		this.monto = valor;
		this.destino = cuenta;
		this.categoria = categoria;
		this.tipo=movimiento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMovimiento")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column
	private double monto;

	@Column
	private String concepto;

	@Enumerated
	private TipoMovimiento tipo;

	@ManyToOne
	@JoinColumn
	private Cuenta origen;

	@ManyToOne
	@JoinColumn
	private Cuenta destino;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Categoria categoria;

	

	/**
	 * @param ingreso
	 * @return
	 */
	public static boolean createIngreso(Movimiento ingreso) {
		EntityManager em= Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		em.getTransaction().begin();
		try {
		    em.persist(ingreso);
		    em.getTransaction().commit();
		    return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
		}
			return false;
		}
	}

	/**
	 * @param gasto
	 * @return
	 */
	public boolean createGasto(Movimiento gasto) {
		// TODO implement here
		return false;
	}

	/**
	 * @param ingreso
	 * @param egreso
	 */
	public void createTransferencia(Movimiento ingreso, Movimiento egreso) {
		// TODO implement here
	}

	/**
	 * @param id
	 * @param fecha
	 * @param monto
	 * @param concepto
	 * @return
	 */
	public boolean update(int id, Date fecha, double monto, String concepto) {
		// TODO implement here
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		// TODO implement here
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Movimiento> getAllByCuenta(int idCuenta) {
		return null;
	}
	
	public static List<Movimiento> getAllByDate(Date fecha){
		return null;
		
	}
	
	/*****************Getter y setters********************/
/*
	@Override
	public String toString() {
		return this.concepto + " " + this.getCategoria().getId();
	}
*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

	public Cuenta getOrigen() {
		return origen;
	}

	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	public Cuenta getDestino() {
		return destino;
	}

	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}