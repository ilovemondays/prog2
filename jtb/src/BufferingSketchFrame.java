import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

interface Primitive {
    /**
     * Zeichnet das Objekt und verändert dabei ggf. die aktuelle Zeichenposition
     * @param g hierhin wird gezeichnet
     * @param position In/Out-Parameter
     */
    void zeichne(Graphics g, Point position);
}

class Linie implements Primitive {
    private int dx, dy;
    
    public Linie(int dx, int dy) {
        this.dx= dx;
        this.dy= dy;
    }
    @Override public void zeichne(Graphics g, Point position) {
        g.drawLine(position.x, position.y, position.x+dx, position.y+dy);
        position.x += dx; position.y += dy;
    }
}

class Zeichen implements Primitive {
    private char c;
    
    public Zeichen(char c) {
        this.c= c;
    }
    @Override public void zeichne(Graphics g, Point position) {
        g.drawString(String.valueOf(c), position.x, position.y);
    }
}

@SuppressWarnings("serial")
public class BufferingSketchFrame extends JFrame {
    private ArrayList<Primitive> primitives= new ArrayList<Primitive>();
    private MyPanel jpnl;
    private int draggedX=0, draggedY=0;
    private Point cursorPos;

    class MyPanel extends JPanel {
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Startpunkt ermitteln:
            Point position= new Point((int)jpnl.getBounds().getCenterX()+draggedX,(int)jpnl.getBounds().getCenterY()+draggedY);

            for (Primitive o : primitives) {
                o.zeichne(g, position);
            }
        }
    }
    
    public BufferingSketchFrame() {
        setTitle("Sketchpad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jpnl= new MyPanel();
        jpnl.setPreferredSize(new Dimension(400,300));
        // Normalerweise kann ein JPanel keinen Tastaturfokus erhalten.
        // Das ändern wir nun ...
        jpnl.setFocusable(true);
        
        // Listener hinzufügen
        KeyListener kl= new KeyAdapter() {
            @Override public void keyPressed(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                int d= 2;
                switch (keyCode) {
                  case KeyEvent.VK_LEFT: step(-d,0); break;    
                  case KeyEvent.VK_RIGHT: step(d,0); break;    
                  case KeyEvent.VK_UP: step(0,-d); break;    
                  case KeyEvent.VK_DOWN: step(0,d); break;
                }
                //System.out.println(KeyEvent.getKeyText(evt.getKeyCode())); // nur so
            }
            @Override public void keyTyped(KeyEvent evt) {
                print(evt.getKeyChar());
            }    
        };
        jpnl.addKeyListener(kl);

        jpnl.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int dX = (int) ( e.getX() - cursorPos.getX() );
                int dY = (int) ( e.getY() - cursorPos.getY() );

                draggedX += dX;
                draggedY += dY;

                cursorPos = e.getPoint();

                jpnl.repaint();

            }
        });
        jpnl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                getContentPane().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                cursorPos = mouseEvent.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        getContentPane().add(jpnl, BorderLayout.CENTER);
        pack();
    }
    private void step(int dx, int dy) {
        primitives.add(new Linie(dx, dy));
        jpnl.repaint();

    }
    private void print(char c) {
        primitives.add(new Zeichen(c));
        jpnl.repaint();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                BufferingSketchFrame f = new BufferingSketchFrame();
                f.setVisible(true);
            }
        });
    }
}
