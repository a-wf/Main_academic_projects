library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

ENTITY Game_Manager_tb IS
END Game_Manager_tb;

ARCHITECTURE tb OF Game_Manager_tb IS 
   	signal Clk25_in:STD_LOGIC;
	signal Reset_in : STD_LOGIC;
	signal game_rqt_in : STD_LOGIC;
	signal game_type_out : STD_LOGIC := '0';

BEGIN

   Test: entity work.Game_Manager(corps_Game_Manager)
    port map (
   	Clk25_in ,
	Reset_in ,
	game_rqt_in,
	game_type_out
	);
	
	
	
clk_process :process
   begin
		  Clk25_in <= '0';
		  wait for 40 ns;
		  Clk25_in <= '1';
		  wait for 40 ns;
   end process;


simu: process
   begin
   	Reset_in <= '0';
	game_rqt_in <= '0';

    wait for 80 ns;
    Reset_in <= '1';
    
	wait for 50 ns;
	game_rqt_in <= '1';
	wait for 80 ns;
	game_rqt_in <= '0';

	wait for 240 ns;
	game_rqt_in <= '1';
	wait for 450 ns;
	game_rqt_in <= '0';
	wait for 160 ns;
	game_rqt_in <= '0';
   end process;
	
END tb;