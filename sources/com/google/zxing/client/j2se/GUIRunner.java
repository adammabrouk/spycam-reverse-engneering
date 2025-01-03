package com.google.zxing.client.j2se;

import androidx.viewpager.widget.ViewPager;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/* loaded from: classes.dex */
public final class GUIRunner extends JFrame {
    public final JLabel imageLabel = new JLabel();
    public final JTextComponent textArea;

    public GUIRunner() {
        JTextArea jTextArea = new JTextArea();
        this.textArea = jTextArea;
        jTextArea.setEditable(false);
        this.textArea.setMaximumSize(new Dimension(ViewPager.MIN_FLING_VELOCITY, 200));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(this.imageLabel);
        jPanel.add(this.textArea);
        setTitle("ZXing");
        setSize(ViewPager.MIN_FLING_VELOCITY, ViewPager.MIN_FLING_VELOCITY);
        setDefaultCloseOperation(3);
        setContentPane(jPanel);
        setLocationRelativeTo(null);
    }

    private void chooseImage() throws MalformedURLException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(this);
        Path path = jFileChooser.getSelectedFile().toPath();
        ImageIcon imageIcon = new ImageIcon(path.toUri().toURL());
        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight() + 100);
        this.imageLabel.setIcon(imageIcon);
        this.textArea.setText(getDecodeText(path));
    }

    public static String getDecodeText(Path path) {
        try {
            try {
                return String.valueOf(new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageReader.readImage(path.toUri()))))).getText());
            } catch (ReaderException e2) {
                return e2.toString();
            }
        } catch (IOException e3) {
            return e3.toString();
        }
    }

    public static void main(String[] strArr) throws MalformedURLException {
        GUIRunner gUIRunner = new GUIRunner();
        gUIRunner.setVisible(true);
        gUIRunner.chooseImage();
    }
}
