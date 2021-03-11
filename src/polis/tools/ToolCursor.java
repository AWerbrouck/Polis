package polis.tools;

import javafx.scene.layout.Pane;

public class ToolCursor{
	

	private Pane pane;
	private boolean active = false;
	private CursorBlock cb;
	public String img;
	public int size;
	public ToolCursor(){
		this.cb = new CursorBlock();
	}
	
	public void setPane(Pane pane){
		this.pane = pane;
	}
	
	public void setImg(String img){
		this.img = img;
		cb.setImg(img);
	}
	public void setSize(int size){
		this.size = size;
		cb.setSize(size);
	}
	
	public void addCursorBlock(){
		cb.setPane(this.pane);
		active = ! active;
		if(active){
			cb.addMouseEvent();
		}else{
			cb.removeMouseEvent();
		}
	}
}
