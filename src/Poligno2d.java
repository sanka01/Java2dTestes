import java.awt.*;

class Poligono2D extends Java2d {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int pontoXInicial = this.altura/2;
    private int pontoYInicial = this.largura/2;

    private int distanciaX = 15 + 30;
    private int distanciaY = 25 + 30;
    private int larguraQuadradoInterno = 12;

    private int[] x = {
            pontoXInicial,
            pontoXInicial + distanciaX,
            pontoXInicial + distanciaX,
            pontoXInicial};
    private int[] y = {pontoYInicial, pontoYInicial,
            pontoYInicial - distanciaY,
            pontoYInicial - distanciaY};

    private int[] x1 = {
            x[0] + larguraQuadradoInterno,
            x[1] - larguraQuadradoInterno,
            x[2] - larguraQuadradoInterno,
            x[3] + larguraQuadradoInterno};
    private int[] y1 = {
            y[0] - larguraQuadradoInterno,
            y[1] - larguraQuadradoInterno,
            y[2] + larguraQuadradoInterno,
            y[3] + larguraQuadradoInterno};

    private int[] x2 = {x[3], x1[3], x1[2], x[2]};
    private int[] y2 = {y[3], y1[3], y1[2], y[2]};

    private int[] x3 = {x[0], x[1], x1[1], x1[0]};
    private int[] y3 = {y[0], y[1], y1[1], y1[0]};

    private int[] x4 = {x[1], x1[1], x1[2], x[2]};
    private int[] y4 = {y[1], y1[1], y1[2], y[2]};

    private int[] x5 = {x[0], x1[0], x1[3], x[3]};
    private int[] y5 = {y[0], y1[0], y1[3], y[3]};

    private Polygon quadrado = new Polygon(x, y, 4);
    private Polygon face1 = new Polygon(x1, y1, 4);
    private Polygon face2 = new Polygon(x2, y2, 4);
    private Polygon face3 = new Polygon(x3, y3, 4);

    private Polygon face4 = new Polygon(x4, y4, 4);
    private Polygon face5 = new Polygon(x5, y5, 4);

    public Poligono2D(int largura, int altura) {
        super(largura, altura);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawPolygon(quadrado);
        g.drawPolygon(face1);
        g.drawPolygon(face2);
        g.drawPolygon(face3);
        g.drawPolygon(face4);
        g.drawPolygon(face5);
    }

}