package org.game.music;

import org.game.Game;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import javax.sound.sampled.*;
import java.util.Random;


public class Music implements MusicObserver{
    private Game game;
    private URL url;
    private Integer last_obs = 0;
    private int last_map = 0;
    private static Clip clip;
    private boolean is_lvlup = false;
    private boolean invent_sound = false;
    public Music(Game game){
        this.game = game;
    }
    public void MusicPlay(int estado) throws URISyntaxException {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
        switch (estado)
        {
            case 0://mainmenu
                url = Music.class.getResource("/music/main_menu.wav");
                break;
            case 1://vila
                url = Music.class.getResource("/music/village_music.wav");
                break;
            case 2://inventario
                url = Music.class.getResource("/music/invent.wav");

                break;
            case 3: //castleentrance
                url = Music.class.getResource("/music/castleentrance.wav");

                break;
            case 4: //castelo
                url = Music.class.getResource("/music/castle.wav");

                break;
            case 5: // combat
                Random rand = new Random();
                int n = rand.nextInt(2);
                if(n == 0) url = Music.class.getResource("/music/combat1.wav");
                else url = Music.class.getResource("/music/combat2.wav");
                break;

            case 6:
                url = Music.class.getResource("/music/victory.wav");
                break;
        }
        File file = Paths.get(url.toURI()).toFile();

        AudioInputStream audiostream = null;
        try {
            audiostream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(audiostream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(1.0f);
        clip.start();





    }

    @Override
    public void update(Game game) throws URISyntaxException {
        if(last_obs == game.getState().getObs().getKey() && last_obs!=1)
        {
            return;
        }

        last_obs = (Integer) game.getState().getObs().getKey();


        switch (last_obs)
        {
            case 0: //menu
                MusicPlay(0);
                break;
            case 1: //mapstate
                Integer maptosee = (Integer) game.getState().getObs().getValue();
                if(invent_sound==true)
                {
                    invent_sound=false;
                    upvolume();
                    break;

                }
                switch ((Integer)game.getState().getObs().getValue())
                {

                    case 0://vila
                        MusicPlay(1);
                        break;
                    case 1: //castle entrance
                        MusicPlay(3);
                        break;
                    case 2://insidecastle
                        MusicPlay(4);
                        break;

                    case 10:
                        lowervolume();
                        invent_sound=true;
                        break;
                }
                break;



            case 3: //inventario
                break;
            case 4: //death
                MusicPlay(3); //alterar
                break;
            case 5: //combate
                MusicPlay(5);
                break;
            case 6://receive e lvlupstate
            {
              /*  switch ((Integer)game.getState().getObs().getValue())
                {
                    case 0:
                        MusicPlay(6);
                        is_lvlup=true;
                        break;
                    case 1:
                        if(is_lvlup){
                            is_lvlup=false;
                            break;
                        }
                        else MusicPlay(6);
                        break;
                }*/
                MusicPlay(6);
            }

                break;
        }




    }

    public void lowervolume()
    {
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f);
        clip.start();
    }


    public void upvolume()
    {
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();
    }
}