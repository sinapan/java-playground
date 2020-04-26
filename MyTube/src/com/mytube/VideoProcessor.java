package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private MessagingService emailService;

    public VideoProcessor(VideoEncoder encoder,
                          VideoDatabase database,
                          MessagingService emailService) {
        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        emailService.sendMessage(video.getUser());
    }
}

