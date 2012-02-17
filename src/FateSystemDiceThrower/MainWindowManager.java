/*
 * Copyright (c) 2012 <jecnua - jecnua@gmail.com>
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package FateSystemDiceThrower;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author      jecnua <jecnua@gmail.com>
 * @version     1.0
 * @since       2012-01-01
 */
public class MainWindowManager {
    
    static JLabel jlbOutput;
    //static BufferedImage image1,image2,image3,image4;
    
    static JFrame aJFrame;                              //Principal JFrame
    static Container aContentPanel = null;              //contentPane object for this aJFrame
    static JPanel dicePanelGrid = new JPanel();
    
    static MainWindowManager anInstance = new MainWindowManager();
    
    public static void initializeMainWindow(){
        
        aJFrame = new JFrame("FateDiceTrower");
        aJFrame.setSize(300,400);                               //width x height
        
        aContentPanel = aJFrame.getContentPane();
        aContentPanel.setLayout(new BorderLayout());            //type of layout
        
        dicePanelGrid.setLayout(new GridLayout(1,4));           //four dice
        
        
        aContentPanel.add(dicePanelGrid,BorderLayout.NORTH);
        
        //Date c = new Date();
        /*
        Calendar c = Calendar.getInstance();
        DateFormat d = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);
        aContentPanel.add(new JPanel().add(new JLabel(""+d.format(new Date()))),BorderLayout.NORTH);
        */
        
        final JPanel panel = new JPanel();
        aContentPanel.add(panel);
        
        panel.setLayout(new GridLayout(3,3));
        
        jlbOutput = new JLabel("--",SwingConstants.CENTER);
        jlbOutput.setHorizontalTextPosition(JLabel.CENTER);
        jlbOutput.setBackground(Color.WHITE);
        jlbOutput.setOpaque(true);
        //panel.add(jlbOutput);
        aContentPanel.add(jlbOutput,BorderLayout.SOUTH);
        
        for (int count = 0; count < 9; count++){
            
            JButton aButton = new JButton(""+count);        //Skill button
            final int skillLevel = count;                   //Final copy of the skill level
            
            ActionListener anActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //myJFrame.setVisible(false);
                    int res = FateSystemUtilities.trowDices(skillLevel);    //Throw the dice
                    dicePanelGrid.removeAll();                              //Remove old image
                    int[] g = FateSystemUtilities.getResultsArr();          //Get each dice value
                    for(int f: g){
                        anInstance.foo(f);                     //Draw the dice
                    }
                    
                    jlbOutput.setText("Skill: "+skillLevel+"     Tot: "+res);
                }
            };
            aButton.addActionListener(anActionListener);
            panel.add(aButton);
        }
        
        anInstance.foo(0);
        anInstance.foo(0);
        anInstance.foo(0);
        anInstance.foo(0);
        
        //Puts the window in the middle of the screen.
        aJFrame.setLocationRelativeTo(null);
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aJFrame.setVisible(true);
        
    }
    
    public void foo(final int x){
        
        BufferedImage image = null;
        String path = "/FateSystemDiceThrower/resources/";  //TODO: Better
        
        switch(x){
            case -1: path+="minus.gif"; break;
            default: ;
            case 0: path+="nothing.gif"; break;
            case 1: path+="plus.gif"; break;
        }
        
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Logger.getLogger(MainWindowManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel picLabel = new JLabel(new ImageIcon(image));
        dicePanelGrid.add(new JPanel().add(picLabel));
    }
    
}
