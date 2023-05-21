$(document).ready(function() {
//	入力チェックを行う。

	var gyomukuCount = 0;
	const items = {};
	
//	items.employeeCode = {
//		code: "employeeCode",
//		required: 1,
//		str: "社員コード",
//		regex: "^[A-Za-z0-9]+$",
//		regexstr: "[A-Z]、[a-z]、[0-9]",
//		len: 10,
//		feedback: "invalidCodefeedback",
//	};
//	items.firstNameKanji = {
//		code: "firstNameKanji",
//		required: 1,
//		str: "社員名（漢字）＿姓",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 15,
//		feedback: "invalidKanjiSeifeedback",
//	};
//	items.lastNameKanji = {
//		code: "lastNameKanji",
//		required: 1,
//		str: "社員名（漢字）＿名",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 15,
//		feedback: "invalidKanjiMeifeedback",
//	};
//	
//	items.fitNameKana = {
//		code: "firstNameKana",
//		required: 1,
//		str: "社員名（カタカナ）＿姓",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 15,
//		feedback: "invalidKanaSeifeedback",
//	};
//	items.lastNameKana = {
//		code: "lastNameKana",
//		required: 1,
//		str: "社員名（カタカナ）＿名",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 15,
//		feedback: "invalidKanaMeifeedback",
//	}; 
//	items.firstNameEigo = {
//		code: "firstNameEigo",
//		required: 1,
//		str: "社員名（英語）＿姓",
//		regex: "^[A-Za-z]+$",
//		regexstr: "[A-Z]、[a-z]",
//		len: 30,
//		feedback: "invalidEngSeifeedback",
//	}; 
//	items.lastNameEigo = {
//		code: "lastNameEigo",
//		required: 1,
//		str: "社員名（英語）＿名",
//		regex: "^[A-Za-z]+$",
//		regexstr: "[A-Z]、[a-z]",
//		len: 30,
//		feedback: "invalidEngMeifeedback",
//	}; 
	items.syussinn = {
		code: "syussinn",
		required: 0,
		str: "出身地",
		regex: "",
		regexstr: "",
		len: 30,
		feedback: "invalidsyussinnfeedback",
	}; 
	items.ssportNum = {
		code: "passportNum",
		required: 0,
		str: "パスポート番号",
		regex: "^[A-Z0-9]+$",
		regexstr: "[A-Z]、[0-9]",
		len: 20,
		feedback: "invalidpassportNumfeedback",
	}; 
	items.kojinNum = {
		code: "kojinNum",
		required: 0,
		str: "マイナンバー",
		regex: "^[A-Z0-9]+$",
		regexstr: "[A-Z]、[0-9]",
		len: 20,
		feedback: "invalidkojinNumfeedback",
	}; 
	items.zairyuNum = {
		code: "zairyuNum",
		required: 0,
		str: "在留番号",
		regex: "^[A-Z0-9]+$",
		regexstr: "[A-Z]、[0-9]",
		len: 20,
		feedback: "invalidzairyuNumfeedback",
	}; 
	items.bikou = {
		code: "bikou",
		required: 0,
		str: "備考",
		regex: "",
		regexstr: "",
		len: 255,
		feedback: "invalidbikoufeedback",
	}; 
	items.yuubin = {
		code: "yuubin",
		required: 0,
		str: "日本の住所の郵便",
		regex: "",
		regexstr: "",
		len: 8,
		feedback: "invalidyuubinfeedback",
	}; 
	items.syussinn = {
		code: "jyusyo1",
		required: 0,
		str: "番地まで",
		regex: "",
		regexstr: "",
		len: 100,
		feedback: "invalidjyusyo1feedback",
	}; 
	items.jyusyo2 = {
		code: "jyusyo2",
		required: 0,
		str: "マンション名・号室など",
		regex: "",
		regexstr: "",
		len: 100,
		feedback: "invalidjyusyo2feedback",
	}; 
	items.moyoriEki = {
		code: "moyoriEki",
		required: 0,
		str: "最寄駅",
		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
		regexstr: "全角",
		len: 30,
		feedback: "invalidmoyoriEkifeedback",
	}; 
	items.tel = {
		code: "tel",
		required: 0,
		str: "携帯電話",
		regex: "^\\A0\\d{1,4}-\\d{1,4}-\\d{4}\\z",
		regexstr: "\A0\d{1,4}-\d{1,4}-\d{4}\z",
		len: 15,
		feedback: "invalidtelfeedback",
	}; 
	items.email = {
		code: "email",
		required: 0,
		str: "メールアドレス",
		regex: "^\\[A-Z0-9._%+-\]+@[A-Z0-9.-\]+\\.[A-Z]{2,4}\\z",
		regexstr: "\A[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\z",
		len: 15,
		feedback: "invalidemailfeedback",
	}; 
	items.wechat = {
		code: "wechat",
		required: 0,
		str: "WechatID",
		regex: "",
		regexstr: "",
		len: 50,
		feedback: "invalidwechatfeedback",
	}; 
	items.line = {
		code: "line",
		required: 0,
		str: "LineID",
		regex: "",
		regexstr: "",
		len: 50,
		feedback: "invalidlinefeedback",
	}; 
	items.bokokuJyusyo = {
		code: "bokokuJyusyo",
		required: 0,
		str: "母国住所",
		regex: "",
		regexstr: "",
		len: 255,
		feedback: "invalidbokokuJyusyofeedback",
	}; 
	items.bokokuKinnkyuuRennraku = {
		code: "bokokuKinnkyuuRennraku",
		required: 0,
		str: "母国緊急連絡先",
		regex: "",
		regexstr: "",
		len: 255,
		feedback: "invalidbokokuKinnkyuuRennrakufeedback",
	}; 
	items.gakkouName = {
		code: "gakkouName",
		required: 0,
		str: "学校名",
		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
		regexstr: "全角",
		len: 100,
		feedback: "invalidgakkouNamefeedback",
	}; 
	items.sennmomName = {
		code: "sennmomName",
		required: 0,
		str: "専門",
		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
		regexstr: "全角",
		len: 100,
		feedback: "invalidsennmomNamefeedback",
	}; 
	items.itBikou = {
		code: "itBikou",
		required: 0,
		str: "備考及び自己アピール",
		regex: "",
		regexstr: "",
		len: 1024,
		feedback: "invaliditBikoufeedback",
	}; 
//	items.kinyukikanCode = {
//		code: "kinyukikanCode",
//		required: 0,
//		str: "金融機関コード",
//		regex: "^[0-9]+$",
//		regexstr: "数字のみ",
//		len: 10,
//		feedback: "invalidkinyukikanCodefeedback",
//	}; 
//	items.kinyukikanName = {
//		code: "kinyukikanName",
//		required: 0,
//		str: "金融機関名",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 50,
//		feedback: "invalidkinyukikanNamefeedback",
//	}; 
//	items.sitenCode = {
//		code: "sitenCode",
//		required: 0,
//		str: "支店名コード",
//		regex: "^[0-9]+$",
//		regexstr: "数字のみ",
//		len: 10,
//		feedback: "invalidsitenCodefeedback",
//	}; 
//	items.sitenName = {
//		code: "sitenName",
//		required: 0,
//		str: "支店名",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 50,
//		feedback: "invalidsitenNamefeedback",
//	}; 
//	items.kouzaNum = {
//		code: "kouzaNum",
//		required: 0,
//		str: "口座番号",
//		regex: "^[0-9]+$",
//		regexstr: "数字のみ",
//		len: 10,
//		feedback: "invalidkouzaNumfeedback",
//	}; 
//	items.meigiName = {
//		code: "meigiName",
//		required: 0,
//		str: "名義人",
//		regex: "^[\u4E00-\u9FFF]+|[\u3040-\u309F\u30A0-\u30FF]+$",
//		regexstr: "全角",
//		len: 50,
//		feedback: "invalidmeigiNamefeedback",
//	}; 
//	プルダウンリストの情報を取得し、プルダウンリストにセットする
	$.ajax({
    	url: '/syain/load/syainitems',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
          for (var key in data) {
            if (key == 'kokuseki') {
              var kokuseki = data[key];
              var kokusekiSelect = $('#kokuseki');
              addSelect(kokuseki, kokusekiSelect);
            }
            if (key == 'visaKikan') {
              var visaKikan = data[key];
              var visaKikanSelect = $('#visaKikan');
              addSelect(visaKikan, visaKikanSelect);
            }
            if (key == 'zairyuShikaku') {
              var zairyuShikaku = data[key];
              var zairyuShikakuSelect = $('#zairyuShikaku');
              addSelect(zairyuShikaku, zairyuShikakuSelect);
            }
            if (key == 'syozokuKaisya') {
              var syozokuKaisya = data[key];
              var syozokuKaisyaSelect = $('#syozokuKaisya');
              $.each(syozokuKaisya, function(index, item) {
                syozokuKaisyaSelect.append($('<option></option>').attr('value', item.category2).text(item.value1));
              });
              syozokuKaisyaSelect.append($('<option></option>').text("").attr('selected', true));
            }
            if (key == 'syokugyoKind') {
              var syokugyoKind = data[key];
              var syokugyoKindSelect = $('#syokugyoKind');
              addSelect(syokugyoKind, syokugyoKindSelect);
            }
            if (key == 'saisyuuGakureki') {
              var saisyuuGakureki = data[key];
              var saisyuuGakurekiSelect = $('#saisyuuGakureki');
              addSelect(saisyuuGakureki, saisyuuGakurekiSelect);
            }
            if (key == 'OS') {
              var OS = data[key];
              var OSTable = $('#itOstable tbody');
              itSelect(OSTable, OS);
            }
            if (key == 'gengo') {
              var gengo = data[key];
              var gengoTable = $('#itGengotable tbody');
              itSelect(gengoTable, gengo);
            }
            if (key == 'DB') {
              var DB = data[key];
              var DBTable = $('#itDbtable tbody');
              itSelect(DBTable, DB);
            }
            if (key == 'WebServer') {
              var WebServer = data[key];
              var WebServerTable = $('#itWebServertable tbody');
              itSelect(WebServerTable, WebServer);
            }
            if (key == 'FW') {
              var FW = data[key];
              var FWTable = $('#itFwtable tbody');
              itSelect(FWTable, FW);
            }
            if (key == 'Other') {
              var Other = data[key];
              var OtherTable = $('#itOthertable tbody');
              itSelect(OtherTable, Other);
            }
          }
          
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log('Error: ' + textStatus + ' ' + errorThrown);
        }
      });
//      技術経験
      function addSelect(label, labelSelect) {
        $.each(label, function(index, item) {
          labelSelect.append($('<option></option>').attr('value', item.category3).text(item.value1));
        });
        labelSelect.append($('<option></option>').text("").attr('selected', true));
      }
      /**
	   * 技術経験情報を取得し、技術履歴リストに導入
	   * 技術経験は「-」区切って、IDと経験レベルを記入
	   */
      function itSelect(table, contents) {
        var cnt = 5;
        var rows = contents.length;
        table.find('td.table-label').attr('rowspan', rows);
        $.each(contents, function(index, item) {
          if (cnt == 0) {
            cnt = 5;
            table.append('<tr></tr>');
          }
          var val = item.category3;
          var title = item.value1;
          var newCell = '<td class="custom-td"><div class="d-inline"><span>' +
                  title +
                  '</span></div><div class="d-inline float-right"><select class="form-select">' +
                  '<option value="" selected="selected"></option>' +
                  '<option value="' + val +
                  '-1">◎</option><option value="' + val +
                  '-2">○</option><option value="' + val +
                  '-3">△</option></select></div></td>';
          table.find('tr:last').append(newCell);
          cnt -= 1;
        });
        if (cnt != 0) {
          for (var i = cnt; i > 0; i--) {
            var newCell = $('<td>').addClass('custom-td');
            table.find('tr:last').append(newCell);
          }
        }
      }
//      「,」区切って、複数技術経験登録する
      function fillIt(name) {
		var t = name+"table select";
        var selectValues = '';
        $('#'+t).each(function() {
          if($(this).val() !== '') {
            selectValues += $(this).val() + ',';
          }
        });
        $('#'+name).val(selectValues);
      }
//      作業範囲
      function fillsagyohani() {
		  var selectValues = "";
		  for (var i=0; i<gyomukuCount; i++) {
			  selectValues = selectValues+
			  $("#you"+i).val()+
			  $("#cyo"+i).val()+
			  $("#ki"+i).val()+
			  $("#syo"+i).val()+
			  $("#cd"+i).val()+
			  $("#dan"+i).val()+
			  $("#ketu"+i).val()+
			  $("#zou"+i).val()+
			  $("#gou"+i).val()+
			  $("#bou"+i).val();
			  $("#sagyohani"+i).val(selectValues);
		  }
	  }
//	  給与口座入力項目一覧
      $("#addSyainKyuyo").click(function() {
        let rowCount = $("#syainKyuyo-body tbody tr").length;
		let newRow = `
		    <tr>
		      <td><input type="text" name="syainKyuyo[${rowCount}].kaishiNengetsu" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].syuryoNengetsu" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].kihonkyu" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].syokunoukyu" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].koyouHokenNo" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].nankinNo" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].nankinKijyunGaku" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].kenkouHokenNo" class="form-control invisible-input"></td>
		      <td><input type="text" name="syainKyuyo[${rowCount}].bikou" class="form-control invisible-input"></td>
		    </tr>`;
        $("#syainKyuyo tbody").append(newRow);
      });
      
      $("#deleteSyainKyuyo").click(function() {
        let rowCount = $("#syainKyuyo tbody tr").length;
        if (rowCount > 0) {
          $("#syainKyuyo tbody tr:last").remove();
        }
      });
      /**
	   * 職歴情報
	   * 新規行追加ボタンクリック,最後に新規行を追加します
	   */
      $("#addSyokureki").click(function () {
        let rowCount = $("#Syokureki tbody tr").length;
		let newRow = `
          <tr>
            <td><input type="text" name="syainSyokurekis[${rowCount}].nyusya" class="form-control invisible-input"></td>
            <td><input type="text" name="syainSyokurekis[${rowCount}].taisya" class="form-control invisible-input"></td>
            <td><input type="text" name="syainSyokurekis[${rowCount}].kaisya" class="form-control invisible-input"></td>
            <td><input type="text" name="syainSyokurekis[${rowCount}].busyo" class="form-control invisible-input"></td>
          </tr>`;
        $("#Syokureki tbody").append(newRow);
      });
      $("#deleteSyokureki").click(function() {
        let rowCount = $("#Syokureki tbody tr").length;
        if (rowCount > 0) {
          $("#Syokureki tbody tr:last").remove();
        }
      });
      /**
	   * 業務経歴
	   * 新規行追加ボタンクリック,最後に新規行を追加します
	   */
      $('#addGyomuku').click(function () { 
        var tableParent = $('#tableParent');
        let newTable = '<!--      行1-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">開始年月</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].kaisibi" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">終了年月</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].syuryobi" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1 table-cell table-label">PJ名</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].pjName" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1 table-cell table-label">対日</div>\n' +
                '        <div class="table-select-cell">\n' +
                '          <select class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki['+gyomukuCount+'].tainitiFlag">\n' +
                '            <option value="0" selected></option>\n' +
                '            <option value="1">○</option>\n' +
                '          </select>\n' +
                '        </div>\n' +
                '      </div>\n'+

                '      <!--        行2-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">開発場所</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="basyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki['+gyomukuCount+'].basyo"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">規模人数</div>\n' +
                '        <div class="col-1 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].kibo" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">開発業種</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="gyosyu'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki['+gyomukuCount+'].gyosyu"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">開発環境</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="kaihatuKankyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki['+gyomukuCount+'].kaihatukankyo"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">運用環境</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="unyouKankyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki['+gyomukuCount+'].unyoukankyo"></select>\n' +
                '        </div>\n' +
                '      </div>\n'+

                '<!--      行3-->\n' +
				'      <div class="row table-row">\n' +
				'        <div class="col-1.5 table-cell table-label">言語</div>\n' +
				'        <div class="col-2 table-cell">\n' +
				'          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].gengo" type="text">\n' +
				'        </div>\n' +
				'        <div class="col-1.5 table-cell table-label">DB</div>\n' +
				'        <div class="col-2 table-cell">\n' +
				'          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].db" type="text">\n' +
				'        </div>\n' +
				'        <div class="col-1.5 table-cell table-label" style="white-space: nowrap;">FW・IDE・ツール</div>\n' +
				'        <div class="col-2 table-cell">\n' +
				'          <input class="invisible-input" name="syainRireki['+gyomukuCount+'].tool" type="text">\n' +
				'        </div>\n' +
				'      </div>\n'+

				'<!--      行4-->\n' +
				'      <div class="row table-row" style="white-space: nowrap;">\n' +
				'        <div class="col-1 table-cell table-label">担当</div>\n' +
				'        <div class="col-1 table-cell"><input class="invisible-input" name="syainRireki['+gyomukuCount+'].tool" type="text"></div>\n' +
				'        <div class="col-1 table-cell table-label">作業範囲</div>\n' +
				'        <div class="table-cell-s">要</div>\n' +
				'        <div class="table-select-cell"><select id="you'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">調</div>\n' +
				'        <div class="table-select-cell"><select id="cyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">基</div>\n' +
				'        <div class="table-select-cell"><select id="ki'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">詳</div>\n' +
				'        <div class="table-select-cell"><select id="syo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">CD</div>\n' +
				'        <div class="table-select-cell"><select id="cd'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">単</div>\n' +
				'        <div class="table-select-cell"><select id="dan'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">結</div>\n' +
				'        <div class="table-select-cell"><select id="ketu'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">総</div>\n' +
                '		 <div class="table-select-cell"><select id="zou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option vvalueal="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">構</div>\n' +
				'        <div class="table-select-cell"><select id="gou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'        <div class="table-cell-s">保</div>\n' +
				'        <div class="table-select-cell"><select id="bou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
				'      </div>\n' +
				'<!--      行5-->\n' +
				'      <div class="row table-row">\n' +
				'        <div class="col-1.5 table-cell table-label">開発概要</div>\n' +
				'        <div class="table-cell">\n' +
				'          <textarea name="syainRireki['+gyomukuCount+'].gaiyou" rows="3"></textarea>\n' +
				'        </div>\n' +
				'      </div>\n' + 
				'<input id="sagyohani'+gyomukuCount+'" type="hidden" name="syainRireki['+gyomukuCount+'].sagyohani" />\n';

					    
        /*
        let newTable = '<!--      行1-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">開始年月</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].kaisibi" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">終了年月</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].syuryobi" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1 table-cell table-label">PJ名</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].pjName" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1 table-cell table-label">対日</div>\n' +
                '        <div class="table-select-cell">\n' +
                '          <select class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki[${'+gyomukuCount+'}].tainitiFlag">\n' +
                '            <option value="0" selected></option>\n' +
                '            <option value="1">○</option>\n' +
                '          </select>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '      <!--        行2-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">開発場所</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="basyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki[${'+gyomukuCount+'}].basyo"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">規模人数</div>\n' +
                '        <div class="col-1 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].kibo}" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">開発業種</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="gyosyu'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki[${'+gyomukuCount+'}].gyosyu"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">開発環境</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="kaihatuKankyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki[${'+gyomukuCount+'}].kaihatuKankyo"></select>\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">運用環境</div>\n' +
                '        <div class="col-1 table-select-cell">\n' +
                '          <select id="unyouKankyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select" name="syainRireki[${'+gyomukuCount+'}].unyouKankyo"></select>\n' +
                '        </div>\n' +
                '      </div>\n' +
                '<!--      行3-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">言語</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].gengo" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label">DB</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].db" type="text">\n' +
                '        </div>\n' +
                '        <div class="col-1.5 table-cell table-label" style="white-space: nowrap;">FW・IDE・ツール</div>\n' +
                '        <div class="col-2 table-cell">\n' +
                '          <input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].tool" type="text">\n' +
                '        </div>\n' +
                '      </div>\n' +
                '<!--      行4-->\n' +
                '      <div class="row table-row" style="white-space: nowrap;">\n' +
                '        <div class="col-1 table-cell table-label">担当</div>\n' +
                '        <div class="col-1 table-cell"><input class="invisible-input" name="syainRireki[${'+gyomukuCount+'}].tool" type="text"></div>\n' +
                '        <div class="col-1 table-cell table-label">作業範囲</div>\n' +
                '        <div class="table-cell-s">要</div>\n' +
                '        <div class="table-select-cell"><select id="you'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">調</div>\n' +
                '        <div class="table-select-cell"><select id="cyo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">基</div>\n' +
                '        <div class="table-select-cell"><select id="ki'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">詳</div>\n' +
                '        <div class="table-select-cell"><select id="syo'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">CD</div>\n' +
                '        <div class="table-select-cell"><select id="cd'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">単</div>\n' +
                '        <div class="table-select-cell"><select id="dan'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">結</div>\n' +
                '        <div class="table-select-cell"><select id="ketu'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">総</div>\n' +
                '        <div class="table-select-cell"><select id="zou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option vvalueal="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">構</div>\n' +
                '        <div class="table-select-cell"><select id="gou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '        <div class="table-cell-s">保</div>\n' +
                '        <div class="table-select-cell"><select id="bou'+gyomukuCount+'" class="form-select form-select-sm d-inline w-auto custom-select"><option value="0" selected></option><option value="1">○</option></select></div>\n' +
                '      </div>\n' +
                '<!--      行5-->\n' +
                '      <div class="row table-row">\n' +
                '        <div class="col-1.5 table-cell table-label">開発概要</div>\n' +
                '        <div class="table-cell">\n' +
                '          <textarea name="syainRireki[${'+gyomukuCount+'}].gaiyou" rows="3"></textarea>\n' +
                '        </div>\n' +
                '      </div>\n' + 
                '<input id="sagyohani'+gyomukuCount+'" type="hidden" name="syainRireki[${'+gyomukuCount+'}].sagyoHani" />\n';
                */
        tableParent.append(newTable);
        $.ajax({
			url:'/syain/upload/rireki',
			type:'get',
			dataType:'json',
			success: function(data) {
				for (var key in data) {
					if (key == 'basyo') {
						var basyo = data[key];
						var basyoSelect = $('#basyo'+gyomukuCount);
						addSelect(basyo, basyoSelect);
					}
					if (key == 'gyosyu') {
						var gyosyu = data[key];
						var gyosyuSelect = $('#gyosyu'+gyomukuCount);
						addSelect(gyosyu, gyosyuSelect);
					}
					if (key == 'kaihatuKankyo') {
						var kaihatuKankyo = data[key];
						var kaihatuKankyoSelect = $('#kaihatuKankyo'+gyomukuCount);
						addSelect(kaihatuKankyo, kaihatuKankyoSelect);
					}
					if (key == 'unyouKankyo') {
						var unyouKankyo = data[key];
						var unyouKankyoSelect = $('#unyouKankyo'+gyomukuCount);
						addSelect(unyouKankyo, unyouKankyoSelect);
					}
					
				}
				gyomukuCount++;
			},
			error: function(xhr, status, error) {
				console.log('Error: ' + textStatus + ' ' + errorThrown);
			}
		});
		
      });
      $('#deleteGyomuku').click(function () {
        for (let i = 0; i < 5; i++) {
          var lastTable = $('#tableParent .table-row:last');
          lastTable.remove();
        }
        gyomukuCount--;
      });
      /**
	   * 画面側でJSでチェックを行う
	   * エラーがある場合はエラーメッセージを表示しつつ自画面遷移
	   */
	  function check(item) {
		  var ele = $("#"+item.code);
		  var errele = $("#"+item.feedback);
		  if (item.required == 0 && ele.val() == "") {
			  return true;
//			  必須
		  } else if (item.required == 1 && ele.val() == "") {
			  ele.addClass('is-invalid');
	          errele.text(item.str+"を入力してください。");
	          return false;
		  }
		  checkLen(ele, item.len, item.str, errele);
		  if (item.regex != "") {
			  var r = new RegExp(item.regex);
			  if (!r.test(ele.val())) {
				  ele.addClass('is-invalid');
	          	  errele.text(item.str+"は"+item.regexstr+"で入力してください。");
				  return false;
			  }
		  }
		  
		  ele.removeClass('is-invalid').addClass('is-valid');
		  errele.text("");
		  return true;
	  }
	  function checkLen(ele, len, str, errele) {
		  if (ele.val().length > len) {
			  ele.addClass('is-invalid');
	          errele.text(str+"は"+len+"以下で入力してください。");
			  return false;
		  }
		  ele.removeClass('is-invalid').addClass('is-valid');
		  errele.text("");
		  return true;
	  }
	  
	  function checkAll() {
		  for (let key in items) {
			  const item = items[key];
			  if (!check(item)) {
				  $('html, body').animate({
					  scrollTop:$("#"+item.code).offset().top
			      }, 500);
				  return false;
			  }
		  }
		  
		  return true;
	  }
	  
      $("#addsyain").on("submit", function(event) {
        event.preventDefault();
        if (checkAll()) {
			fillIt("itOs");
	        fillIt("itGengo");
	        fillIt("itDb");
	        fillIt("itWebServer");
	        fillIt("itFw");
	        fillIt("itOther");
	        fillIt("itBikou");
	        fillsagyohani();
	        var formData = $("#addsyain").serialize();
	        $.ajax({
	          url: "/syain/upload/syaininfo",
	          method: "POST",
	          data: formData,
	          dataType: "json",
	          success: function(response) {
			  	console.log(response);
	          },
	          error: function(xhr, status, error) {
	            console.log('Error: ' + status + ' ' + error);
	          }
	        });
		}
        
    });
});