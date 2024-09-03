package com.model.managers;

import com.model.Campaign;
import com.model.users.Player;

public class PlayerManager {
    private final Campaign campaign;

    public PlayerManager(Campaign campaign) {
        this.campaign = campaign;
    }

    public boolean addPlayer(Player player) {
        if (player == null || campaign.getPlayers().contains(player) || campaign.getPlayers().size() >= campaign.getMaxPlayers()) {
            return false;
        }
        campaign.getPlayers().add(player);
        campaign.attach(player);
        campaign.notifyMasterPlayerJoined(player);
        return true;
    }

    public boolean removePlayer(Player player) {
        if (player == null || !campaign.getPlayers().contains(player)) {
            return false;
        }
        campaign.getPlayers().remove(player);
        campaign.detach(player);
        campaign.notifyMasterPlayerLeft(player);
        return true;
    }
}
