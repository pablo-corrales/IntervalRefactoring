package persistence.models.daos.jpa;

import persistence.models.daos.VotoDAO;
import persistence.models.entities.Voto;

public class VotoDAOJPA extends GenericDAOJPA<Voto,Integer> implements VotoDAO {

    public VotoDAOJPA() {
        super(Voto.class);
    }

 }