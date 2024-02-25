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
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 * @author Grupo 7
 */
@Entity
@Table(name="Categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
     * Default constructor
     */
    public Categoria() {
    }

    
    public Categoria(Integer id, String nombre, TipoMovimiento tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;

    @Column
    private String nombre;

    @Enumerated
    private TipoMovimiento tipo;

    
    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Categoria> getAllOfIngresoType() { // Obtiene las categorias del tipo ingreso
    	// Conectarse a la base de datos, realizar operaciones
    	EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
    	// Query de la base de datos. (t.tipo= :mitipo") El miTipo es un parametro que voy a ingresar
    	String consultaJPQL = "SELECT t FROM Categoria t WHERE t.tipo= :mitipo";
    	// Preparar la consulta
    	Query query = em.createQuery(consultaJPQL ); //Paquete javax persistence.
    	// Aqui ya inserta el paramtro
    	query.setParameter("mitipo", TipoMovimiento.INGRESO);
    	// Devuelve las categorias y hace el cast
        return (List<Categoria>)query.getResultList();
        
    }
    
    /**
     * @param idCategoria 
     * @return
     */
    public static Categoria getById(int idCategoria) { // este va a utilizarse para guardar el Ingreso
    	EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
    	String consultaJPQL = "SELECT c FROM Categoria c WHERE c.id= :miCategoria";
    	Query query = em.createQuery(consultaJPQL);
    	query.setParameter("miCategoria", idCategoria);
    	return (Categoria)query.getSingleResult();
    }


	/**
     * @param categoria 
     * @return
     */
    public boolean create(Categoria categoria) {
        // TODO implement here
        return false;
    }

   

    /**
     * @return
     */
    public List<Categoria> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param categoria 
     * @return
     */
    public boolean update(Categoria categoria) {
        // TODO implement here
        return false;
    }

    /**
     * @param idCategoria 
     * @return
     */
    public boolean delete(int idCategoria) {
        // TODO implement here
        return false;
    }

    
    /**
     * @return
     */
    public List<Categoria> getAllOfExpenseType() {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha  
     * @return
     */
    public static List<Categoria> getSumarizedByDate(int mes ) {
        
        return null;
    }

    
    /********************** GETTERS Y SETTERS******************************/
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

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}
}