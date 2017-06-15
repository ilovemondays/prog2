package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by jannis on 13.06.17.
 */
public class ComponentDemo extends JFrame {

    /**
     * Sub-Panel für den Namen
     */
    private JPanel jpnlName;

    /**
     * Sub-Panel für weitere Angaben
     */
    private JPanel jpnlWeitere;

    /**
     * Sub-Panel für die Auswahl einer Foto-Datei
     */
    private JPanel jpnlFoto;

    /**
     * Sub-Panel für die Visitenkarte
     */
    private JPanel jpnlVisit;

    /**
     * Eingabe des Nachnamens
     */
    private JTextField jtfName;

    /**
     * Eingabe des Rufnamens
     */
    private JTextField jtfRufname;

    /**
     * Eingabe der weiteren Vornamen
     */
    private JTextField jtfVornamen;



    public ComponentDemo() {
        super("ComponentDemo");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buildPanels();
        buildNameGui();

        pack();

    }

    private void buildPanels() {

        jpnlName= new JPanel();
        jpnlName.setLayout(new GridBagLayout());
        jpnlName.setBorder(BorderFactory.createTitledBorder("Name"));
        jpnlWeitere= new JPanel();
        jpnlWeitere.setLayout(new GridBagLayout());
        jpnlWeitere.setBorder(BorderFactory.createTitledBorder("Weitere Angaben"));

        jpnlFoto= new JPanel();
        jpnlFoto.setLayout(new BorderLayout());
        jpnlFoto.setBorder(BorderFactory.createTitledBorder("Foto"));

        jpnlVisit= new JPanel();
        jpnlVisit.setLayout(new BorderLayout());
        jpnlVisit.setBorder(BorderFactory.createTitledBorder("Visitenkarte"));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpnlName);
        getContentPane().add(jpnlWeitere);
        getContentPane().add(jpnlFoto);
        getContentPane().add(jpnlVisit);

    }

    /**
     * Baut Eingabefelder für Name, Rufname und weitere Vornamen mitsamt
     * der benötigten Eventhandler.
     */
    private void buildNameGui() {
        Insets nullInsets= new Insets(0,0,0,0); // keine Abstände
        Insets lblInsets= new Insets(2,5,2,2); // Label-Abstände

        jtfName= new JTextField(10);
        jtfRufname= new JTextField(10);
        jtfVornamen= new JTextField(20);
        // x y w h wx wy
        addComponent(0, 0, 1, 1, 0.0, 0.0, jpnlName, new JLabel("Name:"), lblInsets);
        addComponent(1, 0, 1, 1, 1.0, 0.0, jpnlName, jtfName, nullInsets);
        addComponent(2, 0, 1, 1, 0.0, 0.0, jpnlName, new JLabel("Rufname:"), lblInsets);
        addComponent(3, 0, 1, 1, 1.0, 0.0, jpnlName, jtfRufname, nullInsets);
        addComponent(0, 1, 1, 1, 0.0, 0.0, jpnlName, new JLabel("Vornamen:"), lblInsets);
        addComponent(1, 1, 3, 1, 1.0, 0.0, jpnlName, jtfVornamen, nullInsets);

        jtfRufname.setFont(jtfRufname.getFont().deriveFont(Font.BOLD));

        DocumentListener docListener= new DocumentListener() {
            @Override public void changedUpdate(DocumentEvent arg0) {
            }
            @Override public void insertUpdate(DocumentEvent arg0) {
                visitenkarteBauen();
            }
            @Override public void removeUpdate(DocumentEvent arg0) {
                visitenkarteBauen();
            }
        };

        jtfRufname.getDocument().addDocumentListener(docListener);
        jtfVornamen.getDocument().addDocumentListener(docListener);
        jtfName.getDocument().addDocumentListener(docListener);

    }

    /**
     * Hilfsroutine beim Hinzufügen einer Komponente zu einem
     * Container im GridBagLayout.
     * Die Parameter sind Constraints beim Hinzufügen.
     * @param x x-Position
     * @param y y-Position
     * @param width Breite in Zellen
     * @param height Höhe in Zellen
     * @param weightx Gewicht
     * @param weighty Gewicht
     * @param cont Container
     * @param comp Hinzuzufügende Komponente
     * @param insets Abstände rund um die Komponente
     */
    private static void addComponent(int x, int y,
                                     int width, int height,
                                     double weightx, double weighty,
                                     Container cont, Component comp,
                                     Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x; gbc.gridy = y;
        gbc.gridwidth = width; gbc.gridheight = height;
        gbc.weightx = weightx; gbc.weighty = weighty;
        gbc.insets= insets;
        cont.add(comp, gbc);
    }

    public static void main(String[] a) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new ComponentDemo();
                f.setVisible(true);
            }
        });

    }

}
