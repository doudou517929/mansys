package sia.mansys.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SyainMain {	
    private Integer syainId;
//	社員名
    @Valid
	@NotBlank(message = "社員名（漢字）＿姓を入力してください")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "社員名（漢字）＿姓は全角で入力してください。")
	@Size(min = 1, max = 15, message = "社員名（漢字）＿姓は15以下で入力してください。")
    private String firstNameKanji;
	@NotBlank(message = "社員名（漢字）＿名を入力してください")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "社員名（漢字）＿名は全角で入力してください。")
	@Size(min = 1, max = 15, message = "社員名（漢字）＿名は15以下で入力してください。")
    private String lastNameKanji;
	@NotBlank(message = "社員名（カタカナ）＿姓を入力してください")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "社員名（カタカナ）＿姓は全角で入力してください。")
	@Size(min = 1, max = 15, message = "社員名（カタカナ）＿姓は15以下で入力してください。")
    private String firstNameKana;
	@NotBlank(message = "社員名（カタカナ）＿名を入力してください")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "社員名（カタカナ）＿名は全角で入力してください。")
	@Size(min = 1, max = 15, message = "社員名（カタカナ）＿名は15以下で入力してください。")
    private String lastNameKana;
	@NotBlank(message = "社員名（英語）＿姓を入力してください")
	@Pattern(regexp = "^[A-Za-z]+$", message = "社員名（英語）＿姓は[A-Z]、[a-z]で入力してください。")
	@Size(min = 1, max = 30, message = "社員名（英語）＿姓は30以下で入力してください。")
    private String firstNameEigo;
	@NotBlank(message = "社員名（英語）＿名を入力してください")
	@Pattern(regexp = "^[A-Za-z]+$", message = "社員名（英語）＿名は[A-Z]、[a-z]で入力してください。")
	@Size(min = 1, max = 30, message = "社員名（英語）＿名は30以下で入力してください。")
    private String lastNameEigo;
//    性別
    private Integer seibetu;
//    誕生日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date tanjyobi;
//    国籍
    private Integer kokuseki;
//    出身地
    @Size(min = 0, max = 30, message = "出身地は30以下で入力してください。")
    private String syussinn;
//    配偶者有り無し
    private int haigusya;
//    パスポート番号
	@Pattern(regexp = "^[A-Z0-9]+$", message = "パスポート番号は[A-Z]、[0-9]で入力してください。")
	@Size(min = 0, max = 20, message = "パスポート番号は20以下で入力してください。")
    private String passportNum;
//  パスポート有効日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date passportEndDate;
//    ビザ期間
    private Integer visaKikan;
//    ビザ有効日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date visaEndDate;
//    在留資格名称
    private Integer zairyuSikaku;
//    マイナンバー
    @Pattern(regexp = "^[A-Z0-9]+$", message = "マイナンバーは[A-Z]、[0-9]で入力してください。")
	@Size(min = 0, max = 20, message = "マイナンバーは20以下で入力してください。")
    private String kojinNum;
//    在留番号
    @Pattern(regexp = "^[A-Z0-9]+$", message = "在留番号は[A-Z]、[0-9]で入力してください。")
	@Size(min = 0, max = 20, message = "在留番号は20以下で入力してください。")
    private String zairyuNum;
//    所属会社
    private Integer syozokuKaisya;
//    入社日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date nyuusyaDate;
//    退社日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date taisyaDate;
//    職業種類
    private Integer syokugyoKind;
//    来日時間
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date rainitiDate;
//    備考
    @Size(min = 0, max = 255, message = "備考は255以下で入力してください。")
    private String bikou;
//    日本の住所の郵便
    @Pattern(regexp = "^\\\\d{3}-\\\\d{4}$", message = "日本の住所の郵便は\\A\\d\\d\\d-\\d\\d\\d\\d\\zで入力してください。")
	@Size(min = 0, max = 8, message = "日本の住所の郵便は8以下で入力してください。")
    private String yuubin;
//    番地まで
    @Size(min = 0, max = 100, message = "番地までは100以下で入力してください。")
    private String jyusyo1;
//    マンション名・号室など
    @Size(min = 0, max = 100, message = "マンション名・号室などは100以下で入力してください。")
    private String jyusyo2;
//    最寄駅
    @Pattern(regexp = "^[\\u4E00-\\u9FFF\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "最寄駅は全角で入力してください。")
	@Size(min = 0, max = 30, message = "最寄駅は30以下で入力してください。")
    private String moyoriEki;
//    携帯電話
    @Pattern(regexp = "^\\\\A0\\\\d{1,4}-\\\\d{1,4}-\\\\d{4}\\\\z", message = "携帯電話は\\A0\\d{1,4}-\\d{1,4}-\\d{4}\\zで入力してください。")
	@Size(min = 0, max = 15, message = "携帯電話は15以下で入力してください。")
    private String tel;
//    メールアドレス
    @Email
    private String email;
//    WechatID
    @Size(min = 0, max = 50, message = "WechatIDは50以下で入力してください。")
    private String wechat;
//    LineID
    @Size(min = 0, max = 50, message = "LineIDは50以下で入力してください。")
    private String line;
//    母国住所
    @Size(min = 0, max = 255, message = "母国住所は255以下で入力してください。")
    private String bokokuJyusyo;
//    母国緊急連絡先
    @Size(min = 0, max = 255, message = "母国緊急連絡先は255以下で入力してください。")
    private String bokokuKinnkyuuRennraku;
//    最終学歴
    private Integer saisyuuGakureki;
//    学校名
    @Pattern(regexp = "^[\\u4E00-\\u9FFF]+|[\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "学校名は全角で入力してください。")
	@Size(min = 0, max = 100, message = "学校名は100以下で入力してください。")
    private String gakkouName;
//    専門
    @Pattern(regexp = "^[\\u4E00-\\u9FFF]+|[\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "専門は全角で入力してください。")
	@Size(min = 0, max = 100, message = "専門は100以下で入力してください。")
    private String sennmomName;
//    卒業年月日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sotugyoDate;
//    IT関連実務年数
    private Float gyumuNensu;
//    技術経験
    private String itOs;
    private String itGengo;
    private String itDb;
    private String itWebServer;
    private String itFw;
    private String itOther;
//    備考及び自己アピール
    private String itBikou;
//    社員コード
    @UniqueElements(message = "社員コードが重複しています")
    @NotBlank(message = "社員コードを入力してください")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "社員コードは[A-Z]、[a-z]、[0-9]で入力してください。")
	@Size(min = 1, max = 10, message = "社員コードは10以下で入力してください。")
    private String employeeCode;
//    コメント
    private String comment;
//    金融機関コード
    @Pattern(regexp = "^[0-9]+$", message = "金融機関コードは数字のみで入力してください。")
	@Size(min = 0, max = 10, message = "金融機関コードは10以下で入力してください。")
    private String kinyukikanCode;
//    金融機関名
    @Pattern(regexp = "^[\\u4E00-\\u9FFF]+|[\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "金融機関名は全角で入力してください。")
	@Size(min = 0, max = 50, message = "金融機関名は50以下で入力してください。")
    private String kinyukikanName;
//    支店名コード
    @Pattern(regexp = "^[0-9]+$", message = "支店名コードは数字のみで入力してください。")
	@Size(min = 0, max = 10, message = "支店名コードは10以下で入力してください。")
    private String sitenCode;
//    支店名
    @Pattern(regexp = "^[\\u4E00-\\u9FFF]+|[\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "支店名は全角で入力してください。")
	@Size(min = 0, max = 50, message = "支店名は50以下で入力してください。")
    private String sitenName;
//    口座種類
    private Integer kouzaKind;
//    口座番号
    @Pattern(regexp = "^[0-9]+$", message = "口座番号は数字のみで入力してください。")
	@Size(min = 0, max = 10, message = "口座番号は10以下で入力してください。")
    private String kouzaNum;
//    名義人
    @Pattern(regexp = "^[\\u4E00-\\u9FFF]+|[\\u3040-\\u309F\\u30A0-\\u30FF]+$", message = "名義人は全角で入力してください。")
	@Size(min = 0, max = 50, message = "名義人は50以下で入力してください。")
    private String meigiName;
//    論理削除フラグ
    private int deleteFlag;
//    登録日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date tourokubi;
//    更新日
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date kousinnbi;
}
