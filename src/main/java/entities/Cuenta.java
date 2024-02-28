package entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 * @author Carlos Iñiguez
 */
@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCuenta")
    private Integer id;

	@Column(name="nombre")
    private String nombre;

	@Column(name="total")
    private double total;
	
	 /**
     * Default constructor
     */
    public Cuenta() {
    	
    }

    /**
     * Constructor con parámetros
     */
    public Cuenta(String nombre, double total) {
		super();
		this.nombre = nombre;
		this.total = total;
	}

	/**
     * @param nombre
     */
    public void Cuenta(String nombre) {
        // TODO implement here
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Cuenta> getSumarized() { //obtener todas las cuentas
    	EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
    	//SELECT * FROM CUENTA
    	String consulta = "SELECT c FROM Cuenta c";
    	Query query = em.createQuery(consulta);
    	return (List<Cuenta>) query.getResultList(); 
    	}

    /**
     * @param cuenta 
     * @return
     */
    
    /**
     * @param idCuenta 
     * @return
     */
    public static Cuenta getById(int idCuenta) { // obtener el id de la cuenta para guardar el ingreso
    	// Conectarse a la base de datos
    	EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
    	return em.find(Cuenta.class, idCuenta); // este puede ser usado solo cuando se necesite un solo valor de retorno
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Cuenta> getAll() {
    	return null;
    }

    
    public boolean update(Cuenta cuenta) {
        // TODO implement here
        return false;
    }

    /**
     * @param idCuenta 
     * @return
     */
    public boolean delete(int idCuenta) {
        // TODO implement here
        return false;
    }

    /**
     * @param valor
     */
    public void ajustarSaldo(double valor) {
        // TODO implement here
    	double nuevoSaldo=this.total+valor;
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		em.getTransaction().begin();
    	String consultaJPQL = "UPDATE Cuenta c SET c.total = :nuevoTotal WHERE c.id = :id";
    	Query query =  em.createQuery(consultaJPQL);
    	query.setParameter("nuevoTotal", nuevoSaldo);
    	query.setParameter("id", this.id);
    	int filasActualizadas = query.executeUpdate(); // Ejecutar la consulta de actualización
        em.getTransaction().commit();
        em.close();
    }
    
/*********************** Getters y Setters ************************/

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

   
}