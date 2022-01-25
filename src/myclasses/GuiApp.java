/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import mycomponents.CaptionComponent;
import facade.BuyerFacade;
import facade.ModelFacade;
/**
 *
 * @author user
 */
public class GuiApp extends JFrame{
    private CaptionComponent captionComponent;
    public final static int WIDTH_FRAME = 600;
    public final static int HEIGHT_FRAME = 470;
    public GuiApp guiApp = this;
    
    private BuyerFacade buyerFacade;
    private ModelFacade modelFacade;

    
    private GuestComponent guestComponent;
    private ButtonComponent guestButton;
    private ManagerComponent managerComponent;
    public GuiApp(){
        buyerFacade = new BuyerFacade();
        userRolesFacade = new UserRolesFacade();
        roleFacade = new RoleFacade();
        readerFacade = new ReaderFacade(Reader.class);
        addSuperAdmin();
        super.setMinimumSize(new Dimension(GuiApp.WIDTH_FRAME,GuiApp.HEIGHT_FRAME));
        super.setPreferredSize(super.getMaximumSize());
        super.setMaximumSize(super.getMaximumSize());
        initComponents();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setMinimumSize(new Dimension(600,400));
        this.setPreferredSize(this.getMaximumSize());
        this.setMaximumSize(this.getMaximumSize());
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        captionComponent = new CaptionComponent("Adding new shoes ", this.getWidth(), 50);
        this.getContentPane().add(captionComponent);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
        
    }
}
