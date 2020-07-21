import java.awt.*;
import java.io.*;

public class notepadFunction {
    notepadGUI gui;
    String fileName = null;
    String fileAddress = null;

    public notepadFunction(notepadGUI gui) {
        this.gui = gui;
    }

    public void createNewFile() {
        gui.textArea.setText("");
        gui.window.setTitle("Untitled New File");
        fileName = null;
        fileAddress = null;
    }

    public void exitApp() {
        System.exit(0);
    }

    public void openFile() {
        FileDialog explore = new FileDialog(gui.window, "Open File", FileDialog.LOAD);
        explore.setVisible(true);
        fileName = explore.getFile();
        if (fileName != null) {
            fileAddress = explore.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line;
            System.out.println("File opening");
            while ((line = reader.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not open");
        }
    }

    public void fileSave() {
        if (fileName == null) {
            fileSaveAs();
        } else {
            try {
                FileWriter writer = new FileWriter(fileAddress + fileName);
                writer.write(gui.textArea.getText());
                System.out.println("File saved");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File cannot be save");
            }
        }
    }

    public void fileSaveAs() {
        FileDialog explore = new FileDialog(gui.window, "Save as", FileDialog.LOAD);
        explore.setVisible(true);

        fileName = explore.getFile();
        if (fileName != null) {
            fileAddress = explore.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter writer = new FileWriter(fileAddress + fileName);
            writer.write(gui.textArea.getText());
            System.out.println("File saved");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File cannot be save");
        }
    }

    public void undo(){
        gui.ud.undo();
    }

    public void redo(){
        gui.ud.redo();
    }
}
