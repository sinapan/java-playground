package com.mytube;

public class EmailService implements MessagingService {
    @Override
    public void sendMessage(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
