package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;

import controller.Controller;
import model.*;

public class View extends JFrame {
    private JPanel panel1, panel2;
    private JButton btSave, btDelete, btReadFile, btClearFile;
    private JTextArea textArea;

    private Controller controller = new Controller(this);

    public View(){
        this.setTitle("Text editor");
        this.setSize(1010, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(2, 2, 300, 760);
        panel1.setBorder(new LineBorder(Color.black, 1));
        panel1.setLayout(null);

        panel2 = new JPanel();
        panel2.setBounds(305, 2, 600, 760);
        panel2.setBorder(new LineBorder(Color.blue, 1));
        panel2.setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(5, 5, 580, 740);
        panel2.add(textArea);

        btSave = new JButton("Save");
        btSave.setBounds(910, 2, 80, 30);
        btSave.addActionListener(controller);

        btDelete = new JButton("Clear");
        btDelete.setBounds(910, 40, 80, 30);
        btDelete.addActionListener(controller);

        btReadFile = new JButton("Read file");
        btReadFile.setBounds(910, 78, 80, 30);
        btReadFile.addActionListener(controller);

        this.add(btSave);
        this.add(btDelete);
        this.add(btReadFile);
        this.add(panel1);
        this.add(panel2);

        createTreeModel();
    }

    public void read(){
        readFile rf = new readFile();
        textArea.setText(rf.readFile());
    }

    public void save(){
        String data = textArea.getText();
        saveToFiletxt sf = new saveToFiletxt();
        sf.file(data);
    }

    public void clear(){
        textArea.setText("");
    }
    private void createTreeModel(){
        String directoryPath = "D:\\";
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()){
            JOptionPane.showMessageDialog(null, "Thu muc khong ton tai");
            return;
        }

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(directory.getName());
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        duyetThuMuc(directory, root);

        JTree tree = new JTree(treeModel);
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setBounds(5, 5, 280, 750);

        panel1.add(scrollPane);
    }

    private void duyetThuMuc(File directory, DefaultMutableTreeNode rootFather){
        File[] files = directory.listFiles();

        if (files != null){
            for (File f : files){
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(f.getName());
                if (f.isDirectory()){
                    duyetThuMuc(f, node);
                }
                rootFather.add(node);
            }
        }
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(()->{
                new View();
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
