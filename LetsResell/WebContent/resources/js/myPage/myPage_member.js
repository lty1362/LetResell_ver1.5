/* 프로필 관련  script*/

$(document).ready(function(){
	
	// 프로필 수정 > 저장버튼 click 이벤트
	$("#btn_updateMember").on("click", function(){
		$("#updateMemberForm").submit();
	});
	
});

$(document).ready(function(){
	
	// 비밀번호 변경 > 저장버튼 click 이벤트
	$("#btn_updatePwd").on("click", function(){
		$("#updatePwdForm").submit();
	});
	
});

$(document).ready(function(){
	
	// 회원 탈퇴 > 탈퇴버튼 click 이벤트
	$("#btn_updateMemStatus").on("click", function(){
		$("#updateMemStatusForm").submit();
	});

});

$(function(){
	
	var regName = /^[가-힣]{2,20}$/;
	
    $("#name").keyup(function(){

    	if($(this).val().length > 0){

	        if(regName.test($(this).val())){ // 특정패턴에 만족할경우
	            $("#result").css({"color":"black", "font-size":"12px", "font-weight":"lighter"}).html("사용가능한 형식입니다.");
	            $("#btn_updateMember").attr("disabled", true);
	        }else{ // 그게 아닐 경우
	            $("#result").css({"color":"red", "font-size":"12px", "font-weight":"lighter"}).html("사용할 수 없는 형식입니다.");
	            $("#btn_updateMember").attr("disabled", true);
	        }

    	}else{
    		$("#result").html("");
    	}

    });
});