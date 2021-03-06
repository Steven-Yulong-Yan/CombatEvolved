package deco.combatevolved.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import deco.combatevolved.worlds.AbstractWorld;
import deco.combatevolved.worlds.Tile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BFSPathfinder extends Pathfinder {
	
	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(BFSPathfinder.class);


	@Override
	public List<Tile> pathfind(AbstractWorld world, HexVector origin, HexVector destination) {
		Tile originTile = getTileByHexVector(world, origin);

		Tile destinationTile = getTileByHexVector(world, destination);

		if (originTile == null || destinationTile == null) {
			return null;
		}


		return pathfindBFS(world, originTile, destinationTile);

	}

	private List<Tile> pathfindBFS(AbstractWorld world, Tile origin, Tile destination) {
		LinkedList<Tile> queue = new LinkedList<Tile>();
		Set<Tile> closedSet = new HashSet<Tile>();
		Map<Tile, Tile> path = new HashMap<Tile, Tile>();
		queue.add(origin);
		
		Tile root;

		while (!queue.isEmpty()) {
			//log.info("Queue: {}    Closed: {}", queue.size(), closedSet.size());
			root = queue.remove();
			
			if (root.equals(destination)) {
				return reconstructPath(destination, path);
			}
			
			for (Tile child : root.getNeighbours().values()) {
				if (closedSet.contains(child) || queue.contains(child) || child.isObstructed()) {
					continue;
				}
				path.put(child, root);
				queue.add(child);
			}
			
			closedSet.add(root);
		}
		return null;
	}
	
	private List<Tile> reconstructPath(Tile destination, Map<Tile, Tile> pathMap) {
		Tile root = destination;
		List<Tile> path = new ArrayList<Tile>();
		path.add(root);
		while(pathMap.get(root) != null) {
			root = pathMap.get(root);
			path.add(0, root);
		}
		return path;
	}


	// custom tile find to allow for the chartactor to not be centered over the square.
	public static Tile getTileByHexVector(AbstractWorld world, HexVector vector) {
		List<Tile> candidates = new ArrayList<>();
		for (Tile tile : world.getTileListFromMap()) {
			if (vector.isCloseEnoughToBeTheSame(tile.getCoordinates(),1f) ) {
				candidates.add(tile);
				//return tile;
			}
		}
		if (!candidates.isEmpty()) {
			Tile closest = candidates.get(0);
			for (Tile tile : candidates) {
				if (vector.distance(tile.getCoordinates()) <
						vector.distance(closest.getCoordinates())) {
					closest = tile;
				}
			}
			return closest;
		}
		return null;

	}

}
