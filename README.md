# CombatEvolved

## Game Overview
CombatEvolved is a 2-player co-op game set on a remote Earth-like planet that humans have since established life on.
It is discovered that the 8 communication towers used to keep in contact with Earth have been deactivated. Players are given the mission of reversing this.

The players begin the game crash-landed on the planet in a desolate area due to having sustained damage to their vehicle during orbital landing.
Gameplay involves traversing the planet for resources for survival, as well as to locate, defend and take back the communication towers.
Both players experience the same day and night mode and can interact in the world.

## Play Testing Guide
To test networking, you will need to complete the rest of this guide on both a host and a client and ensure both players act accordingly.

1. Open two instances of the game. In IntelliJ, you can enable this by editing the run configuration by checking parallel run.
2. Create a new game with one player in single player and one in co-op modes. Give each player a different username so you know which is which.
3. Once both games are connected, ensure that both players can move around and can send messages to each other (Press T to open the chat).

## Keyboard and Mouse Button References

* **Left Mouse**: [Shoot bullets] or [Ready projectiles or launch projectiles] (Depends on the character attack pattern)
* **Mouse Movement**: Move camera on the edge of the screen
* **Mouse Wheel Up**: Zoom camera in
* **Mouse Wheel Down**: Zoom camera out

_____________________________

* **W**: Move player up
* **A**: Move player left
* **S**: Move player down
* **D**: Move player right
* **X**: Switch weapons
* **LeftShift**: Sprint
_____________________________

* **Arrow Up**: Shoot bullets upward
* **Arrow Left**: Shoot bullets leftward
* **Arrow Down**: Shoot bullets downward
* **Arrow Right**: Shoot bullets rightward
* **RightShift**: Combined with direction keys to shoot diagonally
* **Spacebar**: Center camera on player
* **-**: Zoom camera out
* **+**: Zoom camera in
_____________________________

* **K**: Open/close skill tree
* **U**: Open/close tower inventory
* **R**: Open/close recipe book
* **Q**: Enter/exit vehicle
* **I**: Open/close inventory
* **E**: Open/close crafting table interface (when near a crafting table)
**On click within an inventory, recycling or crafting table interface**
* **P**: Transfers items in the players visible inventory to full inventory
* **Left Mouse**: Shoot bullets/Fire projectiles/Pickup/drop full stack of items
* **Right Mouse**: Pickup/drop single quantity in the stack of items. For Equipment, equip or unequip the equipment.
_____________________________

* **T**: Chat
* **H**: Lock/unlock camera
______________________________

* **ESC**: Toggle pause screen (in-game only)
* **F3**: Save world
* **F4**: Load world
* **F5**: Reload world, kills peons
* **F10**: Show/hide entity paths
* **F11**: Show/hide tile coordinates
* **F12**: Show/hide debug information