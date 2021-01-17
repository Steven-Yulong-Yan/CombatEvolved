package deco.combatevolved.entities.staticentities;

import com.google.gson.annotations.Expose;

import deco.combatevolved.util.HexVector;

public class Part {
	@Expose
	Boolean obstructed;
	@Expose 
	String textureString;
	HexVector position; 
	
	/**
	 * @param position Relative position to a center position defined in Static Entity 
	 * @param textureString id String for the texture 
	 * @param obstructed whether the underlying tile for the StaticEntity part is obstructed or not 
	 */
	public Part(HexVector position, String textureString, Boolean obstructed){
		this.position = position; 
		this.textureString = textureString;
		this.obstructed = obstructed; 
	}

	public Boolean isObstructed() {
		return obstructed;
	}

	public HexVector getPostion() {
		return position;
	}
}