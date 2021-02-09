import java.util.List;

public class DrawingTable {
    public static void draw(List<Statistic> statistics){
        Canvas canvas = new Canvas(64, 50);
        canvas.drawBorder("#");
        canvas.printTextLine(15, 0, "CARS OUT LESS THAN 30 MINUTES");
        int count=2;
        for (Statistic s:statistics
             ) {
            for (int i = canvas.getHeight()-2; i >(canvas.getHeight()-s.getCarsLeastMin())-2 ; i--) {
                canvas.setPixel(count, i, "*");
            }
            count+=2;
        }

        System.out.println(canvas.toString());
        System.out.println();

        canvas = new Canvas(64, 30);
        canvas.drawBorder("#");
        canvas.printTextLine(15, 0, "Cash on per day");
        count=2;
        for (Statistic s:statistics
        ) {
            for (int i = canvas.getHeight()-2; i >(canvas.getHeight()-s.getCash()/1000)-2 ; i--) {
                canvas.setPixel(count, i, "*");
            }
            count+=2;
        }
        System.out.println(canvas.toString());

        System.out.println();

        canvas = new Canvas(64, 12);
        canvas.drawBorder("#");
        canvas.printTextLine(15, 0, "Load on per day");
        count=2;
        for (Statistic s:statistics
        ) {
            for (int i = canvas.getHeight()-2; i >(canvas.getHeight()-s.getLoad()+90)-2 ; i--) {
                canvas.setPixel(count, i, "*");
            }
            count+=2;
        }
        System.out.println(canvas.toString());
    }
}
