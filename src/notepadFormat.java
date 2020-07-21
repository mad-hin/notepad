import javax.swing.*;
import java.awt.*;

public class notepadFormat {
    notepadGUI gui;

    public notepadFormat(notepadGUI gui) {
        this.gui = gui;
    }

    public void fontInit() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            JMenuItem fontItem = new JMenuItem(font);
            gui.textFont.add(fontItem);
        }
        MenuScroller.setScrollerFor(gui.textFont,30);
        gui.textFormat.add(gui.textFont);
        gui.mainMenu.add(gui.textFormat);
    }
}
