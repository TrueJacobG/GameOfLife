package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import game.logic.GameThread;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class GameThreadTest {
    @Test
    void isValidCoordsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = GameThread.class.getDeclaredMethod("isValidCoords", int.class, int.class);
        method.setAccessible(true);
        assertEquals(method.invoke(new GameThread(), 0, 0), false);
        assertEquals(method.invoke(new GameThread(), 0, 13213), false);
        assertEquals(method.invoke(new GameThread(), 34534523, 0), false);
        assertEquals(method.invoke(new GameThread(), 123, 1231), true);
    }

}