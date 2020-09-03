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
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>

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
      <jsp:include page="/includeFiles/sideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        
          <div class="container py-3">
          <div>
            <header class="px-4">
              <h3>글보기</h3>
              <div class="text-right">목록으로</div>
            </header>
          </div>

          <div>
            <main>
              <form>
                <div class="cardWrapper p-2">
                  <div class="card h-100">
                    <div class="card-body p-1">
                      <ul class="list-group list-group-flush h-100">
                        <li class="list-group-item">
                          <div class="row">
                            <div class="col-lg-12">
                              <h3 class="mt-3 ml-2 mb-0">제목입니다.</h3>
                              <h5 class="mt-2 ml-2">OOO 회원</h5>
                              <div class="row mt-2 ml-2 mb-0">
                                <div class="container pl-0 mb-0">
                                  <p class="text-muted mb-0 float-left">
                                    2020-08-27 17:28
                                  </p>
                                  <div class="row float-right">
                                    <p class="mb-0">
                                      조회수<span id="readnum" class=""
                                        >56 ｜</span
                                      >
                                    </p>
                                    <p class="mb-0 ml-2">
                                      추천수<span id="likenum" class=""
                                        >30 ｜</span
                                      >
                                    </p>
                                    <p class="mb-0 ml-2 mr-1">
                                      댓글<span id="commentnum" class=""
                                        >10</span
                                      >
                                    </p>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <div id="result"></div>
                        </li>
                      </ul>
                    </div>
                  </div>
                  <div class="card">
                    <div class="table-responsive">
                      <table class="table mb-0">
                        <tbody>
                          <tr>
                            <td class="text-left">
                              <p class="mb-0 ml-3">홍길동</p>
                            </td>
                            <td class="text-left" style="width: 60%">
                              <p class="mb-0">안녕하세요</p>
                            </td>
                            <td class="text-right">
                              <p class="text-muted mb-0">2020-08-25 12:40</p>
                            </td>
                          </tr>
                          <tr>
                            <td class="text-left">
                              <p class="mb-0 ml-3">아이유</p>
                            </td>
                            <td class="text-left" style="width: 60%">
                              <p class="mb-0">반갑습니다</p>
                            </td>
                            <td class="text-right">
                              <p class="text-muted mb-0">2020-08-24 11:30</p>
                            </td>
                          </tr>
                          <tr>
                            <td class="text-left">
                              <p class="mb-0 ml-3">아이유</p>
                            </td>
                            <td class="text-left" style="width: 60%">
                              <p class="mb-0">
                                반갑습니다 아이유입니다. 반갑습니다.
                                아이유입니다. 반갑습니다. 아이유입니다.
                                반갑습니다.아이유입니다.
                              </p>
                            </td>
                            <td class="text-right">
                              <p class="text-muted mb-0 mr-1">
                                2020-08-24 11:30
                                <a href="#"
                                  ><i
                                    class="fas fa-edit ml-1 mr-1 text-success"
                                  ></i
                                ></a>
                                <a href="#"
                                  ><i class="fas fa-times text-danger"></i
                                ></a>
                              </p>
                            </td>
                          </tr>

                          <tr>
                            <td colspan="3">
                              <ul
                                class="pagination justify-content-center mb-0"
                              >
                                <li class="page-item">
                                  <a class="page-link" href="#">이전</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">1</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">2</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">다음</a>
                                </li>
                              </ul>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="card">
                    <form>
                      <table>
                        <tr>
                          <td style="width: 85%">
                            <textarea
                              name=""
                              id=""
                              cols="30"
                              rows="5"
                              class="float-left"
                              style="width: 100%"
                            ></textarea>
                          </td>
                          <td>
                            <input
                              type="submit"
                              value="등록"
                              class="float-right"
                              style="width: 100%; height: 125px"
                            />
                          </td>
                        </tr>
                      </table>
                    </form>
                  </div>
                </div>
              </form>
            </main>
          </div>
        </div>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="/myPT/js/scripts.js"></script>
    <!-- 게시판 관련 -->
    <script src="/myPT/js/detail.js"></script>
  <script type="text/javascript" src="assets/summernote-0.8.18-dist/summernote-bs4.js"></script>
  <script src="assets/summernote-0.8.18-dist/lang/summernote-ko-KR.js"></script>
  </body>
</html>
