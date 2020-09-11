import java.text.SimpleDateFormat;
import java.util.*;

public class ArrangeDate {
    public static String DisplayDay(String[] key, int[] value) throws Exception {
        Map<String, Integer> dayName = new HashMap<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        Date minDate = dateFormatter.parse("1970-01-01");
        Date maxDate = dateFormatter.parse("2100-01-01");
        Date inputDate; String nameOfDay;
        boolean flag = false;
        for (int i = 0; i < key.length; i++) {
             inputDate = dateFormatter.parse(key[i]);
             if(inputDate.compareTo(minDate) < 0 || inputDate.compareTo(maxDate) > 0 || value[i] < -1000000 || value[i] > 1000000){
                 flag = true;
                 break;
             }
             nameOfDay = formatter.format(inputDate);
            if(!dayName.containsKey(nameOfDay)){
                dayName.put(nameOfDay, value[i]);
            } else {
                dayName.put(nameOfDay, (dayName.get(nameOfDay) + value[i]));
            }
        }
        String[] daysInWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] newValue = new int[daysInWeek.length];
        for(int k=0; k<daysInWeek.length;k++){
            if(flag){
                break;
            }
            if(k != 0 && dayName.get(daysInWeek[k]) == null && dayName.get(daysInWeek[k+1]) != null && dayName.get(daysInWeek[k-1]) != null){
                newValue[k] = (dayName.get(daysInWeek[k-1]) +  dayName.get(daysInWeek[k+1])) / 2;
            } else if(k != 0 && dayName.get(daysInWeek[k]) == null && dayName.get(daysInWeek[k+1]) == null) {
                newValue[k] = dayName.get(daysInWeek[k-1]) + 2;
            }
            else {
                newValue[k] = dayName.get(daysInWeek[k]);
            }
            dayName.put(daysInWeek[k], newValue[k]);
        }
        if(flag == false) {
            return ("{'Mon':" + newValue[0] + ", 'Tue':" + newValue[1] + ", 'Wed':" + newValue[2]
                    + ", 'Thu':" + newValue[3] + ", 'Fri':" + newValue[4] + ", 'Sat':" + newValue[5]
                    + ", 'Sun':" + newValue[6] + "}");
        }
            return null;
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] key = new String[n];
        int[] value = new int[n];
        for(int i=0; i<n; i++){
            key[i] = scanner.next();
            value[i] = scanner.nextInt();
        }
        ArrangeDate.DisplayDay(key, value);
    }
}
