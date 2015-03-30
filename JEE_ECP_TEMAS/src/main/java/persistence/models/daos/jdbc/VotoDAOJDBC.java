package persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import persistence.models.daos.VotoDAO;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;


public class VotoDAOJDBC extends GenericDAOJDBC<Voto, Integer> implements VotoDAO {

    private Logger log = LogManager.getLogger(VotoDAOJDBC.class);
    
    private Voto create(ResultSet resultSet) {
    	
        Voto voto;
        try {
            if (resultSet != null && resultSet.next()) {
                voto = new Voto(resultSet.getInt(Voto.PUNTAJE), NivelEstudios.valueOf(resultSet.getString(Voto.NIVELESTUDIOS)), resultSet.getString(Voto.IP));
                     
                voto.setId(resultSet.getInt(Voto.ID));
                
                return voto;
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s INT, "
            + "%s INT, %s VARCHAR(255), PRIMARY KEY (%s))";
             

    public static String sqlToCreateTable() {
		    
        return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.PUNTAJE, Voto.NIVELESTUDIOS, Voto.IP, Voto.ID);
                    	
    }

    

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')";

    @Override
    public void create(Voto voto) {
    	
        
        this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.PUNTAJE, Voto.NIVELESTUDIOS, Voto.IP,  
        		voto.getPuntaje(), voto.getNivelEstudios(), voto.getIp()));
        voto.setId(this.autoId());
        
    }

    @Override
    public Voto read(Integer id) {
		
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
        return this.create(resultSet);
        
       
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

    @Override
    public void update(Voto voto) {
    	       
        this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.PUNTAJE, voto.getPuntaje(), Voto.NIVELESTUDIOS,
                        voto.getNivelEstudios(), voto.getId()));
               
    }

    @Override
    public void deleteByID(Integer id) {
    	
        Voto votoBD = this.read(id);
        if (votoBD != null) {
           
            this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
            
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
