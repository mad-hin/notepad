import javax.swing.*;
import java.awt.*;

public class notepadFormat {
    notepadGUI gui;
    public notepadFormat(notepadGUI gui) {
        this.gui = gui;
    }

    public void textWarp(){
        if(!gui.warpOn){
            gui.warpOn = true;
            gui.textArea.setLineWrap(true);
            gui.wordWarp.setText("Word Warp Off");
        }else {
            gui.warpOn = false;
            gui.textArea.setLineWrap(false);
            gui.wordWarp.setText("Word Warp On");
        }
    }

    public void fontInit() {
        String[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fonts : allFonts) {
            JMenuItem fontItem = new JMenuItem(fonts);
            gui.textFont.add(fontItem);
        }
        MenuScroller.setScrollerFor(gui.textFont,30);
        gui.textFormat.add(gui.textFont);
        gui.mainMenu.add(gui.textFormat);
    }

    public void setSize(float size){
        Font font = gui.textArea.getFont();
        gui.textArea.setFont( font.deriveFont(size) );
    }
}
