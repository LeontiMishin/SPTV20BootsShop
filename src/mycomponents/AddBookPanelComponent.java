/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponents;
import entity.Customer;
import entity.History;
import facade.ModelFacade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 *
 * @author user
 */
public class AddBookPanelComponent extends JPanel{
    private CaptionComponent captionComponentTabAddBook;
    private InfoComponent infoComponentTabAddBook;
    private EditComponent bookNameComponentTabAddBook;
    private ListAuthorsComponent listAuthorsComponentTabAddBook;
    private EditComponent publishedYearComponentTabAddBook;
    private EditComponent quantityComponentTabAddBook;
    private ButtonComponent buttonComponentTabAddBook;
    
    private final ModelFacade bookFacade;
    
    public AddBookPanelComponent(int widthPanel, int heightPanel) {
        this.bookFacade = new BookFacade(Book.class);
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(heightPanel, heightPanel);
        super.setPreferredSize(new Dimension(heightPanel,heightPanel));
        super.setMinimumSize(super.getPreferredSize());
        super.setMaximumSize(super.getPreferredSize());
        initComponents();
        
    }
}
