import java.awt.*;

public class notepadFunction {
    notepadGUI gui;
    String fileName;

    public notepadFunction(notepadGUI gui) {
        this.gui = gui;
    }

    public void createNewFile() {
        gui.textArea.setText("");
        gui.window.setTitle("Untitled New File");
    }

    public void exitApp() {
        System.exit(0);
    }

    public void openFile() {
        FileDialog explore = new FileDialog(gui.window, "Open File", FileDialog.LOAD);
        explore.setVisible(true);
    }
}
