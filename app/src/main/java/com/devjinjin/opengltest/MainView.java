package com.devjinjin.opengltest;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.SurfaceHolder;

/**
 * Created by JYLEE on 2016-05-16.
 */
public class MainView extends GLSurfaceView {
    MainRendererLollipop mRolliPopRenderer;
    MainRenderer mRenderer;
    MainView ( Context context ) {
        super ( context );
        if(Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT) {
            mRolliPopRenderer = new MainRendererLollipop(this);
            setEGLContextClientVersion ( 2 );
            setRenderer ( mRolliPopRenderer );
            setRenderMode ( GLSurfaceView.RENDERMODE_WHEN_DIRTY );

        }else{
            mRenderer = new MainRenderer(this);
            setEGLContextClientVersion ( 2 );
            setRenderer ( mRenderer );
            setRenderMode ( GLSurfaceView.RENDERMODE_WHEN_DIRTY );
        }

    }

    public void surfaceCreated ( SurfaceHolder holder ) {
        super.surfaceCreated ( holder );
    }

    public void surfaceDestroyed ( SurfaceHolder holder ) {
        super.surfaceDestroyed ( holder );
    }

    public void surfaceChanged ( SurfaceHolder holder, int format, int w, int h ) {
        super.surfaceChanged ( holder, format, w, h );
    }

    @Override
    public void onResume() {
        super.onResume();
        if(Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT) {
            mRolliPopRenderer.onResume();
        }
    }

    @Override
    public void onPause() {
        if(Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT) {
            mRolliPopRenderer.onPause();
        }

        super.onPause();
    }
}
