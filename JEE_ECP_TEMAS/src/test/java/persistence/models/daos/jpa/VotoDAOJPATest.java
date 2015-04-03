package persistence.models.daos.jpa;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class VotoDAOJPATest {
	private Voto voto;
	private Tema tema;
	private VotoDAO votoDAO;
	private TemaDAO temaDAO;
	
	
	@BeforeClass
	public static void beforeClass(){
		DAOFactory.setFactory(new DAOJPAFactory());
	}
	
	@Before
	public void before(){
		this.tema = new Tema("nombre", "pregunta");
		this.voto = new Voto( 1, 1, "192.168.1.1", this.tema);
		temaDAO = DAOJPAFactory.getFactory().getTemaDAO();
		votoDAO = DAOJPAFactory.getFactory().getVotoDAO();
		temaDAO.create(this.tema);
		votoDAO.create(this.voto);
	}
	
	@Test
	public void testCreate(){
		Tema tema = new Tema("nombre", "pregunta");
		temaDAO.create(tema);
		
		Voto votoPrueba = new Voto(0, 1, "192.168.1.1", tema);
		votoDAO.create(votoPrueba);
		
		Voto votoconDAO = votoDAO.read(votoPrueba.getId());
		assertEquals(votoPrueba, votoconDAO);
		
		temaDAO.deleteByID(tema.getId());
		votoDAO.deleteByID(votoPrueba.getId());
	}
	
	@Test
	public void testUpdate(){
		this.voto.setNivelEstudios(1);
		this.voto.setPuntaje(10);
		votoDAO.update(this.voto);
		assertEquals(this.voto, votoDAO.read(this.voto.getId()));
	}
	
	@Test
	public void testDelete(){
		votoDAO.deleteByID(this.voto.getId());
		assertNull(votoDAO.read(this.voto.getId()));
	}
	
	@Test
	public void testRead(){
		assertEquals(this.voto, votoDAO.read(this.voto.getId()));
	}
	
	@Test
	public void testFindAll(){
		Voto voto = new Voto( 1, 1, "192.168.1.1", this.tema);
		votoDAO.create(voto);
		assertEquals(2, votoDAO.findAll().size());
		votoDAO.deleteByID(voto.getId());
	}

}
