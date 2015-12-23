package com.lzw;

import javax.swing.*;
import java.awt.*;

public class RotateFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private RotatePanel jContentPane = null;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RotateFrame thisClass = new RotateFrame();
                thisClass
                        .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
    
    /**
     * This is the default constructor
     */
    public RotateFrame() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(388, 302);
        this.setContentPane(getJContentPane());
        this.setTitle("������ת����");
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                getRootPane().repaint();
            }
        });
    }
    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private RotatePanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new RotatePanel();
            jContentPane.setLayout(new BorderLayout());
        }
        return jContentPane;
    }
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
