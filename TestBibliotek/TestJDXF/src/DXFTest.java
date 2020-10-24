/*
 * JDXF Library
 *
 *   Copyright (C) 2018, Jonathan Sevy <jsevy@cs.drexel.edu>
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 *
 */




import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.io.*;



public class DXFTest extends JFrame
        implements ActionListener
{


    private MenuBar theMenubar;
    private Menu fileMenu;
    private MenuItem quitItem, graphicsItem, textTransformationsItem, graphicsTransformationsItem, textItem, graphics2DItem, hatchItem;

    private String currentDirectory = null;

    private DXFTestPanel dxfTestPanel;
    private JTextArea messagesArea;



    // WindowCloseAdapter to catch window close-box closings
    private class WindowCloseAdapter extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }



    public DXFTest()
    {

        setUpDisplay();

        // set current directory to be wherever the jar file is located
        currentDirectory = new File(".").getAbsolutePath();
    }


    private void setUpDisplay()
    {
        this.setTitle("JDXF Test App");

        dxfTestPanel = new DXFTestPanel();
        JScrollPane scrollPane = new JScrollPane(dxfTestPanel);

        this.getRootPane().setBorder(new BevelBorder(BevelBorder.RAISED));

        theMenubar = new MenuBar();
        this.setMenuBar(theMenubar);


        fileMenu = new Menu("File");

        graphicsItem = new MenuItem("Test graphics");
        graphicsItem.setActionCommand("graphics");
        graphicsItem.addActionListener(this);
        fileMenu.add(graphicsItem);

        graphicsTransformationsItem = new MenuItem("Test graphics transformations");
        graphicsTransformationsItem.setActionCommand("transformations_graphics");
        graphicsTransformationsItem.addActionListener(this);
        fileMenu.add(graphicsTransformationsItem);

        textItem = new MenuItem("Test text");
        textItem.setActionCommand("text");
        textItem.addActionListener(this);
        fileMenu.add(textItem);

        textItem = new MenuItem("Test font loading");
        textItem.setActionCommand("fonts");
        textItem.addActionListener(this);
        fileMenu.add(textItem);

        textTransformationsItem = new MenuItem("Test text transformations");
        textTransformationsItem.setActionCommand("transformations_text");
        textTransformationsItem.addActionListener(this);
        fileMenu.add(textTransformationsItem);

        graphics2DItem = new MenuItem("Test graphics2D");
        graphics2DItem.setActionCommand("graphics2D");
        graphics2DItem.addActionListener(this);
        fileMenu.add(graphics2DItem);

        hatchItem = new MenuItem("Test hatch");
        hatchItem.setActionCommand("hatch");
        hatchItem.addActionListener(this);
        fileMenu.add(hatchItem);

        quitItem = new MenuItem("Quit");
        quitItem.setActionCommand("quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);

        theMenubar.add(fileMenu);




        // set size of scroll pane to mostly fill screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        scrollPane.setPreferredSize(new Dimension((int)(screenSize.width*(0.80)), (int)(screenSize.height*(0.80))));
        //splineCanvas.setSize(new Dimension(700,500));


        messagesArea = new JTextArea(3, 60);
        JScrollPane messagesScroll = new JScrollPane(messagesArea);



        // set params for layout manager
        GridBagLayout  theLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 0;
        c.ipady = 0;
        Insets theMargin = new Insets(2,2,2,2);
        c.insets = theMargin;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = .5;
        c.weighty = .5;


        this.getContentPane().setLayout(theLayout);

        c.gridx = 1;
        c.gridy = 1;
        theLayout.setConstraints(scrollPane, c);
        this.getContentPane().add(scrollPane);

        /*
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        theLayout.setConstraints(messagesScroll, c);
        this.getContentPane().add(messagesScroll);
        */

    }



    public void actionPerformed(ActionEvent theEvent)
    {
        String command = theEvent.getActionCommand();


        if (command.equals("quit"))
        {
            System.exit(0);
        }
        /*
        if (command.equals("graphics")
                || command.equals("text")
                || command.equals("transformations_graphics")
                || command.equals("transformations_text")
                || command.equals("graphics2D"))
        */
        else
        {
            if (command.equals("fonts"))
            {
                selectFontFile();
            }

            dxfTestPanel.setDisplayContent(command);
            String dxfString = dxfTestPanel.generateDXF();
            saveProcedure(command + ".dxf", dxfString);
        }

    }



    private void saveProcedure(String defaultFilename, String dxfString)
    {
        FileDialog f = new FileDialog(this, "Save", FileDialog.SAVE);
        f.setDirectory(currentDirectory);
        f.setName(defaultFilename);
        f.setVisible(true);

        if (f.getFile() != null)
        {
            currentDirectory = f.getDirectory();
            File designFile = new File(currentDirectory + f.getFile());
            try
            {
                FileWriter fileWriter = new FileWriter(designFile);

                fileWriter.write(dxfString);

                fileWriter.flush();
                fileWriter.close();

            }
            catch (Exception e)
            {
                System.out.println("Exception while writing out design file: " + e.toString());
            }

        }

    }


    // put up a dialog to ask for a TrueType font file
    private void selectFontFile()
    {
        FileDialog f = new FileDialog(this, "Open font file", FileDialog.LOAD);
        f.setVisible(true);

        if (f.getFile() != null)
        {
            String fontFilePath = f.getDirectory() + f.getFile();
            dxfTestPanel.setFontFilePath(fontFilePath);
        }

    }




    public static void main(String args[])
    {
        try
        {

            DXFTest theApp = new DXFTest();

            theApp.pack();

            // tweak app size to make it a little larger than necessary, to address the
            // "shrunken textfields" problem arising from the layout manager packing stuff
            // a little too tightly.
            Dimension dim = theApp.getSize();
            dim.height += 20;
            dim.width += 20;
            theApp.setSize(dim);

            theApp.setVisible(true);

        }
        catch (Exception e)
        {System.out.println("Problem starting app:" + e.toString());}
    }


}
