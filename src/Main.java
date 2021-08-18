import java.util.Calendar;

public class Main {


    public static void main(String args[]){

        long x = 768614336404564650L;
        System.out.println("Probability of Friday the 13ths over the next "+x+" years is " + probability(x));
        System.out.println("Over time, there should be about a 1/7 chance for the 13th of each month to be a friday, or "+ 1.0/7.0);
    }

    public static double probability(long years) {
        long months = years*12;
        if(months < 0){
            System.out.println("Integer Overflow");
            System.exit(2);
        }
        long total = numFriThirteenths(years);
        System.out.println("There are a total of " + total + " Friday the 13ths over the next " + years +" years.");

        return (double) total / (double) months;
    }
    public static long numFriThirteenths(long years){

        long months = years*12;

        long retval = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 13);

        for(long i = 0; i < months; i++){
            //System.out.println(calendar.getTime().toString());
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            //printDayOfWeek(dayOfWeek);
            if(i % 1000000 == 0){
                clearScreen();
                double percentage = ((double) i / (double) months ) * 100;
                System.out.println( String.format("%.9f", percentage)+"%\n");
                printProgressBar(percentage);
            }
            if(dayOfWeek == 6){
                retval++;
            }

        }

        return retval;
    }
    public static void printDayOfWeek(int day){
        switch (day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void printProgressBar(double percentage){
        int percent = (int) Math.floor(percentage);
        System.out.print("|");
        for(int i = 0; i < percent; i ++){
            System.out.print("=");
        }
        for(int i = 0; i < 100-percent; i++ ){
            System.out.print("-");
        }
        System.out.print("|");
    }
}
