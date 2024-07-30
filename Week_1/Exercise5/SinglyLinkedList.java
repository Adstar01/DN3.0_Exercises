package Exercise5;

public class SinglyLinkedList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(taskId)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
            return;
        }

        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        taskList.addTask(new Task("T001", "Design Database", "Pending"));
        taskList.addTask(new Task("T002", "Implement API", "In Progress"));
        taskList.addTask(new Task("T003", "Test Application", "Completed"));

        System.out.println("Task List:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task T002:");
        Task task = taskList.searchTask("T002");
        System.out.println(task != null ? task : "Task not found");

        System.out.println("\nDeleting Task T002:");
        taskList.deleteTask("T002");

        System.out.println("\nTask List after Deletion:");
        taskList.traverseTasks();
    }
}

