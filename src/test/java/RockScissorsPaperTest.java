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
			Mockito.when(userMock.getChoice()).thenReturn(Sign.SCISSORS.name());
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.SCISSORS.name());

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			assertTrue(result.isDraw());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUserWins() {
		try {
			Mockito.when(userMock.getChoice()).thenReturn(Sign.SCISSORS.name());
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.PAPER.name());

			Result expected = new Result();
			expected.setWinner(userMock);

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			assertEquals(expected.getWinnerChoice(), result.getWinnerChoice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testComputerWins() {
		try {
			Mockito.when(userMock.getChoice()).thenReturn(Sign.PAPER.name());
			Mockito.when(computerMock.getChoice()).thenReturn(Sign.SCISSORS.name());

			Result result = RockScissorsPaperComperator.compare(userMock, computerMock);

			Result expected = new Result();
			expected.setWinner(computerMock);

			assertEquals(expected.getWinnerChoice(), result.getWinnerChoice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
