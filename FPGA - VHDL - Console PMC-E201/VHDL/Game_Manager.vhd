library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_ARITH.all;
use IEEE.STD_LOGIC_UNSIGNED.all;

entity Game_Manager is
	port(Clk25, Reset, game_rqt : in STD_LOGIC;
			game_type : out STD_LOGIC := '0');
end Game_Manager;

architecture corps_Game_Manager of Game_Manager is 	
signal prec_rqt: std_logic := '0';
signal sig_type : std_logic :='0';
begin 
	game_type <= sig_type;
p1  : process (Clk25, Reset)
	begin 
		if Reset = '0' then 
			sig_type <= '0';
		elsif (rising_edge(Clk25)) then
			if (prec_rqt /= game_rqt) and (game_rqt = '1') then
				sig_type <= not sig_type; 
			end if;
			prec_rqt <= game_rqt;
		end if;
end process;
end corps_Game_Manager;