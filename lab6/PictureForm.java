import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PictureForm {
    private JPanel panel1;
    private JSpinner radiusSpiner;
    private JSpinner sectorsSpiner;
    private CanvasPanel canvasPanel1;


    public PictureForm(){
        radiusSpiner.setValue(200);

        radiusSpiner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int radius = (int)radiusSpiner.getValue();
                canvasPanel1.setRadius(radius);
            }
        });
        sectorsSpiner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int sectors = (int)sectorsSpiner.getValue();
                canvasPanel1.setSectors(sectors);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("PictureForm");
        frame.setContentPane(new PictureForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);
    }

}
