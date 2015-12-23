package com.lzw;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * �������
 * 
 * @author YongQiang Lee
 */
public class RotatePanel extends JPanel {
    private static final long serialVersionUID = 5260642571525243284L;
    private BufferedImage bimage;
    private Dimension fsize;
    private JFrame frame;
    private int angle=1;
    
    public RotatePanel() {
        setOpaque(false);
        setLayout(null);
    }
    
    /**
     * ��������
     */
    protected void paintComponent(Graphics g1) {
        Graphics2D g=(Graphics2D) g1;
        if (frame != null)
            fsize = frame.getSize();
        if (frame == null) {
            frame = (JFrame) getRootPane().getParent();
            fsize = frame.getSize();
            bimage = new BufferedImage(fsize.width,
                    fsize.height, BufferedImage.TYPE_INT_ARGB);
            frame.printAll(bimage.getGraphics());
            bimage.flush();
        }
        if (bimage != null && fsize.width >= 20
                && fsize.height >= 20) {
            // ͼƬ���
            fsize.width -= 30;
            // ͼƬ�߶�
            fsize.height -= 30;
            angle+=10;
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.rotate(Math.toRadians(angle), fsize.width/2, fsize.height/2);
            // ����ͼƬ
            g.drawImage(bimage, 0, 0, this);
        }
        super.paintComponent(g);
    }
}
