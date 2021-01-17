package deco.combatevolved.entities.dynamicentities;

import deco.combatevolved.entities.RenderConstants;
import deco.combatevolved.entities.enemyentities.BasicEnemy;
import deco.combatevolved.entities.enemyentities.FlyingEnemy;
import deco.combatevolved.exceptions.EnemyValueException;
import deco.combatevolved.util.HexVector;
import deco.combatevolved.managers.GameManager;
import deco.combatevolved.worlds.AbstractWorld;
import deco.combatevolved.entities.AbstractEntity;
import deco.combatevolved.entities.HasHealth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class TowerBullet extends DynamicEntity {

    private HexVector bulletPosition;
    private HexVector initialPosition;

    private HexVector bulletVelocity;

    private String type;

    private int damage;

    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private float distance;

    public TowerBullet(HexVector position, HexVector velocity, float distance, int damage, String type, String suffix) {
        super(position.getCol(), position.getRow(), RenderConstants.BULLET_RENDER, 0);
        this.bulletPosition = new HexVector(position.getCol(), position.getRow());
        this.bulletVelocity = new HexVector(velocity.getCol(), velocity.getRow());
        initialPosition = new HexVector(position);
        this.distance = distance;
        this.damage = damage;
        this.type = type;


        switch (this.type) {
            case "snipertower":
            case "simpletower":
            case "zaptower":
                setTexture(type + "_bullet" + suffix);
                break;
            default:
                setTexture(type + "_bullet");

        }
    }

    public void update() {
        bulletPosition.setCol(bulletPosition.getCol() + bulletVelocity.getCol());
        bulletPosition.setRow(bulletPosition.getRow() + bulletVelocity.getRow());
    }

    public HexVector getBulletPosition() {
        return bulletPosition;
    }

    @Override
    public void onTick(long i) {
        AbstractWorld world = GameManager.get().getWorld();
        // if the bullet as travelled a far enough distance then the bullet is
        // removed
        if (initialPosition.distance(position) > distance) {
            world.removeEntity(this);
            logger.info("Removed bullet {} after travelling distance {}", this, distance);
        }
        // if the bullet has collided with an enemy then the enemy is damaged
        // and the bullet is removed
        for (AbstractEntity entity : world.getEntities()) {
            if ((entity instanceof BasicEnemy) &&
                    position.distance(entity.getPosition()) < 0.5f) {
                if ((entity instanceof FlyingEnemy && !this.type.equals("zaptower"))) {
                    break;
                } else {
                    try {
                        ((HasHealth) entity).loseHealth(damage);
                    } catch (EnemyValueException e) {
                        logger.warn("Bullet {} does negative damage", this);
                    }
                    logger.info("Bullet {} hit enemy {} and caused {} damage",
                            this, entity, damage);
                    world.removeEntity(this);
                    return;
                }
            }
        }
        position = position.add(bulletVelocity);
    }
}
