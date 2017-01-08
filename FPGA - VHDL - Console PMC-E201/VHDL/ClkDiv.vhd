library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_ARITH.all;
use IEEE.STD_LOGIC_UNSIGNED.all;

entity ClkDiv is
	port(Clk100, Reset : in STD_LOGIC;
			Clk25 : out STD_LOGIC);
end ClkDiv;

architecture corps_ClkDiv of ClkDiv is 
	signal count : std_logic_vector(2 downto 0):= "001";
	signal  sig_clk_25: std_logic := '0';
begin 

		Clk25 <= sig_clk_25;

	
	DIV : process 
	begin 
		WAIT UNTIL Clk100'EVENT and Clk100 = '1' ;

			if count < 4 and Reset = '1' then
				count <= count+1;
			else 
				count <= "001";
			end if;
	
	end process DIV;

	counter: process (count) 
	begin 
		if ( rising_edge (count(2))and Reset = '1')then 
			if(sig_clk_25 ='0')then 
				sig_clk_25 <= '1';
			else
				sig_clk_25 <= '0';
			end if;
	   end if;
	end process counter;	
	
end corps_ClkDiv;