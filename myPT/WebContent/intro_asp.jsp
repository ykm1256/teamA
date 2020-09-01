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
    <title>myPT</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/widget.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="" style="background-color: black">
    <div id="demo" class="carousel slide" data-interval="false">
      <div class="carousel-inner">
        <!-- 슬라이드 쇼 -->

        <div class="carousel-item">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-5 mt-5">
                <div>
                  <a
                    class="mb-0 text-light"
                    href="#demo"
                    data-slide="next"
                    style="text-decoration: none"
                  >
                    <h5><i class="fas fa-angle-right"></i></h5>
                  </a>
                </div>
                <div
                  class="card shadow-lg rounded-0 border-white"
                  style="background-color: black; border: 5px solid"
                >
                  <div class="card-header">
                    <h2 class="text-center font-weight-light my-4 text-white">
                      TRAINER LOGIN
                    </h2>
                  </div>
                  <div class="card-body">
                    <form>
                      <div class="form-group">
                        <label class="small mb-1 text-white">ID</label>
                        <input
                          class="form-control py-4 text-white rounded-0 border-top-0 border-right-0 border-left-0"
                          id="inputID"
                          style="background-color: black"
                          placeholder="Enter ID"
                        />
                      </div>
                      <div class="form-group">
                        <label
                          class="small mb-1 text-white"
                          for="inputPassword1"
                          >Password</label
                        >
                        <input
                          class="form-control py-4 text-white rounded-0 border-top-0 border-right-0 border-left-0"
                          style="background-color: black"
                          id="inputPassword1"
                          type="password"
                          placeholder="Enter password"
                        />
                      </div>
                      <div class="form-group">
                        <div class="">
                          <input
                            class=""
                            id="rememberPasswordCheck1"
                            type="checkbox"
                          />
                          <label class="text-muted" for="rememberPasswordCheck1"
                            >Remember password</label
                          >
                        </div>
                      </div>
                      <div
                        class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"
                      >
                        <a
                          class="btn btn-primary btn-block"
                          style="
                            background-color: rgb(63, 72, 204);
                            border-color: rgb(63, 72, 204);
                          "
                          href="index.html"
                          >Login</a
                        >
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="carousel-item active">
          <div class="container text-center">
            <img class="col-md-8 col-lg-6" src="img/logo_transparent.png" />
            <div>
              <a
                href="#demo"
                class="btn col-md-3 text-white carousel-control"
                style="
                  background-color: rgb(63, 72, 204);
                  border-color: rgb(63, 72, 204);
                "
                data-slide="next"
                ><h4>로그인</h4></a
              >
            </div>

            <a href="#demo" data-slide="prev" style="text-decoration: none">
              <h5 class="text-white-50 mt-3">Trainer Login</h5>
            </a>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-5 mt-5">
                <div>
                  <a
                    class="mb-0 text-light"
                    href="#demo"
                    data-slide="prev"
                    style="text-decoration: none"
                  >
                    <h5><i class="fas fa-angle-left"></i></h5>
                  </a>
                </div>
                <div
                  class="card shadow-lg rounded-0 border-white"
                  style="background-color: black; border: 5px solid"
                >
                  <div class="card-header">
                    <h2 class="text-center font-weight-light my-4 text-white">
                      LOGIN
                    </h2>
                  </div>
                  <div class="card-body">
                    <form>
                      <div class="form-group">
                        <label
                          class="small mb-1 text-white"
                          for="inputEmailAddress"
                          >Email</label
                        >
                        <input
                          class="form-control py-4 text-white rounded-0 border-top-0 border-right-0 border-left-0"
                          id="inputEmailAddress"
                          style="background-color: black"
                          type="email"
                          placeholder="Enter email address"
                        />
                      </div>
                      <div class="form-group">
                        <label
                          class="small mb-1 text-white"
                          for="inputPassword2"
                          >Password</label
                        >
                        <input
                          class="form-control py-4 text-white rounded-0 border-top-0 border-right-0 border-left-0"
                          style="background-color: black"
                          id="inputPassword2"
                          type="password"
                          placeholder="Enter password"
                        />
                      </div>
                      <div class="form-group">
                        <div class="">
                          <input
                            class=""
                            id="rememberPasswordCheck2"
                            type="checkbox"
                          />
                          <label class="text-muted" for="rememberPasswordCheck2"
                            >Remember password</label
                          >
                        </div>
                      </div>
                      <div
                        class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"
                      >
                        <a
                          class="btn btn-primary btn-block"
                          style="
                            background-color: rgb(63, 72, 204);
                            border-color: rgb(63, 72, 204);
                          "
                          href="index.html"
                          >Login</a
                        >
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- / 슬라이드 쇼 끝 -->
      </div>
    </div>

    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
