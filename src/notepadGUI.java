import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class notepadGUI implements ActionListener {
    public JPanel mainPanel;
    public JMenuBar mainMenu;
    public JTextArea textArea;
    public JScrollPane scrollBar;
    public JMenu file;
    public JMenu edit;
    public JMenu formate;
    public JFrame window;

    notepadFunction func = new notepadFunction(this);

    public static void main(String[] args) {
        new notepadGUI();
    }

    public notepadGUI() {
        createWindow();
        init();
        menuInit();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init() {
        //Create the scroll pane when it is needed
        //noinspection BoundFieldAssignment
        scrollBar = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Empty the border
        scrollBar.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollBar);
    }

    public void menuInit() {
        //noinspection BoundFieldAssignment
        mainMenu = new JMenuBar();

        //noinspection BoundFieldAssignment
        file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        newFile.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        newFile.addActionListener(this);
        newFile.setActionCommand("new");
        file.add(newFile);

        JMenuItem openFile = new JMenuItem("Open");
        openFile.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        openFile.addActionListener(this);
        openFile.setActionCommand("open");
        file.add(openFile);

        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveFile.addActionListener(this);
        saveFile.setActionCommand("save");
        file.add(saveFile);

        JMenuItem saveAs = new JMenuItem("Save As");
        saveAs.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + InputEvent.ALT_DOWN_MASK));
        saveAs.addActionListener(this);
        saveAs.setActionCommand("saveAs");
        file.add(saveAs);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exit.addActionListener(this);
        exit.setActionCommand("exit");
        file.add(exit);
        mainMenu.add(file);

        //noinspection BoundFieldAssignment
        edit = new JMenu("Edit");


        mainMenu.add(edit);
        window.setJMenuBar(mainMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "new":
                func.createNewFile();
                break;
            case "open":
                func.openFile();
                break;
            case "save":
                func.fileSave();
                break;
            case "saveAs":
                func.fileSaveAs();
                break;
            case "exit":
                func.exitApp();
                break;
        }
    }
}
