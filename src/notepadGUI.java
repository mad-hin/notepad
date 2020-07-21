import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
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
    public JMenu textFormat;
    public JFrame window;
    public JMenu textFont;
    public JMenu textSize;
    public JMenuItem wordWarp;
    public JMenuItem size12, size14, size16, size18, size20, size24, size32;
    public JMenuItem undo;
    public JMenuItem redo;
    public boolean warpOn;
    UndoManager ud = new UndoManager();

    notepadFunction func = new notepadFunction(this);
    notepadFormat format = new notepadFormat(this);

    public static void main(String[] args) {
        new notepadGUI();
    }

    public notepadGUI() {
        createWindow();
        init();
        menuInit();
        warpOn = false;
        format.textWarp();
        format.setFont("Arial");
        format.setSize(12);
        format.fontInit();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init() {
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                ud.addEdit(e.getEdit());
            }
        });
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

        undo = new JMenuItem("Undo");
        undo.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        undo.addActionListener(this);
        undo.setActionCommand("undo");
        edit.add(undo);

        redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() + InputEvent.SHIFT_DOWN_MASK));
        redo.addActionListener(this);
        redo.setActionCommand("redo");
        edit.add(redo);

        mainMenu.add(edit);

        //noinspection BoundFieldAssignment
        textFormat = new JMenu("Format");

        wordWarp = new JMenuItem("Word Warp Off");
        wordWarp.addActionListener(this);
        wordWarp.setActionCommand("warp");
        textFormat.add(wordWarp);

        textFont = new JMenu("Font");

        textSize = new JMenu("Font Size");
        size12 = new JMenuItem("12");
        size12.addActionListener(this);
        size12.setActionCommand("12");
        textSize.add(size12);

        size14 = new JMenuItem("14");
        size14.addActionListener(this);
        size14.setActionCommand("14");
        textSize.add(size14);

        size16 = new JMenuItem("16");
        size16.addActionListener(this);
        size16.setActionCommand("16");
        textSize.add(size16);

        size18 = new JMenuItem("18");
        size18.addActionListener(this);
        size18.setActionCommand("18");
        textSize.add(size18);

        size20 = new JMenuItem("20");
        size20.addActionListener(this);
        size20.setActionCommand("20");
        textSize.add(size20);

        size24 = new JMenuItem("24");
        size24.addActionListener(this);
        size24.setActionCommand("24");
        textSize.add(size24);

        size32 = new JMenuItem("32");
        size32.addActionListener(this);
        size32.setActionCommand("32");
        textSize.add(size32);

        textFormat.add(textSize);
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
            case "warp":
                format.textWarp();
                break;
            case "12":
                format.setSize(12);
                break;
            case "14":
                format.setSize(14);
                break;
            case "16":
                format.setSize(16);
                break;
            case "18":
                format.setSize(18);
                break;
            case "20":
                format.setSize(20);
                break;
            case "24":
                format.setSize(24);
                break;
            case "32":
                format.setSize(32);
                break;
            case "undo":
                func.undo();
                break;
            case"redo":
                func.redo();
                break;
        }
    }
}
