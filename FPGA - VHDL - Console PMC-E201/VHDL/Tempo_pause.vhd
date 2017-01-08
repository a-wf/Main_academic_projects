library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all; 
use ieee.std_logic_unsigned.all;
ENTITY Tempo_pause IS
PORT (
  Clk25, Reset, RAZ_Tempo_Pause, Update_Tempo_Pause :IN std_logic :='0';
  Fin_Tempo_Pause : OUT std_logic := '0'
); -- sortie véritable
END Tempo_pause;
ARCHITECTURE corps_Tempo_pause OF Tempo_pause IS
SIGNAL compt : std_logic_vector(9 downto 0) := "0000000000"; -- signal intermédiaire
BEGIN

-- RAZ synchrone
  PROCESS(Clk25, Reset) BEGIN

    IF Reset = '0' then 
  		compt<=(OTHERS=>'0');
       		Fin_Tempo_Pause <= '0';
    ELSIF Clk25'event and Clk25='1' THEN
      IF RAZ_Tempo_Pause ='1' THEN
        compt<=(OTHERS=>'0');
        Fin_Tempo_Pause <= '0';
      ELSIF Update_Tempo_Pause = '1' THEN
        compt <= compt + 1;
      END IF;
    END IF;
    IF compt = "1111111111" then 
    	Fin_Tempo_Pause <= '1';
    END IF;
  END PROCESS;
END corps_Tempo_pause;