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

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author      jecnua <jecnua@gmail.com>
 * @version     1.0
 * @since       2012-01-01
 */
public class MainWindowManager {
    
    static JLabel jlbOutput;
    
    public static void initializeMainWindow(){
        
        final JFrame myJFrame = new JFrame("FateDiceTrower");
        myJFrame.setSize(200,200);
        
        final Container cp = myJFrame.getContentPane();
        
        final JPanel panel = new JPanel();
        cp.add(panel);
        panel.setLayout(new GridLayout(4,2));
        
        jlbOutput = new JLabel("--",SwingConstants.CENTER);
        jlbOutput.setHorizontalTextPosition(JLabel.CENTER);
        jlbOutput.setBackground(Color.WHITE);
        jlbOutput.setOpaque(true);
        panel.add(jlbOutput);
        
        for (int count = 0; count < 11; count++){
            JButton button1 = new JButton(""+count);
            final int y = count;
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //myJFrame.setVisible(false);
                    int res = FateSystemUtilities.trowDices(y);
                    jlbOutput.setText(""+res);
                }
            };
            button1.addActionListener(al);
            panel.add(button1);
        }
        
        //Puts the window in the middle of the screen.
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setVisible(true);
    }
    
}
