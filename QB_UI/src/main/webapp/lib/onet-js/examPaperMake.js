/**
 * 18.10.10 현이 teacherMyExamPaper.js 파일 추가
 * 18.10.16 한결 선택문제 출제 및 삭제 
 */

jQuery(document).ready(function() {

	TaskList.initTaskWidget();
	
	/*선택문제 출제 + 문제 수 +카운트*/
	$('#pickQuestionBtn').click(function(){
		/*문제 수*/
		var sortable_li_num = $('#qnum').text();
		/*선택한 애들의 순서 지정할 배열 생성*/
		var selected = new Array();
		
		/*선택된 애들의 html 끌어오기*/
		$('input[name="checkbox[]"]:checked').each(function() {
			selected.push("<li><div class='row'>" 
					+ $(this).parents(".qnumdiv").parents(".questionDiv").html()
					+ "<hr><div class='col-lg-12 qscore'>배점:&nbsp; <input type='number' " +
							"class='form-control questionScoreInputTag' id='insertedQScore' name='quantity' min='1' max='5'  " +
							"onchange='plusqcore()' /><hr></div></div></li>");
			/*문제 수 +1*/
			sortable_li_num++;
		});
		/*오른쪽 구역으로 이동*/
		$('.task-list').append(selected);
		/*선택한 애들 선택해제*/
		$('input[name="checkbox[]"]:checked').prop('checked',false);
		/*이동한 문제수 만큼 문제 개수 카운트*/
		$('#qnum').text(sortable_li_num);
	});
	
	/*선택문제 삭제 + 문제 수 -카운트 / 점수 -카운트*/
	$('#pickQuestionDeleteBtn').click(function(){
		/*문제 수 / 점수값 가져오기*/
		var sortable_li_num = $('#qnum').text();
		var qc = Number($('#qcore').text());
		
		/*체크된 애들만 실행*/
		$('input[name="checkbox[]"]:checked').each(function() {
			/*선택문제 삭제부분*/
			$(this).closest("li").remove();
			sortable_li_num--;
			
			/*점수 -카운트*/
			qc = qc - Number($(this).parents('.qnumdiv').siblings(".qscore").children("#insertedQScore").val());
		});
		$('#qnum').text(sortable_li_num);
		$('#qcore').text(qc);
	});
	
	/*점수가 100점일때만 시험지생성 활성화*/
	$('#makeExamSubmitModalBtn').click(function(){
		if($('#qcore').text()==100){
			$('#makeExamSubmitModal').modal();
		}else{
			swal("현재 총 배점을 확인해주세요.\n총 배점이 100점일때만 시험지를 생성할 수 있습니다.");
		}
	});
	
	/*모달창 내부 임시저장 클릭시*/
	$('#pickQuestionTempSaveBtn').click(function(){
		if($('.exam-paper-name').val() == ""){
			swal("시험지 이름을 작성해주세요");
			$('.exam-paper-name').focus();
		}else if($('.exam-paper-desc').val() == ""){
			swal("시험지 설명을 입력하세요(ex.기초 자바문제");
			$('.exam-paper-desc').focus();
		}else{
			console.log("이제부터 데이터를 뿌려보자~");
			
			var examName = $('.exam-paper-name').val();
			var examDesc = $('.exam-paper-desc').val();
			var memId = $('.dpn1').val();
			console.log("시험지이름 및 기타 등등 설정 >> " + examName +"//"+examDesc + "\\" +memId);
			
			/*시험지 이름으로 시험지가 있는지 확인 >> 시험지 번호를 받아온다.*/
			var promise = $.ajax({
				url:"checkExam_paper.do",
				type:"get",
				data:{"exam_paper_name":$('.exam-paper-name').val()},
				success:function(data){
					console.log("1. 같은 값이 있는지 체크한다. 결과값은 >> " + data + " || 첫번째 checkExam_paper.do");
					if(data == ""){
						/*공백 >> 데이터 없음(null) >> 시험지를 만든다.*/
						console.log("2-1. data 값이 null 값이다. >> 새로운 시험지를 insert한다.")
						$.ajax({
							url:"examPaperInsert.do",
							type:"get",
							dataType:"json",
							data:{
								"exam_paper_name":examName, 
								"member_id":memId,
								"exam_paper_desc":examDesc
								},
							success:function(data){
								if(data == "0"){
									console.log("실패");
								}else if(data == "1"){
									console.log("성공");
								}
							},
							error:function(xml){
								swal("저장을 실패하였습니다.");
							}
						});
						/*만든 시험지 번호를 받아온다.*/
						/*$.ajax({
							url:"",
							type:"get",
							data:{"exam_paper_name":$('.exam-paper-name').val()},
							success:function(epn){
								console.log("3-1. 만든 시험지 번호를 받아온다. 시험지 번호는 [" + epn+ "] 이다. 두번째 checkExam_paper.do");
								받아온 시험지 번호로 시험지 문제 테이블에 문제를 넣는다.
								
							}
						});           이 방식은 받아오질 못하네..*/
						$('.selectedBox').find('input[name="checkbox[]"]').each(function(index){
							console.log("	시험지 번호 = " + epn);
							console.log("	문제번호 = "+$(this).val());
							console.log("	문제 배치번호 = " + (Number(index) + 1));
							var EQSeq=(Number(index) + 1);
							console.log("	점수 = "+$(this).parents('.qnumdiv').siblings('.qscore').find('#insertedQScore').val());
							$.ajax({
								url:"examQuestionInsert.do",
								type:"get",
								dataType:"json",
								data:{
									"exam_paper_num":epn,
									"question_num":$(this).val(),
									"exam_question_seq":EQSeq,
									"exam_question_score":$(this).parents('.qnumdiv').siblings('.qscore').find('#insertedQScore').val()
								},
								success:function(data){
									console.log(data);
								}
							});
							console.log("여기까지 시험지 번호를 받아와서 시험지 문제에 넣는 과정~ 이 여러번 나와야 함.");
						});
					} else{
						console.log("2-1. data값이 있다. data 값은 [" + data + "] 이다.")
						/*그 외... 데이터 있음 >> update*/
						$.ajax({
							url:"examPaperUpdate.do",
							type:"get",
							dataType:"json",
							data:{
								"exam_paper_name":examName, 
								"member_id":memId,
								"exam_paper_desc":examDesc,
								"exam_paper_num":data
							},
							success:function(data){
								console.log("업데이트 성공 >> " + data);
								if(data == "0"){
									console.log("0이면 실패인가?");
								}else if(data == "1"){
									console.log("1이면 성공이고?")
								}
							},
							error:function(xml){
								swal("업데이트 에러입니다.");
							}
						});
						$.ajax({
									url:"examQuestionDelete.do",
									type:"get",
									dataType:"json",
									data:{
										"exam_paper_num":data
										},
									success:function(Qnum){
										console.log("시험지 번호 ["+data+"] 값 애들 다 지움 >> "+Qnum);
									}
								});
						$('.selectedBox').find('input[name="checkbox[]"]').each(function(index){
							console.log("시험지 번호 = " + data);
							console.log("문제번호 = "+$(this).val());
							console.log("문제 배치번호 = " + index + 1);
							var EQSeq=(Number(index) + 1);
							console.log("점수 = "+$(this).parents('.qnumdiv').siblings('.qscore').find('#insertedQScore').val());
							var Score = $(this).parents('.qnumdiv').siblings('.qscore').find('#insertedQScore').val();
								/*insert자리*/
								$.ajax({
									url:"examQuestionInsert.do",
									type:"get",
									dataType:"json",
									data:{
										"exam_paper_num":data,
										"question_num":$(this).val(),
										"exam_question_seq":EQSeq,
										"exam_question_score":Score
									},
									success:function(data){
										console.log(data);
									}
								});
							});
					}
				},
				error:function(xml){
					swal("문제가 생겨부럿네");
				}
			});
			$('#pickQuestionTempSaveModal').modal('hide');
		}
	});
});

function plusqcore(){
	var qc = Number($('#qcore').val());
	$('.questionScoreInputTag').each(function(){
		if($(this).val()>101){
			swal("한 문제당 최대 배점은 5점까지 인정됩니다.");
			$(this).val(5);
			qc += Number(5);
		} else {
			qc += Number($(this).val());
		}
	});
		if(qc > 100){
			swal("총 점수가 100점이 넘을 수 없습니다.");
			$('#qcore').text(qc);
		}
		$('#qcore').text(qc);
};

$(function() {
	$("#sortable").sortable();
	$("#sortable").disableSelection();
});