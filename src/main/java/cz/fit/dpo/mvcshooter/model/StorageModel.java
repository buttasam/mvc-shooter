package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.dao.CannonDao;
import cz.fit.dpo.mvcshooter.entity.Cannon;

/**
 * @author Samuel Butta
 */
public class StorageModel {


    /**
     * Stored objects
     */
    private Cannon cannon;


    /**
     * DAOs for entity manipulation
     */
    private CannonDao cannonDao = new CannonDao();


    public StorageModel() {
        this.cannon = new Cannon(50, 50);
    }

    // FIXME
    public void moveConnonDown() {
        cannonDao.moveDown(cannon);

    }

}
