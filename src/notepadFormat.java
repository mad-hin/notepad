import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class notepadFormat implements ActionListener {
    notepadGUI gui;
    JMenuItem fontItem;
    float fontSize;

    public notepadFormat(notepadGUI gui) {
        this.gui = gui;
    }

    public void textWarp() {
        if (!gui.warpOn) {
            gui.warpOn = true;
            gui.textArea.setLineWrap(true);
            gui.wordWarp.setText("Word Warp Off");
        } else {
            gui.warpOn = false;
            gui.textArea.setLineWrap(false);
            gui.wordWarp.setText("Word Warp On");
        }
    }

    public void fontInit() {
        String[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fonts : allFonts) {
            fontItem = new JMenuItem(fonts);
            fontItem.addActionListener(this);
            fontItem.setActionCommand(fonts);
            gui.textFont.add(fontItem);
        }
        MenuScroller.setScrollerFor(gui.textFont, 30);
        gui.textFormat.add(gui.textFont);
        gui.mainMenu.add(gui.textFormat);
    }

    public void setSize(float size) {
        fontSize = size;
        Font font = gui.textArea.getFont();
        gui.textArea.setFont(font.deriveFont(size));
    }

    public void setFont(String font) {
        Font[] allFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        String[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int i = 0;
        for (String fonts : allFonts) {
            i++;
            if (font.equals(fonts)) {
                gui.textArea.setFont(allFont[i]);
                setSize(fontSize);
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        setFont(cmd);
    }
}
