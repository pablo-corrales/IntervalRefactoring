package persistence.models.daos.jpa;

import persistence.models.daos.TemaDAO;
import persistence.models.entities.Tema;

public class TemaDAOJPA extends GenericDAOJPA<Tema,Integer>implements TemaDAO {

    public TemaDAOJPA() {
        super(Tema.class);
    }

 }