package persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.VotoDAO;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;



public class VotoDAOJDBC extends GenericDAOJDBC<Voto, Integer> implements VotoDAO {

    private Logger log = LogManager.getLogger(VotoDAOJDBC.class);
    
    private Voto create(ResultSet resultSet) {
    	
    	Voto voto;
        try {
            if (resultSet != null && resultSet.next()) {
                voto = new Voto(resultSet.getInt(Voto.PUNTAJE), resultSet.getInt(Voto.NIVELESTUDIOS), resultSet.getString(Voto.IP));
                     
                voto.setId(resultSet.getInt(Voto.ID));
                // Reconstruir Tema
                Integer temaId = resultSet.getInt(Voto.TEMA);
                if (temaId > 0) {
                    Tema tema = DAOFactory.getFactory().getTemaDAO().read(temaId);
                    voto.setTema(tema);
                }
                return voto;
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s INT, "
            + "%s INT, %s VARCHAR(255), PRIMARY KEY (%s), "
            + "FOREIGN KEY(%s) REFERENCES %s(ID) )";

    public static String sqlToCreateTable() {
		    
        return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.PUNTAJE, Voto.NIVELESTUDIOS, Voto.IP, Voto.ID, Voto.TEMA, Tema.TABLE);
                    	
    }

    

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s','%s','%s','%s',%d)";

    @Override
    public void create(Voto voto) {
    	
        Integer temaId = null;
        if (voto.getTema() != null) {
            DAOFactory.getFactory().getTemaDAO().create(voto.getTema());
            temaId = voto.getTema().getId();
        }
        this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.ID, Voto.PUNTAJE, Voto.NIVELESTUDIOS, Voto.IP, Voto.TEMA, 
        		voto.getPuntaje(), voto.getNivelEstudios(), voto.getIp(), temaId));
        voto.setId(this.autoId());
        
    }

    @Override
    public Voto read(Integer id) {
		
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
        return this.create(resultSet);
        
       
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', %s=%d WHERE ID=%d";

    @Override
    public void update(Voto voto) {
    	
        Integer temaId, oldTemaId = null;
        if (voto.getTema() == null) {
            Voto oldVoto = this.read(voto.getId());
            if (oldVoto.getTema() != null) {
                oldTemaId = oldVoto.getTema().getId();
            }
            temaId = null;
        } else {
            temaId = voto.getTema().getId();
            if (DAOFactory.getFactory().getTemaDAO().read(temaId) == null) {
                DAOFactory.getFactory().getTemaDAO().create(voto.getTema());
            } else {
                DAOFactory.getFactory().getTemaDAO().update(voto.getTema());
            }
        }
        this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.PUNTAJE, voto.getPuntaje(), Voto.NIVELESTUDIOS,
                        voto.getNivelEstudios(), Voto.TEMA, temaId, voto.getId()));
        if (oldTemaId != null) {
            DAOFactory.getFactory().getTemaDAO().deleteByID(oldTemaId);
        }
       
    }

    @Override
    public void deleteByID(Integer id) {
    	
        Voto votoBD = this.read(id);
        if (votoBD != null) {
            Integer temaId = null;
            if (votoBD.getTema() != null) {
                temaId = votoBD.getTema().getId();
            }
            this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
            if (temaId != null) {
                DAOFactory.getFactory().getTemaDAO().deleteByID(votoBD.getTema().getId());
            }

        }
       
    }

    @Override
    public List<Voto> findAll() {
		
        List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Voto.TABLE));
        Voto voto = this.create(resultSet);
        while (voto != null) {
            list.add(voto);
            voto = this.create(resultSet);
        }
        return list;
       
    }
    protected static final String SQL_SELECT_TEMA_BY_ID = "SELECT * FROM %s WHERE TEMA_ID=%d";

    
    public List<Voto> findByTemaId(Integer temaId) {
		
    	List<Voto> list = new ArrayList<Voto>();
    	
    	ResultSet resultSetVoto = this.query(String.format(SQL_SELECT_TEMA_BY_ID, Voto.TABLE,temaId));
    	
    	Voto voto = this.create(resultSetVoto);
    	
        while (voto != null) {
            	list.add(voto);
            	voto = this.create(resultSetVoto);
            }
        return list;
       
    }

   
	@Override
	public void delete(Voto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voto> findVotoByTema(Integer tema_id) {
		// TODO Auto-generated method stub
		return null;
	}



}
