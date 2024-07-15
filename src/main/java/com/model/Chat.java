package com.model;

public class Chat {
    private User[] participantList;
    private Message[] messageList;

    public Chat(User[] participantList, Message[] messageList) {
        this.participantList = new User[0];
        this.messageList = new Message[0];
    }

    public boolean addParticipant(User participant){
        if (participant == null) {
            return false;
        }

        User[] newList = new User[participantList.length + 1];
        System.arraycopy(participantList, 0, newList, 0, participantList.length);
        newList[participantList.length] = participant;
        participantList = newList;
        return true;
    }

    public boolean removeParticipant(User participant) {
        if (participant == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < participantList.length; i++) {
            if (participantList[i].equals(participant)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        User[] newList = new User[participantList.length - 1];
        System.arraycopy(participantList, 0, newList, 0, index);
        System.arraycopy(participantList, index + 1, newList, index, participantList.length - index - 1);
        participantList = newList;
        return true;
    }

    public boolean addMessage(Message message) {
        if (message == null) {
            return false;
        }

        Message[] newList = new Message[messageList.length + 1];
        System.arraycopy(messageList, 0, newList, 0, messageList.length);
        newList[messageList.length] = message;
        messageList = newList;
        return true;
    }

    public User[] getParticipantList() {
        return participantList;
    }

    public Message[] getMessageList() {
        return messageList;
    }
}
