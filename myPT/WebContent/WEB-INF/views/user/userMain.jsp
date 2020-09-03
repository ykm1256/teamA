<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>메인 페이지</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/widget.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="/includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="/includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="/includeFiles/userSideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        <main>
          <div class="container-fluid">
          	<h1 class="mt-4 mb-4">메인 페이지</h1>
            <div class="card-group text-center p-0" id="weekSchedule">
              <div class="card mb-4 p-0" id="week0">
                <div class="card-header bg-dark text-white">일요일</div>
                <div class="card-body">
                  <div class="card">
                    <div class="card-body p-0">쉬는 날</div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView0"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week1">
                <div class="card-header bg-dark text-white">월요일</div>
                <div class="card-body">
                  <div class="card bg-danger text-white">
                    <div class="card-body p-0">
                      PT
                      <a
                        class="small stretched-link pt-modal"
                        data-toggle="modal"
                        data-target="#PT"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView1"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week2">
                <div class="card-header bg-dark text-white">화요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView2"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week3">
                <div class="card-header bg-dark text-white">수요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView3"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week4">
                <div class="card-header bg-dark text-white">목요일</div>
                <div class="card-body">
                  <div class="card bg-danger text-white">
                    <div class="card-body p-0">
                      PT
                      <a
                        class="small stretched-link pt-modal"
                        data-toggle="modal"
                        data-target="#PT"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView4"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week5">
                <div class="card-header bg-dark text-white">금요일</div>
                <div class="card-body">
                  <div class="card bg-light">
                    <div class="card-body p-0">
                      프로그램
                      <a
                        class="small stretched-link"
                        data-toggle="modal"
                        data-target="#program"
                        href="#"
                      ></a>
                    </div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView5"
                >
                  전체보기
                </div>
              </div>
              <div class="card mb-4 p-0" id="week6">
                <div class="card-header bg-dark text-white">토요일</div>
                <div class="card-body">
                  <div class="card">
                    <div class="card-body p-0">쉬는 날</div>
                  </div>
                </div>
                <div
                  class="card-footer clickable-row"
                  data-toggle="modal"
                  data-target="#schedule"
                  style="display: none"
                  id="weekView6"
                >
                  <b>전체보기</b>
                </div>
              </div>
            </div>
            <div class="card mb-4">
              <div class="card-header bg-dark text-white">
                <i class="fas fa-chart-area mr-1"></i>
                Personal Trainning
              </div>
              <div class="card-body">
                <ul class="list-group">
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">남은 횟수</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div
                            class="widget-numbers"
                            style="color: #3ac47d !important"
                          >
                            20회
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">담당 트레이너</div>
                          <div class="widget-subheading">서브글</div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-primary">김갑환</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">시작일자</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-warning">
                            2020.08.01
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">종료일자</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-dark">2020.11.01</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">조절 체중</div>
                          <div class="widget-subheading">조절</div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-danger">-10KG</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </main>
      </div>
      
      <!-- 모달 -->
      <jsp:include page="/includeFiles/modalUserMain.jsp"></jsp:include>
      <!-- /모달 -->
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="js/scripts.js"></script>
  </body>
</html>
