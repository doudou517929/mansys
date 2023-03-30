package sia.mansys.model;

import java.util.Date;

import lombok.Data;

@Data
public class SyainMain {
	private int syain_id;
    private String first_name_kanji;
    private String last_name_kanji;
    private String first_name_kana;
    private String last_name_kana;
    private String first_name_eigo;
    private String last_name_eigo;
    private int seibetu;
    private Date tanjyobi;
    private int kokuseki;
    private String syussinn;
    private int haigusya;
    private String passport_num;
    private Date passport_end_date;
    private int visa_kikan;
    private Date visa_end_date;
    private int zairyu_sikaku;
    private String kojin_num;
    private String zairyu_num;
    private int syozoku_kaisya;
    private Date nyuusya_date;
    private Date taisya_date;
    private int syokugyo_kind;
    private Date rainiti_date;
    private String bikou;
    private String yuubin;
    private String jyusyo_1;
    private String jyusyo_2;
    private String moyori_eki;
    private String tel;
    private String email;
    private String wechat;
    private String line;
    private String bokoku_jyusyo;
    private String bokoku_kinnkyuu_rennraku;
    private int saisyuu_gakureki;
    private String gakkou_name;
    private String sennmom_name;
    private Date sotugyo_date;
    private float gyumu_nensu;
    private String it_os;
    private String it_gengo;
    private String it_db;
    private String it_web_server;
    private String it_fw;
    private String it_other;
    private String it_bikou;
    private int delete_flag;
    private Date tourokubi;
    private Date kousinnbi;
}
