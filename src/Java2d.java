import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import javax.swing.JPanel;


public class Java2d extends JPanel implements Runnable {

    protected int altura, largura;
    protected Graphics2D g2d;
    private int animationY = 100;
    private int animationX = 200;
    private int flagX = 1, flagY = -1;


    public Java2d(int largura, int altura) {
        this.altura = altura;
        this.largura = largura;
        setDoubleBuffered(true);
        setFocusable(true);
        load();
        new Thread(this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void run() {
        double btime, dtime = 0;
        btime = System.currentTimeMillis();
        while (true) {
            update(dtime / 1000);
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            dtime = (System.currentTimeMillis() - btime);
            btime = System.currentTimeMillis();
        }
    }

    private void load() {
        setBackground(Color.BLACK);
    }

    private void update(double dt) {

    }

    private void desenhaRect(int x, int y, int largura, int altura) {

        g2d.setColor(Color.red);
        g2d.drawRect(x, y, largura, altura);
    }


    private void desenhaOval(int x, int y, int largura, int altura) {
        g2d.setColor(Color.blue);
        g2d.drawOval(x, y, largura, altura);

    }

    private void desenhaOvalFill(int x, int y, int largura, int altura, Color cor) {
        g2d.setColor(cor);
        g2d.fillOval(x, y, largura, altura);
    }

    private void desenhaArc(int x, int y, int largura, int altura, int startAngulo, int arcAngulo) {
        g2d.setColor(Color.yellow);
        g2d.drawArc(x, y, largura, altura, startAngulo, arcAngulo);
    }

    private void desenhaArcFill(int x, int y, int largura, int altura, int startAngulo, int arcAngulo, Color cor) {

        g2d.setColor(cor);
        g2d.fillArc(x, y, largura, altura, startAngulo, arcAngulo);
    }

    private void desenhaTexto(int x, int y, String texto) {
        g2d.setColor(Color.green);
        g2d.drawString(texto, x, y);
    }
    private void desenhaRectFill(int x, int y, int largura, int altura, Color cor) {

        g2d.setColor(cor);
        g2d.fillRect(x, y, largura, altura);

    }

    private void desenhaPath(int[] xPoint, int[] yPoint, Color cor){

        GeneralPath polygon =
                new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoint.length);
        polygon.moveTo(xPoint[0], yPoint[0]);

        for (int index = 1; index < xPoint.length; index++) {
            polygon.lineTo(xPoint[index], yPoint[index]);
        };

        polygon.closePath();
        g2d.setColor(cor);
        g2d.fill(polygon);
    }
    private void desenhaBandeira() {

        desenhaRectFill(200,200,300,200,Color.green);

        int xPoint[] = {225, 350, 470, 350};
        int yPoint[] = {300, 225, 300, 370};

        desenhaPath(xPoint,yPoint, Color.yellow);

        desenhaOvalFill(295,250,100,100,Color.blue);

    }

    private void draw(Graphics g) {
        g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        desenhaBandeira();


//        desenhaRect(200, 300, 100, 100);
//
//        desenhaOval(500, 400, 150, 100);
//
//        desenhaArc(50, 50, 200, 100, 25, 90);
//
//        desenhaTexto(largura / 2, altura / 2, "alou");
//
//        if(animationX <= 0 || animationX >=altura)
//            flagX *= -1;
//        if(animationY <=0 || animationY >= altura)
//            flagY *= -1;
//
//        animationX =  animationX + flagX;
//        animationY = animationY +  flagY;
//        desenhaRectFill(animationX, animationY, 10, 10, Color.blue);
    }
}