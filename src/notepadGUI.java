import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class notepadGUI {
    private JPanel mainPanel;
    private JMenuBar mainMenu;
    private JTextArea textArea;
    private JScrollPane scrollBar;
    private JMenu file;
    private JMenu edit;
    private JFrame window;

    public static void main(String[] args){
        new notepadGUI();
    }

    public notepadGUI(){
        createWindow();
        init();
        menuInit();
        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init(){
        //Create the scroll pane when it is needed
        //noinspection BoundFieldAssignment
        scrollBar = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Empty the border
        scrollBar.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollBar);
    }

    public void menuInit(){
        //noinspection BoundFieldAssignment
        mainMenu = new JMenuBar();

        //noinspection BoundFieldAssignment
        file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        newFile.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        file.add(newFile);

        JMenuItem openFile = new JMenuItem("Open");
        openFile.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        file.add(openFile);

        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        file.add(saveFile);

        JMenuItem saveAs = new JMenuItem("Save As");
        saveAs.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()+ InputEvent.ALT_DOWN_MASK));
        file.add(saveAs);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        file.add(exit);
        mainMenu.add(file);

        //noinspection BoundFieldAssignment
        edit = new JMenu("Edit");


        mainMenu.add(edit);
        window.setJMenuBar(mainMenu);
    }
}
