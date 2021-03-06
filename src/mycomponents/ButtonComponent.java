/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponents;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ButtonComponent extends JPanel {
    private JButton jButton;
   
    
    public ButtonComponent(String text,int widthPanel,int heightPanel, int left, int widthEdit) {
       initComponents(text,widthPanel,heightPanel,left,widthEdit);
    }

    private void initComponents(String text,int widthPanel,int heightPanel, int left, int widthButton) {
        this.setPreferredSize(new Dimension(widthPanel,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        super.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(left,0)));
        jButton = new JButton(text);
        jButton.setPreferredSize(new Dimension(widthButton,27));
        jButton.setMaximumSize(jButton.getPreferredSize());
        jButton.setMinimumSize(jButton.getPreferredSize());
        this.add(jButton);
        
   }

    public JButton getjButton() {
        return jButton;
    }
}
