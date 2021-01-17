package deco.combatevolved;

import deco.combatevolved.worlds.CombatEvolvedWorld;
import deco.combatevolved.worlds.worldgen.WorldGenParamBag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import deco.combatevolved.handlers.KeyboardManager;
import deco.combatevolved.entities.dynamicentities.PlayerPeon;
import deco.combatevolved.managers.DatabaseManager;
import deco.combatevolved.managers.GameManager;
import deco.combatevolved.managers.InputManager;
import deco.combatevolved.managers.OnScreenMessageManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameManager.class, DatabaseManager.class, PlayerPeon.class})
public class SaveLoadTest {
    private CombatEvolvedWorld w = null;

    @Mock
    private GameManager mockGM;
    
    
    @Before
    public void Setup() {
        w = new CombatEvolvedWorld();
        
        mockGM = mock(GameManager.class);
        mockStatic(GameManager.class);
        
        
        when(GameManager.get()).thenReturn(mockGM);
        when(mockGM.getWorld()).thenReturn(w);
        
        //mocked imput manager
        InputManager Im = new InputManager();
        KeyboardManager Km = new KeyboardManager();
        OnScreenMessageManager mockOSMM = mock(OnScreenMessageManager.class);
        when(mockGM.getManager(OnScreenMessageManager.class)).thenReturn(mockOSMM);
        
        when(GameManager.getManagerFromInstance(InputManager.class)).thenReturn(Im);
        when(GameManager.getManagerFromInstance(KeyboardManager.class)).thenReturn(Km);

     
    }

    // TODO: Split this test up into multiple unit tests that test individual component functionality
    // TODO: instead of just testing the entire DatabaseManager in a single test.
    // TODO: Whenever this test fails it's impossible to know what went wrong.
    // TODO: If this test is intentionally testing system functionality, then
    // TODO: it still needs to be obvious where the test went wrong so it can be debugged
    // TODO: rather than it just saying "Test failed, good luck!"
    // TODO: rewrite this to fit new structure
    @Test
    public void SetMapTest() {
        assertEquals("This is temp", "This is temp");
   }
}
