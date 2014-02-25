package fullapp;

import java.awt.Color;
import java.awt.Graphics;

public class TotalAutonPointsGraphPanel extends GraphPanel {
	private Team _team;
	private int diameter = 10;
	
	public TotalAutonPointsGraphPanel(Team team) {
		super();
		this._yScale = 3;
		_team = team;
		
		setName("Autonomous");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		
		int numMatches = _team.getNumberOfMatchRecords();
		for (int i = 0; i < numMatches; i++) {
			g.fillOval(this._x0 + this._xScale * (i+1) - diameter/2, (int)(this._y0 - this._yScale * _team.getMatchRecord(i).getAutonPoints()) - diameter/2, diameter, diameter);
		}
		
		if (numMatches > 1) {
			for (int i = 0; i < numMatches - 1; i++) {
				int x1 = this._x0 + this._xScale * (i+1);
				int x2 = this._x0 + this._xScale * (i+2);
				int y1 = (int)(this._y0 - this._yScale * _team.getMatchRecord(i).getAutonPoints());
				int y2 = (int)(this._y0 - this._yScale * _team.getMatchRecord(i+1).getAutonPoints());
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
