package ui.tools;

import model.Rectangle;
import ui.DrawingEditor;

import java.awt.event.MouseEvent;

import javax.swing.*;

public class RectangleTool extends ShapeTool {
    public RectangleTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
    }

    @Override
    protected String getLabel() {
        return "Rectangle";
    }

    @Override
    protected void makeShape(MouseEvent e) {
        shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }
}
