package deco.combatevolved.entities.dynamicentities;

import com.google.gson.annotations.Expose;

import deco.combatevolved.entities.AbstractEntity;
import deco.combatevolved.util.HexVector;

/**
 * A DynamicEntity is an entity that moves and interacts within the world. For
 * example, the player, or a duck.
 */
public abstract class DynamicEntity extends AbstractEntity{
	@Expose
	protected float speed;
	private HexVector nextCoords = null;

	public DynamicEntity(float col, float row, int renderOrder, float speed) {
		super(col, row, renderOrder);

		this.speed = speed;
	}

	public DynamicEntity() {
		super();
	}

	public void setNextCoords(HexVector coords) {this.nextCoords = coords;}

	public HexVector getNextCoords() {return this.nextCoords;}

	public void moveTowards(HexVector destination) {
			position.moveToward(destination, speed);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed( float speed) {
		this.speed = speed;
	}
}
