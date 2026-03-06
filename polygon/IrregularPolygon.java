package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool
import java.lang.Math;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        double distance = 0; //distance = Math.sqrt(((x2 - x1)^2) + ((y2 - y1)^2))
        double total = 0;
        Point2D.Double point1;
        Point2D.Double point2;
        for(int i = 0; i < myPolygon.size() - 1; i++){
            point1 = myPolygon.get(i);
            point2 = myPolygon.get(i + 1);
            distance = point1.distance(point2);
            total += distance;
        }
        point1 = myPolygon.get(0);
        point2 = myPolygon.getLast();
        distance = point1.distance(point2);
        total += distance;
        return total;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        double sum1 = 0;
        double sum2 = 0;
        for(int i = 0; i < myPolygon.size() - 1; i++){
            sum1 = sum1 + myPolygon.get(i).getX() * myPolygon.get(i + 1).getY();
        }
        sum1 = sum1 + myPolygon.getLast().getX() * myPolygon.getFirst().getY();
        for (int i = 0; i < myPolygon.size() - 1; i++) {
            sum2 = sum2 + myPolygon.get(i).getY() * myPolygon.get(i + 1).getX();
        }
        sum2 = sum2 + myPolygon.getLast().getY() * myPolygon.getFirst().getX();
        area = Math.abs(0.5 * (sum1 - sum2));
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            double minX = myPolygon.getFirst().getX();
            double maxX = myPolygon.getFirst().getX();
            double minY = myPolygon.getFirst().getY();
            double maxY = myPolygon.getFirst().getY();
            int i = 0;
            for(i = 1; i < myPolygon.size(); i++){
                if(myPolygon.get(i).getX() < minX){
                    minX = myPolygon.get(i).getX();
                } else if(myPolygon.get(i).getX() > maxX){
                    maxX = myPolygon.get(i).getX();
                }
                if(myPolygon.get(i).getY() < minY) {
                    minY = myPolygon.get(i).getX();
                } else if (myPolygon.get(i).getY() > maxY) {
                    maxY = myPolygon.get(i).getX();
                }
            }
            double ShapeWidth = maxX - minX;
            double ShapeHeight = maxY - minY;
            double maxdimension = Math.max(ShapeWidth, ShapeHeight);
            int p = 100; //(int) Math.max(maxdimension * 0.20, 60);
            //int menuSpace = 60;
            int CanvasWidth = (int) (ShapeWidth + (2 * p));
            int CanvasHeight = (int) (ShapeHeight + (2 * p)/* + menuSpace*/);
            DrawingTool myPen = new DrawingTool(new SketchPad(CanvasWidth, CanvasHeight));
            double CenterX = (minX + maxX) / 2.0;
            double CenterY = (minY + maxY) / 2.0;
            myPen.up();
            myPen.move(myPolygon.getFirst().getX() - CenterX, (myPolygon.getFirst().getY() - CenterY)); //- (menuSpace / 2));
            myPen.down();
            for(i = 1; i < myPolygon.size(); i++){
                myPen.move(myPolygon.get(i).getX() - CenterX, (myPolygon.get(i).getY() - CenterY)); //- (menuSpace / 2));
            }
            myPen.move(myPolygon.getFirst().getX() - CenterX, (myPolygon.getFirst().getY() - CenterY)); //- (menuSpace / 2));
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
