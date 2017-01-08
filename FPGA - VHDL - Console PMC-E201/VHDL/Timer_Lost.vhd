library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all; 
use ieee.std_logic_unsigned.all;


ENTITY Timer_Lost IS
PORT (
  Clk25, Reset, Load_Timer_Lost, Update_Timer_Lost :IN std_logic;
  Game_Lost : OUT std_logic := '0';
  compt_timer_Lost : out std_logic_vector (5 downto 0) 
); -- sortie véritable
END Timer_Lost;
ARCHITECTURE corps_Timer_Lost OF Timer_Lost IS
SIGNAL compt : std_logic_vector(5 downto 0) := "000000"; -- signal intermédiaire
BEGIN
  
  compt_timer_Lost <= compt;
  PROCESS(Clk25, Reset) BEGIN

  	IF Reset = '0' then 
  		compt<=(OTHERS=>'0');
        Game_Lost <= '0';
    ELSIF Clk25'event and Clk25='1' THEN
      IF Load_Timer_Lost ='1' THEN
        compt<=(OTHERS=>'1');
        Game_Lost <= '0';
      END IF;
    ELSIF compt /= "000000" and Update_Timer_Lost = '1' THEN
      compt <= compt - 1;
    END IF;

    IF compt /= "000000" then 
    	Game_Lost <= '1';
    else 
      Game_Lost <= '0';
    END IF;
  END PROCESS;
END corps_Timer_Lost;