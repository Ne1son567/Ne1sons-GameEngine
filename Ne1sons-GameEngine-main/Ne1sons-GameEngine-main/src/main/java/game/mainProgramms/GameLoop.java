package main.java.game.mainProgramms;
//Java-Imports

import main.java.game.graphic.JFrames.MainJFrame;

//Custom-Defined Imports
public class GameLoop implements Runnable {
    
    private Thread gameThread;
    private boolean isRunning = false;

    private int maxLoopTime = 16; //  60 FPS
    private long lastTime;
    private int frameCount;
    private int fps;

    public GameLoop() {

        lastTime = System.currentTimeMillis();
    }

    public synchronized void start() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            isRunning = true;
            gameThread.start();
        }
    }

    public synchronized void stop() {
        isRunning = false;
        
    }

    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;

        while (isRunning) {
            oldTimestamp = System.currentTimeMillis();
            //update();
            timestamp = System.currentTimeMillis();

            if (timestamp - oldTimestamp > maxLoopTime) {
                //System.out.println("We're late!");
                continue;
            }

            render();
            timestamp = System.currentTimeMillis();

            frameCount++;
            if (timestamp - lastTime >= 1000) {
                fps = frameCount;
                frameCount = 0;
                lastTime = timestamp;
            }

            //System.out.println("FPS: " + fps);

            if (timestamp - oldTimestamp <= maxLoopTime) {
                try {
                    Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        stop(); 
    }

    public void update() 
    {
       
    }

    private void render() 
    {
       MainJFrame.getGameJPanel1().repaint();
    }
    
   
}
