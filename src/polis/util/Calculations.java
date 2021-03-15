package polis.util;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Calculations {
	
	public static int[] NormalizeXY(Pane pane, int CELL_SIZE, MouseEvent event) {
		int[] ret = new int[2];
		int r = CalcRowFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
		int k = CalcColFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
		int x = CalcXFromRowCol(CELL_SIZE, r, k);
		int y = CalcYFromRowCol(CELL_SIZE, r, k);
		ret[0] = x;
		ret[1] = y;
		return ret;
	}
	
	public static int CalcRowFromXY(Pane pane, int CELL_SIZE, int x, int y) {
		return (int) (2 * y - x + (pane.getWidth() / 2)) / (2 * CELL_SIZE);
	}
	
	public static int CalcColFromXY(Pane pane, int CELL_SIZE, int x, int y) {
		return (int) (2 * y + x - (pane.getWidth() / 2)) / (2 * CELL_SIZE);
	}
	
	public static int CalcXFromRowCol(int CELL_SIZE, int r, int k) {
		return CELL_SIZE * (1 - r + k);
	}
	
	public static int CalcYFromRowCol(int CELL_SIZE, int r, int k) {
		return (CELL_SIZE * (r + k)) / 2;
	}
}
