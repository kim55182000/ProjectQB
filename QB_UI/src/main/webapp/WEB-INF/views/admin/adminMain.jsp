<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <style>
  	/*회준*/
	.wrapper-low {
	    display: inline-block;
	    margin-top: 20px;
	    padding-left: 15px;
	    padding-right: 15px;
	    padding-bottom: 0px;
	    padding-top: 0px;
	    width: 100%;
	}
	.pn-big {
	height: 300px;
	box-shadow: 0 2px 1px rgba(0, 0, 0, 0.2);
	}
	.weather-4 {
	background: #3cb371;
	}	
	.weather-4 i {
		color: white;
		margin-top: 30px;
		font-size: 70px;
	}
	.weather-4 h1 {
		margin-top: 10px;
		color: white;
		font-weight: 900;
	}
	.weather-4 .info {
		background: #f2f2f2;
	}
	.weather-4 .info i {
		font-size: 15px;
		color: #c2c2c2;
		margin-bottom: 0px;
		margin-top: 10px;
	}
	.weather-4 .info h3 {
		font-weight: 900;
		margin-bottom: 0px;
	}
	.weather-4 .info p {
		margin-left: 10px;
		margin-right: 10px;
		margin-bottom: 16px;
		color: #c2c2c2;
		font-size: 15px;
		font-weight: 700;
	}
  </style>
</head>

<body>
  <section id="main-content">
    <section class="wrapper">
      <div class="row mt">

        <!--  DATE PICKERS -->
        <div class="col-lg-12">
          <!--  MODALS -->
          <div class="showback">
            <!-- Button trigger modal -->
            <button class="btn btn-success" data-toggle="modal" data-target="#myModal">
              새 클래스 개설하기
            </button>

              <div class="col-sm-4 col-xs-4 pull-right">
                <div class="col-sm-4 col-xs-4 pull-right">
                  <button class="btn btn-success btn-block">
                    검색
                  </button>
                </div>
                <div class="col-sm-4 col-xs-4 pull-right">
                  <input type="text" class="form-control" placeholder="검색어를 입력">
                </div>
                <div class="col-sm-4 col-xs-4 pull-right">
                <select class="form-control">
                    <option>클래스명</option>
                    <option>강사</option>
                    <option>교육과목</option>
                  </select>
                </div>
              </div>

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">클래스 개설</h4>
                  </div>

                  <div class="modal-body">

                    <div class="form-panel">
                      <form action="#" class="form-horizontal style-form">
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">클래스명</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="클래스 명을 입력해주세요.">
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">수강기간</label>
                          <div class="col-md-10">
                            <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                              <input type="text" class="form-control dpd1" name="from">
                              <span class="input-group-addon"> 에서 </span>
                              <input type="text" class="form-control dpd2" name="to">
                            </div>
                            <span class="help-block">기간을 선택하세요.</span>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">강사명</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="강사님 이름을 입력해주세요.">
                          </div>
                        </div>
                      </form>
                      <!-- /form-panel -->
                    </div>
                    <!-- /col-lg-12 -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-primary">생성</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- /showback -->
        </section>

    <section class="wrapper-low">
      <h3><i class="fa fa-angle-right"></i> 강의 목록</h3>
      <div class="row mt">
        <div class="col-lg-12">
          <!-- weather-4 PANEL -->
              <div class="col-lg-3 col-md-3 col-sm-3 mb">
                <a href="adminClassInfo.do">
                <div class="weather-4 pn-big centered">
                  <i class="fa fa-desktop"></i>
                  <h1>JAVA</h1>
                  <div class="info">
                    <div class="row">
                      <h5 class="centered">클래스:비트캠프 - 자바 99기</h5>
                      <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                      <h5 class="centered">강사:홍길동</h5>
                      <div class="col-sm-6 col-xs-6 pull-right">
                        <p class="goright"><i class="fa fa-users"></i> 25명</p>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
              </div>
        <!-- weather-4 PANEL -->
            <div class="col-lg-3 col-md-3 col-sm-3 mb">
              <a href="adminClassInfo.do">
              <div class="weather-4 pn-big centered">
                <i class="fa fa-cog"></i>
                <h1>빅데이터</h1>
                <div class="info">
                  <div class="row">
                    <h5 class="centered">클래스:비트캠프 - 빅데이터 2기</h5>
                    <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                    <h5 class="centered">강사:장영실</h5>
                    <div class="col-sm-6 col-xs-6 pull-right">
                      <p class="goright"><i class="fa fa-users"></i> 20명</p>
                    </div>
                  </div>
                </div>
              </div>
            </a>
            </div>
          <!-- weather-4 PANEL -->
              <div class="col-lg-3 col-md-3 col-sm-3 mb">
                <a href="adminClassInfo.do">
                <div class="weather-4 pn-big centered">
                  <i class="fa fa-gamepad"></i>
                  <h1>AR/VR</h1>
                  <div class="info">
                    <div class="row">
                      <h5 class="centered">클래스:비트캠프 - AR/VR 17기</h5>
                      <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                      <h5 class="centered">강사:사임당</h5>
                      <div class="col-sm-6 col-xs-6 pull-right">
                        <p class="goright"><i class="fa fa-users"></i> 20명</p>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
              </div>
          <!-- weather-4 PANEL -->
              <div class="col-lg-3 col-md-3 col-sm-3 mb">
                <a href="adminClassInfo.do">
                <div class="weather-4 pn-big centered">
                  <i class="fa fa-keyboard-o"></i>
                  <h1>임베디드</h1>
                  <div class="info">
                    <div class="row">
                      <h5 class="centered">클래스:비트캠프 - 임베디드 7기</h5>
                      <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                      <h5 class="centered">강사:이순신</h5>
                      <div class="col-sm-6 col-xs-6 pull-right">
                        <p class="goright"><i class="fa fa-users"></i> 15명</p>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
              </div>
<!-- row -->
<!-- row -->
<!-- weather-4 PANEL -->
    <div class="col-lg-3 col-md-3 col-sm-3 mb">
      <a href="adminClassInfo.do">
      <div class="weather-4 pn-big centered">
        <i class="fa fa-desktop"></i>
        <h1>JAVA</h1>
        <div class="info">
          <div class="row">
            <h5 class="centered">클래스:비트캠프 - 자바 99기</h5>
            <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
            <h5 class="centered">강사:홍길동</h5>
            <div class="col-sm-6 col-xs-6 pull-right">
              <p class="goright"><i class="fa fa-users"></i> 25명</p>
            </div>
          </div>
        </div>
      </div>
    </a>
    </div>
<!-- weather-4 PANEL -->
  <div class="col-lg-3 col-md-3 col-sm-3 mb">
    <a href="adminClassInfo.do">
    <div class="weather-4 pn-big centered">
      <i class="fa fa-cog"></i>
      <h1>빅데이터</h1>
      <div class="info">
        <div class="row">
          <h5 class="centered">클래스:비트캠프 - 빅데이터 2기</h5>
          <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
          <h5 class="centered">강사:장영실</h5>
          <div class="col-sm-6 col-xs-6 pull-right">
            <p class="goright"><i class="fa fa-users"></i> 20명</p>
          </div>
        </div>
      </div>
    </div>
  </a>
  </div>
<!-- weather-4 PANEL -->
    <div class="col-lg-3 col-md-3 col-sm-3 mb">
      <a href="adminClassInfo.do">
      <div class="weather-4 pn-big centered">
        <i class="fa fa-gamepad"></i>
        <h1>AR/VR</h1>
        <div class="info">
          <div class="row">
            <h5 class="centered">클래스:비트캠프 - AR/VR 17기</h5>
            <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
            <h5 class="centered">강사:사임당</h5>
            <div class="col-sm-6 col-xs-6 pull-right">
              <p class="goright"><i class="fa fa-users"></i> 20명</p>
            </div>
          </div>
        </div>
      </div>
    </a>
    </div>
<!-- weather-4 PANEL -->
    <div class="col-lg-3 col-md-3 col-sm-3 mb">
      <a href="adminClassInfo.do">
      <div class="weather-4 pn-big centered">
        <i class="fa fa-keyboard-o"></i>
        <h1>임베디드</h1>
        <div class="info">
          <div class="row">
            <h5 class="centered">클래스:비트캠프 - 임베디드 7기</h5>
            <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
            <h5 class="centered">강사:이순신</h5>
            <div class="col-sm-6 col-xs-6 pull-right">
              <p class="goright"><i class="fa fa-users"></i> 15명</p>
            </div>
          </div>
        </div>
      </div>
    </a>
    </div>
    <!-- row -->
    <!-- row -->
    <!-- weather-4 PANEL -->
        <div class="col-lg-3 col-md-3 col-sm-3 mb">
          <a href="adminClassInfo.do">
          <div class="weather-4 pn-big centered">
            <i class="fa fa-desktop"></i>
            <h1>JAVA</h1>
            <div class="info">
              <div class="row">
                <h5 class="centered">클래스:비트캠프 - 자바 99기</h5>
                <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                <h5 class="centered">강사:홍길동</h5>
                <div class="col-sm-6 col-xs-6 pull-right">
                  <p class="goright"><i class="fa fa-users"></i> 25명</p>
                </div>
              </div>
            </div>
          </div>
        </a>
        </div>
    <!-- weather-4 PANEL -->
      <div class="col-lg-3 col-md-3 col-sm-3 mb">
        <a href="adminClassInfo.do">
        <div class="weather-4 pn-big centered">
          <i class="fa fa-cog"></i>
          <h1>빅데이터</h1>
          <div class="info">
            <div class="row">
              <h5 class="centered">클래스:비트캠프 - 빅데이터 2기</h5>
              <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
              <h5 class="centered">강사:장영실</h5>
              <div class="col-sm-6 col-xs-6 pull-right">
                <p class="goright"><i class="fa fa-users"></i> 20명</p>
              </div>
            </div>
          </div>
        </div>
      </a>
      </div>
    <!-- weather-4 PANEL -->
        <div class="col-lg-3 col-md-3 col-sm-3 mb">
          <a href="adminClassInfo.do">
          <div class="weather-4 pn-big centered">
            <i class="fa fa-gamepad"></i>
            <h1>AR/VR</h1>
            <div class="info">
              <div class="row">
                <h5 class="centered">클래스:비트캠프 - AR/VR 17기</h5>
                <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                <h5 class="centered">강사:사임당</h5>
                <div class="col-sm-6 col-xs-6 pull-right">
                  <p class="goright"><i class="fa fa-users"></i> 20명</p>
                </div>
              </div>
            </div>
          </div>
        </a>
        </div>
    <!-- weather-4 PANEL -->
        <div class="col-lg-3 col-md-3 col-sm-3 mb">
          <a href="adminClassInfo.do">
          <div class="weather-4 pn-big centered">
            <i class="fa fa-keyboard-o"></i>
            <h1>임베디드</h1>
            <div class="info">
              <div class="row">
                <h5 class="centered">클래스:비트캠프 - 임베디드 7기</h5>
                <h5 class="centered">교육기간:2018.05.28-2018.11.22</h5>
                <h5 class="centered">강사:이순신</h5>
                <div class="col-sm-6 col-xs-6 pull-right">
                  <p class="goright"><i class="fa fa-users"></i> 15명</p>
                </div>
              </div>
            </div>
          </div>
        </a>
        </div>
            </div>
          </div>
        </section>
        <!-- /wrapper-low -->
      </section>