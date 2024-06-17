import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisShapeViewer extends JFrame {

    private JPanel shapePanel;
    private JComboBox<String> shapeComboBox;
    private JSpinner squareSizeSpinner;

    public TetrisShapeViewer() {
        setTitle("Tetris Shape Viewer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        shapePanel = new ShapePanel();
        add(shapePanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        shapeComboBox = new JComboBox<>(new String[]{"I", "J", "L", "O", "S", "T", "Z"});
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapePanel.repaint();
            }
        });
        controlPanel.add(new JLabel("Shape:"));
        controlPanel.add(shapeComboBox);

        squareSizeSpinner = new JSpinner(new SpinnerNumberModel(30, 10, 100, 5));
        squareSizeSpinner.addChangeListener(e -> shapePanel.repaint());
        controlPanel.add(new JLabel("Square Size:"));
        controlPanel.add(squareSizeSpinner);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private class ShapePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            String selectedShape = (String) shapeComboBox.getSelectedItem();
            int squareSize = (Integer) squareSizeSpinner.getValue();
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
                    g.fillRect(50 + 2 * a, 50 + a, a, a);
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
                new TetrisShapeViewer().setVisible(true);
            }
        });
    }
}
