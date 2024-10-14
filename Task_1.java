import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Task_1 {
    public static void main(String[] args) {

        // Header
        String[] header = {"name", "age", "position", "salary"};

        // Rows
        String[] kirill = {"Kirill", "26", "Middle Java", "150000 руб"};
        String[] vitaly = {"Vitaly", "28", "Senior java automation QA", "2000$"};
        String[] alex = {"Alexandr", "31", "junior functional tester", "50000 руб"};
        String[] dementy = {"Dementy", "35", "dev-ops", "1500$"};
        List<String[]> emp = List.of(kirill, vitaly, alex, dementy);


        // Table
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        emp.forEach(x -> {
            HashMap<String, String> r = new HashMap<>();
            for(int i = 0; i < x.length; i++) {
                r.put(header[i], x[i]);
            }
            table.add(r);
        });


        // Младше 30
        table.stream()
                .forEach(x -> {
                    if(Integer.parseInt(x.get("age")) < 30) System.out.println(x.get("name"));
                });
        System.out.println();

        // Все сотрудники, получающие зарплату в рублях
        table.stream()
                .forEach(x -> {
                    if(x.get("salary").endsWith("руб")) System.out.println(x.get("name"));
                });
        System.out.println();

        // Средний возраст
        AtomicReference<Double> avg = new AtomicReference<>(0.0);
        table.stream().forEach(x -> {
            int age = Integer.parseInt(x.get("age"));
            avg.updateAndGet(
                    v -> (double) (v + (double) age / table.size())
                );
            }
        );
        System.out.println(avg);
    }

}