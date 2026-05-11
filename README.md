## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [x] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

# 2차 요구사항
- [x] 게시글 상세페이지(http://주소:포트/article/detail/{id})에 수정 버튼이 있다. 수정 버튼을 누르면 게시글을 수정 할 수 있는 폼이 나오고 수정이 가능하다.
- [x] 게시글 상세페이지에 삭제 버튼이 있다. 삭제 버튼을 누르면 게시글이 삭제가 된다. 삭제 후 리스트 페이지로 리다이렉트 된다.
- [x] 모든 페이지 상단에 루트 디렉토리로 이동하는 버튼이 있다.(예: 로고)
- [x] 모든 페이지 상단에 로그인 상태 표시하는 버튼이 있다.(예: 로그인 / 로그아웃)
- [x] 모든 페이지 회원가입 버튼이 있다. 버튼을 누르면 회원가입 폼으로 이동한다.
- [x] 회원가입 폼은 유저ID, 닉네임, 비빌번호, 비밀번호 확인으로 구성된다. 회원가입 버튼을 누르면 데이터 검증 후 회원가입이 된다.
- [x] 로그인 버튼을 누르면 로그인 폼으로 이동한다.
- [x] 로그인 페이지는 사용자 유저ID과 비밀번호를 입력하는 폼으로 구성되고 로그인 버튼을 누르면 데이터 검증 후 로그인이 된다.
- [x] 로그아웃 버튼을 누르면 로그아웃이 된다.
- [x] 유저가 게시글 작성 및 수정 접근시 로그인 여부를 검사하고 본인 글에 대해서만 수정 / 삭제가 가능하다.
- [x] (선택)메인페이지에 검색 기능이 구현되어야 한다. input 박스에 내용을 적고 검색 버튼을 누르면 해당 문자가 포함된 게시글이 리스트업 되어야 한다.

## 미비사(선택)항 or 막힌 부분
- ...

## 비고
- 검색 기능 : 제목 및 내용만 검색하게 구현

## UI/UX (화면 캡처본을 복사 붙여 넣기, url 주소 나오도록)
- 게시글 리스트 페이지
  <img width="2003" height="559" alt="목록" src="https://github.com/user-attachments/assets/50ea7ec7-f789-40b6-860c-9040c8653882" />

- 게시글 등록 폼 페이지
  <img width="1973" height="642" alt="등록" src="https://github.com/user-attachments/assets/9f1a6f18-63e8-436a-a09f-f23accb27634" />
  - 게시글 등록 오류
    <img width="1996" height="739" alt="등록 오류1" src="https://github.com/user-attachments/assets/8674235c-d614-4e6b-956f-a25a6f60daff" />

- 게시글 상세 페이지
  - 본인이 작성한 게시글
    <img width="1992" height="433" alt="상세1" src="https://github.com/user-attachments/assets/5039fc2d-8649-444f-9a0a-5ccaa2447955" />
  - 다른 유저가 작성한 게시글
    <img width="1991" height="475" alt="상세2" src="https://github.com/user-attachments/assets/69db4e86-4c36-4f90-8fed-a542dde8ea08" />

- 로그인 페이지
  <img width="1981" height="459" alt="로그인" src="https://github.com/user-attachments/assets/45f37659-6360-45f3-9465-565e5a12f999" />
  - 로그인 오류
    <img width="2014" height="538" alt="로그인 오류1" src="https://github.com/user-attachments/assets/0baaa121-4eb8-4f2f-a65d-ff23ce707349" />

- 회원가입 페이지
  <img width="1981" height="602" alt="회원가입" src="https://github.com/user-attachments/assets/3d6cca61-20ad-4814-9bf5-7b70bf57c1d4" />
  - 회원가입 오류1
    <img width="2006" height="775" alt="회원가입 오류1" src="https://github.com/user-attachments/assets/7aec3a89-c175-4ad3-a482-f9465caddfe2" />
  - 회원가입 오류2
    <img width="1981" height="679" alt="회원가입 오류2" src="https://github.com/user-attachments/assets/2eea1068-a5d6-4d8a-9b9e-a6b150786244" />
  - 회원가입 오류3
    <img width="1992" height="683" alt="회원가입 오류3" src="https://github.com/user-attachments/assets/963f4ee9-c730-4fc7-939b-162c02d9f5ee" />

- (선택) 검색 페이지
  - 'test' 검색
    <img width="1989" height="486" alt="검색1" src="https://github.com/user-attachments/assets/7c626dc5-8b65-4de2-8c2f-55c6add0ca58" />
  - 'hi' 검색
    <img width="1991" height="447" alt="검색2" src="https://github.com/user-attachments/assets/bd21e8a1-7f3b-42c3-8576-c9d253a4ccd6" />

