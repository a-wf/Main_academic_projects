library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

ENTITY Move_tb IS
END Move_tb;

ARCHITECTURE tb OF Move_tb IS 
   	signal Clk25_in:STD_LOGIC;
	signal Reset_in : STD_LOGIC;
	signal QA_in : STD_LOGIC;
	signal QB_in : STD_LOGIC;
	signal RL_out : STD_LOGIC := '0';
	signal RR_out : STD_LOGIC := '0';

BEGIN

   Test: entity work.Move(corps_Move)
    port map (
   	Clk25_in ,
	Reset_in ,
	QA_in,
	QB_in,
	RL_out,
	RR_out
        );
	
	Reset_in <= '1';
	
clk_process :process
   begin
		  Clk25_in <= '0';
		  wait for 40 ns;
		  Clk25_in <= '1';
		  wait for 40 ns;
   end process;


simu: process
   begin

QA_in <= '0';
QB_in <= '0';  
     wait for 50 ns;
        QA_in <='1';
	wait for 50 ns;
	QB_in <='1';
	wait for 240 ns;
	 QA_in <='0';
	wait for 50 ns;
	QB_in <='0';

	wait for 100 ns;
	QB_in <='1';
	wait for 50 ns;
	QA_in <='1';
	wait for 240 ns;
	QB_in <='0';
	wait for 50 ns;
	QA_in <='0';
   end process;
	
    
END tb;