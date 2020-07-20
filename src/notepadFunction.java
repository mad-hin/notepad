import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class notepadFunction {
    notepadGUI gui;
    String fileName;
    String fileAddress;

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
        fileName = explore.getFile();
        fileAddress = explore.getDirectory();
        if (fileName != null) {
            gui.window.setTitle(fileName);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line;
            System.out.println("File opening");
            while ((line = reader.readLine()) != null) {
                gui.textArea.append(line+"\n");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not open");
        }
    }
}
