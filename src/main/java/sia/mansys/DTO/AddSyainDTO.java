package sia.mansys.DTO;

import java.util.List;

import lombok.Data;
import sia.mansys.model.SyainKyuyo;
import sia.mansys.model.SyainMain;
import sia.mansys.model.SyainRireki;
import sia.mansys.model.SyainSyokureki;

@Data
public class AddSyainDTO {
	private SyainMain syainMain;
	private List<SyainKyuyo> syainKyuyo;
	private List<SyainRireki> syainRireki;
	private List<SyainSyokureki> syainSyokurekis;
}
