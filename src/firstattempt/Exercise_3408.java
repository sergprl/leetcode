package firstattempt;

import java.util.*;

class TaskManager {

    // whole map is based on prios HashMap<prio, HashMap<taskId,
    //
    private TreeMap<Integer, TreeMap<Integer, Integer>> tasks = new TreeMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int prio = task.get(2);

            this.tasks
                    .computeIfAbsent(prio, k -> new TreeMap<>())
                    .put(taskId, userId);

        }
    }

    public void add(int userId, int taskId, int priority){
        this.tasks
                .computeIfAbsent(priority, k -> new TreeMap<>())
                .put(taskId, userId);
    }

    public int getUser(int prio, int taskId) {
        return tasks.get(prio).getOrDefault(taskId, null);
    }

    private int findTaskPrio(int taskId) {
        int prio = -1;

        for(int currentPrio : tasks.keySet()) {
            if (tasks.get(currentPrio).containsKey(taskId)) {
                prio = currentPrio;
                break;
            }
        }

        return prio;
    }

    public void edit(int taskId, int newPriority) {
        int oldPrio = findTaskPrio(taskId);
        int user = getUser(oldPrio, taskId);

        rmv(taskId, oldPrio);
        add(user, taskId, newPriority);
    }

    public void rmv(int taskId, int priority) {
        tasks.get(priority).remove(taskId);

        if(tasks.get(priority).isEmpty()) {
            tasks.remove(priority);
        }

    }

    public void rmv(int taskId) {
        int priority = findTaskPrio(taskId);
        tasks.get(priority).remove(taskId);

        if(tasks.get(priority).isEmpty()) {
            tasks.remove(priority);
        }
    }


    public int execTop() {
        if(tasks.isEmpty()) return -1;

        int maxPrio = tasks.lastKey();
        int maxTaskId = tasks.get(maxPrio).lastKey();
        int userId = tasks.get(maxPrio).get(maxTaskId);

        rmv(maxTaskId, maxPrio);

        return userId;
    }

    // -----------------------

    public void showTasks() {
        System.out.println("---------------------------------------");
        for(int prio : tasks.keySet()) {
            System.out.printf("Prio %d:%n", prio);
            System.out.println(" Task ID    User ID");
            for (int taskId : tasks.get(prio).keySet()) {
                System.out.printf("%8d    %8d%n", taskId, tasks.get(prio).get(taskId));
            }
        }
        System.out.println("---------------------------------------\n");
    }


}

public class Exercise_3408 {

    public static void main(String[] args) {
        // userId, taskId, prio
        List<Integer> task1 = new ArrayList<>(Arrays.asList(1, 101, 10));
        List<Integer> task2 = new ArrayList<>(Arrays.asList(2, 102, 3));
        List<Integer> task3 = new ArrayList<>(Arrays.asList(3, 103, 10));

        TaskManager taskManager = new TaskManager(new ArrayList<>(Arrays.asList(task1, task2, task3)));

        System.out.println("Adding task 104, userId 2, prio 3");
        taskManager.add(2, 104, 3);
        taskManager.showTasks();

        System.out.println("Adding task 105, userId 3, prio 6");
        taskManager.add(3, 105, 6);
        taskManager.showTasks();

        System.out.println("Changing prio of task 103 to 6");
        taskManager.edit(103, 6);
        taskManager.showTasks();


        taskManager.rmv(103);
        taskManager.showTasks();


        System.out.println("Max user: " + taskManager.execTop());
        taskManager.showTasks();

        System.out.println("Max user: " + taskManager.execTop());
        taskManager.showTasks();

    }

}
