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

/**
 * @author      jecnua <jecnua@gmail.com>
 * @version     1.0
 * @since       2012-01-01
 */
public class FateSystemUtilities {
    
    public static int trowDices(int skillPower){
        //int skillPower = 0;
        int minDiceValue = -1;
        int maxDiceValue = +1;
        /*
        if (args.length != 0){
            skillPower = Integer.parseInt(args[0]);
        }
        */
        int diceTrowsResults = 0;
        for (int count = 0; count < 4; count++){
            diceTrowsResults += minDiceValue + (int)(Math.random() * ((maxDiceValue - minDiceValue) + 1));
        }

        int results = skillPower + diceTrowsResults;
        //System.out.println(diceTrowsResults);
        return results;
    }
    
}
