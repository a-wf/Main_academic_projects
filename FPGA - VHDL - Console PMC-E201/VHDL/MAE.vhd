library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_ARITH.all;
use IEEE.STD_LOGIC_UNSIGNED.all;

entity MAE is
  port(Clk25, Reset, pause_rqt, endframe, lost, no_brick, fin_tempo_pause: in STD_LOGIC;
      pause, brick_win, raz_tempo_pause, update_tempo_pause, load_timer_lost, update_timer_lost: out STD_LOGIC := '0';
      timer_lost6bits : in std_logic_vector(5 downto 0) := "000000");
end MAE;

architecture corps_MAE of MAE is  
signal sig_pause: std_logic := '0';
signal prec_pause_rqt: std_logic := '0';
signal prec_lost : std_logic := '0';
begin 

pause <= sig_pause;

p1 : process (Clk25, Reset)
begin 
    if Reset = '0' then 
      pause <= '0';
      brick_win  <= '0';
      raz_tempo_pause  <= '0';
      update_tempo_pause  <= '0';
      load_timer_lost  <= '0';
      update_timer_lost  <= '0';
    elsif rising_edge(Clk25) then
      if(prec_pause_rqt /= pause_rqt and pause_rqt = '1') then
        sig_pause <= not sig_pause;
        update_tempo_pause <= '1';
      end if;
      
      if sig_pause = '0' then 
        if(no_brick = '1') then 
          brick_win <= '1';
        end if;

        if(lost = '1' ans prec_lost /= lost)then
          load_timer_lost <= '1';
          pause <= '1';
        else 
          load_timer_lost <= '0';
        end if;
        prec_lost <= lost;
        if fin_tempo_pause = '1' then 
          lost <= '1';
        end if;
      else 
        if fin_tempo_pause = '1' then 
          pause <= '0';
      end if;
      prec_pause_rqt <= pause_rqt;
    end if;
end process p1;

p2 : process (Endframe)
begin 
    if(timer_lost6bits /= "000000")then 
        if (rising_edge(Endframe)) then 
          update_timer_lost <= '1';
        else 
          update_timer_lost <= '0';
        end if;
    end if;
end process p2;
end corps_MAE;
