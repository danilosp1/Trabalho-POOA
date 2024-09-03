package com.model.managers;

import com.enums.StatusType;
import com.model.Campaign;
import com.model.Session;

public class SessionManager {
    private final Campaign campaign;

    public SessionManager(Campaign campaign) {
        this.campaign = campaign;
    }

    public void startSession(Session session) {
        if (session == null || session.isFinished() || !campaign.getSessions().contains(session)) {
            System.out.println("Erro: Sessão inválida ou já finalizada na campanha: " + campaign.getName());
            return;
        }

        campaign.setCurrentSession(session);
        campaign.setStatus(StatusType.ATIVA);
        System.out.println("Sessão iniciada com sucesso para a campanha " + campaign.getName());
    }

    public void endSession(Session session) {
        if (campaign.getCurrentSession() == null || campaign.getCurrentSession() != session || !campaign.getSessions().contains(session) || session.isFinished()) {
            System.out.println("Erro ao finalizar a sessão na campanha " + campaign.getName());
            return;
        }

        session.setFinished(true);
        campaign.setSessionsNumber(campaign.getSessionsNumber() - 1);
        if (campaign.getSessionsNumber() == 0) {
            campaign.setStatus(StatusType.FINALIZADA);
        }
    }
}
