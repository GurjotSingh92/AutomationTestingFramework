/**
 * 
 */
package amazonAutoTestingFramework.utils.helpers;

import java.util.List;

import org.testng.Assert;


/**
 * @author Gurjot Ahuja This class is used for keeping all the assertion methods
 *         in a same place
 */
public class Assertions {

	// Assertion wrappers ***

	// this wrapper changes hard assert to simple boolean function
	public boolean verifyEquality(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);
			return true;
		} catch (AssertionError e) {
			e.toString();
			e.getMessage();
			return false;
		}
	}

	// actual assert equality - hard
	public void verifyEqualityAssert(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);

		} catch (AssertionError e) {
			e.toString();
			e.getMessage();
		}
	}

	// always failing hard assertion
	public void failAlwaysHard() {
		Assert.assertTrue(false);
	}

	// compare or assert 2 lists
	public boolean compare2Lists(List<String> list1, List<String> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals(list2.get(i))) {
				return true;
			}
		}
		return false;
	}

	// asserts 2 lists match
	public boolean contains2Lists(List<String> parentList, List<String> childList) {
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).contains(childList.get(i))) {
				return true;
			}
		}
		return false;
	}

}
