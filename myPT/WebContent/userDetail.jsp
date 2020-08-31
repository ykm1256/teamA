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
      <jsp:include page="includeFiles/adminSideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        <main>
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-8">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                  <div class="card-header">
                    <h3 class="text-center font-weight-light my-4">
                      회원 관리
                    </h3>
                  </div>

                  <div class="card-body">
                    <form>
                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="trainerID"
                              >아이디</label
                            >
                            <input
                              class="form-control py-2"
                              id="trainerID"
                              name="trainerID"
                              type="text"
                              required
                              disabled
                              value="M951021"
                            />
                          </div>
                        </div>
                      </div>

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
                            />
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="gender">성별</label>
                            <select
                              class="form-control"
                              id="gender"
                              name="gender"
                              required
                            >
                              <option value="남성" selected>남성</option>
                              <option value="여성">여성</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="birthdate"
                              >생년월일</label
                            >
                            <input
                              class="form-control py-2"
                              id="birthdate"
                              name="birthdate"
                              type="date"
                              required
                            />
                          </div>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="small mb-1" for="nickname">닉네임</label>
                        <div class="form-row">
                          <div class="col-md-9">
                            <input
                              class="form-control py-2 mb-sm-2"
                              id="nickname"
                              name="nickname"
                              type="text"
                              required
                            />
                          </div>
                          <div class="col-md-3">
                            <button
                              class="btn btn-outline-primary btn-block"
                              type="button"
                            >
                              중복확인
                            </button>
                          </div>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="small mb-1" for="email">이메일</label>
                        <div class="form-row">
                          <div class="col-md-9">
                            <input
                              class="form-control py-2 mb-sm-2"
                              id="email"
                              name="email"
                              type="email"
                              aria-describedby="emailHelp"
                              required
                            />
                          </div>
                          <div class="col-md-3">
                            <button
                              type="button"
                              class="btn btn-outline-primary btn-block"
                            >
                              중복확인
                            </button>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="password"
                              >비밀번호</label
                            >
                            <input
                              class="form-control py-2"
                              id="password"
                              name="password"
                              type="password"
                              required
                            />
                            <div class="checkMessage1 d-none">
                              입력한 비밀번호가 다릅니다
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="confirmPassword"
                              >비밀번호 확인</label
                            >
                            <input
                              class="form-control py-2"
                              id="confirmPassword"
                              type="password"
                              required
                            />
                            <div class="checkMessage2 d-none">
                              입력한 비밀번호가 다릅니다
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="small mb-1" for="address">주소</label>
                        <div class="form-row">
                          <div class="col-md-9 mb-sm-2">
                            <input
                              class="form-control py-2"
                              id="zipcode"
                              name="zipcode"
                              type="text"
                            />
                          </div>
                          <div class="col-md-3">
                            <button
                              class="btn btn-outline-primary btn-block"
                              type="button"
                            >
                              주소찾기
                            </button>
                          </div>
                        </div>
                        <input
                          class="form-control py-2 mb-2"
                          id="address"
                          name="address"
                          type="text"
                        />
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="trainer"
                              >담당 트레이너</label
                            >
                            <select
                              class="form-control"
                              id="trainer"
                              name="trainer"
                            >
                              <option value="0" selected>미정</option>
                              <option value="1">트레이너1</option>
                              <option value="2">트레이너2</option>
                              <option value="3">트레이너3</option>
                              <option value="4">트레이너4</option>
                            </select>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="startDate"
                              >시작일</label
                            >
                            <input
                              class="form-control py-2"
                              id="startDate"
                              name="startDate"
                              type="date"
                              required
                            />
                          </div>
                        </div>
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="startDate"
                              >만료일</label
                            >
                            <input class="form-control py-2" id="endDate""
                            name="endDate" type="date" required/>
                          </div>
                        </div>
                      </div>

                      <div class="form-row">
                        <div class="col-md-6">
                          <div class="form-group">
                            <label class="small mb-1" for="remainNum"
                              >남은횟수</label
                            >
                            <input
                              class="form-control py-2"
                              id="remainNum"
                              name="remainNum"
                              type="number"
                              min="0"
                              required
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
