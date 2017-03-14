/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballphysics;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class BallPhysics extends StateBasedGame {
    private static double GRAVITY = 20;
    private static double DAMP = 0.8;
    private static int SCREEN_WIDTH = 1920;
    private static int SCREEN_HEIGHT = 1080;
    public static int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public static void setSCREEN_WIDTH(int SCREEN_WIDTH) {
        BallPhysics.SCREEN_WIDTH = SCREEN_WIDTH;
    }

    public static int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public static void setSCREEN_HEIGHT(int SCREEN_HEIGHT) {
        BallPhysics.SCREEN_HEIGHT = SCREEN_HEIGHT;
    }
    public static void main(String[] args) {
        try {//based on Slick2d documentation
            BallPhysics ballPhysics = new BallPhysics("title");
            AppGameContainer appgc = new AppGameContainer(ballPhysics);
            appgc.setTargetFrameRate(60);
            appgc.setShowFPS(false);
            appgc.setDisplayMode(SCREEN_WIDTH,SCREEN_HEIGHT,false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(BallPhysics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public BallPhysics(String name) {
        super(name);

    }
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new StartScreen());
        this.addState(new Simulation());
        this.enterState(0);
    }
    public static double getGRAVITY() {
        return GRAVITY;
    }
    public static void setGRAVITY(double GRAVITY) {
        BallPhysics.GRAVITY = GRAVITY;
    }
    
    public static double getDAMP() {
        return DAMP;
    }
    public static void setDAMP(double DAMP) {
        BallPhysics.DAMP = DAMP;
    }
    public static void close(){
        
    }
}
