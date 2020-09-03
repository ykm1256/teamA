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
        <main>
          <div class="container-fluid mt-3">
          <!-- 여기서부터 작성 -->
          <div class="row">
              <div class="col-12">
                <div class="card" style="overflow: auto">
                  <div class="card-body">
                    <h3 class="card-title text-center">커뮤니티</h3>
                  </div>
                  <select class="form-control text-center col-md-2" id="head">
                    <option value="정보">정보</option>
                    <option value="잡담">잡담</option>
                  </select>
                  <div class="table-responsive">
                    <table class="table mb-0">
                      <thead class="thead-light text-center">
                        <tr>
                          <th>말머리</th>
                          <th id="title" style="width: 50%">제목</th>
                          <th>작성자</th>
                          <th>작성일자</th>
                          <th>조회수</th>
                          <th>좋아요</th>
                        </tr>
                      </thead>
                      <tbody class="customtable text-center">
                        <tr>
                          <td>
                            <div class="badge badge-primary">정보</div>
                          </td>
                          <td><a href="">안녕하세요</a></td>
                          <td>홍길동</td>
                          <td>2020-08-25 12:40</td>
                          <td>21</td>
                          <td>10</td>
                        </tr>
                        <tr>
                          <td>
                            <div class="badge badge-pill badge-success">
                              잡담
                            </div>
                          </td>
                          <td><a href="">반갑습니다</a></td>
                          <td>아이유</td>
                          <td>2020-08-24 11:30</td>
                          <td>29</td>
                          <td>30</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>

                <div class="form-group mt-3 float-right">
                  <a class="btn btn-primary text-white">글쓰기</a>
                </div>

                <ul class="pagination mt-5 ml-5 justify-content-center">
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
    <script src="/myPT/js/scripts.js"></script>
  </body>
</html>
