package stuff;

import java.awt.*;
import java.awt.event.*;

public class Main 
{

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private TextField c, i, g, x, m;
   private Label cLabel, iLabel, gLabel, xLabel, mLabel;

   public Main()
   {
      prepareGUI();
   }

   public static void main(String[] args)
   {
      Main awtControlDemo = new Main();
      awtControlDemo.showEventDemo();
   }

   private void prepareGUI()
   {
      mainFrame = new Frame("ECONBS");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() 
      {
         public void windowClosing(WindowEvent windowEvent)
         {
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
      
      cLabel = new Label("C:", Label.LEFT);
      iLabel = new Label("I:", Label.LEFT);
      gLabel = new Label("G:", Label.LEFT);
      xLabel = new Label("X:", Label.LEFT);
      mLabel = new Label("M:", Label.LEFT);
      
      c = new TextField("", 80);
      i = new TextField("", 80);
      g = new TextField("", 80);
      x = new TextField("", 80);
      m = new TextField("", 80);
      
      mainFrame.add(cLabel);
      mainFrame.add(c);
      mainFrame.add(iLabel);
      mainFrame.add(i);
      mainFrame.add(gLabel);
      mainFrame.add(g);
      mainFrame.add(xLabel);
      mainFrame.add(x);
      mainFrame.add(mLabel);
      mainFrame.add(m);
      
   }

   private void showEventDemo()
   {
      headerLabel.setText("GDP: C+I+G+(X-M)!"); 

      Button okButton = new Button("Calculate!");
      Button submitButton = new Button("Submit");
      Button cancelButton = new Button("Exit");

      okButton.setActionCommand("Calculate");
      submitButton.setActionCommand("Submit");
      cancelButton.setActionCommand("Exit");

      okButton.addActionListener(new ButtonClickListener()); 
      submitButton.addActionListener(new ButtonClickListener()); 
      cancelButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      controlPanel.add(cancelButton);       

      mainFrame.setVisible(true);  
   }

   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) 
      {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))  
         {
            statusLabel.setText("Ok Button clicked.");
         }
         else if( command.equals( "Submit" ) )  
         {
            statusLabel.setText("Submit Button clicked."); 
         }
         else  
         {
            System.exit(0);
         }  	
      }		
   }
}
