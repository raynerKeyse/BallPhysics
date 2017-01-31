/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballphysics;


import org.newdawn.slick.*;

import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author yr10rkeyse
 */
public class  Ball extends Ellipse{
    Graphics g;
    private double xVelocity = -80;
    private double yVelocity = -60;
    public Ball(float centerPointX, float centerPointY, float radius1, float radius2) {
        super(centerPointX, centerPointY, radius1, radius2);
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
    public void collision(){
        if(maxX>BallPhysics.getSCREEN_WIDTH()){
            setCenterX(BallPhysics.getSCREEN_WIDTH()-this.getRadius1());
            xVelocity = -xVelocity*(BallPhysics.getDAMP());
        }
        else if(maxY>BallPhysics.getSCREEN_HEIGHT()){
            setCenterY(BallPhysics.getSCREEN_HEIGHT()-this.getRadius2());
            yVelocity = -yVelocity*(BallPhysics.getDAMP());
        }
        else if(minX<0){
            setCenterX(this.getRadius1());
            xVelocity = -xVelocity*(BallPhysics.getDAMP());
        }
        else if(minY<0){
            setCenterY(this.getRadius2());
            yVelocity = -yVelocity*(BallPhysics.getDAMP());
        }
    }
    public void update(GameContainer container, StateBasedGame game, int delta){
        setY((float) (getY()+yVelocity));
        setX((float) ((getX()+xVelocity)));
        xVelocity = (0.99)*xVelocity;
        collision();
        yVelocity = yVelocity + (BallPhysics.getGRAVITY()/60);

        
    }
    public void render(GameContainer container, StateBasedGame game, Graphics g){
        g.fill(this);
    }
    
}
