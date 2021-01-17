package deco.combatevolved.handlers.commands;

import deco.combatevolved.managers.GameManager;
import deco.combatevolved.managers.NetworkManager;

import java.util.List;

public class KickCommandListener extends AbstractCommandListener {

    @Override
    public void call(List<Object> args, Integer senderId) {
        GameManager.get().getManager(NetworkManager.class).removeClientConnection((Integer) args.get(0),
                GameManager.get().getManager(NetworkManager.class).getClientUsernameFromConnection((int) args.get(0)));
    }
}