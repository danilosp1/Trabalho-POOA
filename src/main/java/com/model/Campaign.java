package com.model;

import com.enums.StatusType;
import com.interfaces.Observer;
import com.interfaces.Subject;
import com.model.managers.PlayerManager;
import com.model.managers.SessionManager;
import com.model.users.Master;
import com.model.users.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Campaign implements Subject {
    private final UUID id;
    private String name;
    private final int maxPlayers;
    private final int minPlayers;
    private final Master master;
    private int sessionsNumber;
    private String description;
    private StatusType status;
    private String startDate;
    private String endDate;
    private List<Player> players = new ArrayList<>();
    private List<CharacterSheet> characters = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    private Session currentSession;
    private SystemRPG systemRPG;
    private final List<Observer> observers = new ArrayList<>();

    public Campaign(String name, int maxPlayers, int minPlayers, Master master, int sessionsNumber, String description, StatusType status, String startDate, String endDate, SystemRPG systemRPG) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.master = master;
        this.sessionsNumber = sessionsNumber;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.systemRPG = systemRPG;
        this.attach(master);
    }

    private final SessionManager sessionManager = new SessionManager(this);

    public void startSession(Session session) {
        sessionManager.startSession(session);
    }

    public void endSession(Session session) {
        sessionManager.endSession(session);
    }

    private PlayerManager playerManager = new PlayerManager(this);

    public boolean addPlayer(Player player) {
        return playerManager.addPlayer(player);
    }

    public boolean removePlayer(Player player) {
        return playerManager.removePlayer(player);
    }

    private void notifyChange(String message) {
        notifyObservers("O status da campanha " + this.getName() + " mudou para " + message + ".");
    }

    public void notifyMasterPlayerJoined(Player player) {
        if (master != null) {
            master.update("O jogador " + player.getName() + " entrou na campanha " + this.getName());
        }
    }

    public void notifyMasterPlayerLeft(Player player) {
        if (master != null) {
            master.update("O jogador " + player.getName() + " saiu da campanha " + this.getName());
        }
    }

    public void cancelCampaign() {
        setStatus(StatusType.CANCELADA);
    }

    public String printCampaignInfos() {
        return "Informações da campanha: " + this.getName() + "\nMáximo de jogadores: " + this.getMaxPlayers() + "\nMínimero de jogadores: "
                + this.getMinPlayers() + "\nMestre: " + this.getMaster() + "\nNúmero de sessões restantes: " + this.getSessionsNumber()
                + "\nDescrição: " + this.getDescription() + "\nStatus: " + this.getStatus() + "\nData de inicio: " + this.getStartDate()
                + "\nData de fim: " + this.getEndDate();
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public Master getMaster() {
        return master;
    }

    public int getSessionsNumber() {
        return sessionsNumber;
    }

    public String getDescription() {
        return description;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public List<CharacterSheet> getCharacters() {
        return characters;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public SystemRPG getSystemRPG() {
        return systemRPG;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionsNumber(int sessionsNumber) {
        this.sessionsNumber = sessionsNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(StatusType status) {
        this.status = status;
        notifyChange(this.getStatus().toString());
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setSystemRPG(SystemRPG systemRPG) {
        this.systemRPG = systemRPG;
    }

    public void setCharacters(List<CharacterSheet> characters) {
        this.characters = characters;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}