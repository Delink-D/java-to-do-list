import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {
	@Test public void category_instantiatesCorrectly_true() {
		Category testCategory = new Category("Home");
		assertEquals(true, testCategory instanceof Category);
	}

	@Test public void getName_categoryInstantiatesWithName_Home() {
		Category testCategory = new Category("Home");
		assertEquals("Home", testCategory.getCategory());
	}

	@Test public void all_returnsAllInstancesOfCategory_true() {
		Category testCategory1 = new Category("Home");
		Category testCategory2 = new Category("School");
		assertEquals(true, Category.getCat().contains(testCategory1));
		assertEquals(true, Category.getCat().contains(testCategory2));
	}

	@Test public void clear_emptiesAllCategoriesFromList_0() {
		Category testCategory = new Category("Home");
		Category.clear();
		assertEquals(Category.getCat().size(), 0);
	}

	@Test public void getId_categoriesInstantiateWithAnId_1() {
		Category testCategory = new Category("Home");
		assertEquals(1, testCategory.catId());
	}

	@Test public void find_returnsCategoryWithSameId_secondCategory() {
		Category.clear();
		Category testCategory1 = new Category("Home");
		Category testCategory2 = new Category("School");
		assertEquals(Category.findCat(testCategory2.catId()), testCategory2);
	}

	@Test public void getTasks_initiallyReturnsEmptyList_ArrayList() {
		Category.clear();
		Category testCategory = new Category("Home");
		assertEquals(0, testCategory.getTasks().size());
	}
	
	@Test public void addTask_addsTaskToList_true() {
		Category testCategory = new Category("Home");
		Task testTask = new Task("This is Task");
		testCategory.addTask(testTask);
		assertTrue(testCategory.getTasks().contains(testTask));
	}

	@Test public void find_returnsNullWhenNoTaskFound_null() {
		assertTrue(Category.findCat(999) == null);
	}
}