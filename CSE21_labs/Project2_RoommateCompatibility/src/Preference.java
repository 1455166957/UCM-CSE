import java.util.Scanner;

public class Preference {
    private int quietTime, music, reading, chatting;

    public Preference(Scanner line) {
        quietTime = line.nextInt();
        music = line.nextInt();
        reading = line.nextInt();
        chatting = line.nextInt();
    }

    public int getQuietTime() {
        return quietTime;
    }

    public int getMusic() {
        return music;
    }

    public int getReading() {
        return reading;
    }

    public int getChatting() {
        return chatting;
    }

    public int compare(Preference pref) {
        int timeDiff = Math.abs(quietTime - pref.quietTime);
        int musicDiff = Math.abs(music - pref.music);
        int readingDiff = Math.abs(reading - pref.reading);
        int chattingDiff = Math.abs(chatting - pref.chatting);
        return (timeDiff + musicDiff + readingDiff + chattingDiff);
    }
}
