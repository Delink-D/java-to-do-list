import java.util.*;

public class Category {
	private String mCategory;
	private int mCatId;
	private static List<Category> instances = new ArrayList<Category>();
	private List<Task> mTasks; 

	public Category(String category) {
		mCategory = category;
		instances.add(this);
		mCatId = instances.size();
		mTasks = new ArrayList<Task>();
	}

	public String getCategory() {
		return mCategory;
	}

	public static List<Category> getCat() {
		return instances;
	}

	public static void clear() {
		instances.clear();
	}

	public int catId() {
		return mCatId;
	}

	public static Category findCat(int id) {
		try{
			return instances.get(id -1);
		}catch(IndexOutOfBoundsException exception) {
			return null;
		}
	}

	public List<Task> getTasks() {
		return mTasks;
	}

	public void addTask(Task task) {
		mTasks.add(task);
	}
}