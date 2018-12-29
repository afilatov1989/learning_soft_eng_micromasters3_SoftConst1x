package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {

    public Oval(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);

        // customize instrument played, use Strings instead of default Piano
        instrument = 42;

        // customize the default color
        playingColor = new Color(10, 100, 200);
    }

    @Override
    protected void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    protected void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);
    }

    // EFFECTS: return true if this Oval contains the given point p, else return false
    @Override
    public boolean contains(Point p) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, p.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, p.y);
        }
        return diff <= 1.0 + TOL;
    }

    @Override
    protected void drawPlayLine(Graphics g, Color save) {
        g.setColor(Color.red);

        // relative top and bottom points of the play line, derived from an ellipse equation
        int top = (int) (height / 2.0 + height * Math.sqrt(1 / 4.0 - Math.pow(((playLineCoord - width / 2.0) / (double) width), 2.0)));
        int bottom = (int) (height / 2.0 - height * Math.sqrt(1 / 4.0 - Math.pow(((playLineCoord - width / 2.0) / (double) width), 2.0)));

        g.drawLine(x + playLineCoord, y + bottom, x + playLineCoord, y + top);
        g.setColor(save);
    }

    // Compute square of difference
    // EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }

}
