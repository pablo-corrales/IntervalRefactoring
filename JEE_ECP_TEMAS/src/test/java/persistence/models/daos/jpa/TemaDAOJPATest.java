package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.entities.Tema;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;

public class TemaDAOJPATest {
	
	private TemaDAO dao;
	private Tema tema;
	
	@BeforeClass
	public static void beforeClass(){
		DAOFactory.setFactory(new DAOJPAFactory());
	}
	@Before
	public void before(){
		this.tema = new Tema("TestTemaNombret", "TestTemaNombre");
		dao = DAOJPAFactory.getFactory().getTemaDAO();
		dao.create(this.tema);
	}
	
	@Test
	public void testCreate(){
		Tema tema = new Tema("TestTemaNombre", "TestTemaNombre");
		tema.setId(1);		
		dao.create(tema);
		
		Tema temaTest = dao.read(1);
		assertEquals(tema, temaTest);
		dao.deleteByID(1);
	}
	
	@Test
	public void testUpdate(){
		this.tema.setNombre("testNombre");
		this.tema.setPregunta("testPregunta");
		dao.update(this.tema);
		assertEquals(this.tema, dao.read(this.tema.getId()));
	}
	
	@Test
	public void testRead(){
		assertEquals(this.tema, dao.read(this.tema.getId()));
	}
	
	@Test
	public void testDelete(){
		dao.deleteByID(this.tema.getId());
		assertNull(dao.read(this.tema.getId()));
	}
	
	@Test
	public void testFindAll(){
		
		Tema tema = new Tema("TestTemaNombre", "TestTemaNombre");
		tema.setId(2);
		dao.create(tema);
		
		assertEquals(2, dao.findAll().size());
		dao.deleteByID(2);
	}
	
	@After
    public void after() {
        dao.deleteByID(this.tema.getId());
    }
	

}
