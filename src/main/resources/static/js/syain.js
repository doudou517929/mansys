$(document).ready(function() {
//	在職と非在職がいずれにしても、１つのチェックが必須
    var searchButton = $('#search');
    searchButton.click(function() {
        var zaisyaCheckbox = $('#zaisya');
        var taisyaCheckbox = $('#taisya');
        if (!zaisyaCheckbox.prop('checked') && !taisyaCheckbox.prop('checked')) {
            alert('在籍と非在籍がいずれにしても、１つのチェックが必須です。');
        }
    });
    /**
	 * 更新ボタンクリック,該当社員情報の「ID」を持ち、社員更新画面へ遷移する。
	 * 新規作成ボタン 社員登録画面へ遷移。
	 * 履歴書登録・更新ボタン:履歴書の登録があれば、「更新」表示/履歴書の登録がなければ、「登録」表示
	 * ログインユーザがシステム管理者のみ表示する
	 */
    function addRowToTable(tableBody, values) {
		var row = '<tr>' +
            '<td>' + values[1] + '</td>' +
            '<td>' + values[2] + '</td>' +
            '<td>' + values[3] + '</td>' +
            '<td>' + values[4] + '</td>' +
            '<td>' + values[5] + '</td>' +
            '<td>' + values[6] + '</td>' +
            '<td><a href="/syain/upload/rirekisyo?id=' + values[0] + '">登録</a></td>' +
            '<td>' +
            '<a href="/syain/update/syain?id=' + values[0] + '">更新</a>' +
            '<br>' +
            '<a href="#" class="delete-link" data-id="' + values[0] + '">削除</a>' +
            '</td>' +
            '</tr>';
        tableBody.append(row);
//        削除ボタンクリック
		$('.delete-link').last().on('click', function(e) {
		    e.preventDefault();
		    var confirmed = confirm("削除してもよろしいですか？");
		    if (confirmed) {
				var id = $(this).data('id');
			    $.ajax({
			      url: '/syain/delete/syain?id=' + id,
			      type: 'GET',
			      success: function(response) {
//					画面上では再検索し、最新の受注情報を表示する。
			        var tableBody = $("#syainTable tbody");
	                tableBody.empty();
	//                表示した社員情報の件数を表示
	                var cnt = response.length;
	                $('#cnt').text(cnt+"    ");
	                $.each(response, function(index, item) {
	                    var cnt = response.length;
	                    $('#cnt').text(cnt);
	                    $.each(response, function(i, item) {
	                        var values = Object.values(item);
	                        addRowToTable(tableBody, values);
	                    });
	                });
			      },
			      error: function(xhr, status, error) {
			        console.log('Error: ' + Status + ' ' + error);
			      }
			    });
			}    
		});
	}
//    検索条件により、検索し、結果を表示する
    $("#syainsearch").submit(function(event) {
		event.preventDefault();
		var btn = $('#search');
		btn.prop('click', false);
        var formData = $("#syainsearch").serialize();
        $.ajax({
            url: "/syain/search",
            method: "POST",
            data: formData,
            dataType: "json",
            success: function(response) {
                var tableBody = $("#syainTable tbody");
                tableBody.empty();
                var cnt = response.length;
                $('#cnt').text(cnt+"    ");
                $.each(response, function(index, item) {
//					表示した社員情報の件数を表示
                    var cnt = response.length;
                    $('#cnt').text(cnt);
                    $.each(response, function(i, item) {
                        var values = Object.values(item);
                        addRowToTable(tableBody, values);
                    });
                });
            },
            error: function(xhr, status, error) {
                console.log('Error: ' + Status + ' ' + error);
            }
        });
    });
    
    $.ajax({
        url: '/syain/show',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
			var link = $('a[href="/add_employee"]');
            link.attr('href', '/syain/upload/Syain');
            for (var key in data) {
//				所属会社プルダウンリスト情報の取得
                if (key == 'kaisya') {
                    var kaisya = data[key];
                    var kaisyaSelect = $('#kaisya');
                    $.each(kaisya, function(index, item) {
                        kaisyaSelect.append($('<option></option>').attr('value', item.category2).text(item.value1));
                    });
                    kaisyaSelect.append($('<option></option>').attr('value', 0).text("全て").attr('selected', true));
                }
//                職業種類プルダウンリスト情報の取得
                if (key == 'syokugyo') {
                    var syokugyo = data[key];
                    var syokugyoSelect = $('#syokugyo');
                    $.each(syokugyo, function (index, item) {
                        var option = $('<option></option>').attr('value', item.category3).text(item.value1);
                        if (item.category3 == '4') {
                            option.attr('selected', true);
                        }
                        syokugyoSelect.append(option);
                    });
                }
//                初期検索条件のどおり現有データを表示されました。
                if (key == 'syainTables') {
                    var cnt = data[key].length;
                    $('#cnt').text(cnt);
                    var tableBody = $("#syainTable tbody");
                    $.each(data[key], function(i, item) {
                        var values = Object.values(item);
                        addRowToTable(tableBody, values);
                    });
                }
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Error: ' + textStatus + ' ' + errorThrown);
        }
    });
});