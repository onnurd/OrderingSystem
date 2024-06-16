import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter the number of requests : ");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int reqs = sc.nextInt();
        Object[] products = new Object[6];
        products[0] = new Sofa();
        products[1] = new Bed();
        products[2] = new Chair();
        products[3] = new Dresser();
        products[4] = new Table();
        products[5] = new Bookcase();
        FactoryLine fl = new FactoryLine(15);

        SofaWarehouse sw = new SofaWarehouse(15);
        BedWarehouse bw = new BedWarehouse(15);
        ChairWarehouse cw = new ChairWarehouse(15);
        DresserWarehouse dw = new DresserWarehouse(15);
        TableWarehouse tw = new TableWarehouse(15);
        BookcaseWarehouse bcw = new BookcaseWarehouse(15);

        
        //main loop
        for(int i=0; i<reqs; i++) {
            int r1 = rand.nextInt(3);
            if ( r1 == 0) {
                int r2 = rand.nextInt(6);
                Object pr = products[r2];
                System.out.print("Marketing Analyst requesting " + pr.getClass().getName());
                System.out.println(", SUCCESS, " + pr.getClass().getName()+ " manufactured");
                fl.enqueue(products[r2]);
                }
            else if ( r1 == 1) {

                Object pr = fl.getFront();

                if( pr!=null) {
                    System.out.print("Storage Chief Storing " + pr.getClass().getName());
                    System.out.println(", SUCCESS, "+ pr.getClass().getName() + " Stored.");

                } else if (pr == null) {
                } else if (pr.getClass().getName() == "Sofa") {
                    sw.push(products[0]);
                    fl.dequeue();
                } else if (pr.getClass().getName() == "Bed") {
                    bw.push(products[1]);
                    fl.dequeue();
                } else if (pr.getClass().getName() == "Chair") {
                    cw.push(products[2]);
                    fl.dequeue();
                } else if (pr.getClass().getName() == "Dresser") {
                    dw.push(products[3]);
                    fl.dequeue();
                } else if (pr.getClass().getName() == "Table") {
                    tw.push(products[4]);
                    fl.dequeue();
                } else if (pr.getClass().getName() == "Bookcase") {
                    bcw.push(products[5]);
                    fl.dequeue();
                }
            }else if ( r1 == 2) {
                int r2 = rand.nextInt(6);
                Object pr = products[r2];
                System.out.print("Customer Buying " + pr.getClass().getName());

                if ( pr.getClass().getName() == "Sofa") {
                    if ( sw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }else if ( pr.getClass().getName() == "Bed") {
                    if ( bw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }
                else if ( pr.getClass().getName() == "Chair") {
                    if ( cw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }
                else if ( pr.getClass().getName() == "Dresser") {
                    if ( dw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }
                else if ( pr.getClass().getName() == "Table") {
                    if ( tw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }
                else if ( pr.getClass().getName() == "Bookcase") {
                    if ( bcw.pop() != null) {
                        System.out.println(", SUCCESS, CUSTOMER BOUGHT "+ pr.getClass().getName());
                    }else {
                        System.out.println(", FAIL "+ pr.getClass().getName() + " WAREHOUSE IS EMPTY.");
                    }
                }
            }

        }

    }
}
