package manager.gui;

import manager.ManagersFactory;
import manager.entities.Student;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by ПК on 07.11.2016.
 */
public class MainFrame extends JFrame{

    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JButton saveButton, rollbackButton, showProgress;
    private JTextArea outputText;
    private JScrollPane scrollPane;

    public MainFrame(){
        setTitle("Faculty manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);


        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);


        //region TOP PANEL
        topPanel = new JPanel(new BorderLayout());

        outputText = new JTextArea(50,50);
        scrollPane = new JScrollPane(outputText);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        topPanel.add(scrollPane,BorderLayout.CENTER);

        mainPanel.add(topPanel);
        //endregion
        //region BOTTON PANEL
        bottomPanel = new JPanel(new FlowLayout());

        saveButton = new JButton("Save");
        rollbackButton = new JButton("Cancel Transaction");
        showProgress = new JButton("Show students");
        bottomPanel.add(saveButton);
        bottomPanel.add(rollbackButton);
        bottomPanel.add(showProgress);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        //endregion

        //region ActionListeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagersFactory.getInstance().save();
            }
        });
        rollbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagersFactory.getInstance().rollback();
            }
        });
        showProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder sb = new StringBuilder();
                    for(Object student: ManagersFactory.getStudentManager().getAllStudents()){
                        sb.append(((Student)student).toString());
                    }
                    outputText.setText(sb.toString());
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(MainFrame.this,e1.getLocalizedMessage());
                }
            }
        });
        //endregion



        setVisible(true);
    }

}
