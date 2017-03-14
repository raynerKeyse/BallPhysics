/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballphysics;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.openal.*;

public class Simulation extends BasicGameState{ 
    Ball ball = new Ball(500,500,20,20);
    private Graphics g;
    Platform platform = new Platform(0,0,0,0);
    Image closeButton;
    Input input = new Input(1080);
    @Override
    public int getID() {
        return 1;
    }
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        closeButton = new Image("/CLOSE.png");
    }
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        ball.update(container, game, delta);
        platform.update(container, game, delta);
        if((input.getMouseX()>(BallPhysics.getSCREEN_WIDTH()-40)&&input.getMouseY()<40)&&input.isMouseButtonDown(0)){
            container.exit();
        }  
        if(platform.intersects(ball)){
            if(ball.getyVelocity()>0){
                ball.setCenterY(platform.getMinY()-ball.getRadius1());
            }
            else{
                ball.setCenterY(platform.getMaxY()+ball.getRadius1());
            }
            ball.setyVelocity(-ball.getyVelocity()*BallPhysics.getDAMP());
        }
    }      
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        ball.render(container, game, g); 
        platform.render(g); 
        g.drawImage(closeButton, 1880, 20);
    }
    public void synthesize(int length, int velocity,GameContainer container, StateBasedGame game, int delta){
        
    }
    
}
    
