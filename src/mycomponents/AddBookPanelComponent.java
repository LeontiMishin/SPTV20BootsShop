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
    
     private void initComponents() {
        this.add(Box.createRigidArea(new Dimension(0,15)));
        captionComponentTabAddBook = new CaptionComponent("Добавление новой книги ", this.getWidth(), 30);
        this.add(captionComponentTabAddBook);
        infoComponentTabAddBook = new InfoComponent("", this.getWidth(), 30);
        this.add(infoComponentTabAddBook);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        bookNameComponentTabAddBook=new EditComponent("Название книги ", this.getWidth(), 30, 300);
        this.add(bookNameComponentTabAddBook);
        listAuthorsComponentTabAddBook = new ListAuthorsComponent("Авторы", this.getWidth(), 120, 300);
        this.add(listAuthorsComponentTabAddBook);
        publishedYearComponentTabAddBook=new EditComponent("Год публикации книги ", this.getWidth(), 30, 80);
        this.add(publishedYearComponentTabAddBook);
        quantityComponentTabAddBook=new EditComponent("Количество экземпляров ", this.getWidth(), 30, 40);
        this.add(quantityComponentTabAddBook);
        buttonComponentTabAddBook=new ButtonComponent("Добавить книгу", this.getWidth(), 50, 210, 195);
        this.add(buttonComponentTabAddBook);
        buttonComponentTabAddBook.getjButton().addActionListener(createAddBookButtonActionListener());
        
    }
    
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
