// [a-z]、[A-Z]、[0-9]、「_」、「-」のみ ８～20文字
function checkUserCode(){
    var code = $("#userCode").val();
    var usernameRegex = /^[a-zA-Z0-9_-]+$/;
    if (code == "") {
        $("#userCode").addClass('is-invalid');
        $("#invalidusfeedback").text("ユーザコードを入力してください。");
        return false;
    }
    if (code.length < 8 || code.length > 20) {
        $("#userCode").addClass('is-invalid');
        $("#invalidusfeedback").text("ユーザコードは８～20文字以下で入力してください。");
        return false;
    }
    if (!usernameRegex.test(code)) {
		console.log("error usercode");
        $("#userCode").addClass('is-invalid');
        $("#invalidusfeedback").text("ユーザコードは[a-z]、[A-Z]、[0-9]、「_」、「-」で入力してください。");
        return false;
    }
    $("#userCode").removeClass('is-invalid');
    $("#userCode").addClass('is-valid');
    return true;
}

// [a-z]、[A-z]、[0-9]のみ ８～15文字
function checkPW() {
    var pw = $("#password").val();
    var pwRegex = /^[a-zA-Z0-9]+$/;
    if (pw == "") {
        $("#password").addClass('is-invalid');
        $("#invalidpwfeedback").text("パスワードを入力してください。");
        return false;
    }
    if (pw.length < 6 || pw.length > 15) {
        $("#password").addClass('is-invalid');
        $("#invalidpwfeedback").text("パスワードは6～15文字以下で入力してください。");
    }
    if (!pwRegex.test(pw)) {
		console.log("error pw");
        $("#password").addClass('is-invalid');
        $("#invalidpwfeedback").text("パスワード[a-z]、[A-Z]、[0-9]で入力してください。");
        return false;
    }
    $("#password").removeClass('is-invalid');
    $("#password").addClass('is-valid');
    return true;
}
// サーバ側でDBのユーザ管理情報テーブルと連携し、認証を行う
$(document).ready(function () {
    $("#loginForm").on("submit", function(event) {
        event.preventDefault();
        if (checkUserCode() && checkPW()) {
			var formData = $(this).serialize();
	        $.post('/login', formData)
	            .done(function(response) {
					console.log("start login")
	                window.location.href = '/syain/main';
	            })
	            .fail(function(xhr) {
	                var errorMessage = JSON.parse(xhr.responseText).error;
	                $('#error-message').text(errorMessage).show();
	            });
		}
    });
});
