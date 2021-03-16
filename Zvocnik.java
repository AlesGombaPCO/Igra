import java.io.*;

import javax.sound.sampled.*;

public class Zvocnik {
	
	private Clip clipTrk;
	private Clip clipOdboj;
	
	public Zvocnik() {
		try {
			AudioInputStream aisTrk = AudioSystem.getAudioInputStream(new File("impact.wav").getAbsoluteFile());
			clipTrk = AudioSystem.getClip();
			clipTrk.open(aisTrk);
			
			AudioInputStream aisOdboj = AudioSystem.getAudioInputStream(new File("bounce.wav").getAbsoluteFile());
			clipOdboj = AudioSystem.getClip();
			clipOdboj.open(aisOdboj);
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void trk() {
		clipOdboj.stop();
		clipTrk.setFramePosition(0);
		clipTrk.start();
	}
	
	public void odboj() {
		clipOdboj.setFramePosition(0);
		clipTrk.stop();
		clipOdboj.stop();
		clipOdboj.start();
	}
}
