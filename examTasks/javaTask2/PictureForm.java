import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureForm extends JFrame {

    private JPanel shapePanel;
    private JComboBox<String> shapeComboBox;
    private int squareSize;
    private JSpinner spinner1;
    private javax.swing.JPanel JPanel;
    private ShapePanel canvas;


    public PictureForm(int squareSize) {
        this.squareSize = squareSize;
        spinner1.setValue(squareSize);
        setTitle("Tetris Shape Viewer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int size = (int)spinner1.getValue();
                canvas.setSquareSize(size);

            }
        });
        shapePanel = new ShapePanel();
        add(shapePanel, BorderLayout.CENTER);

        shapeComboBox = new JComboBox<>(new String[]{"I", "J", "L", "O", "S", "T", "Z"});
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapePanel.repaint();
            }
        });
        add(shapeComboBox, BorderLayout.SOUTH);
    }

    private class ShapePanel extends JPanel {
        private int squareSize = 30;

        public void setSquareSize(int size){
            squareSize = size;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String selectedShape = (String) shapeComboBox.getSelectedItem();
            if (selectedShape != null) {
                drawShape(g, selectedShape, squareSize);
            }
        }

        private void drawShape(Graphics g, String shape, int a) {
            g.setColor(Color.BLUE);
            switch (shape) {
                case "I":
                    for (int i = 0; i < 4; i++) {
                        g.fillRect(50 + i * a, 50, a, a);
                    }
                    break;
                case "J":
                    g.fillRect(50, 50, a, a);
                    for (int i = 0; i < 3; i++) {
                        g.fillRect(50 + i * a, 50 + a, a, a);
                    }
                    break;
                case "L":
                    for (int i = 0; i < 3; i++) {
                        g.fillRect(50 + i * a, 50, a, a);
                    }
                    g.fillRect(50, 50 + a, a, a);
                    break;
                case "O":
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            g.fillRect(50 + i * a, 50 + j * a, a, a);
                        }
                    }
                    break;
                case "S":
                    for (int i = 0; i < 2; i++) {
                        g.fillRect(50 + i * a, 50 + a, a, a);
                    }
                    for (int i = 1; i < 3; i++) {
                        g.fillRect(50 + i * a, 50, a, a);
                    }
                    break;
                case "T":
                    for (int i = 0; i < 3; i++) {
                        g.fillRect(50 + i * a, 50, a, a);
                    }
                    g.fillRect(50 + a, 50 + a, a, a);
                    break;
                case "Z":
                    for (int i = 0; i < 2; i++) {
                        g.fillRect(50 + i * a, 50, a, a);
                    }
                    for (int i = 1; i < 3; i++) {
                        g.fillRect(50 + i * a, 50 + a, a, a);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PictureForm(30).setVisible(true);
            }
        });
    }
}
