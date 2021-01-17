package deco.combatevolved.managers;

import deco.combatevolved.entities.AbstractEntity;
import java.util.Queue;

/**
 * Manager that houses the updates to entities for sending them from the host to the client
 */

public class UpdateEntityManager extends AbstractManager{
    private Queue<AbstractEntity> entityQueue;

    public AbstractEntity getEntityForSending() {
        return entityQueue.poll();
    }
}
