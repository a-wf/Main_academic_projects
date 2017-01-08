library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

ENTITY ClkDiv_tb IS
END ClkDiv_tb;

ARCHITECTURE tb OF ClkDiv_tb IS 
   signal Clk100_in:STD_LOGIC;
	signal Reset_in : STD_LOGIC;
	signal Clk25_in : STD_LOGIC;

BEGIN

   Test: entity work.ClkDiv(corps_ClkDiv)
    port map (
   Clk100_in ,
	Reset_in ,
	Clk25_in
        );
	
	Reset_in <= '1';
	clk_process :process
   begin
		  Clk100_in <= '0';
		  wait for 10 ns;
		  Clk100_in <= '1';
		  wait for 10 ns;
   end process;
  
    
END tb;