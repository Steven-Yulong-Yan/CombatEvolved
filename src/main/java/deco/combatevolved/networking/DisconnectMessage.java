package deco.combatevolved.networking;

public class DisconnectMessage {
    private DisconnectReason disconnectReason;

    public DisconnectMessage(DisconnectReason reason) {
        disconnectReason = reason;
    }

    public DisconnectReason getReason() {
        return disconnectReason;
    }
}