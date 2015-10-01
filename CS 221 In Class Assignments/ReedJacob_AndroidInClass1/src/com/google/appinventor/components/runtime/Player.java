// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.FroyoUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnPauseListener, OnResumeListener, 
//            OnDestroyListener, OnStopListener, Deleteable, ComponentContainer, 
//            Form, EventDispatcher

public final class Player extends AndroidNonvisibleComponent
    implements Component, android.media.MediaPlayer.OnCompletionListener, OnPauseListener, OnResumeListener, OnDestroyListener, OnStopListener, Deleteable
{
    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State INITIAL;
        public static final State PAUSED_BY_EVENT;
        public static final State PAUSED_BY_USER;
        public static final State PLAYING;
        public static final State PREPARED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/appinventor/components/runtime/Player$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            INITIAL = new State("INITIAL", 0);
            PREPARED = new State("PREPARED", 1);
            PLAYING = new State("PLAYING", 2);
            PAUSED_BY_USER = new State("PAUSED_BY_USER", 3);
            PAUSED_BY_EVENT = new State("PAUSED_BY_EVENT", 4);
            $VALUES = (new State[] {
                INITIAL, PREPARED, PLAYING, PAUSED_BY_USER, PAUSED_BY_EVENT
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final boolean audioFocusSupported;
    private final Activity activity;
    private Object afChangeListener;
    private AudioManager am;
    private boolean focusOn;
    private boolean loop;
    private boolean playOnlyInForeground;
    private MediaPlayer player;
    public State playerState;
    private String sourcePath;
    private final Vibrator vibe;

    public Player(ComponentContainer componentcontainer)
    {
        Object obj = null;
        super(componentcontainer.$form());
        activity = componentcontainer.$context();
        sourcePath = "";
        vibe = (Vibrator)form.getSystemService("vibrator");
        form.registerForOnDestroy(this);
        form.registerForOnResume(this);
        form.registerForOnPause(this);
        form.registerForOnStop(this);
        form.setVolumeControlStream(3);
        loop = false;
        playOnlyInForeground = false;
        focusOn = false;
        if (audioFocusSupported)
        {
            componentcontainer = FroyoUtil.setAudioManager(activity);
        } else
        {
            componentcontainer = null;
        }
        am = componentcontainer;
        componentcontainer = obj;
        if (audioFocusSupported)
        {
            componentcontainer = ((ComponentContainer) (FroyoUtil.setAudioFocusChangeListener(this)));
        }
        afChangeListener = componentcontainer;
    }

    private void abandonFocus()
    {
        FroyoUtil.abandonFocus(am, afChangeListener);
        focusOn = false;
    }

    private void prepare()
    {
        try
        {
            player.prepare();
            playerState = State.PREPARED;
            return;
        }
        catch (IOException ioexception)
        {
            player.release();
        }
        player = null;
        playerState = State.INITIAL;
        form.dispatchErrorOccurredEvent(this, "Source", 702, new Object[] {
            sourcePath
        });
    }

    private void prepareToDie()
    {
        if (audioFocusSupported && focusOn)
        {
            abandonFocus();
        }
        if (player != null && playerState != State.INITIAL)
        {
            player.stop();
        }
        playerState = State.INITIAL;
        if (player != null)
        {
            player.release();
            player = null;
        }
        vibe.cancel();
    }

    private void requestPermanentFocus()
    {
        boolean flag;
        if (FroyoUtil.focusRequestGranted(am, afChangeListener))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        focusOn = flag;
        if (!focusOn)
        {
            form.dispatchErrorOccurredEvent(this, "Source", 709, new Object[] {
                sourcePath
            });
        }
    }

    public void Completed()
    {
        if (audioFocusSupported && focusOn)
        {
            abandonFocus();
        }
        EventDispatcher.dispatchEvent(this, "Completed", new Object[0]);
    }

    public boolean IsPlaying()
    {
        if (playerState == State.PREPARED || playerState == State.PLAYING)
        {
            return player.isPlaying();
        } else
        {
            return false;
        }
    }

    public void Loop(boolean flag)
    {
        if (playerState == State.PREPARED || playerState == State.PLAYING || playerState == State.PAUSED_BY_USER)
        {
            player.setLooping(flag);
        }
        loop = flag;
    }

    public boolean Loop()
    {
        return loop;
    }

    public void OtherPlayerStarted()
    {
        EventDispatcher.dispatchEvent(this, "OtherPlayerStarted", new Object[0]);
    }

    public void Pause()
    {
        if (player != null)
        {
            boolean flag = player.isPlaying();
            if (playerState == State.PLAYING)
            {
                player.pause();
                if (flag)
                {
                    playerState = State.PAUSED_BY_USER;
                    return;
                }
            }
        }
    }

    public void PlayOnlyInForeground(boolean flag)
    {
        playOnlyInForeground = flag;
    }

    public boolean PlayOnlyInForeground()
    {
        return playOnlyInForeground;
    }

    public void PlayerError(String s)
    {
    }

    public String Source()
    {
        return sourcePath;
    }

    public void Source(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        sourcePath = s1;
        if (playerState == State.PREPARED || playerState == State.PLAYING || playerState == State.PAUSED_BY_USER)
        {
            player.stop();
            playerState = State.INITIAL;
        }
        if (player != null)
        {
            player.release();
            player = null;
        }
        if (sourcePath.length() > 0)
        {
            player = new MediaPlayer();
            player.setOnCompletionListener(this);
            try
            {
                MediaUtil.loadMediaPlayer(player, form, sourcePath);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                player.release();
                player = null;
                form.dispatchErrorOccurredEvent(this, "Source", 701, new Object[] {
                    sourcePath
                });
                return;
            }
            player.setAudioStreamType(3);
            if (audioFocusSupported)
            {
                requestPermanentFocus();
            }
            prepare();
        }
    }

    public void Start()
    {
        if (audioFocusSupported && !focusOn)
        {
            requestPermanentFocus();
        }
        if (playerState == State.PREPARED || playerState == State.PLAYING || playerState == State.PAUSED_BY_USER || playerState == State.PAUSED_BY_EVENT)
        {
            player.setLooping(loop);
            player.start();
            playerState = State.PLAYING;
        }
    }

    public void Stop()
    {
        if (audioFocusSupported && focusOn)
        {
            abandonFocus();
        }
        if (playerState == State.PLAYING || playerState == State.PAUSED_BY_USER || playerState == State.PAUSED_BY_EVENT)
        {
            player.stop();
            prepare();
            if (player != null)
            {
                player.seekTo(0);
            }
        }
    }

    public void Vibrate(long l)
    {
        vibe.vibrate(l);
    }

    public void Volume(int i)
    {
        if (playerState == State.PREPARED || playerState == State.PLAYING || playerState == State.PAUSED_BY_USER)
        {
            if (i > 100 || i < 0)
            {
                throw new IllegalArgumentError("Volume must be set to a number between 0 and 100");
            }
            player.setVolume((float)i / 100F, (float)i / 100F);
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Completed();
    }

    public void onDelete()
    {
        prepareToDie();
    }

    public void onDestroy()
    {
        prepareToDie();
    }

    public void onPause()
    {
        while (player == null || !playOnlyInForeground || !player.isPlaying()) 
        {
            return;
        }
        pause();
    }

    public void onResume()
    {
        if (playOnlyInForeground && playerState == State.PAUSED_BY_EVENT)
        {
            Start();
        }
    }

    public void onStop()
    {
        while (player == null || !playOnlyInForeground || !player.isPlaying()) 
        {
            return;
        }
        pause();
    }

    public void pause()
    {
        while (player == null || playerState != State.PLAYING) 
        {
            return;
        }
        player.pause();
        playerState = State.PAUSED_BY_EVENT;
    }

    static 
    {
        if (SdkLevel.getLevel() >= 8)
        {
            audioFocusSupported = true;
        } else
        {
            audioFocusSupported = false;
        }
    }
}
