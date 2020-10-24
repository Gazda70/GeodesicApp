
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


import com.jsevy.jdxf.BSpline;
import com.jsevy.jdxf.DXFDocument;
import com.jsevy.jdxf.DXFGraphics;
import com.jsevy.jdxf.RealPoint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JPanel;






public class DXFTestPanel extends JPanel
{

    private static final long serialVersionUID = 1L;

    // what to display and generate in the PDF file - just use button ID
    //private int displayContent = R.id.testGraphicsButton;
    private String displayContent = "graphics";

    //private float displayScale = 1.0f;

    private int xCen = 0;
    private int yCen = 0;
    private int height;
    private int width;

    private String fontFilePath = "";



    public void setDisplayContent(String content)
    {
        this.displayContent = content;
        repaint();
    }


    public void setFontFilePath(String fontFilePath)
    {
        this.fontFilePath = fontFilePath;
        repaint();
    }



    public DXFTestPanel()
    {
        xCen = 0;
        yCen = 2000;
        height = 4000;
        width = 2000;

        setPreferredSize(new Dimension(width, height));
    }



    public void paint(Graphics g)
    {
        g.clearRect(0, 0, width, height);
        g.translate(xCen, yCen);
        drawDesign((Graphics2D)g);
    }



    public String generateDXF()
    {
        DXFDocument dxfDocument = new DXFDocument("Example DXF output from Java DXFGraphics");

        // set units to mm
        dxfDocument.setUnits(4);

        // set precision digits to 8
        dxfDocument.setPrecisionDigits(8);

        // set to generate only elliptical arcs, not circles and circular arcs
        //dxfDocument.generateCircularArcs(false);

        // set to generate zero-length lines; default is to generate DXF point when a zero-length line is drawn
        //dxfDocument.generatePoints(false);

        // get the DXFGraphics object to draw into
        DXFGraphics dxfGraphics = dxfDocument.getGraphics();

        // supply this as a Graphics subclass object to our main Draw methos
        drawDesign(dxfGraphics);

        // get the DXF output (just text)
        String stringOutput = dxfDocument.toDXFString();
        System.out.println(stringOutput);

        return stringOutput;
    }



    /**
     * Used to draw both on the screen and to the PDF document, to check if the PDF image matches the
     * one on the screen
     * @param graphics  Either a "normal" canvas for screen rendering or one associated with a PDF Page
     */
    private void drawDesign(Graphics2D graphics)
    {


        // fill the page with a pale yellow
        //graphics.setColor(new Color(255, 245, 240));
        //graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        if (displayContent.equals("graphics"))
        {
            testGraphics(graphics);
        }

        if (displayContent.equals("text"))
        {
            testText(graphics);
        }

        if (displayContent.equals("fonts"))
        {
            testFonts(graphics);
        }

        if (displayContent.equals("transformations_graphics"))
        {
            testTransformationsGraphics(graphics);
        }

        if (displayContent.equals("transformations_text"))
        {
            testTransformationsText(graphics);
        }

        if (displayContent.equals("graphics2D"))
        {
            testGraphics2D(graphics);
        }

        if (displayContent.equals("hatch"))
        {
            testHatch(graphics);
        }


    }




    private void testText(Graphics graphics)
    {
        // do some stuff
        FontMetrics fm;
        int ascent, descent, width, baseX, baseY;
        String text;

        // use the FontMetrics to draw a box around the text. Unfortunately, since the DXF fonts will in general be different
        // from the corresponding Java fonts, the boxes will be the wrong size in the DXF display.
        graphics.setFont(new Font(Font.SERIF, Font.PLAIN, 24));
        graphics.setColor(Color.RED);

        baseX = 150;
        baseY = 250;
        text = "Some 24-point serif red text at position " + baseX + ", " + baseY + " with some accented characters: áéíóúüèìç";
        graphics.drawLine(0, 0, baseX, baseY);
        graphics.drawString(text, baseX, baseY);
        fm = graphics.getFontMetrics();
        ascent = fm.getAscent();
        descent = fm.getDescent();
        width = fm.stringWidth(text);
        graphics.drawRect(baseX, baseY - ascent, width, ascent + descent);

        graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 48));
        graphics.setColor(Color.GREEN);

        baseX = 180;
        baseY = 350;
        text = "Some 48-point sans-serif green text at position " + baseX + ", " + baseY;
        graphics.drawLine(0, 0, baseX, baseY);
        graphics.drawString(text, baseX, baseY);
        fm = graphics.getFontMetrics();
        ascent = fm.getAscent();
        descent = fm.getDescent();
        width = fm.stringWidth(text);
        graphics.drawRect(baseX, baseY - ascent, width, ascent + descent);

        graphics.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 38));
        graphics.setColor(Color.BLUE);

        baseX = 480;
        baseY = 400;
        text = "Some 38-point monospace blue text at position " + baseX + ", " + baseY;
        graphics.drawLine(0, 0, baseX, baseY);
        graphics.drawString(text, baseX, baseY);
        fm = graphics.getFontMetrics();
        ascent = fm.getAscent();
        descent = fm.getDescent();
        width = fm.stringWidth(text);
        graphics.drawRect(baseX, baseY - ascent, width, ascent + descent);


        // try drawing characters at indicated positions
        /*
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
        float[] pos = { 400, 500, 440, 510, 480, 525, 520, 545, 560, 570, 600, 600, 640, 635, 680, 675, 720, 720, 760, 770, 800, 825};
        String text = "drawPosText";
        graphics.drawPosText(text, pos);
        */

        // draw characters along path
        /*
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
        Path path = new Path();
        path.addArc(new RectF(100, 1000, 700, 1400), 180, -180);
        graphics.drawArc(new RectF(100, 1000, 700, 1400), 180, -180, false);
        path.arcTo(new RectF(700, 1000, 1400, 1400), 180, 180);
        graphics.drawArc(new RectF(700, 1000, 1400, 1400), 180, 180, false);
        path.arcTo(new RectF(1400, 1100, 1600, 1300), 180, -180);
        graphics.drawArc(new RectF(1400, 1100, 1600, 1300), 180, -180, false);
        text = "Example of bold serif drawTextOnPath with offset and composite path";
        graphics.drawTextOnPath(text, path, 100, 40);
        */

    }



    private void testFonts(Graphics graphics)
    {
        int baseX, baseY;

        // load the Font from a path previously specified through a Dialog
        File fontFile = new File(fontFilePath);

        try
        {
            Font newFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphicsEnvironment.registerFont(newFont);

            // Draw some strings inside bounding boxes. Since we're loading the same TrueType font into both Java and the CAD
            // program, one would expect the strings to fit inside the boxes the same in both cases; but alas, it's just
            // an approximate fit, especially regarding string width. Not sure why this should be, but it is...
            graphics.setFont(newFont.deriveFont(24.0f));
            graphics.setColor(Color.RED);
            baseX = 150;
            baseY = 250;
            drawFontStringInBox(graphics, baseX, baseY);


            // try different sizes
            graphics.setFont(newFont.deriveFont(48.0f));
            graphics.setColor(Color.GREEN);
            baseX = 180;
            baseY = 350;
            drawFontStringInBox(graphics, baseX, baseY);


            graphics.setFont(newFont.deriveFont(38.0f));
            graphics.setColor(Color.BLUE);
            baseX = 480;
            baseY = 400;
            drawFontStringInBox(graphics, baseX, baseY);

        }
        catch (Exception e)
        {
            System.out.println("Problem loading font: " + e.toString());
        }

    }


    private void drawFontStringInBox(Graphics graphics, int baseX, int baseY)
    {
        FontMetrics fm = graphics.getFontMetrics();
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int capHeight = (int)Math.ceil(graphics.getFont().createGlyphVector(((Graphics2D) graphics).getFontRenderContext(),"H").getVisualBounds().getHeight());
        Font font = graphics.getFont();

        String text = "Some " + font.getSize() + "-point text in font " + font.getFamily() + " at position " + baseX + ", " + baseY + ".";
        int width = fm.stringWidth(text);

        graphics.drawLine(0, 0, baseX, baseY);
        graphics.drawString(text, baseX, baseY);
        graphics.drawRect(baseX, baseY - capHeight, width, capHeight);

        //System.out.println("Height, ascent, descent, leading: " + height + ", " + ascent + ", " + descent + ", " + leading);
    }




    private void arctestGraphics(Graphics2D graphics)
    {
        // do some stuff

        // draw some stuff in default black and stroke width
        //graphics.setColor(Color.BLACK);
        //graphics.setStroke(new BasicStroke(5));

        int radius = 20;
        int center;

        graphics.drawLine(0, 0, 600, 600);
        graphics.drawOval(715, 715, 170, 170);
        graphics.drawOval(790, 790, 20, 20);
        radius = 50;
        center = 600;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, 45);
        radius = 100;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, 90);
        radius = 150;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, -135);

    }


    private void testGraphics(Graphics2D graphics)
    {
        // do some stuff

        // draw some stuff in default black and stroke width
        //graphics.setColor(Color.BLACK);
        //graphics.setStroke(new BasicStroke(5));

        // generate a DXFPoint by using a zero-length line - works in both standard Java Graphics and DXF Graphics
        graphics.drawLine(400, 600, 400, 600);

        // generate a DXFPoint by using a zero-radius circle - works in both standard Java Graphics and DXF Graphics
        graphics.drawOval(400, 650, 0, 0);

        // generate a DXFPoint using the DXFGraphics extension method drawPoint(); not present in standard Java Graphics,
        // so works only for our DXFGraphics instance
        if (graphics instanceof DXFGraphics)
            ((DXFGraphics)graphics).drawPoint(400, 700);

        int radius = 20;
        int center;

        graphics.drawLine(0, 0, 800, 800);
        graphics.drawOval(715, 715, 170, 170);
        graphics.drawOval(790, 790, 20, 20);
        radius = 50;
        center = 800;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, 45);
        radius = 100;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, 90);
        radius = 150;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 0, -135);


        graphics.setColor(Color.RED);
        radius = 50;
        center = 400;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 90, 45);
        radius = 100;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 90, 90);
        radius = 150;
        graphics.drawArc(center-radius, center-radius, 2*radius, 2*radius, 90, -135);

        // fill a rectangle
        graphics.setColor(Color.RED);
        graphics.setStroke(new BasicStroke(3));
        graphics.drawLine(0, 0, 1000, 500);
        graphics.drawRect(1000, 500, 150, 150);

        // draw a rounded rectangle
        graphics.drawLine(0, 0, 20, 200);
        graphics.drawRoundRect(20, 200, 130, 100, 20, 10);
        graphics.drawRoundRect(30, 210, 110, 80, 30, 30);

        // draw some ovals
        graphics.setColor(Color.MAGENTA);
        graphics.setStroke(new BasicStroke(3));
        graphics.drawLine(0, 0, 300, 1000);
        graphics.drawOval(200, 800, 200, 400);
        graphics.drawRect(200, 800, 200, 400);

        // draw oval arc
        graphics.setStroke(new BasicStroke(1));
        graphics.drawLine(0, 0, 300, 2000);
        //graphics.drawOval(new RectF(100, 1900, 500, 2100));
        graphics.drawArc(100, 1900, 400, 200, 60, 150);
        graphics.drawRect(100, 1900, 400, 200);

        // now draw a spline; static BSpline method handles both regular and DXF graphics.- since no native
        // splines in standard graphics. spline is drawn as a set of connected line segments, with the tolerance
        // parameter indicating that maximum length of any line segment to control smoothness of the representation
        {
            int degree = 3;
            double[] controlPoints = {500, 1600, 500, 1300, 700, 1800, 800, 1200, 1000, 2000, 500, 1200};
            int[] multiplicities = {3, 1, 1, 2, 1, 3};

            BSpline.drawSpline(graphics, degree, controlPoints, multiplicities, true, 1);
        }

        // draw a series of splines using the same control points but with different degrees
        {

            double[] controlPoints = {1000, 1600, 1000, 1300, 1200, 1800, 1300, 1200, 1500, 2000, 1000, 1200, 1400, 1200};
            int[] multiplicities = {1, 1, 1, 1, 1, 1, 1};

            for (int degree = 2; degree < 6; degree++)
            {
                BSpline.drawSpline(graphics, degree, controlPoints, multiplicities, true, 1);
            }
        }

    }



    private void testHatch(Graphics2D graphics)
    {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(250, 100, 100, 100);

        // get fancy - even apply a transformation
        // save current transform to restore it
        AffineTransform initialTransform = graphics.getTransform();

        graphics.rotate(-15 *(Math.PI/180)); // counterclockwise...
        graphics.shear(0.1f, 0.2f);

        graphics.fillRect(100, 100, 100, 50);

        graphics.setColor(Color.CYAN);
        graphics.fillOval(250, 100, 100, 50);

        graphics.setColor(Color.RED);
        int[] xPoints = {200, 300, 250};
        int[] yPoints = {200, 250, 300};
        graphics.fillPolygon(xPoints , yPoints , xPoints.length);


        graphics.setColor(Color.GREEN);
        graphics.fillRoundRect(100, 400, 100, 150, 40, 60);

        graphics.setColor(Color.BLUE);
        graphics.fillArc(50, 600, 200, 100, 120, 120);
        graphics.setColor(Color.RED);
        graphics.drawArc(50, 600, 200, 100, 120, 120);
        graphics.setColor(Color.GREEN);
        graphics.fillArc(100, 600, 200, 200, 30, 60);
        graphics.setColor(Color.CYAN);
        graphics.fillArc(300, 600, 400, 200, 30, -60);
        graphics.setColor(Color.YELLOW);
        graphics.fillArc(100, 700, 300, 300, 0, 270);

        // now create a Path for use with the general draw(Shape) method;
        // add winding specification so hole won't be filled
        graphics.setColor(Color.BLACK);
        Path2D.Double path1 = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        // Draw square at 1, 1 calling closePath() to draw last segment of square
        path1.moveTo(500.0, 100.0);
        path1.lineTo(600.0, 100.0);
        path1.lineTo(600.0, 200.0);
        path1.lineTo(500.0, 200.0);
        path1.closePath();

        // Add another square in center of larger square
        path1.append(new Rectangle.Double(525, 125, 50, 50), false);

        graphics.fill(path1);

        // now do the same, but with circles
        graphics.setColor(Color.RED);
        Path2D.Double path2 = new Path2D.Double(Path2D.WIND_EVEN_ODD);

        // outer circle
        path2.append(new Ellipse2D.Double(500, 400, 100, 150), false);

        // Add another circle in center of larger circle
        path2.append(new Ellipse2D.Double(525, 425, 50, 100), false);

        graphics.fill(path2);

        //restore the original transform
        graphics.setTransform(initialTransform);

        // fill an ellipse via the path iterator; see that outline is true circle
        Ellipse2D.Double pathEllipse = new Ellipse2D.Double(500, 500, 200, 200);
        Path2D.Double path = new Path2D.Double();
        path.append(pathEllipse.getPathIterator(new AffineTransform()), false);
        graphics.fill(path);





    }



    private void testGraphics2D(Graphics2D graphics)
    {
        // do some stuff with Graphics2D and shapes

        // draw some stuff in default black and stroke width
        //graphics.setColor(Color.BLACK);
        //graphics.setStroke(new BasicStroke(5));


        double radius = 57.5;
        RealPoint center = new RealPoint(800.3, 627.12, 0);

        Line2D line = new Line2D.Double(0, 0, center.x, center.y);
        graphics.draw(line);

        Ellipse2D ellipse = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2*radius);
        graphics.draw(ellipse);

        ellipse = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2.1*radius);
        graphics.draw(ellipse);
        ellipse = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2.2*radius);
        graphics.draw(ellipse);
        ellipse = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2.4*radius);
        graphics.draw(ellipse);
        ellipse = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2.8*radius);
        graphics.draw(ellipse);


        graphics.setColor(Color.RED);
        radius = 50;
        center = new RealPoint(200, 400, 0);

        Arc2D arc = new Arc2D.Double(center.x-radius, center.y-radius, 2*radius, 2*radius, 0, 30, Arc2D.OPEN);
        graphics.draw(arc);
        arc = new Arc2D.Double(center.x-radius, center.y-radius, 2*radius, 2.1*radius, 0, 40, Arc2D.OPEN);
        graphics.draw(arc);
        arc = new Arc2D.Double(center.x-radius, center.y-radius, 2*radius, 2.2*radius, 0, 50, Arc2D.OPEN);
        graphics.draw(arc);
        arc = new Arc2D.Double(center.x-radius, center.y-radius, 2*radius, 2.4*radius, 0, 60, Arc2D.OPEN);
        graphics.draw(arc);
        arc = new Arc2D.Double(center.x-radius, center.y-radius, 2*radius, 2.8*radius, 0, 70, Arc2D.OPEN);
        graphics.draw(arc);


        graphics.setColor(Color.BLUE);
        Rectangle2D rect = new Rectangle2D.Double(45.5, 87.99, 110, 210);
        graphics.draw(rect);
        rect = new Rectangle2D.Double(1.1*45.5, 87.99, 110, 210);
        graphics.draw(rect);
        rect = new Rectangle2D.Double(1.2*45.5, 87.99, 110, 210);
        graphics.draw(rect);
        rect = new Rectangle2D.Double(1.4*45.5, 87.99, 110, 210);
        graphics.draw(rect);
        rect = new Rectangle2D.Double(1.6*45.5, 87.99, 110, 210);
        graphics.draw(rect);

        graphics.setColor(Color.GREEN);
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(211.3, 400, 110, 210, 10, 20);
        graphics.draw(roundRect);
        roundRect = new RoundRectangle2D.Double(211.3, 400, 110, 210, 20, 30);
        graphics.draw(roundRect);
        roundRect = new RoundRectangle2D.Double(211.3, 400, 110, 210, 30, 40);
        graphics.draw(roundRect);
        roundRect = new RoundRectangle2D.Double(211.3, 400, 110, 210, 40, 60);
        graphics.draw(roundRect);
        roundRect = new RoundRectangle2D.Double(211.3, 400, 110, 210, 60, 80);
        graphics.draw(roundRect);


        graphics.setColor(Color.CYAN);
        float[] cp3 = {500, 1600, 500, 1300, 700, 1800, 800, 1200};
        CubicCurve2D cubicSpline = new CubicCurve2D.Float(cp3[0], cp3[1], cp3[2], cp3[3], cp3[4], cp3[5], cp3[6], cp3[7]);
        graphics.draw(cubicSpline);

        graphics.setColor(Color.MAGENTA);
        double[] cp2 = {500, 1600, 600, 1400, 800, 1200};
        QuadCurve2D quadraticSpline = new QuadCurve2D.Double(cp2[0], cp2[1], cp2[2], cp2[3], cp2[4], cp2[5]);
        graphics.draw(quadraticSpline);


        // now create a Path for use with the general draw(Shape) method
        graphics.setColor(Color.BLACK);
        Path2D.Double path1 = new Path2D.Double();
        // Draw square at 1, 1 calling closePath() to draw last segment of square
        path1.moveTo(500.0, 100.0);
        path1.lineTo(600.0, 100.0);
        path1.lineTo(600.0, 200.0);
        path1.lineTo(500.0, 200.0);
        path1.closePath();

        // Add another square in center of larger square
        path1.append(new Rectangle.Double(525, 125, 50, 50), false);

        graphics.draw(path1);


        // do an ellipse via the path iterator
        Ellipse2D.Double pathEllipse = new Ellipse2D.Double(500, 500, 200, 200);
        Path2D.Double path = new Path2D.Double();
        path.append(pathEllipse.getPathIterator(new AffineTransform()), false);
        graphics.draw(path);

        /*
        // now draw a spline; static BSpline method handles both regular and DXF graphics.- since no native
        // splines in standard graphics. spline is drawn as a set of connected line segments, with the tolerance
        // parameter indicating that maximum length of any line segment to control smoothness of the representation
        {
            int degree = 3;
            double[] controlPoints = {500, 1600, 500, 1300, 700, 1800, 800, 1200, 1000, 2000, 500, 1200};
            int[] multiplicities = {1, 1, 1, 1, 1, 1};
            double[] knots = {0, 0, 0, 0, 1, 2, 3, 4, 5, 5, 5, 5};

            BSplineNonuniform.drawSpline(graphics, degree, controlPoints, multiplicities, knots, true, 1);
        }
        */


    }



    private void testTransformationsGraphics(Graphics2D graphics)
    {
        // do some stuff
        graphics.setColor(Color.BLUE);
        graphics.setStroke(new BasicStroke(1));

        // save current transform to restore it
        AffineTransform initialTransform = graphics.getTransform();


        // Rotation: draw a series of rotated elliptical arcs
        graphics.setColor(Color.GREEN);

        for (int i = 0; i < 40; i += 5)
        {
            graphics.rotate(-5); // counterclockwise...
            graphics.drawLine(0, 0, 250, 1550);
            //graphics.drawOval(new RectF(100, 1500, 400, 1600));
            graphics.drawArc(100, 1500, 300, 100, 60, 150);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);

        // Skew: draw a series of increasingly skewed circular arcs and rectangles
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < 8; i++)
        {
            graphics.drawLine(0, 0, 200, 200);
            //graphics.drawOval(new RectF(100, 1500, 400, 1600));
            graphics.drawArc(100, 100, 200, 200, 45, 135);
            graphics.shear(0.2f, 0.0f);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);


        graphics.setColor(Color.CYAN);
        for (int i = 0; i < 8; i++)
        {
            graphics.drawLine(0, 0, 100, 100);
            graphics.drawRect(100, 100, 200, 200);
            graphics.shear(0.1f, 0.2f);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);

        graphics.setColor(Color.RED);
        // Scaling: do series of scaled circular arcs
        for (int i = 0; i < 8; i++)
        {
            graphics.drawLine(0, 0, 500, 200);
            //graphics.drawCircle(500, 200, 50);
            graphics.drawArc(450, 150, 100, 100, -45, 135);

            graphics.drawLine(0, 0, 200, 500);
            //graphics.drawCircle(500, 200, 50);
            graphics.drawArc(150, 450, 100, 100, 80, -60);
            graphics.scale(1.1f, -1.2f);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);

        // Translation: do series of translated circular arcs
        graphics.setColor(Color.MAGENTA);
        for (int i = 0; i < 8; i++)
        {
            graphics.drawLine(0, 0, 700, -350);
            //graphics.drawCircle(500, 200, 50);
            graphics.drawArc(600, -450, 200, 200, -135, 315);
            graphics.translate(200, 100);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);

        // combine skew and rotate and translate
        graphics.setColor(Color.BLACK);
        graphics.translate(100, 300);
        graphics.rotate(-40); // counterclockwise...
        graphics.shear(-0.4f, -0.3f);
        graphics.drawLine(0, 0, 80, 950);
        graphics.drawRect(80, 880, 620, 140);
        graphics.drawArc(80, 880, 620, 140, -45, 270);

        // now create a Path for use with the general draw(Shape) method
        graphics.setColor(Color.BLACK);
        Path2D.Double path1 = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        // Draw square at 1, 1 calling closePath() to draw last segment of square
        path1.moveTo(200.0, 100.0);
        path1.lineTo(300.0, 100.0);
        path1.lineTo(300.0, 200.0);
        path1.lineTo(200.0, 200.0);
        path1.closePath();

        // Add another square in center of larger square
        path1.append(new Rectangle.Double(225, 125, 50, 50), false);

        graphics.setColor(Color.BLUE);
        graphics.fill(path1);

        graphics.setColor(Color.BLACK);
        graphics.draw(path1);

        //restore the original transform
        graphics.setTransform(initialTransform);

    }



    private void testTransformationsText(Graphics2D graphics)
    {
        // draw a rotated rectangle and some text
        graphics.setStroke(new BasicStroke(3));
        graphics.setColor(Color.GREEN);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));


        // save current transform to restore it
        AffineTransform initialTransform = graphics.getTransform();

        for (int i = 0; i < 40; i += 5)
        {
            graphics.rotate(-5); // counterclockwise...
            graphics.drawLine(0, 0, 250, 1550);
            //graphics.drawOval(new RectF(100, 1500, 400, 1600));
            graphics.drawArc(100, 1500, 300, 100, 60, 150);
        }

        //restore the original transform
        graphics.setTransform(initialTransform);

        graphics.setColor(Color.BLUE);
        // graphics.scale(2, 2);
        graphics.shear(0.3f, 0);
        graphics.drawLine(0, 0, 75, 380);
        graphics.drawRect(75, 380, 700, 520);
        graphics.drawString("Some 40-point blue text skewed at position 80, 450", 80, 450);

        // graphics.setMatrix(origMatrix);
        graphics.shear(-0.3f, 0);

        graphics.setColor(Color.BLUE);
        graphics.shear(0, 0.8f);
        graphics.drawLine(0, 0, 80, 950);
        graphics.drawRect(80, 880, 700, 1020);
        graphics.drawString("Some 40-point blue text skewed at position 80, 950", 80, 950);

        graphics.shear(0, -0.8f);

        // both skew and rotate and translate
        graphics.setColor(Color.RED);
        graphics.translate(100, 300);
        graphics.rotate(-40); // counterclockwise...
        graphics.shear(-0.4f, -0.3f);
        graphics.drawLine(0, 0, 80, 950);
        graphics.drawRect(80, 880, 700, 1020);
        graphics.drawString("Some 40-point red text translated (100,300), rotated -40, and skewed, at position 80, 950", 80, 950);

    }



    /**
     * Helper class for some of the grid-related tests
     *
     * @author jsevy
     *
     */
    public class Vector3D
    {
        float x;
        float y;
        float z;



        public Vector3D(float x, float y, float z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }



        public Vector3D()
        {
            this.x = 0;
            this.y = 0;
            this.z = 0;
        }



        public float dotProduct(Vector3D other)
        {
            return this.x * other.x + this.y * other.y + this.z * other.z;
        }



        public float magnitude()
        {
            return (float) Math.sqrt(this.dotProduct(this));
        }



        public Vector3D scalarProduct(float scale)
        {
            Vector3D result = new Vector3D();

            result.x = this.x * scale;
            result.y = this.y * scale;
            result.z = this.z * scale;

            return result;
        }



        public Vector3D crossProduct(Vector3D other)
        {
            Vector3D result = new Vector3D();

            result.x = this.y * other.z - other.y * this.z;
            result.y = this.x * other.z - other.x * this.z;
            result.z = this.x * other.y - other.x * this.y;

            return result;
        }



        public Vector3D sum(Vector3D other)
        {
            Vector3D result = new Vector3D();

            result.x = this.x + other.x;
            result.y = this.y + other.y;
            result.z = this.z + other.z;

            return result;
        }
    }
}
