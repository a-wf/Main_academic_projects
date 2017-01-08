library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_ARITH.all;
use IEEE.STD_LOGIC_UNSIGNED.all;

entity Move is
	port(Clk25, Reset, QA, QB : in STD_LOGIC;
			Rot_Left, Rot_Right : out STD_LOGIC);
end Move;

architecture corps_Move of Move is 
signal prec_qa: std_logic := '0';	
signal etat: integer :=0;
begin 

p1  : process (Clk25, Reset)
	begin 
		if Reset = '0' then 
			Rot_Left <= '0';
			Rot_Right <= '0';
		elsif (rising_edge(Clk25)) then
			case etat is 
				when 0 => Rot_Left <= '0';
								Rot_Right <= '0';

				when 1 => Rot_Left <= '1';
								Rot_Right <= '0';
								etat <= 0;
				when 2 => Rot_Left <= '0';
								Rot_Right <= '1';
								etat <= 0;
				when others => NULL;
			end case;
		end if;


		if(prec_qa /= QA) then 
			if(QA = QB)then 
				etat <= 2;
			else
				etat <= 1;
			end if;
--		else 
--			if(QA = QB) then 
--				etat <= 1;
--			else
--				etat <= 2;
--			end if;
		end if;
		prec_qa <= QA;		
	end process p1;	
end corps_Move;