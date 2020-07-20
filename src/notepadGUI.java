import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class notepadGUI {
    private JPanel mainPanel;
    private JMenuBar mainMenu;
    private JTextArea textArea;
    private JScrollPane scrollBar;
    private JFrame window;
    public static void main(String[] args){
        new notepadGUI();
    }

    public notepadGUI(){
        createWindow();
        init();
        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init(){
        //noinspection BoundFieldAssignment
        scrollBar = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollBar);
    }
}
