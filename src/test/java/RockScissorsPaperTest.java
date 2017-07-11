import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Computer;
import model.Draw;
import model.Result;
import model.Sign;
import model.User;
import utility.RockScissorsPaperComperator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RockScissorsPaperTest {

	private User userMock;
	private Computer computerMock;

	@Before
	public void setUP() {
		userMock = Mockito.mock(User.class);
		computerMock = Mockito.mock(Computer.class);
	}

	@Test
	public void testDrawResult() {
		try {
			Mockito.when(userMock.getChoice()).thenReturn(Sign.SCISSORS);
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.SCISSORS);

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			Result expected = new Result();
			Draw draw = new Draw(Sign.SCISSORS);
			expected.setResult(draw);

			assertTrue(expected.equals(result));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUserWins() {
		try {
			Mockito.when(userMock.getChoice()).thenReturn(Sign.SCISSORS);
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.PAPER);

			Result expected = new Result();
			expected.setResult(userMock);

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			assertEquals(expected, result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testComputerWins() {
		try {
			Mockito.when(userMock.getChoice()).thenReturn(Sign.PAPER);
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.SCISSORS);

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			Result expected = new Result();
			expected.setResult(computerMock);

			assertEquals(expected, result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
