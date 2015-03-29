package persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class DAOJDBCFactory extends DAOFactory {
	
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/miwjee";

    private static final String USER = "root";

    private static final String PASS = "";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(0)) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            LogManager.getLogger(DAOJDBCFactory.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DAOJDBCFactory.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, Tema.TABLE));
            statement.executeUpdate(String.format(DROP_TABLE, Voto.TABLE));
            statement.executeUpdate(TemaDAOJDBC.sqlToCreateTable());
            statement.executeUpdate(VotoDAOJDBC.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DAOJDBCFactory.class).error("Drop tables: " + e.getMessage());
        }
    }

    @Override
    public TemaDAO getTemaDAO() {
        return new TemaDAOJDBC();
    }

    
	@Override
	public VotoDAO getVotoDAO() {
		return new VotoDAOJDBC();
	}

}
