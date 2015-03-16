package persistence.models.daos.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.VotoDAO;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotoDAOJDBCTest {
    private VotoDAO DAO;

    private Voto voto;

    @BeforeClass
    public static void beforeClass() {
        DAOFactory.setFactory(new DAOJDBCFactory());
        DAOJDBCFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.voto = new Voto(9, 4, "192.168.1.1");
        this.voto.setTema(new Tema("DESARROLLO DE APLICACIONES JEE-PERSISTENCIA","En que consiste la persistencia?"));
        DAO = DAOFactory.getFactory().getVotoDAO();
        DAO.create(voto);
    }

    @Test
    public void testRead() {
        assertEquals(voto, DAO.read(voto.getId()));
    }

    @Test
    public void testUpdateTema() {
        voto.setPuntaje(10);
        voto.setNivelEstudios(4);;
        voto.setIp("192.168.1.255");
        DAO.update(voto);
        assertEquals(voto, DAO.read(voto.getId()));
    }

    @Test
    public void testDeleteByID() {
        DAO.deleteByID(voto.getId());
        assertNull(DAO.read(voto.getId()));
        assertNull(DAOFactory.getFactory().getTemaDAO().read(voto.getTema().getId()));
    }

    @Test
    public void testFindAll() {
    	this.voto = new Voto(5, 1, "192.168.1.1");
    	this.voto.setTema(new Tema("DESARROLLO DE APLICACIONES JEE-PERSISTENCIA","En que consiste la persistencia?"));
        DAO = DAOFactory.getFactory().getVotoDAO();
        DAO.create(voto);
        assertEquals(2, DAO.findAll().size());
    }

    @After
    public void after() {
        DAOJDBCFactory.dropAndCreateTables();
    }

}