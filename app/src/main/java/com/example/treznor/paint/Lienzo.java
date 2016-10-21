package com.example.treznor.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by treznor on 20/10/2016.
 */
public class Lienzo extends View {
   // path que pinta las lineas
    private Path drawPath;
  //Paint de dibujar en canvas
    private Paint drawPaint, canvasPaint;
  //color inicial
    private int paintColor=0xFFFF0000;
  //canvas
    private Canvas drawCanvas;
 //canvas para guardar
    private Bitmap canvasBitmap;





    public Lienzo(Context context, AttributeSet attrs) {

        super(context, attrs);

        setupDrawing();
    }


    private void setupDrawing(){
  //config del area a pintar
    drawPath = new Path();
    drawPaint = new Paint();
    drawPaint.setColor(paintColor);
    drawPaint.setAntiAlias(true);
    drawPaint.setStrokeWidth(20);
    drawPaint.setStyle(Paint.Style.STROKE);
    drawPaint.setStrokeJoin(Paint.Join.ROUND);
    canvasPaint = new Paint(Paint.DITHER_FLAG);

    }

        //tamaño de la vista

    protected void onSieChanged(int w, int h, int oldw,int oldh){

        super.onSizeChanged(w, h,oldw,oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

    }


    //pinta la vista llamado del ontouch event
    @Override
    protected void onDraw(Canvas canvas){

        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);


    }


    //Registra los touch de usuario

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawPath.moveTo(touchX, touchY);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;

                default:

                return false;

        }

    //repintar

        invalidate();
        return true;

    }



}
