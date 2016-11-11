package manager.gui;

import manager.ManagersFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ПК on 07.11.2016.
 */
public class MainFrame extends JFrame{

    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JButton saveButton, rollbackButton, optionButton;
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
        bottomPanel.add(saveButton);
        bottomPanel.add(rollbackButton);

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
        //endregion



        setVisible(true);
    }

}
