/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballphysics;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Platform extends Line{
    Vector2f start = new Vector2f(0,0);
    Vector2f end = new Vector2f(0,0);
    Input input = new Input(1080);
    boolean drawing;
    boolean drawn;
    public Platform(Vector2f start, Vector2f end) {
        super(start, end);   
    }

    @Override
    public Vector2f getStart() {
        return start;
    }

    public void setStart(Vector2f start) {
        
        this.start = start;
    }

    @Override
    public Vector2f getEnd() {
        return end;
    }

    public void setEnd(Vector2f end) {
        this.end = end;
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta){
        if(input.isMouseButtonDown(0)&&!drawing){
            drawing = true;
            start = (new Vector2f(input.getMouseX(),input.getMouseY()));
        }
        if(input.isMouseButtonDown(0)){
            end = (new Vector2f(input.getMouseX(),input.getMouseY()));
        }
        if(drawing&&!input.isMouseButtonDown(0)){
            drawing = false;
        }
        System.out.println(this.getPointCount());
    }
    
    public void render(Graphics g){
        g.setAntiAlias(true); 
        g.drawLine(start.getX(),start.getY(),end.getX(),end.getY());
        
        
    }
    public void synthesize(int length, int velocity){
        
    }
} 
