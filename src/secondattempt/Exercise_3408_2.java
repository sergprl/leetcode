package secondattempt;

import java.util.*;

class TaskManager {
    private static class Task {
        int priority;
        int userId;
        int taskId;

        public Task(int userId, int taskId, int priority) {
            this.priority = priority;
            this.userId = userId;
            this.taskId = taskId;
        }
    }

    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final PriorityQueue<Task> heap = new PriorityQueue<>((task1, task2) ->
        {
            if (task1.priority == task2.priority) return Integer.compare(task2.taskId, task1.taskId);
            return Integer.compare(task2.priority, task1.priority);
        }
    );

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    final public void add(int userId, int taskId, int priority){
        Task newTask = new Task(userId, taskId, priority);
        taskMap.put(taskId, newTask);
        heap.add(newTask);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        if (oldTask == null) return;

        // Create a new Task object to avoid mutating one already in the heap
        Task newTask = new Task(oldTask.userId, taskId, newPriority);
        taskMap.put(taskId, newTask);
        heap.offer(newTask);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while(!heap.isEmpty()){
            Task top = heap.poll();
            Task current = taskMap.get(top.taskId);

            if (current == null || top != current){
                continue;
            }

            taskMap.remove(top.taskId);
            return top.userId;
        }
        return -1;
    }



    // --------------------------------------


}


public class Exercise_3408_2 {

    public static void main(String[] args) {
        // userId, taskId, prio
        List<Integer> task1 = new ArrayList<>(Arrays.asList(1, 101, 10));
        List<Integer> task2 = new ArrayList<>(Arrays.asList(2, 102, 3));
        List<Integer> task3 = new ArrayList<>(Arrays.asList(3, 103, 10));

        TaskManager taskManager = new TaskManager(new ArrayList<>(Arrays.asList(task1, task3, task2)));

        System.out.println(taskManager.execTop());

        // edit
        taskManager.edit(101, 50);
        taskManager.add(1,104, 30);

        System.out.println(taskManager.execTop());


    }

}
