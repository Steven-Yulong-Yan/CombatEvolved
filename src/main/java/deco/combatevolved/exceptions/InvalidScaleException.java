package deco.combatevolved.exceptions;

/**
 * An exception class thrown when the scale used in generating Perlin Noise
 * has an invalid value
 */
public class InvalidScaleException extends WorldGenException {
    public InvalidScaleException(String message) {
        super(message);
    }
}
