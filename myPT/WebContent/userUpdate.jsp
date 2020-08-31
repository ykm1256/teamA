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
    <title>템플릿</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/widget.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="includeFiles/sideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        <main>
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-7">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                  <div class="card-header">
                    <h3 class="text-center font-weight-light my-4">회원정보</h3>
                  </div>
                  <div class="card-body">
                    <form>
                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="userName"
                              >이름</label
                            >
                            <input
                              class="form-control py-2"
                              id="userName"
                              name="userName"
                              type="text"
                              required
                              disabled
                              value="홍길동"
                            />
                          </div>
                        </div>
                      </div>
                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="userNick"
                              >닉네임</label
                            >
                            <input
                              class="form-control py-2"
                              id="userNick"
                              name="userNick"
                              type="text"
                              required
                              disabled
                              value="길동이"
                            />
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="userEmail"
                              >이메일</label
                            >
                            <input
                              class="form-control py-2"
                              id="userEmail"
                              name="userEmail"
                              type="text"
                              required
                              disabled
                              value="hong@naver.com"
                            />
                          </div>
                        </div>
                      </div>
                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="inputPassword"
                              >비밀번호</label
                            >
                            <input
                              class="form-control py-4"
                              id="inputPassword"
                              type="password"
                              placeholder="Enter password"
                            />
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="inputConfirmPassword"
                              >비밀번호 확인</label
                            >
                            <input
                              class="form-control py-4"
                              id="inputConfirmPassword"
                              type="password"
                              placeholder="Confirm password"
                            />
                          </div>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="small mb-1" for="inputPassword"
                          >주소</label
                        >
                        <div class="form-row">
                          <div class="col-md-6">
                            <input
                              class="form-control"
                              id="inputPassword"
                              value="50432"
                            />
                          </div>
                          <div class="col-md-3 col-xs-12">
                            <a class="btn btn-outline-primary btn-block" href=""
                              >주소찾기</a
                            >
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-12">
                          <div class="form-group">
                            <input
                              class="form-control"
                              id="inputdetailaddress"
                              value="부산광역시 용소로 137번길 13 OO빌 302호"
                            />
                          </div>
                        </div>
                      </div>

                      <div class="form-row mt-4 mb-0">
                        <div class="col-md-6">
                          <div class="form-group">
                            <a
                              class="btn btn-primary btn-block"
                              href="login.html"
                              >수정</a
                            >
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group">
                            <a class="btn btn-light btn-block" href="login.html"
                              >취소</a
                            >
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="js/scripts.js"></script>
  </body>
</html>
