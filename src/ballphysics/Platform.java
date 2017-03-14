/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballphysics;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Platform extends Rectangle{
    Input input = new Input(1080);
    boolean drawing;
    boolean drawn;
    public Platform(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta){
        if(input.isMouseButtonDown(0)&&!drawing){
            drawing = true;
            this.setX(input.getMouseX());
            this.setY(input.getMouseY());
            this.setHeight(1);
        }
        if(drawing&&input.isMouseButtonDown(0)){
            System.out.println((float) Math.atan((input.getAbsoluteMouseY()-y)/(input.getAbsoluteMouseX()-x)));
        }
        if(input.isMouseButtonDown(0)){
            this.setWidth(input.getMouseX()-x);
        }
        if(drawing&&!input.isMouseButtonDown(0)){
            drawing = false;
        }
        
    }
    
    public void render(Graphics g){
        g.drawRect(x, y, width, height);
        
    }
    
} 
