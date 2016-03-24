//package stuff;

import java.awt.*;
import java.awt.event.*;

public class Main
{

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel GDPInputPanel;
   private TextField c, i, g, x, m;
   private Label cLabel, iLabel, gLabel, xLabel, mLabel;

   public Test()
   {
      prepareGUI();
   }

   public static void main(String[] args)
   {
      Test awtEcon = new Test();
      awtEcon.showButtons();
   }

   private void prepareGUI()
   {
      mainFrame = new Frame("Economics");
      mainFrame.setSize(550, 150);
      mainFrame.setLayout(new FlowLayout());
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
      GDPInputPanel = new Panel();
      GDPInputPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.add(GDPInputPanel);
      mainFrame.setVisible(true);

      cLabel = new Label("C:", Label.LEFT);
      iLabel = new Label("I:", Label.LEFT);
      gLabel = new Label("G:", Label.LEFT);
      xLabel = new Label("X:", Label.LEFT);
      mLabel = new Label("M:", Label.LEFT);

      c = new TextField("", 5);
      i = new TextField("", 5);
      g = new TextField("", 5);
      x = new TextField("", 5);
      m = new TextField("", 5);

      GDPInputPanel.add(cLabel);
      GDPInputPanel.add(c);
      GDPInputPanel.add(iLabel);
      GDPInputPanel.add(i);
      GDPInputPanel.add(gLabel);
      GDPInputPanel.add(g);
      GDPInputPanel.add(xLabel);
      GDPInputPanel.add(x);
      GDPInputPanel.add(mLabel);
      GDPInputPanel.add(m);

   }

   private void showButtons()
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
         if( command.equals( "Calculate" ))
         {
            //add up GDP stuff and show it
         }
         else if( command.equals( "Submit" ) )
         {
            statusLabel.setText("Submit Button clicked.");
         }
         else if( command.equals("Exit"))
         {
            System.exit(0);
         }
         else
         {
            System.out.println("Unexpected button action!");
            System.exit(0);
         }

      }
   }
}
