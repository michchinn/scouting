package fullapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	private Color _backgroundColor;
	private Color _foregroundColor;
	
	protected double _yScale;
	protected int _xScale;
	protected int _x0;
	protected int _y0;
	private int _labelAxisBuffer;
	
	public GraphPanel() {
		_backgroundColor = Color.WHITE;
		_foregroundColor = Color.BLACK;
		
		setBackground(_backgroundColor);
		setForeground(_foregroundColor);
		
		this._yScale = 1.75;
		this._xScale = 35;
		this._x0 = 30;
		this._y0 = 210;
		this._labelAxisBuffer = 20;
		
		setPreferredSize(new Dimension(600, 250));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawLine(this._x0, 0, this._x0, this._y0);
		g.drawLine(this._x0, this._y0, 450, this._y0);
		
		g.setFont(new Font("Arial", Font.PLAIN, 10));
		g.drawString("10", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(10*this._yScale)));
		g.drawString("20", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(20*this._yScale)));
		g.drawString("30", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(30*this._yScale)));
		g.drawString("40", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(40*this._yScale)));
		g.drawString("50", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(50*this._yScale)));
		g.drawString("60", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(60*this._yScale)));
		g.drawString("70", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(70*this._yScale)));
		g.drawString("80", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(80*this._yScale)));
		g.drawString("90", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(90*this._yScale)));
		g.drawString("100", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(100*this._yScale)));
		g.drawString("110", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(110*this._yScale)));
		g.drawString("120", this._x0 - this._labelAxisBuffer, (int)Math.floor(this._y0-(120*this._yScale)));
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.drawString("Match", 220, 250);
		g.drawString("0", this._x0, 230);
		g.drawString("1", this._x0+1*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("2", this._x0+2*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("3", this._x0+3*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("4", this._x0+4*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("5", this._x0+5*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("6", this._x0+6*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("7", this._x0+7*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("8", this._x0+8*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("9", this._x0+9*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("10", this._x0+10*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("11", this._x0+11*this._xScale, this._y0 + this._labelAxisBuffer);
		g.drawString("12", this._x0+12*this._xScale, this._y0 + this._labelAxisBuffer);
	}
}
