package com.model;

import com.enums.StatusType;
import com.interfaces.Observer;
import com.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Campaign implements Subject {
    private UUID id;
    private String name;
    private int maxPlayers;
    private int minPlayers;
    private Master master;
    private int sessionsNumber;
    private String description;
    private StatusType status;
    private String startDate;
    private String endDate;
    private List<RequestSubscription> subscriptions = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<CharacterSheet> characters = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    private Session currentSession;
    private SystemRPG systemRPG;
    private List<Observer> observers = new ArrayList<>();

    public Campaign(String name, int maxPlayers, int minPlayers, Master master, int sessionsNumber, String description, StatusType status, String startDate, String endDate, SystemRPG systemRPG) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.master = master;
        this.sessionsNumber = sessionsNumber;
        this.description = description;
        this.currentSession = null;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.systemRPG = systemRPG;
    }

    public void addSession(Session session) {
        if (!sessions.contains(session)) {
            sessions.add(session);
        }
    }

    public void startSession(Session session){
        if (sessions.contains(session) && !session.isFinished()) {
            this.setStatus(StatusType.ATIVA);
            this.setCurrentSession(session);
            notifyObservers();
            System.out.println("Sessão iniciada com sucesso para a campanha " + this.getName());
        } else {
            System.out.println("Erro: Sessão não encontrada ou já finalizada na campanha: " + this.getName());
        }

        this.setStatus(StatusType.ATIVA);
    }

    public void endSession(Session session){
        if(this.getStatus() != StatusType.ATIVA){
            System.out.println("É necessário estar com sessão ativa para que seja finalizada.");
        } else if (currentSession != session) {
            System.out.println("Essa sessão não está acontecendo.");
        } else if (session.isFinished()) {
            System.out.println("Essa sessão já foi finalizada.");
        } else if (sessions.contains(session)) {
            System.out.println("Sessão não encontrada na campanha " + this.getName());
        } else {
            if(sessionsNumber == 0) {
                this.setStatus(StatusType.FINALIZADA);
            } else {
                this.setSessionsNumber(sessionsNumber - 1);
            }
            session.setFinished(true);
            notifyObservers();
        }
    }

    public void cancelCampaign(){
        this.setStatus(StatusType.CANCELADA);
    }

    public String campaignInfos() {
        return "Informações da campanha: " + this.getName() + "\nMáximo de jogadores: " + this.getMaxPlayers() + "\nMínimero de jogadores: "
                + this.getMinPlayers() + "\nMestre: " + this.getMaster() + "\nNúmero de sessões restantes: " + this.getSessionsNumber()
                + "\nDescrição: " + this.getDescription() + "\nStatus: " + this.getStatus() + "\nData de inicio: " + this.getStartDate()
                + "\nData de fim: " + this.getEndDate();
    }

    public boolean addCharacter(CharacterSheet characterSheet){
        if (characterSheet == null) {
            return false;
        }

        characters.add(characterSheet);
        return true;
    }

    public boolean removeCharacter(CharacterSheet characterSheet) {
        if (characterSheet != null && characters.contains(characterSheet)) {
            characters.remove(characterSheet);
            return true;
        }
        return false;
    }

    public boolean addSubscription(RequestSubscription subscription) {
        if(subscription == null){
            return false;
        }

        subscriptions.add(subscription);
        return true;
    }

    public void printAllPlayers() {
        System.out.println("\nPlayers:");
        for (int i = 0; i < players.size(); i++) {
            System.out.print("Player " + i+1);
            System.out.print(": " + players.get(i).getName());
            System.out.println(" - " + players.get(i).getRa());
        }
        System.out.println("=======================\n");
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

    public List<RequestSubscription> getSubscriptions() {
        return subscriptions;
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

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public void setSessionsNumber(int sessionsNumber) {
        this.sessionsNumber = sessionsNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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

    public void setSubscriptions(List<RequestSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
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
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
