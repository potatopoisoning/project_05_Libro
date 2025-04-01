# Libro
- **링크** - [Libro](http://13.124.213.24:8080/Libro) / **ppt** - [AWS_2차](https://github.com/user-attachments/files/19360871/AWS_2.pdf)
- 회원 - ID: bookworm / PW: Qq1!  

<br>

## 프로젝트 소개
누구나(비회원) 자유롭게 접근,구매 가능한 도서 쇼핑 사이트입니다.

<br>

## 개발 기간
2024.11.28 - 2025.01.03

<br>
  
## 멤버 구성
- 팀장 김가원 - 관리자 페이지(회원 관리, 상품 관리, 주문 관리, 매출 관리, 리뷰 관리, 문의 관리)
- **팀원 유다현 - 로그인/회원가입, 내 정보/주소록, 최근 본 상품/위시리스트, 나의 게시물(문의,리뷰), 주문/상세 내역 조회, 쇼핑가이드/문의**
- 팀원 전동훈 - 인덱스, 인덱스 검색, 카테고리별 상품 목록/상세정보, 장바구니, 결제 기능

<br>

## 개발 환경
- `java`
- `jdk`
- **IDE** : STS 3.9.13
- **Database** : MySQL
  
<br>

## 주요 기능

### <회원가입 / 로그인>
![image](https://github.com/user-attachments/assets/4dd923ab-4ac5-458d-94f2-a7a10e045fc4)

필수 입력사항과 필수 약관을 동의해야 회원가입이 가능하다.

<br><br>

![image](https://github.com/user-attachments/assets/5a674686-2522-4046-9f81-88b3fb8c126b)

아이디 저장을 체크하면 로컬 스토리지에 아이디가 저장되어 로그인 시 사용자가 다시 아이디를 입력할 필요 없다.

<br><br>

### <내 정보 / 주소록>
- #### 내 정보
![image](https://github.com/user-attachments/assets/78ba5018-cc79-45cb-ac6c-060464c031a3)

회원정보를 확인/변경 하려면 비밀번호 확인 후 확인/변경 가능하다.

<br><br>

![image](https://github.com/user-attachments/assets/e86e23fa-e684-461a-b61d-4ddb021897a9)

비밀번호, 이름, 휴대전화, 이메일을 변경할 수 있다.

<br><br>

- #### 주소록
![6](https://github.com/user-attachments/assets/2c9fba3a-8d38-4997-bf12-899cc2f26aea)

1. 배송지는 최대 5개까지 등록할 수 있다.
2. 기본배송지를 설정한 경우 상단에 배치된다.
3. 등록된 배송지는 수정 및 삭제개 가능하다.
4. 배송지를 등록할 수 있다.

<br><br>

![7](https://github.com/user-attachments/assets/d62c9ff3-6dcc-4fcc-a977-9fbd3e06db04)

1. 카카오 주소 API를 이용해 주소를 입력한다.
2. 기본 배송지로 설정한 경우 상단에 배치된다.

<br><br>

### <최근 본 상품 / 위시리스트>
- #### 최근 본 상품
![1](https://github.com/user-attachments/assets/256e99b1-db61-4349-bfcd-c31192e80381)

1. 최근에 본 상품을 상단에 배치한다.
2. 차례대로 위시리스트 추가, 장바구니 추가, 삭제할 수 있다.

<br><br>

- #### 위시리스트
![2](https://github.com/user-attachments/assets/7c6dca80-1667-48fd-b7a2-48c6aae637db)

1. 최근에 추가한 상품을 상단에 배치한다.
2. 차례대로 장바구니 추가, 삭제할 수 있다.
   
<br><br>

### <나의 게시물(문의,리뷰)>

![8](https://github.com/user-attachments/assets/5c28bfcb-2963-458a-9713-940d023ef4d8)
1. 설정한 날짜별로 작성한 글을 볼 수 있다.
2. 내가 작성한 문의글을 볼 수 있다.
3. 작성 가능한 리뷰나 내가 작성한 리뷰를 볼 수 있다.
   3-1. 물건을 구매했을때만 리뷰를 작성할 수 있다.

<br><br>

### <주문/상세 내역 조회>
![image](https://github.com/user-attachments/assets/a1829d5a-47bc-4031-b0ef-f5b60773c929)

상품 준비중인 경우 배송지 변경이나 주문 취소가 가능하다.

<br><br>

![image](https://github.com/user-attachments/assets/85d33d21-30fb-4a15-8786-d42380cf8d8e)

관리자가 발송완료 버튼을 누르면 배송중으로 상태가 바뀐다.

<br><br>

### <쇼핑가이드/문의>
- #### 쇼핑가이드 
![3](https://github.com/user-attachments/assets/52eaad73-6834-4e37-8d62-37eb4d73b777)

배송, 취소/변경, 교환 및 반품, 불량/오배송 안내 등의 정보를 쉽게 찾을 수 있다.

<br><br>

- #### 문의 
![4](https://github.com/user-attachments/assets/1b543310-1ffa-4119-8460-e3a156e26675)

1. 문의종류를 선택할 수 있다.
2. 문의내용을 작성할 수 있다.
3. 상품에 문제가 있거나 오배송된 경우 사진을 첨부할 수 있다.

<br><br>

![5](https://github.com/user-attachments/assets/aab2035d-31e9-4e72-9542-2e7c2bf3b9bf)

1. 작성한 문의글은 언제든지 수정 및 삭제가 가능하다.
2. 답변이 달릴 경우 위의 화면과 같이 보인다.
   
<br>
