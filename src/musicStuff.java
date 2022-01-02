import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class musicStuff {

	Clip music;
	AudioInputStream audioInput;
	File musicPath;
	int framePosition;
	String filePath;
	
	void playMusic (String musicLocation)
	{		
		try
		{

			
			
			musicPath = new File(musicLocation);
			
			if (musicPath.exists())
			{
				audioInput = AudioSystem.getAudioInputStream(musicPath);
				music = AudioSystem.getClip();
				music.stop();
				music.setFramePosition(framePosition);
				music.open(audioInput);
				music.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else 
			{
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	void stopMusic ()
	{
		music.stop();
		music.close();
		music.setFramePosition(0);
	
	}
	
	void pauseMusic()
	{
		framePosition = music.getFramePosition();
		music.stop();
		music.close();
	}
	
	
}
