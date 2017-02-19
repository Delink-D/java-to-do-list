import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TaskTest {
	@Test public void task_IntantiateCorrectly() {
		Task testTask = new Task("This is a description!");

		assertEquals(true, testTask instanceof Task);
	}

	@Test public void task_IntantiateWithDesc_String() {
		Task testTask = new Task("This is a description!");
		String expected = "This is a description!";
		assertEquals(expected, testTask.getDescription());
	}

	@Test public void isCompleted_isFalseAfterInstantiation_false() {
		Task testTask = new Task("This one");
		assertEquals(false, testTask.isCompleted());
	}

	@Test public void getCreatedAt_instantiatesWithCurrentTime_today() {
		Task testTask = new Task("This one");
		assertEquals(LocalDateTime.now().getDayOfWeek(), testTask.getCreatedAt().getDayOfWeek());
	}

	@Test public void all_returnsAllInstancesOfTask_true() {
		Task testTask1 = new Task("This one");
		Task testTask2 = new Task("This two");

		assertEquals(true, Task.getAll().contains(testTask1));
		assertEquals(true, Task.getAll().contains(testTask2));
	}

	@Test
	public void clear_emptiesAllTasksFromArrayList_0() {
		Task testTask = new Task("This one");
		Task.clear();
		assertEquals(Task.getAll().size(), 0);
	}

	@Test
	public void getId_tasksInstantiateWithAnID_1() {
		Task.clear();
		Task testTask = new Task("This one");
		assertEquals(1, testTask.getTaskId());
	}

	@Test
	public void find_returnsTaskWithSameId_secondTask() {
		Task firstTask = new Task("Mow the lawn");
		Task secondTask = new Task("Buy groceries");
		assertEquals(Task.find(secondTask.getTaskId()), secondTask);
	}
}