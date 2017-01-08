library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

ENTITY Tempo_pause_tb IS
END Tempo_pause_tb;

ARCHITECTURE tb OF Tempo_pause_tb IS 
	signal Clk25_in:std_logic;
	signal Reset_in:std_logic;
	signal RAZ_Tempo_Pause_in:std_logic;
	signal Update_Tempo_Pause_in :std_logic :='0';
	signal Fin_Tempo_Pause_in : std_logic := '0';


BEGIN

   Test: entity work.Tempo_pause(corps_Tempo_pause)
    port map (
   	Clk25_in ,
	Reset_in ,
	RAZ_Tempo_Pause_in,
	Update_Tempo_Pause_in,
	Fin_Tempo_Pause_in
	);
	
	
	
clk_process :process
   begin
		  Clk25_in <= '0';
		  wait for 40 ns;
		  Clk25_in <= '1';
		  wait for 40 ns;
   end process;

   	Reset_in <= '1';
	RAZ_Tempo_Pause_in <= '0';

simu: process
   begin


	wait for 80 ns;
	Update_Tempo_Pause_in <= '1';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '0';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '1';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '0';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '1';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '0';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '1';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '0';
	wait for 80 ns;
	Update_Tempo_Pause_in <= '1';


   end process;
	
END tb;