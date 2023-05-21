$(document).ready(function() {
	function fillDataByName(list, addButton, key) {
		for (var j = 0; j < list.length; j++) {
			addButton.trigger("click");
			var Obj = list[j];
			for (var prop in Obj) {
				if (Obj.hasOwnProperty(prop)) {
					var attrName = prop;
					var attrValue = syainKyuyoObj[prop];
					var ele = $('[name="syainKyuyo['+j+'].' + attrName + '"]');
					if (ele.length > 0) {
						ele.val(attrValue);
					}
				}
			}
		}
	}
	$.ajax({
		url: '/syain/load/syaindata',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
			if (data.hasOwnProperty('addSyainDTO')) {
			  var updateData = data['addSyainDTO'];
			  for (var i = 0; i < updateData.length; i++) {
				  var item = updateData[i];
				  var key = Object.keys(item)[0];
				  var value = item[key];
//				  社員_給与
				  if (key == "syainKyuyo") {
					  var addButton = $("#addSyainKyuyo");
					  fillDataByName(value, addButton, key);
				  } else if (key == "syainRireki") {
//					  社員_履歴
					  var syainRirekiList = value;
					  
				  } else if (key == "syainSyokurekis") {
//					  職歴
					  var addButton = $("#addSyokureki");
					  fillDataByName(value, addButton, key);
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else if (key == "syainSyokurekis") {
					  
				  } else {
					  var syainMain = value;
					  for (var prop in syainMain) {
						  var ele = $("#" + prop);
						  if (syainMain.hasOwnProperty(prop) && ele) {
							  var propValue = syainMain[prop];
							  ele.val(propValue);
						  } else if (syainMain.hasOwnProperty(prop) && $('[name="' + key + '"]').length > 0) {
							  var propValue = syainMain[prop];
							  $('[name="' + key + '"]').val(propValue);
						  }
					  }
				  }
					  
				  
			  }
		  }
		},
		error: function(jqXHR, textStatus, errorThrown) {
          console.log('Error: ' + textStatus + ' ' + errorThrown);
        }
	});
});