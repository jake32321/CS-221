// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, OnDestroyListener, Deleteable, ComponentContainer, 
//            Form, EventDispatcher

public final class VideoPlayer extends AndroidViewComponent
    implements OnDestroyListener, Deleteable, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    class ResizableVideoView extends VideoView
    {

        public int forcedHeight;
        public int forcedWidth;
        private Boolean mFoundMediaPlayer;
        private MediaPlayer mVideoPlayer;
        final VideoPlayer this$0;

        private void onMeasure(final int specwidth, final int specheight, int i)
        {
            float f;
            int j;
            int k;
            int l;
            boolean flag;
            char c;
            flag = false;
            k = 0;
            f = container.$form().deviceDensity();
            Log.i("VideoPlayer..onMeasure", (new StringBuilder()).append("Device Density = ").append(f).toString());
            Log.i("VideoPlayer..onMeasure", (new StringBuilder()).append("AI setting dimensions as:").append(forcedWidth).append(":").append(forcedHeight).toString());
            Log.i("VideoPlayer..onMeasure", (new StringBuilder()).append("Dimenions from super>>").append(android.view.View.MeasureSpec.getSize(specwidth)).append(":").append(android.view.View.MeasureSpec.getSize(specheight)).toString());
            j = 176;
            c = '\220';
            switch (forcedWidth)
            {
            default:
                l = 1;
                j = forcedWidth;
                break MISSING_BLOCK_LABEL_173;

            case -2: 
                switch (android.view.View.MeasureSpec.getMode(specwidth))
                {
                default:
                    l = k;
                    continue; /* Loop/switch isn't completed */

                case -2147483648: 
                case 1073741824: 
                    j = android.view.View.MeasureSpec.getSize(specwidth);
                    l = k;
                    continue; /* Loop/switch isn't completed */

                case 0: // '\0'
                    break;
                }
                try
                {
                    j = ((View)getParent()).getMeasuredWidth();
                }
                catch (ClassCastException classcastexception)
                {
                    j = 176;
                    l = k;
                    continue; /* Loop/switch isn't completed */
                }
                catch (NullPointerException nullpointerexception)
                {
                    j = 176;
                    l = k;
                    continue; /* Loop/switch isn't completed */
                }
                l = k;
                continue; /* Loop/switch isn't completed */

            case -1: 
                l = k;
                break;
            }
            if (!mFoundMediaPlayer.booleanValue())
            {
                continue; /* Loop/switch isn't completed */
            }
            j = mVideoPlayer.getVideoWidth();
            Log.i("VideoPlayer.onMeasure", (new StringBuilder()).append("Got width from MediaPlayer>").append(j).toString());
            l = k;
            continue; /* Loop/switch isn't completed */
            nullpointerexception1;
            Log.e("VideoPlayer..onMeasure", (new StringBuilder()).append("Failed to get MediaPlayer for width:\n").append(nullpointerexception1.getMessage()).toString());
            j = 176;
            l = k;
            if (true) goto _L2; else goto _L1
_L2:
            if (forcedWidth > -1000)
            {
                break; /* Loop/switch isn't completed */
            }
            k = container.$form().Width();
            NullPointerException nullpointerexception1;
            if (k == 0 && i < 2)
            {
                Log.d("VideoPlayer...onMeasure", (new StringBuilder()).append("Width not stable... trying again (onMeasure ").append(i).append(")").toString());
                androidUIHandler.postDelayed(i. new Runnable() {

                    final ResizableVideoView this$1;
                    final int val$specheight;
                    final int val$specwidth;
                    final int val$trycount;

                    public void run()
                    {
                        onMeasure(specwidth, specheight, trycount + 1);
                    }

            
            {
                this$1 = final_resizablevideoview;
                specwidth = i;
                specheight = j;
                trycount = I.this;
                super();
            }
                }, 100L);
                setMeasuredDimension(100, 100);
                return;
            }
            k = (int)((float)((-(j + 1000) * k) / 100) * f);
              goto _L3
_L1:
            k = j;
            if (l != 0)
            {
                k = (int)((float)j * f);
            }
            continue; /* Loop/switch isn't completed */
_L3:
            switch (forcedHeight)
            {
            default:
                l = 1;
                j = forcedHeight;
                break MISSING_BLOCK_LABEL_533;

            case -2: 
                switch (android.view.View.MeasureSpec.getMode(specheight))
                {
                default:
                    j = c;
                    l = ((flag) ? 1 : 0);
                    break;

                case -2147483648: 
                case 1073741824: 
                    j = android.view.View.MeasureSpec.getSize(specheight);
                    l = ((flag) ? 1 : 0);
                    break;
                }
                if (false)
                {
                }
                continue; /* Loop/switch isn't completed */

            case -1: 
                j = c;
                l = ((flag) ? 1 : 0);
                break;
            }
            if (!mFoundMediaPlayer.booleanValue())
            {
                continue; /* Loop/switch isn't completed */
            }
            j = mVideoPlayer.getVideoHeight();
            Log.i("VideoPlayer.onMeasure", (new StringBuilder()).append("Got height from MediaPlayer>").append(j).toString());
            l = ((flag) ? 1 : 0);
            continue; /* Loop/switch isn't completed */
            nullpointerexception2;
            Log.e("VideoPlayer..onMeasure", (new StringBuilder()).append("Failed to get MediaPlayer for height:\n").append(nullpointerexception2.getMessage()).toString());
            j = 144;
            l = ((flag) ? 1 : 0);
            if (true) goto _L5; else goto _L4
_L5:
            if (forcedHeight > -1000)
            {
                break; /* Loop/switch isn't completed */
            }
            l = container.$form().Height();
            NullPointerException nullpointerexception2;
            if (l == 0 && i < 2)
            {
                Log.d("VideoPlayer...onMeasure", (new StringBuilder()).append("Height not stable... trying again (onMeasure ").append(i).append(")").toString());
                androidUIHandler.postDelayed(i. new Runnable() {

                    final ResizableVideoView this$1;
                    final int val$specheight;
                    final int val$specwidth;
                    final int val$trycount;

                    public void run()
                    {
                        onMeasure(specwidth, specheight, trycount + 1);
                    }

            
            {
                this$1 = final_resizablevideoview;
                specwidth = i;
                specheight = j;
                trycount = I.this;
                super();
            }
                }, 100L);
                setMeasuredDimension(100, 100);
                return;
            }
            specwidth = (int)((float)((-(j + 1000) * l) / 100) * f);
_L7:
            Log.i("VideoPlayer.onMeasure", (new StringBuilder()).append("Setting dimensions to:").append(k).append("x").append(specwidth).toString());
            getHolder().setFixedSize(k, specwidth);
            setMeasuredDimension(k, specwidth);
            return;
_L4:
            specwidth = j;
            if (l != 0)
            {
                specwidth = (int)((float)j * f);
            }
            if (true) goto _L7; else goto _L6
_L6:
            if (true) goto _L3; else goto _L8
_L8:
        }

        public void changeVideoSize(int i, int j)
        {
            forcedWidth = i;
            forcedHeight = j;
            forceLayout();
            invalidate();
        }

        public void invalidateMediaPlayer(boolean flag)
        {
            mFoundMediaPlayer = Boolean.valueOf(false);
            mVideoPlayer = null;
            if (flag)
            {
                forceLayout();
                invalidate();
            }
        }

        public void onMeasure(int i, int j)
        {
            onMeasure(i, j, 0);
        }

        public void setMediaPlayer(MediaPlayer mediaplayer, boolean flag)
        {
            mVideoPlayer = mediaplayer;
            mFoundMediaPlayer = Boolean.valueOf(true);
            if (flag)
            {
                forceLayout();
                invalidate();
            }
        }


        public ResizableVideoView(Context context)
        {
            this$0 = VideoPlayer.this;
            super(context);
            mFoundMediaPlayer = Boolean.valueOf(false);
            forcedWidth = -1;
            forcedHeight = -1;
        }
    }


    private final Handler androidUIHandler = new Handler();
    private boolean delayedStart;
    private boolean inFullScreen;
    private MediaPlayer mPlayer;
    private boolean mediaReady;
    private String sourcePath;
    private final ResizableVideoView videoView;

    public VideoPlayer(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        inFullScreen = false;
        mediaReady = false;
        delayedStart = false;
        componentcontainer.$form().registerForOnDestroy(this);
        videoView = new ResizableVideoView(componentcontainer.$context());
        videoView.setMediaController(new MediaController(componentcontainer.$context()));
        videoView.setOnCompletionListener(this);
        videoView.setOnErrorListener(this);
        videoView.setOnPreparedListener(this);
        componentcontainer.$add(this);
        componentcontainer.setChildWidth(this, 176);
        componentcontainer.setChildHeight(this, 144);
        componentcontainer.$form().setVolumeControlStream(3);
        sourcePath = "";
    }

    private void prepareToDie()
    {
        if (videoView.isPlaying())
        {
            videoView.stopPlayback();
        }
        videoView.setVideoURI(null);
        videoView.clearAnimation();
        delayedStart = false;
        mediaReady = false;
        if (inFullScreen)
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("FullScreenKey", false);
            container.$form().fullScreenVideoAction(195, this, bundle);
        }
    }

    public void Completed()
    {
        EventDispatcher.dispatchEvent(this, "Completed", new Object[0]);
    }

    public void FullScreen(boolean flag)
    {
        if (flag && SdkLevel.getLevel() <= 4)
        {
            container.$form().dispatchErrorOccurredEvent(this, "FullScreen(true)", 1303, new Object[0]);
        } else
        if (flag != inFullScreen)
        {
            if (flag)
            {
                Bundle bundle = new Bundle();
                bundle.putInt("PositionKey", videoView.getCurrentPosition());
                bundle.putBoolean("PlayingKey", videoView.isPlaying());
                videoView.pause();
                bundle.putBoolean("FullScreenKey", true);
                bundle.putString("SourceKey", sourcePath);
                if (container.$form().fullScreenVideoAction(195, this, bundle).getBoolean("ActionSuccess"))
                {
                    inFullScreen = true;
                    return;
                } else
                {
                    inFullScreen = false;
                    container.$form().dispatchErrorOccurredEvent(this, "FullScreen", 1301, new Object[] {
                        ""
                    });
                    return;
                }
            }
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("FullScreenKey", false);
            bundle1 = container.$form().fullScreenVideoAction(195, this, bundle1);
            if (bundle1.getBoolean("ActionSuccess"))
            {
                fullScreenKilled(bundle1);
                return;
            } else
            {
                inFullScreen = true;
                container.$form().dispatchErrorOccurredEvent(this, "FullScreen", 1302, new Object[] {
                    ""
                });
                return;
            }
        }
    }

    public boolean FullScreen()
    {
        return inFullScreen;
    }

    public int GetDuration()
    {
        Log.i("VideoPlayer", "Calling GetDuration");
        if (inFullScreen)
        {
            Bundle bundle = container.$form().fullScreenVideoAction(196, this, null);
            if (bundle.getBoolean("ActionSuccess"))
            {
                return bundle.getInt("ActionData");
            } else
            {
                return 0;
            }
        } else
        {
            return videoView.getDuration();
        }
    }

    public int Height()
    {
        return super.Height();
    }

    public void Height(int i)
    {
        super.Height(i);
        videoView.changeVideoSize(videoView.forcedWidth, i);
    }

    public void Pause()
    {
        Log.i("VideoPlayer", "Calling Pause");
        if (inFullScreen)
        {
            container.$form().fullScreenVideoAction(192, this, null);
            delayedStart = false;
            return;
        } else
        {
            delayedStart = false;
            videoView.pause();
            return;
        }
    }

    public void SeekTo(int i)
    {
        Log.i("VideoPlayer", "Calling SeekTo");
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        if (inFullScreen)
        {
            container.$form().fullScreenVideoAction(190, this, Integer.valueOf(j));
            return;
        } else
        {
            videoView.seekTo(j);
            return;
        }
    }

    public void Source(String s)
    {
        if (inFullScreen)
        {
            container.$form().fullScreenVideoAction(194, this, s);
        } else
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            sourcePath = s1;
            videoView.invalidateMediaPlayer(true);
            if (videoView.isPlaying())
            {
                videoView.stopPlayback();
            }
            videoView.setVideoURI(null);
            videoView.clearAnimation();
            if (sourcePath.length() > 0)
            {
                Log.i("VideoPlayer", (new StringBuilder()).append("Source path is ").append(sourcePath).toString());
                try
                {
                    mediaReady = false;
                    MediaUtil.loadVideoView(videoView, container.$form(), sourcePath);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    container.$form().dispatchErrorOccurredEvent(this, "Source", 701, new Object[] {
                        sourcePath
                    });
                    return;
                }
                Log.i("VideoPlayer", "loading video succeeded");
                return;
            }
        }
    }

    public void Start()
    {
        Log.i("VideoPlayer", "Calling Start");
        if (inFullScreen)
        {
            container.$form().fullScreenVideoAction(191, this, null);
            return;
        }
        if (mediaReady)
        {
            videoView.start();
            return;
        } else
        {
            delayedStart = true;
            return;
        }
    }

    public void VideoPlayerError(String s)
    {
    }

    public void Volume(int i)
    {
        i = Math.min(Math.max(i, 0), 100);
        if (mPlayer != null)
        {
            mPlayer.setVolume((float)i / 100F, (float)i / 100F);
        }
    }

    public int Width()
    {
        return super.Width();
    }

    public void Width(int i)
    {
        super.Width(i);
        videoView.changeVideoSize(i, videoView.forcedHeight);
    }

    public void delayedStart()
    {
        delayedStart = true;
        Start();
    }

    public void fullScreenKilled(Bundle bundle)
    {
        inFullScreen = false;
        String s = bundle.getString("SourceKey");
        if (!s.equals(sourcePath))
        {
            Source(s);
        }
        videoView.setVisibility(0);
        videoView.requestLayout();
        SeekTo(bundle.getInt("PositionKey"));
        if (bundle.getBoolean("PlayingKey"))
        {
            Start();
        }
    }

    public int getPassedHeight()
    {
        return videoView.forcedHeight;
    }

    public int getPassedWidth()
    {
        return videoView.forcedWidth;
    }

    public View getView()
    {
        return videoView;
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

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        videoView.invalidateMediaPlayer(true);
        delayedStart = false;
        mediaReady = false;
        Log.e("VideoPlayer", (new StringBuilder()).append("onError: what is ").append(i).append(" 0x").append(Integer.toHexString(i)).append(", extra is ").append(j).append(" 0x").append(Integer.toHexString(j)).toString());
        container.$form().dispatchErrorOccurredEvent(this, "Source", 701, new Object[] {
            sourcePath
        });
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mediaReady = true;
        delayedStart = false;
        mPlayer = mediaplayer;
        videoView.setMediaPlayer(mPlayer, true);
        if (delayedStart)
        {
            Start();
        }
    }

}
