import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommentTester {

	@Test
	void testAddComment() {
		App a = new App("candy crush", "game"); 
		User u = new User(); 
		
		// checks user cant comment if not logged in
		u.login = false;
		assertFalse(u.addComment(a, "I love this!"));
		
		// checks can comment if logged in  
		u.login = true;
		assertTrue(u.addComment(a, "I love this!"));
		
	}

}
