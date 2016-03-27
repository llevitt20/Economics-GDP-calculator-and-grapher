package stuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BoxLayout;

//import com.sun.org.apache.xalan.internal.utils.Objects;

public class GDP
{

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel GDPInputPanel;
   private Panel templatePanel;
   private static TextField cInput, iInput, gInput, xInput, mInput;
   private Label cLabel, iLabel, gLabel, xLabel, mLabel;
   private static double c, i, g, x, m, gdp;

   public GDP()
   {
      prepareGUI();
   }

   public static void main(String[] args)
   {
      GDP awtEcon = new GDP();
      awtEcon.showButtons();
   }

   private void prepareGUI()
   {
      mainFrame = new Frame("Economics");
      mainFrame.setSize(560, 200);
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
      statusLabel.setAlignment(Label.LEFT);
      statusLabel.setSize(325,150);
  //    statusLabel.setFont
      statusLabel.setText("GDP (In billions of USD):                     ");

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      GDPInputPanel = new Panel();
      GDPInputPanel.setLayout(new FlowLayout());

      templatePanel = new Panel();
      templatePanel.setLayout(new BoxLayout(templatePanel, BoxLayout.Y_AXIS)); //Make this a better verticle layout

      mainFrame.add(templatePanel);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(GDPInputPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);

      cLabel = new Label("C:", Label.LEFT);
      iLabel = new Label("I:", Label.LEFT);
      gLabel = new Label("G:", Label.LEFT);
      xLabel = new Label("X:", Label.LEFT);
      mLabel = new Label("M:", Label.LEFT);


      cInput = new TextField("", 5);
      iInput = new TextField("", 5);
      gInput = new TextField("", 5);
      xInput = new TextField("", 5);
      mInput = new TextField("", 5);

      GDPInputPanel.add(cLabel);
      GDPInputPanel.add(cInput);
      GDPInputPanel.add(iLabel);
      GDPInputPanel.add(iInput);
      GDPInputPanel.add(gLabel);
      GDPInputPanel.add(gInput);
      GDPInputPanel.add(xLabel);
      GDPInputPanel.add(xInput);
      GDPInputPanel.add(mLabel);
      GDPInputPanel.add(mInput);


   }

   private void showButtons()
   {
      headerLabel.setText("Calculate your GDP: C+I+G+(X-M)");

      Button okButton = new Button("Calculate!");
      Button clearButton = new Button("Clear");
      Button cancelButton = new Button("Exit");

      okButton.setActionCommand("Calculate");
      clearButton.setActionCommand("Clear");
      cancelButton.setActionCommand("Exit");

      okButton.addActionListener(new ButtonClickListener());
      clearButton.addActionListener(new ButtonClickListener());
      cancelButton.addActionListener(new ButtonClickListener());

      controlPanel.add(okButton);
      controlPanel.add(clearButton);
      controlPanel.add(cancelButton);

      Button canadaButton = new Button("Canada");
      Button usaButton = new Button("USA");
      Button mexicoButton = new Button("Mexico");

      canadaButton.setActionCommand("showCanada");
      usaButton.setActionCommand("showUSA");
      mexicoButton.setActionCommand("showMexico");

      canadaButton.addActionListener(new ButtonClickListener());
      usaButton.addActionListener(new ButtonClickListener());
      mexicoButton.addActionListener(new ButtonClickListener());

      templatePanel.add(canadaButton);
      templatePanel.add(usaButton);
      templatePanel.add(mexicoButton);

      mainFrame.setVisible(true);
   }

   private class ButtonClickListener implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   String command = e.getActionCommand();
		   if( command.equals("Calculate"))
       {
          	   //add up GDP stuff and show it
  			   if(!Objects.equals(cInput.getText(),""))
  			   {
  				   c = Double.parseDouble(cInput.getText());
  			   }
  			   if(!Objects.equals(iInput.getText(),""))
  			   {
  				   i = Double.parseDouble(iInput.getText());
  			   }
  			   if(!Objects.equals(gInput.getText(),""))
  			   {
  				   g = Double.parseDouble(gInput.getText());
  			   }
  			   if(!Objects.equals(xInput.getText(),""))
  			   {
  				   x = Double.parseDouble(xInput.getText());
  			   }
  			   if(!Objects.equals(mInput.getText(),""))
  			   {
  				   m = Double.parseDouble(mInput.getText());
  			   }
  			   gdp = c + i + g + x - m;
  			   System.out.println(gdp);
  			   statusLabel.setText("GDP (in billions of USD): " + gdp);
  			   //statusLabel.setText("GDP: 3");
         }
         else if( command.equals("Clear"))
         {
      	   statusLabel.setText("GDP (In billions of USD):                     ");
         }
         else if( command.equals("Exit"))
         {
             System.exit(0);
         }
         else if( command.equals("showCanada"))
         {
        	 statusLabel.setText("GDP (in billions of USD): 1827");
           cInput.setText("1023");
           iInput.setText("365");
           gInput.setText("457");
           xInput.setText("566");
           mInput.setText("603");
         }
         else if( command.equals("showUSA"))
         {
           //Numbers aren't real
        	 statusLabel.setText("GDP (in billions of USD): 1677");
           cInput.setText("100");
           iInput.setText("100");
           gInput.setText("100");
           xInput.setText("100");
           mInput.setText("100");
         }
         else if( command.equals("showMexico"))
         {
           //Only X and M are real
        	 statusLabel.setText("GDP (in billions of USD): 1261");
           cInput.setText("100");
           iInput.setText("100");
           gInput.setText("100");
           xInput.setText("381");
           mInput.setText("395");
         }
         else
         {
            System.out.println("Unexpected button action!");
            System.exit(0);
         }

	   }
   }
}
