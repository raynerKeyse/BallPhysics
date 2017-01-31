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
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Simulation extends BasicGameState{ 
    Ball ball = new Ball(500,500,20,20);
    private Graphics g;
    Platform platform = new Platform(new Vector2f(0,0), new Vector2f(0,0));
    Image closeButton;
    Input input = new Input(1080);
    Rectangle close = new Rectangle(1880,20,20,20);
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
        if((input.getMouseX()>1880&&input.getMouseY()<40)&&input.isMouseButtonDown(0)){
            
            container.exit();
        }
        
        
    }   
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        ball.render(container, game, g); 
        
        platform.render(g);  
        
        g.drawImage(closeButton, 1880, 20);
        
    }
    
}
    
