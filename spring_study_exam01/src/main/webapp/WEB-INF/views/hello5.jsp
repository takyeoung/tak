<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">SIGN UP</h4>
		<form method="post" action="/exam01/add">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="user_n"  name="user_n"   required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            </div>
          <div class="col-md-6 mb-3">
            <label for="id">아이디</label>
            <input type="text" class="form-control" id="user_id"  name="user_id"  required>
            <div class="invalid-feedback">
              아이디를 입력해주세요.
            </div>
          </div>
           <div class="col-md-6 mb-3">
            <label for="pwd">비밀번호</label>
            <input type="text" class="form-control" id="user_pw"  name="user_pw" required>
            <div class="invalid-feedback">
              비밀번호 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="text" class="form-control" id="user_e"  name="user_e" placeholder="you@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" id="user_adress" name="user_adress" placeholder="서울특별시 강남구" required>
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>
          <hr class="mb-4">
          <div class="mb-4"></div>
          <input type="submit" value ="회원가입" class = "btn btn-dark">
        </form>
      </div>
    </div>
    </div>
</body>
</html>