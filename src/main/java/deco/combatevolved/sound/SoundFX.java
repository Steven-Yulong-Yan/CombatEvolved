package deco.combatevolved.sound;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Timer;

public class SoundFX extends ApplicationAdapter {
    Sound sound;

    @Override
    public void create() {
        sound = Gdx.audio.newSound(Gdx.files.internal("resources/sounds/Background Music/BGM_BattlePlay_01_Inactive.mp3"));
        final long soundID = sound.loop(1.0f, 1.0f, 0.0f);
        Timer.schedule(new Timer.Task(){
            @Override
            public void run(){
                sound.pause(soundID);
            }
            }, 10
        );
    }

    @Override
    public void render() {

    }


}
